package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class P03_LoginPage {

    public WebElement openPage(){

        return Hooks.driver.findElement(By.cssSelector("div.header-links a.ico-login"));
    }

    public WebElement loginEmail()
    {
        return Hooks.driver.findElement(By.name("Email"));
    }

    public WebElement loginPassword()
    {
        return Hooks.driver.findElement(By.name("Password"));
    }

    public WebElement loginButton()
    {
        return Hooks.driver.findElement(By.cssSelector("div.buttons > button.login-button"));
    }

    public String[] errorMessage()
    {
        String[] message = new String[2];
        WebElement errorMessage = Hooks.driver.findElement(By.cssSelector("form > div.message-error"));

        message[0] = errorMessage.getText();
        message[1] = Color.fromString(errorMessage.getCssValue("color")).asHex();

        return message;
    }

    public WebElement accountTab()
    {
        return Hooks.driver.findElement(By.className("ico-account"));
    }
}