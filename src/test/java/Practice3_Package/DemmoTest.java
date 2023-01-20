package Practice3_Package;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tms.LetsFeelRomania.generic.BaseClass;
import com.tms.objectRepository.AdminHomePage;
import com.tms.objectRepository.AdminLoginPage;
import com.tms.objectRepository.HomePage;
import com.tms.objectRepository.ManagePackagePage;
import com.tms.objectRepository.UpdateTourPackagePage;

public class DemmoTest extends BaseClass{
	
	@BeforeMethod
	public void loginasAdmmin() throws Throwable {
		String username = fLib.readPropertyFile("adminUN");
		String password = fLib.readPropertyFile("adminPWD");
		HomePage hp=new HomePage(driver);
		hp.getAdminLoginLink().click();
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.adminLogin(username, password);
	}

	@Test
	public void test() throws Throwable {
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getTourPackageTab().click();
		Thread.sleep(500);
		ahp.getManagetourPackageTab().click();
		String name="Kerla";
		ManagePackagePage mp=new ManagePackagePage();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@class='sidebar-icon']")).click();
		mp.viewDetails(name,driver);
		UpdateTourPackagePage utp=new UpdateTourPackagePage(driver);
		//string to be updated
		String toupdate="updated";
		WebElement element = utp.getPackageDetailsTextField();
		wLib.scrollAction(driver, element);
		Thread.sleep(3000);
		String previousdetails = element.getText();
		String expDetails=previousdetails+toupdate;
		element.sendKeys(toupdate);
		utp.getUpdateBtn().click();
		ahp.getTourPackageTab().click();
		Thread.sleep(500);
		ahp.getManagetourPackageTab().click();
		mp.viewDetails(name,driver);
		Thread.sleep(2000);
		wLib.scrollAction(driver, element);
		String updateddetails = utp.getPackageDetailsTextField().getText();
		
		//comparing the results for verification of test case
		if(updateddetails.equals(expDetails))
		{
			System.out.println("test passed");
		}
		
	}
}
