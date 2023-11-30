package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
												//print matches with position
public class sample1 {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> allpos = driver.findElements(By.xpath("//table/tbody/tr/td[2]/span[@class='u-hide-phablet']"));
		List<WebElement> allmat = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
		
		String[] pos=new String[allpos.size()];
		String[] mat=new String[allmat.size()];
		
		for (int i = 0; i < allpos.size(); i++) 
		{
            pos[i] = allpos.get(i).getText();
            mat[i] =  allmat.get(i).getText();
		}
		
		for (int i = 0; i < allpos.size(); i++) 
		{
            System.out.println("Position : " + pos[i]+"  -------------  "+ "Matches : " + mat[i]);
       
        }
		
		driver.quit();
	}

}
