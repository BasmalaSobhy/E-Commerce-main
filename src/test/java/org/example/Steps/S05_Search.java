package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class S05_Search {
    P04_HomePage home = new P04_HomePage();
    SoftAssert soft = new SoftAssert();

    @When("user enters the product name {string} in the search input")
    public void searchName(String name) {
        home.searchInput().sendKeys(name);
    }

    @When("user enters the product serial number {string} in the search input")
    public void searchSerial(String serial) {
        home.searchInput().sendKeys(serial);
    }

    @And("user clicks on the search button")
    public void clickSearch() {
        home.searchButton().click();
    }

    @Then("user gets the result of the search with name {string}")
    public void searchWithName(String name)
    {
        String url = Hooks.driver.getCurrentUrl();
        List<WebElement> products = home.searchProducts();
        int productsCount = products.size();

        for(int i=0; i<productsCount; i++)
        {
            String resultText = products.get(i).getText().toLowerCase();
            soft.assertTrue(resultText.contains(name), "Check the result against the search");
        }

        soft.assertTrue(url.contains("https://demo.nopcommerce.com/search?q="), "search with name result");
        soft.assertAll();
    }

    @Then("user gets the result of the search with serial {string}")
    public void searchWithSKU(String serial)
    {
        home.searchResult().click();
        String sku = home.sku().getText();

        Assert.assertTrue(sku.contains(serial));
    }
}
