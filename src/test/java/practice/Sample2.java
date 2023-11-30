package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Sample2 	// fetch product name with product price
{
    public static void main(String[] args) 
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");

        // Locate the elements containing product names and prices
        List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='_1AtVbE']"));
        List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='_30jeq3']"));

        // Create arrays to store product names and prices
        String[] productNames = new String[productElements.size()];
        String[] productPrices = new String[priceElements.size()];

        // Iterate through the elements and store their text
        for (int i = 0; i < productElements.size(); i++) 
        {
            productNames[i] = productElements.get(i).getText();
            productPrices[i] = priceElements.get(i).getText();
        }

        // Print the product names and prices
        for (int i = 0; i < productElements.size(); i++) {
            System.out.println("Product Name: " + productNames[i]);
            System.out.println("Product Price: " + productPrices[i]);
            System.out.println("------------------------");
        }

        driver.quit();
    }
}

