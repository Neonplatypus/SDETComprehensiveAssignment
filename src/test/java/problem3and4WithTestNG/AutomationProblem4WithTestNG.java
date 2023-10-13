package problem3and4WithTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationProblem4WithTestNG {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.edge.driver", "D:\\All jar files\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.automationanywhere.com");
    }

    @Test(priority = 1, enabled = true, timeOut = 2000)
    public void testLinksAndCookies() throws InterruptedException {
        WebElement cookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        cookies.click();

        String[] links = { "Products", "Solutions", "Resources", "Company" };

        for (String link : links) {
            WebElement linkElement = driver.findElement(By.xpath("//a[normalize-space()='" + link + "']"));

            if (linkElement.isDisplayed()) {
                System.out.println(link + " link is present");
                linkElement.click();
                System.out.println("Navigate to: " + driver.getCurrentUrl());
                driver.navigate().back();
            } else {
                System.out.println(link + " link is not present");
            }
            Thread.sleep(2000);
        }

        WebElement beyondRPA = driver.findElement(By.xpath("//a[@class='coh-link nav-head-link js-coh-menu-item-link '][normalize-space()='Beyond RPA']"));
        if (beyondRPA.isDisplayed()) {
            System.out.println("Beyond RPA link is present");
            beyondRPA.click();
            System.out.println("Navigate to: " + driver.getCurrentUrl());
            driver.navigate().back();
        } else {
            System.out.println("Beyond RPA link is not present");
        }

        Thread.sleep(2000);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
