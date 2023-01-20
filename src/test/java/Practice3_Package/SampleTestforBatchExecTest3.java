package Practice3_Package;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tms.LetsFeelRomania.generic.BaseClass;

import org.testng.annotations.Test;
@Listeners(com.tms.LetsFeelRomania.generic.ListnersImpClass.class)
public class SampleTestforBatchExecTest3 extends BaseClass {
	@Test(groups = {"smoke","regression"})
	public void test7()
	{
		System.out.println("----test7----");
	}
	@Test(groups = {"smoke","regression"})
	public void test8()
	
	{
		Assert.fail();
		System.out.println("----test8----");
	}
	@Test(groups = "regression")
	public void test9()
	{
		System.out.println("----test9----");
	}

}
