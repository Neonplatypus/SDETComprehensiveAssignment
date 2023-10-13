package problemStatement3and4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AutomationProblem4 {
	public static void main(String arr[]) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "D:\\All jar files\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.automationanywhere.com");
		
		WebElement cookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
		cookies.click();

		String[] Links = { "Products", "Solutions", "Resources", "Company" };

		for (String Link : Links) {
			WebElement Link1 = driver.findElement(By.xpath("//a[normalize-space()='" + Link + "']"));

			if (Link1.isDisplayed()) {
				System.out.println(Link + "link is present");
				Link1.click();
				System.out.println("Navigate to : " + driver.getCurrentUrl());
				driver.navigate().back();

			} else {
				System.out.println("Link is not present");
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
}
