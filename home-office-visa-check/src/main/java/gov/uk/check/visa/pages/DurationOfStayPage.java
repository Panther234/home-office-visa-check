package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;
/**
 * DurationOfStayPage - nextStepButton, lessThanSixMonths, moreThanSixMonths locators and create methods
 * 'void selectLengthOfStay(String moreOrLess)' (Note: use switch statement for select moreOrLess stay) and
 * 'void clickNextStepButton()'
 */

public class DurationOfStayPage extends Utility {
    public DurationOfStayPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> selectStay;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;


    public void selectLengthOfStay(String moreOrLess) {
        switch (moreOrLess) {
            case "6 months or less":
                selectStay.get(0).click();
                break;
            case "longer than 6 months":
                selectStay.get(1).click();
                break;
        }
    }

    public void clickNextStepButton() {
        clickOnElement(continueButton);
        CustomListeners.node.log(Status.PASS, "Click on next step");
        Reporter.log("Click on next step" + "<br>");
    }
}
