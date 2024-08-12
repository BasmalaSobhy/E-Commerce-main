package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class S06_Categories {
    P04_HomePage home = new P04_HomePage();
    Actions action = new Actions(Hooks.driver);
    int randomCat;
    String name;

    @When("user hover on category")
    public void hover()
    {
        List<WebElement> categories = home.categories();
        int count =  categories.size()-1;
        randomCat =  (int)Math.floor(Math.random()*(count-1+1)+1);

        action.moveToElement(categories.get(randomCat)).perform();
    }

    @And("user selects a category or one of the subcategories")
    public void selection()
    {
        List<WebElement> categories = home.categories();

        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        if (home.subCategories(categories.get(randomCat)) != null)
        {
            WebElement sub = home.subCategories(categories.get(randomCat));
            name = sub.getText();
            sub.click();
        }
        else
        {
            name = categories.get(randomCat).getText();
            categories.get(randomCat).click();
        }

        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("the category or subcategory page will open")
    public void checkCategory()
    {
        String title = home.pageTitle().getText().toLowerCase().trim();
        name = name.toLowerCase().trim();

        System.out.println("The title " + title);
        System.out.println("The name " + name);

        Assert.assertTrue(title.contains(name), "Check category title");
    }
}
