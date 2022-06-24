package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarvanaSellCarPage {
    public CarvanaSellCarPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".kjhwtS")
    public WebElement headingText;

    @FindBy(css = ".lnhlkr")
    public WebElement subHeadingText;

    @FindBy(css = "button[data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(css = ".FormInput-oo6j68-5")
    public WebElement vinInput;

    @FindBy(css = "button[data-cv-test='heroGetMyOfferButton']")
    public WebElement getMyOfferButton;

}
