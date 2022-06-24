package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class BaseSteps {

    WebDriver driver;

    @Before
    public void setup(){
        driver = Driver.getDriver();
    }

    @Given("user is on {string}")
    public void userIsOn(String website) {
        driver.get(website);
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        switch(url){
            case "https://www.carvana.com/help-me-search/":
                Assert.assertEquals(url,driver.getCurrentUrl());
            case "https://www.carvana.com/help-me-search/qa":
                Assert.assertEquals(url,driver.getCurrentUrl());
            case "https://www.carvana.com/sell-my-car":
                Assert.assertEquals(url,driver.getCurrentUrl());
                break;
        }
    }

    @Then("user should see {string} in the url")
    public void user_should_see_in_the_url(String key) {
        for(String word : key.split(" ")){
            Assert.assertTrue(driver.getCurrentUrl().contains(word));
        }
    }

    @Then("user should see {string} in the title")
    public void user_should_see_in_the_title(String key) {
        Assert.assertTrue(driver.getTitle().contains(key));
    }
}