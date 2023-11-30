package com.TestNG;

import org.testng.annotations.Test;

import com.bixi.GenericUtils.BaseClass;

public class SampleTest extends BaseClass
{
	@Test(groups = "smoke")
	public void Sample1()
	{
		System.out.println("-- sample 1 --");
	}
	
	@Test(groups = {"smoke","regression"})
	public void Sample2()
	{
		System.out.println("-- sample 2 --");
	}
}
