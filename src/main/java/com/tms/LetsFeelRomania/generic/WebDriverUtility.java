package com.tms.LetsFeelRomania.generic;

	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.util.Iterator;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class WebDriverUtility {
		/**
		 * launch chrome browser
		 */
		public void launchBrowser() {
			WebDriverManager.chromedriver().setup();
			
		}
	/**
	 * 
	 * @param driver
	 * @param partialTitle
	 */
				public void maximizeWindow(WebDriver driver)
				
				{
					driver.manage().window().maximize();
				}
	/**
	 * 
	 * @param driver
	 */
				public void implicityWait(WebDriver driver)
				
				{
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
	/**
	 * 			
	 * @param driver
	 * @param element
	 */
				public void explicitlyWait(WebDriver driver, WebElement element)
				{
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.visibilityOf(element));
				}
	/**
	 * 
	 * @param element
	 * @param value
	 */
				public void selectClassString(WebElement element, String value)
				{
					Select sel = new Select(element);
					sel.selectByValue(value);
				}
	/**
	 * 		
	 * @param elemen
	 */
				public void selectClassInt(WebElement element, int index)
				{
					Select sel = new Select(element);
					sel.selectByIndex(index);
				}
	/**
	 * 		
	 * @param visibleText
	 * @param element
	 */
				public void selectClassVisibleText(String visibleText, WebElement element)
				{
					Select sel = new Select(element);
					sel.selectByValue(visibleText);
				}
	/**
	 * 		
	 * @param driver
	 * @param element
	 */
				public void mouseHover(WebDriver driver, WebElement element)
				{
					Actions act = new Actions(driver);
					act.moveToElement(element).perform();
				}
	/**
	 * 		
	 * @param driver
	 * @param src
	 * @param dst
	 */
				public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
				{
					Actions act = new Actions(driver);
					act.dragAndDrop(src, dst).perform();
				}
	/**
	 * 		
	 * @param driver
	 */
				public void doubleClickAction(WebDriver driver)
				{
					Actions act= new Actions(driver);
					act.doubleClick().perform();
				}
	/**
	 * 		
	 * @param driver
	 */
				public void rightClick(WebDriver driver)
				{
					Actions act= new Actions(driver);
					act.contextClick().perform();
				}
	/**
	 * 		
	 * @param driver
	 * @param element
	 */
				public void rightClick(WebDriver driver, WebElement element)
				{
					Actions act= new Actions(driver);
					act.contextClick(element).perform();
				}
	/**
	 * 		
	 * @param driver
	 */
				public void enterKeyPress(WebDriver driver)
				{
					Actions act= new Actions(driver);
					act.sendKeys(Keys.ENTER).perform();
				}
	/**
	 * 		
	 * @param driver
	 * @throws Throwable
	 */
				public void robotClass(WebDriver driver) throws Throwable
				{
					Robot rb= new Robot();
					rb.keyPress(KeyEvent.VK_ENTER);
					rb.keyRelease(KeyEvent.VK_ENTER);
				}
	/**
	 * 		
	 * @param driver
	 * @param index
	 */
				public void switchToFrameIndex(WebDriver driver, int index)
				{
					driver.switchTo().frame(index);
				}
	/**
	 * 		
	 * @param driver
	 * @param nameOrID
	 */
				public void switchToFrameName(WebDriver driver, String nameOrID)
				{
					driver.switchTo().frame(nameOrID);
				}
	/**
	 * 		
	 * @param driver
	 * @param address
	 */
				public void switchToFrameAddress(WebDriver driver, WebElement address)
				{
					driver.switchTo().frame(address);
				}
	/**
	 * 		
	 * @param driver
	 */
				public void acceptAlert(WebDriver driver)
				{
					driver.switchTo().alert().accept();
				}
	/**
	 * 		
	 * @param driver
	 */
				public void dismissAlert(WebDriver driver)
				{
					driver.switchTo().alert().dismiss();
				}
	/**
	 * 
	 * @param driver
	 * @param partialTitle
	 */
				public void switchToWindow(WebDriver driver, String partialTitle)
				{
					//step1: use getWindowHandes to capture all window id's
					Set<String> windows = driver.getWindowHandles();
					
					//step2: iterate through the windows
					Iterator<String> it = windows.iterator();
					
					//step3: check whether there is next window
					while(it.hasNext())
					{
						//step4: capture current window id
						String winId = it.next();
						
						//step5: switch to current window and capture title 
						String currentWinTitle = driver.switchTo().window(winId).getTitle();
						
						//step6: check whether current window is expected
						if(currentWinTitle.contains(partialTitle))
						{
							break;
						}
					}
				}
	/**
	 * 		
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
				public static String screenShot(WebDriver driver, String screenShotName) throws Throwable
					{
						TakesScreenshot ts = (TakesScreenshot) driver;
						File src = ts.getScreenshotAs(OutputType.FILE);
						String path = ".\\screenshot\\"+screenShotName+".png";
						File dst = new File(path);
						FileUtils.copyFile(src, dst);
						return path;
						
					}
	/**
	 * 		
	 * @param driver
	 */
				public void scrollBarAction(WebDriver driver)
				{
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,800)","");
				}
	/**
	 * 		
	 * @param driver
	 * @param element
	 */
				public void scrollAction(WebDriver driver, WebElement frm)
				{
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView()",frm);
					
//					int y = element.getLocation().getY();
//					jse.executeScript("window.scrollBy(0,"+y+")", element);
					
				}
			


		}
	


