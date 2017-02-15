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
import java.util.Date;
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
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;

import com.business.TimeCounter;
import com.business.ZeroTimer;
import com.UI.ConfigFile;

/**
 * TODO 主桌面界面
 * 
 * @author bob yang
 *
 * @CopyRight yang
 */
@SuppressWarnings("unused")
public class DeskUI extends JFrame
{
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(DeskUI.class);

	private JFrame jf;

	public void CreateUI(String title, final String projectPath)
	{
		logger.info("Start tools!");
		ConfigFile cf = new ConfigFile();
		String configPath = projectPath + "/properties/config.properties";
		Properties config = ConfigFile.getProperty(configPath);
		if (config == null)
		{
			config = cf.loadConfig("configprop", configPath);
		}
		jf = new JFrame(title);
		jf.setBounds(360, 90, 700, 600);
		jf.setResizable(false);
		jf.setLayout(null);
		jf.setIconImage(Toolkit.getDefaultToolkit().createImage(projectPath + "/icon/zero.ico"));
		Container cp = jf.getContentPane();
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
			System.exit(0);
		}
		// 工具大标签
		JLabel figuretitle = new JLabel(config.getProperty("publishname"));
		JLabel version = new JLabel(config.getProperty("publishversion"));
		figuretitle.setFont(new Font("微软雅黑", 1, 21));
		version.setFont(new Font("微软雅黑", 1, 21));
		version.setForeground(Color.red);
		// PS4图标
		JLabel ps4Jl1 = new JLabel();
		Icon ps4Icon1 = new ImageIcon(projectPath + "/icon/PS4.jpg");
		ps4Jl1.setIcon(ps4Icon1);
		JLabel ps4Jl2 = new JLabel();
		Icon ps4Icon2 = new ImageIcon(projectPath + "/icon/PS4.jpg");
		ps4Jl2.setIcon(ps4Icon2);
		// VR图标
		JLabel vrJl1 = new JLabel();
		Icon vrIcon1 = new ImageIcon(projectPath + "/icon/VR.jpg");
		vrJl1.setIcon(vrIcon1);
		JLabel vrJl2 = new JLabel();
		Icon vrIcon2 = new ImageIcon(projectPath + "/icon/VR.jpg");
		vrJl2.setIcon(vrIcon2);
		// zero logo
		JLabel logo = new JLabel();
		Icon logoIcon = new ImageIcon(projectPath + "/icon/zeronull.png");
		logo.setIcon(logoIcon);
		// 文字说明
		JLabel psI = new JLabel(config.getProperty("PSA"));
		JLabel psII = new JLabel(config.getProperty("PSB"));
		JLabel VRI = new JLabel(config.getProperty("VRA"));
		JLabel VRII = new JLabel(config.getProperty("VRB"));
		// 计时器
		final Timer pst1;
		Timer pst2;
		Timer vrt1;
		Timer vrt2;

		// 倒计时框
		JLabel ps4jb1 = new JLabel("时间：", JLabel.CENTER);
		final JLabel ps4TimeView1 = new JLabel("00:00:00.000");
		ps4TimeView1.setFont(new Font("微软雅黑", 0, 13));
		final JButton psbtn1 = new JButton("计时");
		final JButton stopbtn1 = new JButton("停止");

		JLabel ps4jb2 = new JLabel("时间：", JLabel.CENTER);
		final JLabel ps4TimeView2 = new JLabel("00:00:00.000");
		ps4TimeView2.setFont(new Font("微软雅黑", 0, 13));
		final JButton psbtn2 = new JButton("计时");
		final JButton stopbtn2 = new JButton("停止");

		JLabel VRjb1 = new JLabel("时间：", JLabel.CENTER);
		final JLabel VRTimeView1 = new JLabel("00:00:00.000");
		VRTimeView1.setFont(new Font("微软雅黑", 0, 13));
		final JButton VRbtn1 = new JButton("计时");
		final JButton stopbtn3 = new JButton("停止");

