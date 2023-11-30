package com.bixi.GenericUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtlis {
	/**
	 * This method is used to read data from Property file
	 * @author Neyaz
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable 
	{	
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pLib = new Properties();
		pLib.load(fis);
		String value = pLib.getProperty(key);
		return value;
	}
}
