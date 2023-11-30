package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsTest 
{
	@Test
	public void testscriptTest() 
	{
		System.out.println("----Execute TS-1-----");
	}	
		
	@BeforeSuite
	public void config_BSU()
	{
		System.out.println("----DB Connection-----");
	}
	
	@AfterSuite
	public void config_AS()
	{
		System.out.println("----disconnect from DB-----");
	}
	
	@BeforeClass
	public void config_BS()
	{
		System.out.println("----launch the browser-----");
	}
	
	@AfterClass
	public void config_AC()
	{
		System.out.println("----close the browser-----");
	}
	
	@BeforeMethod
	public void config_BM()
	{
		System.out.println("----Login to application-----");
	}
	@AfterMethod
	public void config_AM()
	{
		System.out.println("----Logout the application-----");
	}
}
