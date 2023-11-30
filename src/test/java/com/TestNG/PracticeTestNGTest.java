package com.TestNG;

import org.testng.annotations.Test;

public class PracticeTestNGTest 
{
	@Test(dependsOnMethods = "editTest", priority = 2, invocationCount = 5)
	private void createTest() 
	{
		System.out.println("----Create----");
	}
	
	@Test
	private void editTest() 
	{
		System.out.println("----Edit----");
	}
	
	@Test
	private void deleteTest() 
	{
		System.out.println("----Delete----");
	}
}
