package Practice3_Package;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.reactivex.rxjava3.functions.Action;

public class dropdowntesting {

	public static void main(String[] args) throws AWTException {
WebDriver driver = new ChromeDriver();
driver.get("file:///C:/Users/suman/OneDrive/Desktop/dropdown.html");
driver.findElement(By.tagName("select")).click();
Robot rbt = new Robot();
rbt.keyPress(KeyEvent.VK_DOWN);
rbt.keyRelease(KeyEvent.VK_DOWN);
rbt.keyPress(KeyEvent.VK_ENTER);
rbt.keyRelease(KeyEvent.VK_ENTER);
	}
}
