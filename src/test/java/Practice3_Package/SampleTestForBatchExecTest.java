package Practice3_Package;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tms.LetsFeelRomania.generic.BaseClass;

import org.testng.annotations.Test;

public class SampleTestForBatchExecTest extends BaseClass {
	@Test
	public void test1()
	{
		System.out.println("----test1----");
	}
	@Test
	public void test2()
	{
		Assert.fail();
		System.out.println("----test2----");
	}
	@Test
	public void test3()
	{
		System.out.println("----test3----");
	}
	
}
