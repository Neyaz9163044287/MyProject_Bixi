package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReadDataFromCmdTest
{
	@Test
	public void test1()
	{
		Reporter.log("Hello World",true);
	}
	
	@Test
	public void test2()
	{
		Reporter.log("Heyyyyy", true);
	}
	@Test
	public void test3()
	{
		Reporter.log("Hello Universe",true);
	}
}
