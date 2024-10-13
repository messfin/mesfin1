package sel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import java.time.Duration;

public class Form {
    public static void main(String[] args) {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to the form page
        driver.get("https://formy-project.herokuapp.com/form");

        // Submit the form
        submitForm(driver);

        // Wait for the alert banner to appear
        waitForAlertBanner(driver);

        // Assert the success message in the alert banner
        assertEquals("The form was successfully submitted!", getAlertBannerText(driver));

        // Close the browser
        driver.quit();
    }

    public static void submitForm(WebDriver driver) {
        // Fill out form fields
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("job-title")).sendKeys("QA Engineer");

        // Submit the form
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }

    public static void waitForAlertBanner(WebDriver driver) {
        // Wait for the alert banner to be visible after form submission
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
    }

    public static String getAlertBannerText(WebDriver driver) {
        // Return the alert banner text
        return driver.findElement(By.className("alert")).getText();
    }
}
