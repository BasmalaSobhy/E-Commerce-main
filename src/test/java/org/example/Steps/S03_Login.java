package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_LoginPage;
import org.testng.asserts.SoftAssert;

public class S03_Login {
    P03_LoginPage login = new P03_LoginPage();
    SoftAssert soft = new SoftAssert();

    @Given("user go to the login page")
    public void recoveryPage() throws InterruptedException
    {
        login.openPage().click();
    }

    @When("user enters email {string} and password {string}")
    public void log(String email, String password)
    {
        login.loginEmail().sendKeys(email);
        login.loginPassword().sendKeys(password);
    }

    @And("user clicks on the login button")
    public void clickLogin()
    {
        login.loginButton().click();
    }

    @Then("user will login to his account")
    public void successLogin()
    {
        String url = Hooks.driver.getCurrentUrl();

        soft.assertEquals("https://demo.nopcommerce.com/", url, "Correct URL");
        soft.assertTrue(login.accountTab().isDisplayed(), "My account tab is displayed");
        soft.assertAll();
    }

    @Then("user won't login to his account")
    public void failedLogin()
    {
        String[] message = login.errorMessage();

        soft.assertTrue(message[0].contains("Login was unsuccessful."), "Failed To login");
        soft.assertEquals(message[1], "#e4434b", "The color is Red");
        soft.assertAll();
    }
}
