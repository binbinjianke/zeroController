package com.UI;

import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;

import com.UI.DeskUI;
import com.business.VIPBean;
import com.db.ZeroConn;

public class SignUI extends JDialog
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(SignUI.class);
	
	public static VIPBean vipRecord = new VIPBean();
	
    public SignUI(DeskUI frame,String projectPath)
    {
    	//实例化JDialog类对象，继承DeskUI类型
    	super(frame,"会员注册",true);
    	Container signcon = getContentPane();
    	setBounds(600, 150, 300, 400);
    	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	setIconImage(Toolkit.getDefaultToolkit().createImage(projectPath + "/icon/zero.ico"));
    	setResizable(false);
    	setLayout(null);
    	//引用配置文件
    	ConfigFile cf = new ConfigFile();
		String configPath = projectPath + "/properties/config.properties";
		Properties config = ConfigFile.getProperty(configPath);
		if (config == null)
		{
			config = cf.loadConfig("configprop", configPath);
		}
    	//标签说明
    	JLabel idlabel = new JLabel("会员卡ID：");
    	JLabel namelabel = new JLabel("会员姓名：");
    	JLabel levellabel = new JLabel("会员等级：");
    	JLabel phonelabel = new JLabel("phonenumber：");
    	JLabel createrlabel = new JLabel("创建者：");
    	//文字框
    	final JTextField idjf = new JTextField();
    	final JTextField namejf = new JTextField();
    	final JTextField phonejf = new JTextField();
    	//下拉框
    	String[] levelName = {config.getProperty("vip"),config.getProperty("svip")};
    	String[] createrName = {config.getProperty("clerkA"),config.getProperty("clerkB"),config.getProperty("clerkC"),config.getProperty("clerkD")};		
    	ComboBox levelcb = new ComboBox();
    	levelcb.setSelectedItem(config.getProperty("vip"));
    	levelcb.setDropGroup(levelName);
    	ComboBox creatercb = new ComboBox();
    	creatercb.setSelectedItem(config.getProperty("clerkA"));
    	creatercb.setDropGroup(createrName);
    	final JComboBox<String> leveljc = new JComboBox<>(levelcb);
    	final JComboBox<String> createrjc = new JComboBox<>(createrName);
    	//完成按钮
    	JButton btnsave = new JButton("完成注册");
    	
    	idlabel.setBounds(58,40,100,30);
    	namelabel.setBounds(58, 100, 100, 30);
    	levellabel.setBounds(58, 160, 100, 30);
    	phonelabel.setBounds(40, 220, 100, 30);
    	createrlabel.setBounds(72, 280, 100, 30);
    	idjf.setBounds(120, 40, 120, 30);
    	namejf.setBounds(120, 100, 120, 30);
    	leveljc.setBounds(120, 160, 80, 30);
    	phonejf.setBounds(120, 220, 120, 30);
    	createrjc.setBounds(120, 280, 80, 30);
    	btnsave.setBounds(100, 330, 120, 30);
    	
    	signcon.add(idlabel);
    	signcon.add(namelabel);
    	signcon.add(levellabel);
    	signcon.add(phonelabel);
    	signcon.add(createrlabel);
    	signcon.add(idjf);
    	signcon.add(namejf);
    	signcon.add(leveljc);
    	signcon.add(phonejf);
    	signcon.add(createrjc);
    	signcon.add(btnsave);
    	
    	btnsave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//flag:success 注册成功，faild 注册失败
				String flag = "faild";
				String sql = "";
				try
				{
					checkParam(idjf.getText(),phonejf.getText(),namejf.getText());
					vipRecord.setCardID(Integer.parseInt(idjf.getText()));
					vipRecord.setName(namejf.getText());
					vipRecord.setVIPlevel(leveljc.getSelectedIndex());
					vipRecord.setPhonenumber(phonejf.getText());
					vipRecord.setCreater((String)createrjc.getSelectedItem());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date nowDate = sdf.parse(sdf.format(new Date()));
					vipRecord.setUpdatetime(nowDate);
					ZeroConn zerocon = new ZeroConn();
					Connection con = zerocon.getConnection();
					Statement stmt = con.createStatement();
					sql = "Select * from zerovip where name='"+vipRecord.getName()+"' and phonenumber='"+vipRecord.getPhonenumber()+"'";
					ResultSet res = stmt.executeQuery(sql);
					if(res.next())
					{
						logger.info(res.getString("name")+"该会员已注册！");
						throw new RuntimeException(res.getString("name")+"该会员已注册！");
					}
					else
					{
						String dateTime = sdf.format(vipRecord.getUpdatetime());
						sql = "insert into zerovip values("
					              +vipRecord.getCardID()+",'"
					              +vipRecord.getName()+"',"
								  +vipRecord.getVIPlevel()+",'"
					              +vipRecord.getPhonenumber()+"','"
								  +vipRecord.getCreater()+"','"
					              +dateTime+"')";
						//执行成功返回false
						if(!stmt.execute(sql))
						{
							flag="success";
							logger.info(vipRecord.getName()+"信息已保存！");
							JOptionPane.showMessageDialog(null, vipRecord.getName()+"信息已保存！", "系统提示", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					//PreparedStatement preparedstmt = con.prepareStatement(sql); 
				}
				catch (Exception e1)
				{
					logger.error(e1.toString());
					if(e1.toString().contains("java.lang.RuntimeException"))
					{
						JOptionPane.showMessageDialog(null, e1.getMessage(), "系统提示", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, e1.toString(), "系统提示", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				if("success".equals(flag))
				{
				   dispose();
				}
			}
		});
    }

	protected void checkParam(String id, String phone, String name) throws Exception
	{
		// TODO Auto-generated method stub
		if("".equals(id))
		{
			throw new RuntimeException("请输入会员卡ID");
		}
		if(!id.matches("[0-9]+"))
		{
			throw new RuntimeException("输入会员ID有误，只能输入数字");
		}
		if("".equals(name))
		{
			throw new RuntimeException("请输入会员姓名");
		}
		if(name.matches("[\\p{Punct}\\p{Blank}]"))
		{
			throw new RuntimeException("输入会员姓名有误，请检查是否含有特殊字符");
		}
		if("".equals(phone))
		{
			throw new RuntimeException("请输入手机号");
		}
		if(!phone.matches("((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9])|(17[0-9]))\\d{8}"))
		{
			throw new RuntimeException("输入会员手机号有误，请输入正确手机号");
		}
	}
}
