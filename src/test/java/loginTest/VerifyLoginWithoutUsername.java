package loginTest;

import org.example.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLoginWithoutUsername {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/markodunjic/Desktop/Selenium/chromedriver-mac-x64/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(Url.urlLoginPage);

        //set username
        WebElement inputuserName = driver.findElement(By.id("user-name"));
        inputuserName.clear();


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


        if (currentUrl.equals("https://www.saucedemo.com/")) {
            System.out.println("PASSED");
        }
        else
            System.out.println("FAILED");


        driver.quit();





    }


}
