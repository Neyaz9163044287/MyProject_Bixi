package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetryTest 
{
	@Test(retryAnalyzer = com.bixi.GenericUtils.RetryImpclass.class)
	public void practiceRetry()
	{
		System.out.println("-----execution starts----");
		Assert.fail();
	}
}
