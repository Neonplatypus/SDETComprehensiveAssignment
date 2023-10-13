package problem3and4WithTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationProblem3WithTestNG {
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "D:\\All jar files\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.automationanywhere.com");
        Thread.sleep(3000);

        WebElement cookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        cookies.click();
    }

    @Test(priority = 1, enabled = true, timeOut = 2000)
    public void testWebsiteLogoPresence() {
        WebElement websiteLogo = driver.findElement(By.xpath("//img[@src='/sites/default/files/images/default-images/logo-aa-new.svg']"));
        if (websiteLogo.isDisplayed()) {
            System.out.println("Logo is present");
        } else {
            System.out.println("Logo is not available");
        }
    }

    @Test(priority = 2, enabled = true)
    public void testRequestDemoButton() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000)");

        WebElement requestDemoButton = driver.findElement(By.xpath("//a[@class='coh-link utility-nav-link coh-style-solid-orange-button']"));
        if (requestDemoButton.isDisplayed()) {
            System.out.println("Button is displayed");
            if (requestDemoButton.isEnabled()) {
                System.out.println("Button is Clickable");
                // Uncomment the line below if you want to click the button
                // requestDemoButton.click();
            } else {
                System.out.println("Button is not clickable");
            }
        } else {
            System.out.println("Button is not present");
        }
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