		JLabel VRjb2 = new JLabel("时间：", JLabel.CENTER);
		final JLabel VRTimeView2 = new JLabel("00:00:00.000");
		VRTimeView2.setFont(new Font("微软雅黑", 0, 13));
		final JButton VRbtn2 = new JButton("计时");
		final JButton stopbtn4 = new JButton("停止");

		ps4jb1.setBounds(255, 120, 100, 200);
		ps4TimeView1.setBounds(330, 210, 120, 20);
		psbtn1.setBounds(330, 240, 80, 30);
		stopbtn1.setBounds(330, 270, 80, 30);

		ps4jb2.setBounds(455, 120, 100, 200);
		ps4TimeView2.setBounds(530, 210, 120, 20);
		psbtn2.setBounds(530, 240, 80, 30);
		stopbtn2.setBounds(530, 270, 80, 30);

		VRjb1.setBounds(255, 330, 100, 200);
		VRTimeView1.setBounds(330, 420, 120, 20);
		VRbtn1.setBounds(330, 450, 80, 30);
		stopbtn3.setBounds(330, 480, 80, 30);

		VRjb2.setBounds(455, 330, 100, 200);
		VRTimeView2.setBounds(530, 420, 120, 20);
		VRbtn2.setBounds(530, 450, 80, 30);
		stopbtn4.setBounds(530, 480, 80, 30);

		psI.setBounds(330, 45, 100, 200);
		psII.setBounds(530, 45, 100, 200);
		VRI.setBounds(330, 235, 100, 200);
		VRII.setBounds(530, 235, 100, 200);
		ps4Jl1.setBounds(330, 80, 100, 200);
		ps4Jl2.setBounds(530, 80, 100, 200);
		vrJl1.setBounds(330, 280, 100, 200);
		vrJl2.setBounds(530, 280, 100, 200);
		figuretitle.setBounds(40, -50, 600, 200);
		version.setBounds(250, -50, 200, 200);
		logo.setBounds(30, 250, 300, 300);
		
		//会员模块
		JLabel VIPTip = new JLabel("输入会员卡编号查询信息：");
		JTextField cardID = new JTextField();
		JButton btnFind = new JButton("查询");
		JButton btnSign = new JButton("注册");
		JButton btnExport = new JButton("数据导出");
		
		VIPTip.setBounds(50, 110, 180, 20);
		cardID.setBounds(50, 140, 180, 30);
		btnFind.setBounds(50, 180, 80, 30);
		btnSign.setBounds(140, 180, 80, 30);
		btnExport.setBounds(50, 220, 140, 30);
		
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
		cp.add(ps4TimeView1);
		cp.add(psbtn1);
		cp.add(stopbtn1);
		cp.add(ps4jb2);
		cp.add(ps4TimeView2);
		cp.add(psbtn2);
		cp.add(stopbtn2);
		cp.add(VRjb1);
		cp.add(VRTimeView1);
		cp.add(VRbtn1);
		cp.add(stopbtn3);
		cp.add(VRjb2);
		cp.add(VRTimeView2);
		cp.add(VRbtn2);
		cp.add(stopbtn4);
		cp.add(VIPTip);
		cp.add(cardID);
		cp.add(btnFind);
		cp.add(btnSign);
		cp.add(btnExport);
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		try
		{
			new ZeroTimer(psbtn1, stopbtn1, ps4TimeView1, psI);
			new ZeroTimer(psbtn2, stopbtn2, ps4TimeView2, psII);
			new ZeroTimer(VRbtn1, stopbtn3, VRTimeView1, VRI);
			new ZeroTimer(VRbtn2, stopbtn4, VRTimeView2, VRII);
		}
		catch (Exception e)
		{
			logger.error("异常：" + e.toString());
			JOptionPane.showMessageDialog(jf, "异常：" + e.toString(), "系统提示", JOptionPane.ERROR_MESSAGE);
		}
		btnSign.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new SignUI(DeskUI.this,projectPath).setVisible(true);
			}
		});
	}
}
