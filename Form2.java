import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Form2 {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Setup ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("your-form-page-url");
    }

    @Test
    public void testFormElements() {
        // Assertion for "First name" input
        WebElement firstNameInput = driver.findElement(By.cssSelector("input#first-name"));
        Assert.assertTrue(firstNameInput.isDisplayed(), "First name input should be displayed.");
        firstNameInput.sendKeys("John");

        // Assertion for "Last name" input
        WebElement lastNameInput = driver.findElement(By.cssSelector("input#last-name"));
        Assert.assertTrue(lastNameInput.isDisplayed(), "Last name input should be displayed.");
        lastNameInput.sendKeys("Doe");

        // Assertion for "Job title" input
        WebElement jobTitleInput = driver.findElement(By.cssSelector("input#job-title"));
        Assert.assertTrue(jobTitleInput.isDisplayed(), "Job title input should be displayed.");
        jobTitleInput.sendKeys("Software Engineer");

        // Assertion for the first radio button ("High School")
        WebElement radioButton1 = driver.findElement(By.cssSelector("input#radio-button-1"));
        Assert.assertTrue(radioButton1.isDisplayed(), "High School radio button should be displayed.");
        radioButton1.click();

        // Assertion for the first checkbox ("Male")
        WebElement checkbox1 = driver.findElement(By.cssSelector("input#checkbox-1"));
        Assert.assertTrue(checkbox1.isDisplayed(), "Male checkbox should be displayed.");
        checkbox1.click();

        // Assertion for dropdown (select) menu
        WebElement selectMenu = driver.findElement(By.cssSelector("select#select-menu"));
        Assert.assertTrue(selectMenu.isDisplayed(), "Select menu should be displayed.");
        selectMenu.sendKeys("2-4"); // Selecting "2-4" years of experience

        // Assertion for date picker
        WebElement datePicker = driver.findElement(By.cssSelector("input#datepicker"));
        Assert.assertTrue(datePicker.isDisplayed(), "Date picker should be displayed.");
        datePicker.sendKeys("12/25/2024");

        // Assertion for the submit button
        WebElement submitButton = driver.findElement(By.cssSelector("a.btn-primary"));
        Assert.assertTrue(submitButton.isDisplayed(), "Submit button should be displayed.");
        submitButton.click();

        // Validate URL change after submission (optional)
        Assert.assertEquals(driver.getCurrentUrl(), "your-thank-you-page-url", "Form submission failed!");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
