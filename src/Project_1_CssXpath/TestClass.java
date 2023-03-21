package Project_1_CssXpath;

import Utility.BaseDriver;
import com.google.common.annotations.VisibleForTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.junit.Assert;

public class TestClass extends BaseDriver {

    @Test
    public void Test1() {

        WebElement firstName = driver.findElement(By.cssSelector("input[id='FirstName']"));
        firstName.sendKeys("Mahirr");

       wait(1);
        WebElement surName = driver.findElement(By.cssSelector("input[id='Surname']"));
        surName.sendKeys("Akçayy");

       wait(1);
        WebElement email = driver.findElement(By.cssSelector("input[id='E_post']"));
        email.sendKeys("mahirAkçayy@gmail.com");

      wait(1);

        WebElement mobile = driver.findElement(By.cssSelector("input[id='Mobile']"));
        mobile.sendKeys("5552948156");

     wait(1);

        WebElement userName = driver.findElement(By.cssSelector("div[class='form-horizontal']>:nth-child(7)>div>input"));
        userName.sendKeys("akçyy");

      wait(1);
        WebElement password = driver.findElement(By.cssSelector("[id='Password']"));
        password.sendKeys("1234566");

      wait(1);

        WebElement confirmPassword = driver.findElement(By.cssSelector("[id='ConfirmPassword']"));
        confirmPassword.sendKeys("1234566");

      wait(1);

        WebElement submit = driver.findElement(By.cssSelector("input[id='submit']"));
        submit.click();

      wait(1);

        WebElement registration = driver.findElement(By.xpath("//*[text()='Registration Successful']"));
        System.out.println(registration.getText());

     wait(1);
    }

    @Test
    public void Test2() {
        driver.get("https://itera-qa.azurewebsites.net/");

        WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
        login.click();

      wait(1);

        WebElement userName = driver.findElement(By.xpath("//input[@id='Username']"));
        userName.sendKeys("akçyy");

       wait(1);

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("1234566");

       wait(1);

        WebElement loginclick = driver.findElement(By.xpath("//input[@name='login']"));
        loginclick.click();

        wait(1);

        WebElement confirm = driver.findElement(By.cssSelector("div[class='container body-content'] h3"));
        Assert.assertTrue(confirm.getText().contains("Welcome"));
        System.out.println(confirm.getText());
        wait(1);


    }

    @Test
    public void Test3() {
        driver.get("https://itera-qa.azurewebsites.net/");

        String xpath = "//a[text()='Login' and @class='nav-link']";
        driver.findElement(By.xpath(xpath)).click();

        wait(1);

        WebElement userName = driver.findElement(By.xpath("//input[@id='Username']"));
        userName.sendKeys("akçyy");

        wait(1);

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("1234566");

        wait(1);

        WebElement loginclick = driver.findElement(By.xpath("//input[@name='login']"));
        loginclick.click();

        wait(1);

        WebElement create = driver.findElement(By.xpath("//a[text()='Create New']"));
        create.click();

        wait(1);

        WebElement name = driver.findElement(By.cssSelector("[id=Name]"));
        name.sendKeys("Yunus");

        wait(1);

        WebElement company = driver.findElement(By.cssSelector("[id=Company]"));
        company.sendKeys("Techno Study");

        wait(1);

        WebElement address = driver.findElement(By.cssSelector("[id=Address]"));
        address.sendKeys("Highway St.");

        wait(1);

        WebElement city = driver.findElement(By.cssSelector("[id=City]"));
        city.sendKeys("New Jersey");

        wait(1);

        WebElement phone = driver.findElement(By.cssSelector("[id=Phone]"));
        phone.sendKeys("+1 895 42 512");

        wait(1);

        WebElement email = driver.findElement(By.cssSelector("[id=Email]"));
        email.sendKeys("yunus@gmail.com");

        wait(1);

        WebElement createButton = driver.findElement(By.cssSelector("input[type=submit]"));
        createButton.click();

        wait(1);
        driver.quit();


    }
}
