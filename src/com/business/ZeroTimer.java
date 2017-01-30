package com.business;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;

/**
 * 正数（shǔ）计时
 * @author bob yang
 *
 * @CopyRight yang
 */
public class ZeroTimer
{
	private static Logger logger = Logger.getLogger(ZeroTimer.class);
	
	JLabel timeView;
	Timer timer;

	public ZeroTimer(final JButton btnStart, JButton btnStop, final JLabel timeVeiw,final JLabel equipment)throws Exception
	{
		this.timeView = timeVeiw;
		final int delay = 100;
		final Date startTime = new Date();
		// 显示毫秒数时格式：HH:mm:ss.S
		final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.S");
		final Action taskPerformer = new AbstractAction()
		{
			/**
			 * 事件默认序列，避免冲突
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent evt)
			{
				// 显示时间，System.currentTimeMillis()系统毫秒级时间
				Date d = new Date(System.currentTimeMillis() - startTime.getTime() - 28800000);
				timeView.setText(sdf.format(d));
				timeView.repaint();
			}
		};
		btnStart.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent evt)
			{
				btnStart.setEnabled(false);
				logger.info(equipment.getText()+"启动！");
				try
				{
					//下次计时时清空上一次计时记录
					startTime.setTime(new Date().getTime());
					timer = new Timer(delay, taskPerformer);
					timer.start();
				}
				catch(Exception e)
				{
					throw new RuntimeException(equipment.getText()+"运行出现异常！");
				}
				
			}
		});
		btnStop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				if (timer != null && timer.isRunning())
				{
					timer.stop();
					logger.info(equipment.getText()+"停止,本次使用时间："+timeVeiw.getText());
					btnStart.setEnabled(true);
				}
			}
		});
	}
}
