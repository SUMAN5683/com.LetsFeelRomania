package Practice3_Package;

import org.testng.annotations.Test;

import com.tms.LetsFeelRomania.generic.BaseClass;

import org.testng.annotations.Test;

public class SampleTestForBatchExecTest2 extends BaseClass{
	
		@Test(groups = {"smoke","regression"})
		public void test4()
		{
			System.out.println("----test4----");
		}
		@Test(groups = {"smoke","regression"})
		public void test5()
		{
			System.out.println("----test5----");
		}
		@Test(groups = "smoke")
		public void test6()
		{
			System.out.println("----test6----");
		}
		
	}



