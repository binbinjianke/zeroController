package com.UI;

import java.net.URLDecoder;

import org.apache.log4j.PropertyConfigurator;

//import org.apache.log4j.PropertyConfigurator;


/**
 * 管理桌面主入口
 * @author bob yang
 *
 * @CopyRight yang
 */
public class DeskApp
{
	 /**
     * TODO 管理桌面时间控制程序
     */
    public static void main(String[] args) 
    {
		String binPath = DeskApp.class.getResource("../../").getPath();
		String projectPath = getProjectPath(binPath);
		try 
		{
		  projectPath = URLDecoder.decode(projectPath, "utf-8");
		} catch (Exception e) 
		{
		    e.printStackTrace();
		}
    	PropertyConfigurator.configure(projectPath+"/properties/log4j.properties"); 
    	String title = "Zero零度管理桌面";
    	DeskUI UI = new DeskUI();
    	UI.CreateUI(title,projectPath);
    }

	private static String getProjectPath(String binPath)
	{
		// TODO 获得项目工程路径
        String realPath = binPath.replaceAll("/bin", "");
        return realPath;
	}
}
