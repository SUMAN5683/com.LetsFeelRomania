package com.tms.LetsFeelRomania.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/**
	 * this method will return data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.FilePath);
		Properties p = new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}
}
