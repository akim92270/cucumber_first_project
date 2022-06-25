package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarvanaHomepage {
    public CarvanaHomepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "a[data-cv-test='headerCarFinderLink']")
    public WebElement carFinderLink;

    @FindBy(css = "a[data-cv-test='headerTradesLink']")
    public WebElement sellTradeLink;

    @FindBy(css = ".kAQuLc")
    public WebElement financingLink;

    @FindBy(css = "a[data-cv-test='headerFinanceLoanCalc']")
    public WebElement autoLoanCalculatorLink;

}
