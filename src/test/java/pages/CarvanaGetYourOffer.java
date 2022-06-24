package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarvanaGetYourOffer {
    public CarvanaGetYourOffer(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".kjoUgV")
    public WebElement errorMessage;
}
