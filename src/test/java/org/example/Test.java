package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) {

       //final String urlproductPage = "https://www.saucedemo.com/invetory.html";
       final String urlLoginPage = "https://www.saucedemo.com/";


        System.setProperty("webdriver.chrome.driver", "/Users/markodunjic/Desktop/Selenium/chromedriver-mac-x64/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        //set username
        WebElement inputuserName = driver.findElement(By.id("user-name"));
        inputuserName.clear();
        inputuserName.sendKeys("standard_user");

        //set password
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys("secret_sauce");

        //click on log in
        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        //validacija. potvrda da je test prosao/pao
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        if (currentUrl.equals(urlLoginPage)) {
            System.out.println("PASSED");
        }
        else
            System.out.println("FAILED");

        driver.quit();



    }


}
