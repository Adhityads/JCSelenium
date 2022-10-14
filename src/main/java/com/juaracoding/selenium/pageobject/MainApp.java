package com.juaracoding.selenium.pageobject;

import com.juaracoding.selenium.pageobject.drivers.DriverSingleton;
import com.juaracoding.selenium.pageobject.pages.WebTables;
import com.juaracoding.selenium.pageobject.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainApp {
    public static void main(String[] args) {

        DriverSingleton.getInstance(Constants.CHROME);
        WebDriver driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);

        WebTables webTables = new WebTables();
        webTables.registrationForm("Text 1", "Text 2","text@email.com","20","20000","SQA");

        //Menutup Iklan
        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", ads);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
