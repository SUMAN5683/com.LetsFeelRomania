package Practice3_Package;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tms.LetsFeelRomania.generic.BaseClass;
import com.tms.LetsFeelRomania.generic.ListnersImpClass;
@Listeners(ListnersImpClass.class)
public class ListnerFeature 
extends BaseClass{
	@Test
	public void takescreenshot() {
		Assert.assertEquals(false, true);
	}

}
