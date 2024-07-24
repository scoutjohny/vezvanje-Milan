package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.SauceDemoLoginPage;
import pages.dmMainPage;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class MainSteps extends BaseTest{
    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");
    Map<String, String> data;
    @Before
    public void setup() throws Exception {
        init(browser);

    }

    @After
    public void tearDown(){
        if(quit.equalsIgnoreCase("yes")){
            quit();
        }
    }

    @Given("I am on the sauce demo page")
    public void iAmOnTheSauceDemoPage() throws Exception {
        openApp(env);
    }

    @Given("I am on the dm page")
    public void iAmOnTheDmPage() throws Exception {
        driver.get("https://www.dm.rs/");
        new dmMainPage(driver).acceptCookies();
        //new dmMainPage(driver).closeModal();   - MODAL VIŠE NIJE PRISUTAN NA SAJTU
    }

    @When("I click on the user icon")
    public void iClickOnTheUserIcon() throws Exception {
        new dmMainPage(driver).clickOnTheProfileIcon();
    }

    @And("I click on the prijava button")
    public void iClickOnThePrijavaButton() throws Exception {
        new dmMainPage(driver).clickOnThePrijavaButton();
    }

    @And("I enter valid email {string}")
    public void iEnterValidEmail(String email) {
        new dmMainPage(driver).enterUsername(email);
    }

    @And("I enter valid password {string}")
    public void iEnterValidPassword(String password) throws Exception {
        new dmMainPage(driver).enterPassword(password);
    }

    @And("I click on the prijavaDva button")
    public void iClickOnThePrijavaDvaButton() throws Exception {
        new dmMainPage(driver).clickOnTheLoginButton();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        new dmMainPage(driver).checkIfLoggedIn();
    }
}
