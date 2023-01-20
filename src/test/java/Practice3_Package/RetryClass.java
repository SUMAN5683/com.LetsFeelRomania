package Practice3_Package;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tms.LetsFeelRomania.generic.BaseClass;

public class RetryClass extends BaseClass{
	@Test(retryAnalyzer = com.tms.LetsFeelRomania.generic.retryAnalyzerimpClass.class)
	
	public void test() {
		Assert.assertEquals("a", "b");
	}

}
