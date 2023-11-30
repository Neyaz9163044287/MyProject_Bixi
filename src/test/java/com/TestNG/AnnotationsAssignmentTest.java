package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsAssignmentTest 
{
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("1");
	}
	
	@BeforeClass
	public void BeforeClass1()
	{
		System.out.println("2");
	}
	
	@BeforeClass
	public void BeforeClass2()
	{
		System.out.println("3");
	}
	
	@Test
	public void test1()
	{
		System.out.println("4");
	}
	
	@BeforeMethod
	public void BeforeMethod1()
	{
		System.out.println("5");
	}
	
	@AfterMethod
	public void AfterMethod1()
	{
		System.out.println("6");
	}
	
	@AfterClass
	public void AfterClass1()
	{
		System.out.println("7");
	}
	
	@Test
	public void test2()
	{
		System.out.println("8");
	}
	
	@BeforeMethod
	public void BeforeMethod2()
	{
		System.out.println("9");
	}
	
	@AfterClass
	public void AfterClass2()
	{
		System.out.println("10");
	}
	
	@BeforeMethod
	public void BeforeMethod3()
	{
		System.out.println("11");
	}
	
	@AfterMethod
	public void AfterMethod2()
	{
		System.out.println("12");
	}
	
	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("13");
	}
}
