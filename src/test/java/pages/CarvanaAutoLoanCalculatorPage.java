package pages;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaAutoLoanCalculatorPage {
    public CarvanaAutoLoanCalculatorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "form[data-form-type='loan-calculator']>div>span")
    public List<WebElement> loanCalculatorHeadingText;

    @FindBy(css = "input[name='vehiclePrice']")
    public WebElement amountOfVehiclePriceInputBox;

    @FindBy(css = "select[id='creditBlock']")
    public WebElement creditScoreOption;

    @FindBy(css = "select[name='loanTerm']")
    public WebElement amountOfLoanTermOption;

    @FindBy(css = "input[name='downPayment']")
    public WebElement downPaymentInputBox;

    @FindBy(css = ".loan-calculator-display-value")
    public WebElement monthlyDisplayValue;

}
