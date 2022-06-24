package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarvanaHelpMeSearchPage {
    public CarvanaHelpMeSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".leftSide h1")
    public WebElement h1Heading;

    @FindBy(css = ".leftSide>h3")
    public WebElement h3Heading;

    @FindBy(css = "a[data-qa='router-link']")
    public WebElement tryCarFinderLink;

    @FindBy(css = ".jXLVsd")
    public WebElement headlineText;

    @FindBy(css = ".esZOxN")
    public WebElement subHeadingText;
}
