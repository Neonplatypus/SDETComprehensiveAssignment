package problemStatement3and4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Automationproblem3 {
	
	public static void main(String arr[]) {
		System.setProperty("webdriver.edge.driver", "D:\\All jar files\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.automationanywhere.com");
		
		WebElement cookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
		cookies.click();
		
		WebElement websiteLogo = driver.findElement(By.xpath("//img[@src='/sites/default/files/images/default-images/logo-aa-new.svg']"));
		
		if(websiteLogo.isDisplayed()) {
			System.out.println("logo is present");
		}
		else {
			System.out.println("logo is not available");
		}
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);"); 
		
		WebElement requestDemoButton = driver.findElement(By.xpath("//a[@class='coh-link utility-nav-link coh-style-solid-orange-button']"));
		if(requestDemoButton.isDisplayed()) {
			System.out.println("button is displayed");
			if(requestDemoButton.isEnabled()) {
				System.out.println("Button is Clickebale");
				//requestDemoButton.click();
			}
			else {
				System.out.println("Button is not clickable");
			}
		}
		else {
			System.out.println("Button is not present");
		}
		
		
		
		
		driver.quit();
	}

}
