package com.UI;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Properties;
/**
 * 加载Properties配置文件类
 * @author bob yang
 *
 * @CopyRight yang
 */
public class ConfigFile
{
	public static Properties config = new Properties();

	private static Hashtable<String, Properties> instanceCache  = new Hashtable<String, Properties>();
	
	/**
	 * 加载配置文件 
	 * @param propName
	 * @param config_path
	 * @return 
	 */
	
	public Properties loadConfig(String propName,String config_path)
	{
		InputStreamReader sr = null;
		try
		{
			sr = new InputStreamReader(new FileInputStream(config_path), "utf-8"); 
			config.load(sr);
			instanceCache.put(propName, config);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (sr != null)
			{
				try
				{
					sr.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return config;
	}
	
	/** 
	 * 获取配置文件 
	 * @param propFileName 
	 * @return 
	 */  
	public static Properties getProperty(String propFileName) 
	{  
	       if (instanceCache.containsKey(propFileName)) 
	       {  
	           return (Properties) instanceCache.get(propFileName);  
	       } 
	       else 
	       {  
	           return null;  
	       }  
	   } 
}
