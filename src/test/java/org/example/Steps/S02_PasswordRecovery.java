package org.example.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_LoginPage;
import org.example.Pages.P02_PasswordRecoveryPage;
import org.testng.asserts.SoftAssert;


public class S02_PasswordRecovery {
    P02_PasswordRecoveryPage forget = new P02_PasswordRecoveryPage();
    P03_LoginPage login = new P03_LoginPage();
    SoftAssert soft = new SoftAssert();


    @Given("user go to the password recovery page")
    public void recoveryPage()
    {
        login.openPage().click();
        forget.openPage().click();
    }

    @When("user enters email {string} and clicks on the recover button")
    public void enterEmail(String email)
    {
        forget.recoveryEmail().sendKeys(email);
        forget.passwordRecoveryButton().click();
    }

    @Then("a message will be displayed that an email has been sent to the user")
    public void validRecovery()
    {
        String[] message = forget.notificationMessage();
        soft.assertTrue(message[0].contains("Email with instructions has been sent to you."), "Recovery Message Done");
        soft.assertEquals("#4bb07a",message[1], "Color is Green");
        soft.assertAll();
    }

    @Then("a message will be displayed that the email can't be found")
    public void invalidRecovery()
    {
        String[] message = forget.notificationMessage();
        soft.assertEquals("#e4444c", message[1], "The Color is Red");
        soft.assertTrue(message[0].contains("Email not found."), "Recovery can't be done");
        soft.assertAll();
    }

}
