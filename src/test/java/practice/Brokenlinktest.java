package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlinktest 
{
	public static void main(String[] args) throws IOException 
	{
		//Launch Browser
		WebDriver driver=new ChromeDriver();
		//Maximize the browser
		driver.manage().window().maximize();
		//enter the URL
		driver.get("https://www.irctc.co.in/");
		//driver.get("https:www.flipkart.com");
		//handling Hidden devision Pop up
		//driver.findElement(By.xpath("//span[text()='✕']")).click();
		//Finding all the links
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count = allLinks.size();
		System.out.println(count);
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<count;i++)
		{
			String eachLink= allLinks.get(i).getAttribute("href");
			URL url=null;
			int statuscode = 0;
			try
			{
				url=new URL(eachLink);
				HttpURLConnection urlconn=(HttpURLConnection)url.openConnection();
				statuscode = urlconn.getResponseCode();
				if(statuscode>=400)
				{
					list.add(eachLink);
					System.out.println(eachLink+"----->"+statuscode);
				}
			}
			catch(MalformedURLException e)
			{
				System.out.println(eachLink+"----->"+statuscode);
			}
		}
	}
}
