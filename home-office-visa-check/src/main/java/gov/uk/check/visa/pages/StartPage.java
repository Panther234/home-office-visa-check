package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class StartPage extends Utility {
    public StartPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Accept additional cookies']")
    WebElement cookies;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Start now']")
    WebElement startButton;

    public void clickStartNow() {
        clickOnElement(cookies);
        clickOnElement(startButton);
        CustomListeners.node.log(Status.PASS, "Click on next step");
        Reporter.log("Click on next step" + "<br>");
    }


}
