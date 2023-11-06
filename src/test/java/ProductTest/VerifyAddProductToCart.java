package ProductTest;


import org.example.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyAddProductToCart {

    public static void main (String[] arg) {

        System.setProperty("webdriver.chrome.driver", "/Users/markodunjic/Desktop/Selenium/chromedriver-mac-x64/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(Url.urlLoginPage);


        WebElement inputuserName = driver.findElement(By.id("user-name"));
        inputuserName.clear();
        inputuserName.sendKeys("standard_user");


        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys("secret_sauce");


        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        //nalazimo inventory list
        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        //inventoryList.findElements(By.xpath("//div[@class='inventory_item']"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath("//div[@class= 'inventory_item']"));


        for (int i = 0; i < inventoryItems.size(); i++) {
            WebElement item = inventoryItems.get(i);
            WebElement itemName = item.findElement(By.xpath(".//div[@class='inventory_item_name ']"));
            if (itemName.getText().equals("Sauce Labs Backpack")) {
                WebElement button = item.findElement(By.xpath(".//button"));
                button.click();
                System.out.println("Item added");
                break;
            }
        }



    }
}
