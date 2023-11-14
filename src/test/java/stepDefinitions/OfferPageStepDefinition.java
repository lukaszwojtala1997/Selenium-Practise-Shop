package stepDefinitions;

import io.cucumber.java.en.Then;

import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

    TestContextSetup testContextSetup;
    public String offerPageProductName;

    public OfferPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Then("^User searched for (.+) shortname in offers page$")
    public void user_searched_for_same_shortname_in_offers_page(String shortName) {
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);
        offerPageProductName = offersPage.getProductName();
    }

    public void switchToOffersPage(){
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.switchWindowToChild();
    }

    @Then("validate product name in offers page matches with Landing Page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}
