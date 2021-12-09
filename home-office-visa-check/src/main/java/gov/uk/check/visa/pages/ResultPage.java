package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * ResultPage - resultMessage locator and create methods 'String getResultMessage()' and
 * 'void confirmResultMessage(String expectedMessage)' (Note Use Assert.assertTrue)
 */

public class ResultPage extends Utility {
    public ResultPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//*[@id='result-info']/div[2]/h2")
    WebElement getMessage;

    public String getResultMessage() {
        String message = getTextFromElement(getMessage);
        CustomListeners.node.log(Status.PASS, "Checking is message displayed : " + getMessage.getText());
        Reporter.log("Checking is message displayed : " + getMessage.getText() + "<br>");
        return message;
    }

    public boolean resultMessage() {
        boolean b = Boolean.parseBoolean(getResultMessage());
        return b;
    }

    public void confirmResultMessage() {
       Assert.assertTrue(resultMessage(), "Logout link is not displayed");
        CustomListeners.node.log(Status.PASS, "Confirm message displayed : " + getMessage.getText());
        Reporter.log("Confirm message displayed : " + getMessage.getText() + "<br>");
    }
}
