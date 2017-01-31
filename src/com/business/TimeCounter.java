package com.business;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

/**
 * 倒计时计时器
 * @author bob yang
 *
 * @CopyRight yang
 */
public class TimeCounter extends Thread
{
	private static Logger logger = Logger.getLogger(TimeCounter.class);
	
	int hour = 0;
	int min = 0;
	int sec = 0;
	JTextField jf;
	JButton jb;
	public TimeCounter(JTextField jf,JButton jbstart) 
	{
		this.jf = jf;
		this.jb = jbstart;
	}
	public TimeCounter(int hour,int min,JTextField jf,JButton jb) 
	{
		this.hour=hour;
		this.min=min;
		this.jb=jb;
		this.jf = jf;
	}
//TODO 倒计时时调用run函数	
	public void run()
	{
			while(true)
			{
				jf.setText(hour+":"+min+":"+sec);
				if(hour==0&&min==0&&sec==0){
					jb.setEnabled(true);
					break;
				}
				if(sec==0){
					sec=59;
				}else{
					sec--;
				}
				if(sec==59)
				{
					if(min==0)
					{
						min=59;
						if(hour==0)
						{
							hour=24;
						}else
						{
							hour--;
						}
					}else
					{
						min--;
					}
				}
				
				try 
				{
					Thread.sleep(1000);
				} catch (Exception e) 
				{
					logger.error("计时过程中出现异常！原因为："+e.toString());
					throw new RuntimeException("计时过程中出现异常！");
				}
			}
	}

}
