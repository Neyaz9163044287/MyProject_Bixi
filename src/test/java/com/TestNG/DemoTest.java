package com.TestNG;

import org.testng.annotations.Test;

import com.bixi.GenericUtils.BaseClass;

public class DemoTest extends BaseClass
{
	@Test
	public void Demo1()
	{
		System.out.println("-- demo 1 --");
	}
	
	@Test(groups = {"smoke","regression"})
	public void Demo2()
	{
		System.out.println("-- demo 2 --");
	}
}
