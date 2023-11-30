package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
								// check whether name is present
public class CountryTable {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String name="England";
		List<WebElement> allname = driver.findElements(By.xpath("//table/tbody/tr/td[2]/span[2]"));
		boolean flag=false;
		for(WebElement names:allname)
		{
			String st = names.getText();
			if(st.equals(name))
			{
				System.out.println("Name is present");
				flag=true;
				break;
			}
		}
			if(!flag)
			{
				System.out.println("Name is not present");
			}
		driver.quit();
}
}

