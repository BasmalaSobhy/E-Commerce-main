package org.example.Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class S04_Currencies {
    P04_HomePage home = new P04_HomePage();

    @When("user selects the {string} currency")
    public void changeCurrency(String currency)
    {
        Select select = new Select(home.currencies());
        select.selectByVisibleText(currency);
    }

    @Then("currencies for the products will changed to {string}")
    public void productCurrencies(String symbol)
    {
        List<WebElement> productList = home.products();

        for(int i=0; i<4; i++)
        {
            String currency = productList.get(i).getText();
            Assert.assertTrue(currency.contains(symbol), "Changed Currency");
        }
    }
}
