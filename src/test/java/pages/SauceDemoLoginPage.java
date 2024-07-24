package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SauceDemoLoginPage extends BasePage{
    public SauceDemoLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = "#react-burger-menu-btn")
    WebElement menu;

    @FindBy(css = ".title")
    WebElement title;

    @FindBy(css = "h3")
    WebElement errorMessage;

    public void enterUsername (String username) throws Exception {
        typeText(usernameInput,username,"Username "+username+" has been typed into the field");
    }

    public void enterPassword (String password) throws Exception {
        typeText(passwordInput,password,"Password "+password+" has been typed into the field");
    }

    public void clickOnLoginButton () throws Exception {
        click(loginButton,"Login button has been clicked!");
    }

    public void menuShouldBeVisible(){
        Assert.assertTrue(menu.isDisplayed());
    }

    public void titleShouldBeVisible(){
        Assert.assertTrue(title.isDisplayed());
    }

    public void verifyErrorMessage(String errorMessageText){
        assertEQ(errorMessage.getText(),errorMessageText, "Error message");
    }
}
