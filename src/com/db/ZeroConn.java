package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

//import org.apache.log4j.Logger;


public class ZeroConn
{
//   private static Logger logger = Logger.getLogger(ZeroConn.class);
   Connection con;
   public Connection getConnection()
   {
	   String url = "jdbc:mysql://localhost:3306/zerodatabase?"
               + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
	   try
	   {
		   Class.forName("com.mysql.jdbc.Driver");
//		   logger.info("数据库驱动加载完成！");
		   System.out.println("数据库驱动加载完成！");
	   }
	   catch(Exception e)
	   {
//		   logger.error("数据库驱动加载失败，原因："+e.getMessage());
		   System.out.println("数据库驱动加载失败，原因："+e.toString());
		   e.printStackTrace();
	   }
	   try
	   {
		   con = DriverManager.getConnection(url);
//		   logger.info("数据库连接成功！");
		   System.out.println("数据库连接成功！");
	   }
	   catch(Exception e)
	   {
//		   logger.error("数据库连接失败，原因："+e.getMessage());
		   System.out.println("数据库连接失败，原因："+e.toString());
		   e.printStackTrace();
	   }
	   return con;
   }
/*   public static void main(String[] args)
   {
	   ZeroConn t = new ZeroConn();
	   Connection zerocon = t.getConnection();
   }*/
}
