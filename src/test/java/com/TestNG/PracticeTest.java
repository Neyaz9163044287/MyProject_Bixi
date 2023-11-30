package com.TestNG;

import org.testng.annotations.Test;

import com.bixi.GenericUtils.BaseClass;

public class PracticeTest extends BaseClass
{
	@Test(groups = "regression")
	public void Practice1()
	{
		System.out.println("-- practice 1 --");
	}
	
	@Test
	public void Practice2()
	{
		System.out.println("-- practice 2 --");
	}
}
