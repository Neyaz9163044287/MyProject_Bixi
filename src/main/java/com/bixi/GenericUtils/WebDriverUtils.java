package com.bixi.GenericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils 
{	
	/**
	 * This methid is used to maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) 
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to wait until page load
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver, int sec) 
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	/**
	 * This method is used to wait until element is visible
	 * @param
	 * @param sec
	 */
	
	public void implicitWait(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void quit(WebDriver driver) 
	{
		driver.quit();
	}
	
	
	public void waituntilEleToBeVisible(WebDriver driver, WebElement element, int sec) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait until element is clickable
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waituntilEleToBeClickable(WebDriver driver, WebElement element, int sec) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to select dropdown by using index
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method is used to select dropdown by using visible text
	 * @param element
	 * @param text
	 */
	public void dropdown(WebElement element, String text) 
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to perform drag and drop
	 * @param driver
	 * @param from
	 * @param to
	 */
	public void dragANdDrop(WebDriver driver, WebElement src, WebElement to) 
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, to).perform();
	}
	/**
	 * This method is used to perform double click on an element
	 * @author Neyaz
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.doubleClick().click().perform();
	}
	
	public void doubleClickOnElement(WebDriver driver, WebElement element) 
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).click().perform();
	}
	
	public void multipleActionOnElement(WebDriver driver, WebElement element,String text) 
	{
		Actions act = new Actions(driver);
		act.click().sendKeys(text).perform();
	}
	
	/**
	 * This method is used to perform right click on an element
	 * @author Neyaz
	 * @param driver
	 * @param element
	 */
	public void rightClickOnWebelement(WebDriver driver, WebElement element) 
	{
		Actions act = new Actions(driver);
		act.contextClick(element).click().perform();
	}
	
	public void rightClickOnPage(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.contextClick().click().perform();
	}
	
	/**
	 * This method is used to perform mouse hover 
	 * @author Neyaz
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	
	public void keyPress(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public void keyPress_Enter() throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void keyRelease_Enter() throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void keyPress_UpArrow() throws Throwable 
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_UP);
	}
	
	public void keyRelease_UpArrow() throws Throwable 
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_UP);
	}
	
	public void keyPress_DownArrow() throws Throwable 
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
	}
	
	public void keyRelease_DownArrow() throws Throwable 
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_DOWN);
	}
		
	public void keyPress_Tab() throws Throwable 
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
	}
	
	public void keyRelease_Tab() throws Throwable 
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_TAB);
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	public void alertpopUp(WebDriver driver) 
	{
		driver.switchTo().alert();
	}
	
	/**
	 * This method is used to fetch the text present in alert popup
	 * @author Neyaz
	 * @param driver
	 */
	public void alertPopupWithText(WebDriver driver) 
	{
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
	}
	
	/**
	 * This method is used to accept alert popup
	 * @author Neyaz
	 * @param driver
	 */
	public void alertPopupAccept(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	
	public void scrollBarAction(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	public void scrollAction(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//int y = element.getLocation().getY();
		//js.executeScript("window.scrollBy(0,"+y+")", element);
		//js.executeScript("argument[0].scrollIntoView();", element);
		js.executeScript("argument[0].scrollIntoView(true);", element);
	}
	public void close(WebDriver driver)
	{
		driver.close();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\Screenshot\\"+screenshotName+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
		
}
