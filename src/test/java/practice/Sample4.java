package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample4 	//Search for i-phone fetch the product names along with the price which are less than Rs 60000 in www.amazon.in
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/s?k=samsung+m14+5g&crid=3DI1VQYI26ODA&sprefix=samsung+m14%2Caps%2C270&ref=nb_sb_ss_ts-doa-p_1_11");
		List<WebElement> allproductnames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> allprice = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/../../../following-sibling::div[@class='puisg-row']"));
		int count=0;
		
		for(int i=0;i<allprice.size();i++)
		{
			String text = allprice.get(i).getText();
			String price = text.replaceAll(",", "");
			int f_price = Integer.parseInt(price);
			System.out.println(f_price);
			
			if(f_price<=12000)
			{
				System.out.println(allproductnames.get(i).getText()+"  =  "+allprice.get(i).getText());
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
				count++;
			}
		}
		
		/*for(int i=1;i<allproductnames.size();i++)
		{
			System.out.println(allproductnames.get(i).getText()+" = "+allprice.get(i).getText());
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			count++;
		}*/
		System.out.println("Total product = "+count);
		driver.quit();
	}
}
