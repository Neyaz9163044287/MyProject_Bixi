package com.TestNG;

 import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bixi.GenericUtils.BaseClass;

@Listeners(com.bixi.GenericUtils.ListenerImplementation.class)
public class Assertions extends BaseClass
{
//	@Test
//	private void hardAssertTest1() 
//	{
//		String exp = "A";
//		System.out.println("--TS-1--");
//		System.out.println("--TS-2--");
//		assertEquals(exp, "B");
//		System.out.println("--TS-3--");
//		System.out.println("--TS-4--");
//	}
	
	@Test
	public void softAssertTest2() 
	{
		String exp = "Registration";
		
		WebDriver driver = new ChromeDriver();
		SoftAssert sa = new SoftAssert();		
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.findElement(By.xpath("//li[contains(text(),'Open Account')]")).click();
		String act = driver.getTitle();
		sa.assertEquals(act, exp);
		System.out.println(act);
		sa.assertAll();
	}
	
	@Test
	private void hardAssertTest3() 
	{
		String exp = "Registration";
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.findElement(By.xpath("//li[contains(text(),'Open Account')]")).click();
		String act = driver.getTitle();
		assertEquals(act, exp);
		System.out.println(act);		
	}
	
	
}
