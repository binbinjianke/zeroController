package com.UI;

import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;

import com.UI.DeskUI;
import com.business.VIPBean;

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
    	JTextField idjf = new JTextField();
    	JTextField namejf = new JTextField();
    	JTextField phonejf = new JTextField();
    	//下拉框
    	String[] levelName = {config.getProperty("vip"),config.getProperty("svip")};
    	String[] createrName = {config.getProperty("clerkA"),config.getProperty("clerkB"),config.getProperty("clerkC"),config.getProperty("clerkD")};		
    	ComboBox levelcb = new ComboBox();
    	levelcb.setSelectedItem(config.getProperty("vip"));
    	levelcb.setDropGroup(levelName);
    	ComboBox creatercb = new ComboBox();
    	creatercb.setSelectedItem(config.getProperty("clerkA"));
    	creatercb.setDropGroup(createrName);
    	JComboBox<String> leveljc = new JComboBox<>(levelcb);
    	JComboBox<String> createrjc = new JComboBox<>(createrName);
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
				
			}
		});
    }
}
