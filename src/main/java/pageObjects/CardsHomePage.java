package pageObjects;

import Helper.helper;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**************************
 *  (C) L Somni            *
 ***************************/

public class CardsHomePage extends BasePage {

    public CardsHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailField;

    @FindBy(how = How.ID, using = "address")
    private WebElement addressField;

    @FindBy(how = How.CSS, using = "button[type=submit]")
    private WebElement submitBtn;

    @FindBy(how = How.XPATH, using = "//div[@data-testid='ERROR']/form/h3")
    private WebElement errorMsg;

    @FindBy(how = How.XPATH, using = "//*[@data-testid='FINISHED']/following-sibling::div[1]/h1")
    private WebElement submissionMsg;

//    @FindBy(how = How.XPATH, using = "//*[@data-testid='FINISHED']/following-sibling::div/div[1]")
    @FindBy(how = How.XPATH, using = "//*[@data-testid='FINISHED']/following-sibling::div/div[contains(text(),'C1')]")
    private WebElement card1;

//    @FindBy(how = How.XPATH, using = "//*[@data-testid='FINISHED']/following-sibling::div/div[2]")
    @FindBy(how = How.XPATH, using = "//*[@data-testid='FINISHED']/following-sibling::div/div[contains(text(),'C2')]")
    private WebElement card2;

    public void navigateToHomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void enterName(final String name) {
        nameField.sendKeys(name);
    }

    public void enterEmail(final String email) {
        emailField.sendKeys(email);
    }

    public void enterAddress(final String address) {
        addressField.sendKeys(address);
    }

    public void submitForm() {
        submitBtn.click();
    }

    public String getErrorMsg() {
        helper.fluentWait(driver);
        return errorMsg.getText().trim();
    }

    public String getSubmissionMsg() {
        return submissionMsg.getText();
    }

    public boolean isCardSuggestionDisplayed(final int position) throws Exception {
        boolean isDisplayed = false;
        switch (position) {
            case 1:
                isDisplayed= card1.isDisplayed();
                break;
            case 2:
                isDisplayed = card2.isDisplayed();
                break;
            default:
                throw new Exception("Invalid number card supplied");
        }
        return  isDisplayed;
    }
}

