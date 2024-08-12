package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_RegisterPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class S01_Register {
    P01_RegisterPage register = new P01_RegisterPage();
    SoftAssert soft = new SoftAssert();

    @Given("user goes to register page")
    public void registerPage()
    {
        register.openPage().click();
    }

    @When("user selects the gender")
    public void gender()
    {
        register.registerGender().click();
    }

    @And("user enters his first {string} and last {string} name")
    public void name(String first, String last)
    {
        register.registerFirstName().sendKeys(first);
        register.registerLastName().sendKeys(last);
    }

    @And("user enters the date of birth")
    public void birthdate()
    {
        WebElement[] birthdate = register.registerBirthDay();

        Select birthDay = new Select(birthdate[0]);
        Select birthMonth = new Select(birthdate[1]);
        Select birthYear = new Select(birthdate[2]);

        birthDay.selectByValue("30");
        birthMonth.selectByValue("5");
        birthYear.selectByValue("2000");
    }

    @And("user enters the email {string}")
    public void email(String email)
    {
        register.registerEmail().sendKeys(email);
    }

    @And("user enters the password {string}")
    public void pass(String pass)
    {
        register.registerPassword().sendKeys(pass);
    }

    @And("user confirms the password {string}")
    public void confirmPass(String pass)
    {
        register.registerConfirmPassword().sendKeys(pass);
    }

    @And("user clicks register button")
    public void clickRegister()
    {
        register.registerButton().click();
    }

    @Then("user register successfully")
    public void registerSuccess()
    {
        String[] message = register.successMessage();

        soft.assertTrue(message[0].contains("Your registration completed"), "Register is done");
        soft.assertEquals("#4cb17c", message[1], "Color is green");

        soft.assertAll();
    }
}
