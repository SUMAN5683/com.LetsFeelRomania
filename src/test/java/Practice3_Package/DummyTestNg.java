package Practice3_Package;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class DummyTestNg {
	@Test(priority = 1,invocationCount = 2)
	public void create() {
		System.out.println("created");
	}
	
	
	@Test(invocationCount = 0)
	public void delete() {
		System.out.println("deleted");
	}

	
	@Test(dependsOnMethods = "delete")
	public void update() {
		System.out.println("updated");
	}
	
}
