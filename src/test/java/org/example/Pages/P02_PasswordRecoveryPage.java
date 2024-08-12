package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class P02_PasswordRecoveryPage {

    public WebElement openPage()
    {
        return Hooks.driver.findElement(By.cssSelector("span.forgot-password > a"));
    }

    public WebElement recoveryEmail()
    {
        return Hooks.driver.findElement(By.name("Email"));
    }

    public WebElement passwordRecoveryButton()
    {
        return  Hooks.driver.findElement(By.cssSelector("div.buttons > button.password-recovery-button"));
    }

    public String[] notificationMessage()
    {
        String[] message = new String[2];
        WebElement notification = Hooks.driver.findElement(By.cssSelector("#bar-notification > div"));

        message[0] = notification.getText();
        message[1] = Color.fromString(notification.getCssValue("background-color")).asHex();

        return message;
    }
}
