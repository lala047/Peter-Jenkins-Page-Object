package com.peterjenkins.utilities;


// The Read.Config class gets information from the config.properties class and supplies it to the baseclass


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties"); //./<-shortcut to Project Home Directory

		try {
			FileInputStream fis = new FileInputStream(src); // FileInputStream is used in reading the data
			pro = new Properties();
			pro.load(fis);       // This is used to load the config. properties file
		} catch (Exception e) {   // if the file is not available, it throws an exception
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}

	
}

