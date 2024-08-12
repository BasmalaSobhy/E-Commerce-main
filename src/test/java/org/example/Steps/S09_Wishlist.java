package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P04_HomePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class S09_Wishlist {
    P04_HomePage home = new P04_HomePage();
    SoftAssert soft = new SoftAssert();

    @Given("user clicks on Add to wishlist button")
    public void wishlistAdd()
    {
        home.wishlistButton().click();
    }

    @Then("success message appears")
    public void successMessage()
    {
        String color = Color.fromString(home.wishListMessage().getCssValue("background-color")).asHex();

        soft.assertTrue(home.wishListMessage().getText().contains("The product has been added to your wishlist"), "Wishlist Message");
        soft.assertEquals("#4bb07a", color, "Add to wishlist successfully");
        soft.assertAll();
    }

    @And("success message has disappeared")
    public void messageDisappear()
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(home.wishListMessage()));
    }

    @And("user clicks on wishlist tab")
    public void wishlistTab()
    {
        home.wishlist().click();
    }

    @Then("the quantity of the product on the wishlist will be bigger than 0")
    public void checkQuantity()
    {
        String qty = home.Quantity().getAttribute("value");

        Assert.assertTrue(Integer.parseInt(qty)>0, "Quantity > 0");
    }
}
