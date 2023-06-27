package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    // browser set up
    String baseUrl = " https://courses.ultimateqa.com/";
    @Before

    public void browserSetUp() {
        openBrowser(baseUrl);
    }


    @Test

    public void userShouldNavigateToLoginPageSuccessfully() {
        //Click on the 'Sign In' link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        // Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("Wrong!",expectedText,actualText);
    }
    @Test
        //  verifyTheErrorMessage
        public void  verifyTheErrorMessage(){
        //  click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        //  Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("prime123");
        // Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("12");
        // Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Verify the error message ‘Invalid email or password.
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Wrong credentials", expectedText,actualText);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}