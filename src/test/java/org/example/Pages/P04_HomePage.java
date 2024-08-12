package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P04_HomePage {

    // Currencies Elements
    public WebElement currencies()
    {
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }

    public List<WebElement> products()
    {
        return Hooks.driver.findElements(By.cssSelector("div.prices > span.price"));
    }

    // Search Elements
    public WebElement searchInput()
    {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public WebElement searchButton()
    {
        return Hooks.driver.findElement(By.cssSelector("form > button.search-box-button"));
    }

    public List<WebElement> searchProducts()
    {
        return Hooks.driver.findElements(By.className("product-item"));
    }

    public  WebElement searchResult()
    {
        return Hooks.driver.findElement(By.cssSelector("div > h2.product-title"));
    }

    public WebElement sku()
    {
        return Hooks.driver.findElement(By.cssSelector("div.sku"));
    }

    // Categories Elements
    public List<WebElement> categories()
    {
        return Hooks.driver.findElements(By.cssSelector("div.header-menu > ul.notmobile > li"));
    }

    public WebElement subCategories(WebElement category)
    {
        try {
            return category.findElement(By.cssSelector("div.header-menu > ul.notmobile > li > ul >li"));
        } catch (Exception e) {
            return null;
        }
    }

    public WebElement pageTitle()
    {
        return Hooks.driver.findElement(By.cssSelector("div.page-title > h1"));
    }

    // Slider Elements
    public WebElement nokiaSlide()
    {
        return Hooks.driver.findElement(By.cssSelector("#nivo-slider > a:nth-child(1)"));
    }

    public WebElement iPhoneSlide()
    {
        return Hooks.driver.findElement(By.cssSelector("#nivo-slider > a:nth-child(2)"));
    }

    // FollowUp Elements
    public WebElement facebook()
    {
        return Hooks.driver.findElement(By.cssSelector("ul.networks > li.facebook > a"));
    }

    public WebElement twitter()
    {
        return Hooks.driver.findElement(By.cssSelector("ul.networks > li.twitter > a"));
    }

    public WebElement rss()
    {
        return Hooks.driver.findElement(By.cssSelector("ul.networks > li.rss > a"));
    }

    public WebElement youtube()
    {
        return Hooks.driver.findElement(By.cssSelector("ul.networks > li.youtube > a"));
    }

    //Wishlist Elements
    public WebElement wishlist()
    {
        return Hooks.driver.findElement(By.className("ico-wishlist"));
    }

    public WebElement wishlistButton()
    {
        return Hooks.driver.findElement(new By.ByXPath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]"));
    }

    public WebElement wishListMessage()
    {
        return Hooks.driver.findElement(By.cssSelector("div.bar-notification.success"));
    }

    public WebElement Quantity()
    {
        return Hooks.driver.findElement(By.cssSelector("input.qty-input"));
    }
}
