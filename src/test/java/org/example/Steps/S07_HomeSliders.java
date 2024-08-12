package org.example.Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class S07_HomeSliders {
    P04_HomePage home = new P04_HomePage();
    JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

    @When("users clicks on the nokia slider")
    public void nokiaSlider() throws InterruptedException {
        js.executeScript("arguments[0].click();", home.nokiaSlide());
        Thread.sleep(3000);
    }

    @Then("nokia page will open")
    public void openNokia()
    {
        String url = Hooks.driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals("https://demo.nopcommerce.com/nokia-lumia-1020", url, "Open Nokia SLider Page");
    }

    @When("users clicks on the iPhone slider")
    public void iPhoneSlider() throws InterruptedException {
        js.executeScript("arguments[0].click();", home.iPhoneSlide());
        Thread.sleep(3000);
    }

    @Then("iPhone page will open")
    public void openIPhone()
    {
        String url = Hooks.driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/iphone-6", url, "Open iPhone Slider Page");
    }
}
