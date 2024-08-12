package org.example.Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_HomePage;
import org.testng.Assert;
import java.util.ArrayList;

public class S08_FollowUs {
    P04_HomePage home = new P04_HomePage();

    @When("user clicks on facebook button")
    public void openFacebook() throws InterruptedException {
        home.facebook().click();
        Thread.sleep(3000);
    }

    @When("user clicks on twitter button")
    public void openTwitter() throws InterruptedException {
        home.twitter().click();
        Thread.sleep(3000);
    }

    @When("user clicks on rss button")
    public void openRSS() throws InterruptedException {
        home.rss().click();
        Thread.sleep(3000);
    }

    @When("user clicks on youtube button")
    public void openYoutube() throws InterruptedException {
        home.youtube().click();
        Thread.sleep(3000);
    }

    @Then("{string} is opened in new tab")
    public void newTab(String url)
    {
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        String thisUrl = Hooks.driver.getCurrentUrl();

        Assert.assertEquals(thisUrl, url, "url of new tab");
    }
}
