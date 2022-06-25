package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.Driver;
import utilities.DropdownHandler;
import utilities.ExpectedTexts;
import utilities.Waiter;

public class CarvanaSteps {

    WebDriver driver;
    CarvanaHomepage carvanaHomepage;
    CarvanaHelpMeSearchPage carvanaHelpMeSearchPage;
    CarvanaGetYourOffer carvanaGetYourOffer;
    CarvanaSellCarPage carvanaSellCarPage;
    CarvanaAutoLoanCalculatorPage carvanaAutoLoanCalculatorPage;
    Actions actions;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        carvanaHomepage = new CarvanaHomepage();
        carvanaHelpMeSearchPage = new CarvanaHelpMeSearchPage();
        carvanaSellCarPage = new CarvanaSellCarPage();
        carvanaGetYourOffer = new CarvanaGetYourOffer();
        carvanaAutoLoanCalculatorPage = new CarvanaAutoLoanCalculatorPage();
        actions = new Actions(driver);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuNavigation) {
        switch (menuNavigation) {
            case "CAR FINDER":
                Waiter.waitForVisibilityOfElement(driver, carvanaHomepage.carFinderLink,4);
                carvanaHomepage.carFinderLink.click();
                break;
            case "SELL/TRADE":
                Waiter.waitForVisibilityOfElement(driver, carvanaHomepage.sellTradeLink,4);
                carvanaHomepage.sellTradeLink.click();
                break;
            case "AUTO LOAN CALCULATOR":
                Waiter.waitForVisibilityOfElement(driver, carvanaHomepage.autoLoanCalculatorLink,4);
                carvanaHomepage.autoLoanCalculatorLink.click();
                break;
            default:
                throw new NotFoundException("The menu item is not defined properly");
        }
    }


    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text) {
            case "WHAT CAR SHOULD I GET?":
                Assert.assertTrue(carvanaHelpMeSearchPage.h1Heading.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchPage.h1Heading.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertTrue(carvanaHelpMeSearchPage.h3Heading.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchPage.h3Heading.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertTrue(carvanaHelpMeSearchPage.headlineText.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchPage.headlineText.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertTrue(carvanaHelpMeSearchPage.subHeadingText.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchPage.subHeadingText.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertTrue(carvanaSellCarPage.headingText.isDisplayed());
                Assert.assertEquals(text, carvanaSellCarPage.headingText.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertTrue(carvanaSellCarPage.subHeadingText.isDisplayed());
                Assert.assertEquals(text, carvanaSellCarPage.subHeadingText.getText());
                break;
            case "We couldn't find that VIN. Please check your entry and try again.":
                Assert.assertTrue(text, carvanaGetYourOffer.errorMessage.isDisplayed());
                Assert.assertEquals(text, carvanaGetYourOffer.errorMessage.getText());
                break;
            default:
                throw new NotFoundException("The text is not defined properly");
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String link) {
        Assert.assertEquals(link, carvanaHelpMeSearchPage.tryCarFinderLink.getText());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String link) {
        carvanaHelpMeSearchPage.tryCarFinderLink.click();
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button) {
            case "VIN":
                carvanaSellCarPage.vinButton.click();
            case "GET MY OFFER":
                carvanaSellCarPage.getMyOfferButton.click();
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String vinNumber) {
        carvanaSellCarPage.vinInput.sendKeys("00000000000000000");
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String menuNavigation) {
        Assert.assertTrue(carvanaHomepage.financingLink.isDisplayed());
        Assert.assertEquals(menuNavigation, carvanaHomepage.financingLink.getText());
        actions.moveToElement(carvanaHomepage.financingLink).perform();
        Waiter.pause(3);
        actions.moveToElement(carvanaHomepage.autoLoanCalculatorLink).perform();
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String text, String valueOfCarDesired) {
        switch (text) {
            case "Cost of Car I want":
                carvanaAutoLoanCalculatorPage.amountOfVehiclePriceInputBox.sendKeys(valueOfCarDesired);
            case "What is Your Down Payment":
                carvanaAutoLoanCalculatorPage.downPaymentInputBox.sendKeys("1500");
        }
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String texts, String creditScoreTextOptions) {
        switch (texts) {
            case "What’s Your credit Score?":
                DropdownHandler.selectOptionByValue(carvanaAutoLoanCalculatorPage.creditScoreOption, "3");
            case "Choose Your Loan Terms":
                DropdownHandler.selectOptionByValue(carvanaAutoLoanCalculatorPage.amountOfLoanTermOption, "60");
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String monthlyPaymentText) {
        Assert.assertEquals(monthlyPaymentText, CarvanaAutoLoanCalculatorPage.monthlyDisplayValue.getText());
    }
}
