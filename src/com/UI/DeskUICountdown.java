package com.UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;

import com.business.TimeCounter;
import com.UI.ConfigFile;


/**
 * TODO 倒计时使用界面
 * @author bob yang
 *
 * @CopyRight yang
 */
@SuppressWarnings("unused")
public class DeskUICountdown extends JFrame
{
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(DeskUICountdown.class);

	private JFrame jf;

	public void CreateUI(String title,String projectPath)
	{
		logger.info("Start tools!");
		ConfigFile cf = new ConfigFile();
		String configPath = projectPath+"/properties/config.properties";
		Properties config = ConfigFile.getProperty(configPath);  
		if (config == null) 
		{  
		    config = cf.loadConfig("configprop",configPath);  
		}  
		jf = new JFrame(title);
		jf.setBounds(360, 90, 700, 600);
		jf.setResizable(false);
		jf.setLayout(null);
		jf.setIconImage(Toolkit.getDefaultToolkit().createImage(projectPath+"/icon/zero.ico"));
		Container cp = jf.getContentPane();
		try
		{
		   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			System.exit(0);
		}
		//工具大标签
		JLabel figuretitle = new JLabel(config.getProperty("publishname"));
		JLabel version = new JLabel(config.getProperty("publishversion"));
		figuretitle.setFont(new Font ("微软雅黑", 1, 21));
		version.setFont(new Font ("微软雅黑", 1, 21));
		version.setForeground(Color.red);
		//PS4图标
		JLabel ps4Jl1 = new JLabel(); 
	    Icon ps4Icon1 = new ImageIcon(projectPath+"/icon/PS4.jpg");
		ps4Jl1.setIcon(ps4Icon1);
		JLabel ps4Jl2 = new JLabel(); 
	    Icon ps4Icon2 = new ImageIcon(projectPath+"/icon/PS4.jpg");
		ps4Jl2.setIcon(ps4Icon2);
	    //VR图标
		JLabel vrJl1 = new JLabel();
		Icon vrIcon1 = new ImageIcon(projectPath+"/icon/VR.jpg");
		vrJl1.setIcon(vrIcon1);
		JLabel vrJl2 = new JLabel();
		Icon vrIcon2 = new ImageIcon(projectPath+"/icon/VR.jpg");
		vrJl2.setIcon(vrIcon2);
		//zero logo
		JLabel logo = new JLabel();
		Icon logoIcon = new ImageIcon(projectPath+"/icon/zeronull.png");
		logo.setIcon(logoIcon);
		//文字说明
		JLabel psI = new JLabel(config.getProperty("PSA"));
		JLabel psII = new JLabel(config.getProperty("PSB"));
		JLabel VRI = new JLabel(config.getProperty("VRA"));
		JLabel VRII = new JLabel(config.getProperty("VRB"));
		//倒计时框
		JLabel ps4jb1=new JLabel("倒计时：",JLabel.CENTER);
		JLabel ps4jbs1=new JLabel("设定时间：",JLabel.CENTER);
		JLabel ps4jblHour1=new JLabel("时");
		JLabel ps4jblMin1=new JLabel("分");
		final JTextField ps4jtf1=new JTextField(15);
		final JTextField ps4jtfHour1=new JTextField(3);
		final JTextField ps4jtfMin1=new JTextField(3);
		final JButton psbtn1 = new JButton("计时");
		
		JLabel ps4jb2=new JLabel("倒计时：",JLabel.CENTER);
		JLabel ps4jbs2=new JLabel("设定时间：",JLabel.CENTER);
		JLabel ps4jblHour2=new JLabel("时");
		JLabel ps4jblMin2=new JLabel("分");
		final JTextField ps4jtf2=new JTextField(15);
		final JTextField ps4jtfHour2=new JTextField(3);
		final JTextField ps4jtfMin2=new JTextField(3);
		final JButton psbtn2 = new JButton("计时");
		
		JLabel VRjb1=new JLabel("倒计时：",JLabel.CENTER);
		JLabel VRjbs1=new JLabel("设定时间：",JLabel.CENTER);
		JLabel VRjblHour1=new JLabel("时");
		JLabel VRjblMin1=new JLabel("分");
		final JTextField VRjtf1=new JTextField(15);
		final JTextField VRjtfHour1=new JTextField(3);
		final JTextField VRjtfMin1=new JTextField(3);
		final JButton VRbtn1 = new JButton("计时");
		
		JLabel VRjb2=new JLabel("倒计时：",JLabel.CENTER);
		JLabel VRjbs2=new JLabel("设定时间：",JLabel.CENTER);
		JLabel VRjblHour2=new JLabel("时");
		JLabel VRjblMin2=new JLabel("分");
		final JTextField VRjtf2=new JTextField(15);
		final JTextField VRjtfHour2=new JTextField(3);
		final JTextField VRjtfMin2=new JTextField(3);
		final JButton VRbtn2 = new JButton("计时");
		
		ps4jb1.setBounds(255, 120, 100, 200);
		ps4jtf1.setBounds(330, 210, 120, 20);
		ps4jbs1.setBounds(235, 150, 130, 200);
		ps4jblHour1.setBounds(370, 150, 100, 200);
		ps4jtfHour1.setBounds(330, 241, 35, 20);
		ps4jblMin1.setBounds(429, 150, 100, 200);
		ps4jtfMin1.setBounds(390, 241, 35, 20);
		psbtn1.setBounds(330, 270, 80, 30);
		
		ps4jb2.setBounds(455, 120, 100, 200);
		ps4jtf2.setBounds(530, 210, 120, 20);
		ps4jbs2.setBounds(435, 150, 130, 200);
		ps4jblHour2.setBounds(570, 150, 100, 200);
		ps4jtfHour2.setBounds(530, 241, 35, 20);
		ps4jblMin2.setBounds(629, 150, 100, 200);
		ps4jtfMin2.setBounds(590, 241, 35, 20);
		psbtn2.setBounds(530, 270, 80, 30);
		
		VRjb1.setBounds(255, 330, 100, 200);
		VRjtf1.setBounds(330, 420, 120, 20);
		VRjbs1.setBounds(235, 360, 130, 200);
		VRjblHour1.setBounds(370, 360, 100, 200);
		VRjtfHour1.setBounds(330, 451, 35, 20);
		VRjblMin1.setBounds(429, 360, 100, 200);
		VRjtfMin1.setBounds(390, 451, 35, 20);
		VRbtn1.setBounds(330, 480, 80, 30);
		
		VRjb2.setBounds(455, 330, 100, 200);
		VRjtf2.setBounds(530, 420, 120, 20);
		VRjbs2.setBounds(435, 360, 130, 200);
		VRjblHour2.setBounds(570, 360, 100, 200);
		VRjtfHour2.setBounds(530, 451, 35, 20);
		VRjblMin2.setBounds(629, 360, 100, 200);
		VRjtfMin2.setBounds(590, 451, 35, 20);
		VRbtn2.setBounds(530, 480, 80, 30);
		
		psI.setBounds(330, 45, 100, 200);
		psII.setBounds(530, 45, 100, 200);
		VRI.setBounds(330, 235, 100,200);
		VRII.setBounds(530, 235, 100, 200);
		ps4Jl1.setBounds(330, 80, 100, 200);
		ps4Jl2.setBounds(530, 80, 100, 200);
		vrJl1.setBounds(330, 280, 100, 200);
		vrJl2.setBounds(530, 280, 100, 200);
		figuretitle.setBounds(40, -50, 600, 200);
		version.setBounds(250, -50, 200, 200);
		logo.setBounds(30, 250, 300, 300);

		cp.add(figuretitle);
		cp.add(version);
		cp.add(ps4Jl1);
		cp.add(ps4Jl2);
		cp.add(vrJl1);
		cp.add(vrJl2);
		cp.add(logo);
		cp.add(psI);
		cp.add(psII);
		cp.add(VRI);
		cp.add(VRII);
		cp.add(ps4jb1);
		cp.add(ps4jtf1);
		cp.add(ps4jbs1);
		cp.add(ps4jblHour1);
		cp.add(ps4jtfHour1);
		cp.add(ps4jblMin1);
		cp.add(ps4jtfMin1);
		cp.add(psbtn1);
		cp.add(ps4jb2);
		cp.add(ps4jtf2);
		cp.add(ps4jbs2);
		cp.add(ps4jblHour2);
		cp.add(ps4jtfHour2);
		cp.add(ps4jblMin2);
		cp.add(ps4jtfMin2);
		cp.add(psbtn2);
		cp.add(VRjb1);
		cp.add(VRjtf1);
		cp.add(VRjbs1);
		cp.add(VRjblHour1);
		cp.add(VRjtfHour1);
		cp.add(VRjblMin1);
		cp.add(VRjtfMin1);
		cp.add(VRbtn1);
		cp.add(VRjb2);
		cp.add(VRjtf2);
		cp.add(VRjbs2);
		cp.add(VRjblHour2);
		cp.add(VRjtfHour2);
		cp.add(VRjblMin2);
		cp.add(VRjtfMin2);
		cp.add(VRbtn2);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		psbtn1.addActionListener(new ActionListener()
	    {
		   public void actionPerformed(ActionEvent arg0) 
	    	{
			   psbtn1.setEnabled(false);
			   int time;
			   int hour;
			   int min;
			   if(ps4jtfHour1.getText().equals("") && ps4jtfMin1.getText().equals(""))
			   {
				   JOptionPane.showMessageDialog(jf, "请至少输入1分钟！", "系统提示",
							JOptionPane.ERROR_MESSAGE);
				   logger.error("PSA 请至少输入1分钟！");
				   psbtn1.setEnabled(true);
			   }
				else
				{
					if(!"".equals(ps4jtfHour1.getText().trim().toString()))
					{
						hour=Integer.parseInt(ps4jtfHour1.getText().trim().toString());
					}
					else
					{
						hour = 0;
					}
					if(!"".equals(ps4jtfMin1.getText().trim().toString()))
					{
						min=Integer.parseInt(ps4jtfMin1.getText().trim().toString());
					}
					else
					{
						min = 0;
					}
					time=hour*3600+min*60;
					try
					{
				      logger.info("PSA Start!");
					  new TimeCounter(time/3600,(time%3600)/60,ps4jtf1,psbtn1).start();
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(jf, "异常(PSA)：" + e.getMessage(), "系统提示",
								JOptionPane.ERROR_MESSAGE);
						logger.error("异常(PSA)：" + e.getMessage());
						psbtn1.setEnabled(true);
					}
				}
		    }
		 });
		psbtn2.addActionListener(new ActionListener()
	    {
		   public void actionPerformed(ActionEvent arg0) 
	    	{
			   psbtn2.setEnabled(false);
			   int time;
			   int hour;
			   int min;
			   if(ps4jtfHour2.getText().equals("") && ps4jtfMin2.getText().equals(""))
			   {
				   JOptionPane.showMessageDialog(jf, "请至少输入1分钟！", "系统提示",
							JOptionPane.ERROR_MESSAGE);
				   logger.error("PSB 请至少输入1分钟！");
				   psbtn2.setEnabled(true);
			   }
				else
				{
					if(!"".equals(ps4jtfHour2.getText().trim().toString()))
					{
						hour=Integer.parseInt(ps4jtfHour2.getText().trim().toString());
					}
					else
					{
						hour = 0;
					}
					if(!"".equals(ps4jtfMin2.getText().trim().toString()))
					{
						min=Integer.parseInt(ps4jtfMin2.getText().trim().toString());
					}
					else
					{
						min = 0;
					}
					time=hour*3600+min*60;
					try
					{
					  logger.info("PSB Start!");
					  new TimeCounter(time/3600,(time%3600)/60,ps4jtf2,psbtn2).start();
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(jf, "异常(PSB)：" + e.getMessage(), "系统提示",
								JOptionPane.ERROR_MESSAGE);
						logger.error("异常(PSB)：" + e.getMessage());
						psbtn2.setEnabled(true);
					}
				}
		    }
		 });
		VRbtn1.addActionListener(new ActionListener()
	    {
		   public void actionPerformed(ActionEvent arg0) 
	    	{
			   VRbtn1.setEnabled(false);
			   int time;
			   int hour;
			   int min;
			   if(VRjtfHour1.getText().equals("") && VRjtfMin1.getText().equals(""))
			   {
				   JOptionPane.showMessageDialog(jf, "请至少输入1分钟！", "系统提示",
							JOptionPane.ERROR_MESSAGE);
				   logger.error("VRA 请至少输入1分钟！");
				   VRbtn1.setEnabled(true);
			   }
				else
				{
					if(!"".equals(VRjtfHour1.getText().trim().toString()))
					{
						hour=Integer.parseInt(VRjtfHour1.getText().trim().toString());
					}
					else
					{
						hour = 0;
					}
					if(!"".equals(VRjtfMin1.getText().trim().toString()))
					{
						min=Integer.parseInt(VRjtfMin1.getText().trim().toString());
					}
					else
					{
						min = 0;
					}
					time=hour*3600+min*60;
					try
					{
					  logger.info("VRA Start!");
					  new TimeCounter(time/3600,(time%3600)/60,VRjtf1,VRbtn1).start();
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(jf, "异常(VRA)" + e.getMessage(), "系统提示",
								JOptionPane.ERROR_MESSAGE);
						logger.error("异常(VRA)：" + e.getMessage());
						VRbtn1.setEnabled(true);
					}
				}
		    }
		 });
		VRbtn2.addActionListener(new ActionListener()
	    {
		   public void actionPerformed(ActionEvent arg0) 
	    	{
			   VRbtn2.setEnabled(false);
			   int time;
			   int hour;
			   int min;
			   if(VRjtfHour2.getText().equals("") && VRjtfMin2.getText().equals(""))
			   {
				   JOptionPane.showMessageDialog(jf, "请至少输入1分钟！", "系统提示",
							JOptionPane.ERROR_MESSAGE);
				   logger.error("VRB 请至少输入1分钟！");
				   VRbtn2.setEnabled(true);
			   }
				else
				{
					if(!"".equals(VRjtfHour2.getText().trim().toString()))
					{
						hour=Integer.parseInt(VRjtfHour2.getText().trim().toString());
					}
					else
					{
						hour = 0;
					}
					if(!"".equals(VRjtfMin2.getText().trim().toString()))
					{
						min=Integer.parseInt(VRjtfMin2.getText().trim().toString());
					}
					else
					{
						min = 0;
					}
					time=hour*3600+min*60;
					try
					{
					  logger.info("VRB Start!");
					  new TimeCounter(time/3600,(time%3600)/60,VRjtf2,VRbtn2).start();
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(jf, "异常(VRB)：" + e.getMessage(), "系统提示",
								JOptionPane.ERROR_MESSAGE);
						logger.error("异常(VRB)：" + e.getMessage());
						VRbtn2.setEnabled(true);
					}
				}
		    }
		 });
	}
}
