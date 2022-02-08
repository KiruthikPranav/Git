package Lead;

import org.testng.annotations.Test;
import com.crm.baseClass.BaseClass;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LeadPage;

/** For one class we use @Listener. 
 * 	But for Multiple class we use in Xml
 * @Listeners(com.crm.baseClass.Listener.class)
*/
public class TL_01NavigateToLeadPageTest extends BaseClass {
	
	@Test(groups= {"Smoke","Full Regression"})
	public void createLead() 
	{
		HomePage homePage = new HomePage(driver);
		homePage.clickLead();
		LeadPage leadpage = new LeadPage(driver);
		leadpage.clickLeadImage();
	}	

}