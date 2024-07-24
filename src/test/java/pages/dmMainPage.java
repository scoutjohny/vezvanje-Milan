package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v121.dom.model.ShadowRootType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class dmMainPage extends BasePage{

    public dmMainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#usercentrics-root")
    WebElement shadowRootParent;

    @FindBy(css = "")
    WebElement getShadowRootElement;

    @FindBy(css = "[data-testid='uc-accept-all-button']")
    WebElement cookieConsentButton;

    @FindBy(css = "[data-dmid='layer-header-close-button']")
    WebElement xButton;

    @FindBy(css = "[aria-label='Moj nalog']")
    WebElement profileIcon;

    @FindBy(css = "#login-button")
    WebElement loginButton;

    @FindBy(css = "#emailAddress-input")
    WebElement username;

    @FindBy(css = "#password-input")
    WebElement password;

    @FindBy(css = "[data-dmid=account-widget-icon-active]")
    WebElement activeProfileIcon;

    public void acceptCookies() {
        //Ovde prvo definišemo element u kome se nalazi shadow dom! :
        final WebElement shadowHost = driver.findElement(By.cssSelector("#usercentrics-root"));

        //Kreiramo JavascriptExecutor objekat da bi koristili JavaScript da nam uđe u shadow root:
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Koristimo JavaScript i pretražujemo shadow root kako bi dohvatili listu svih elemenata u njemu
        SearchContext shadowRoot = (SearchContext)(js.executeScript("return arguments[0].shadowRoot", shadowHost));
        //Konačno, klikćemo na element
        shadowRoot.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']")).click();
    }

    public void closeModal() throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(xButton));
        click(xButton,"Closing the modal");
    }
    public void clickOnTheProfileIcon() throws Exception {
        click(profileIcon,"Profile icon - not logged in");
    }

    public void clickOnThePrijavaButton() throws Exception {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOf(loginButton));
        click(loginButton,"Prijava button");
    }

    public void enterUsername(String username){
        this.username.sendKeys(username);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickOnTheLoginButton() throws Exception {
        click(loginButton,"Prijava button");
    }

    public void checkIfLoggedIn(){
        Assert.assertTrue(activeProfileIcon.isDisplayed());
    }

}
