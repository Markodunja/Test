package loginTest;

import org.example.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessageOnLogIn {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/markodunjic/Desktop/Selenium/chromedriver-mac-x64/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(Url.urlLoginPage);

        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        //lociranje web elementa preko xpath-a
        String errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        //Assert.assertEquals("Message is not as ecpected", "Epic sadface: Username is required", errorMessage);

        if (errorMessage.equals("Epic sadface: Username is required")) {
            System.out.println("PASSED");

        }

        else {
            System.out.println();
        }

        driver.quit();

    }









}
