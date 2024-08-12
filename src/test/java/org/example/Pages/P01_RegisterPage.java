package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class P01_RegisterPage {

    public WebElement openPage()
    {
        return Hooks.driver.findElement(By.className("ico-register"));
    }

    public WebElement registerGender()
    {
        return Hooks.driver.findElement(By.id("gender-female"));
    }

    public WebElement registerFirstName()
    {
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement registerLastName()
    {
        return Hooks.driver.findElement(By.id("LastName"));
    }

    public WebElement[] registerBirthDay()
    {
        WebElement[] birthDate = new WebElement[3];

        birthDate[0] = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        birthDate[1] = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        birthDate[2] = Hooks.driver.findElement(By.name("DateOfBirthYear"));

        return birthDate;
    }

    public WebElement registerEmail()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement registerPassword()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement registerConfirmPassword()
    {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement registerButton()
    {
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public String[] successMessage()
    {
        String[] message = new String[2];
        WebElement messageElement = Hooks.driver.findElement(By.cssSelector("div.result"));

        message[0] = messageElement.getText();
        message[1] = Color.fromString(messageElement.getCssValue("color")).asHex();;

        return message;
    }


    public  WebElement loginPage = Hooks.driver.findElement(By.xpath("css = a[href='/login']"));
}
