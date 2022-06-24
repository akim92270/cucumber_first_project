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

    @FindBy(id = "creditBlock")
    public WebElement creditScoreOption;

    @FindBy(css = "select[name='loanTerm'] option")
    public List<WebElement> amountOfLoanTermOption;

    @FindBy(css = "input[name='downPayment']")
    public WebElement downPaymentInputBox;

    public void clickOnLoanTermOptions(String loanText) {
        for (WebElement text : amountOfLoanTermOption) {
            if (text.getText().equals(loanText)) {
                text.click();
                break;
            }
        }
    }
}
