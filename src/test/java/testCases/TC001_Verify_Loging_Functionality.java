package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC001_Verify_Loging_Functionality extends BaseTest {

	LoginPage lp;
	MyAccountPage mp;

	@Test
	public void testUserLogin() {
		
		try {
		logger.info("****Test Case Starting****");
		lp = new LoginPage(driver);
	    logger.debug("**** Enter User Credentials ****");
		lp.setUserName("Admin");
		lp.setPassword("admin1234");
		lp.clickLogin();
		String title=driver.getTitle();
		logger.debug("**** Assert Title ****");
		Assert.assertEquals(title, "OrangeHRM");
		
		mp=new MyAccountPage(driver);
		Assert.assertTrue(mp.isMyAccountPageExists());
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** TC001 is Finished ****");
	}

}
