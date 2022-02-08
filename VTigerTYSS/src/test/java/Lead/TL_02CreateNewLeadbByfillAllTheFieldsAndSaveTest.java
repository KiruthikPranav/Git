package Lead;

import org.testng.annotations.Test;
import com.crm.baseClass.BaseClass;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LeadPage;

public class TL_02CreateNewLeadbByfillAllTheFieldsAndSaveTest extends BaseClass {
	
	@Test(groups="Smoke")
	public void createNewLeadbByfillAllTheFieldsAndSave() {
		HomePage homePage = new HomePage(driver);
		homePage.clickLead();
		LeadPage leadpage = new LeadPage(driver);
		leadpage.clickLeadImage();
		leadpage.firstName();
	}
	
}