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
 * ReasonForTravelPage - nextStepButton, reasonForVisitList locators and create methods  'void selectReasonForVisit(String reason)'
 * and  'void clickNextStepButton()'
 */

public class ReasonForTravelPage extends Utility {
    public ReasonForTravelPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> needUKVisa;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;

    public void selectReasonForVisit(String reason) {
        for (WebElement menu : needUKVisa) {
            if (menu.getText().equals(reason)) {
                clickOnElement(menu);
                CustomListeners.node.log(Status.PASS, "Click on '" + reason + "' tab");
                Reporter.log("Click on '" + reason + "' tab <br>");
                break;
            }
        }
    }

    public void clickNextStepButton() {
        clickOnElement(continueButton);
        CustomListeners.node.log(Status.PASS, "Click on next step");
        Reporter.log("Click on next step" + "<br>");
    }

}