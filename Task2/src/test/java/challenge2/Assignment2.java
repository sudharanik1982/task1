package challenge2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", ".//Resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.weightwatchers.com/us/");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		if (driver.getTitle().contains("Weight Loss Program,Recipes & Help | Weight Watchers"))
			System.out.println("Page title contains \"Weight Loss Program,Recipes & Help | Weight Watchers\" ");
		else {
			System.out.println("Page title doesn't contains \"Weight Loss Program,Recipes & Help | Weight Watchers\" ");
			System.out.println("Actual Title: " + driver.getTitle());
		}

		driver.findElement(By.xpath("//a[contains(@class,'find-a-meeting')]")).click();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		if (driver.getTitle().contains("Get Schedules & Times Near You"))
			System.out.println("Page title contains \"Get Schedules & Times Near You\" ");
		else {
			System.out.println("Page title doesn't contains \"Get Schedules & Times Near You\" ");
			System.out.println("Actual Title: " + driver.getTitle());
		}
		driver.findElement(By.id("meetingSearch")).sendKeys("10011" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		List<WebElement> searchList = driver.findElements(By.xpath("//div[contains(@class,'location__name')]"));
		String firstSearchList = searchList.get(0).getText();

		List<WebElement> searchDistanceList = driver
				.findElements(By.xpath("//div[contains(@class,'location__distance')]"));
		String firstSearchListDistance = searchDistanceList.get(0).getText();
		System.out.println(firstSearchList + "\t" + firstSearchListDistance);
		searchList.get(0).click();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		if (driver.findElement(By.xpath("//div[contains(@class,'location__name')]")).getText()
				.equalsIgnoreCase(firstSearchList)) {
			System.out.println("Search result first string is matched");
		} else {
			System.out.println("Search result first string is not matched");
		}

		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
		String strWeekDay = simpleDateformat.format(new Date());

		System.out.println(
				driver.findElement(By.xpath("//div[contains(text(),'" + strWeekDay + "')]/following-sibling::div"))
						.getText());
		driver.quit();

	}

}
