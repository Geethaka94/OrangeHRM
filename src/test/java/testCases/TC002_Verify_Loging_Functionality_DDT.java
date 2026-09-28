package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC002_Verify_Loging_Functionality_DDT extends BaseTest {

	LoginPage lp;
	MyAccountPage mp;

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups={"Regression","Smoke"})
	public void testUserLogin(String userName, String Password, String expectedResult) {

		//logger.info("**** Starting TC002_Verify_Loging_Functionality_DDT ****");

		try {
			lp = new LoginPage(driver);
			lp.setUserName(userName);
			lp.setPassword(Password);
			lp.clickLogin();

			mp = new MyAccountPage(driver);
			boolean targetPage = mp.isMyAccountPageExists();

			if (expectedResult.equalsIgnoreCase("valid")) {
				if (targetPage == true) {
					mp.logOut();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (expectedResult.equalsIgnoreCase("invalid")) {
				if (targetPage == true) {
					mp.logOut();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}

		//logger.info("**** Finished TC002_Verify_Loging_Functionality_DDT ****");

	}

}
