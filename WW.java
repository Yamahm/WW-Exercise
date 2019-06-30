package seleniumTest;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class WW {

	public static void main(String[] args) throws InterruptedException {
		
		//Forced location of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "/SeleniumWebDriver/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.weightwatchers.com/us/";
		String frontPage = "WW (Weight Watchers): Weight Loss & Wellness Help";
		String studioPage = "Find WW Studios & Meetings Near You | WW USA";
		
		//Check to see if the title match for front page
		driver.get(baseUrl);
		if(frontPage.contentEquals(driver.getTitle())) {
			System.out.println("Front Page Title is Correct! Title: " + frontPage);
		} else {
			System.out.println ("ERROR: Studio Page Title is not correct. Actual title is: " + driver.getTitle());
		}
		
		//Check to see if the title match for studio page
		driver.findElement(By.linkText("Find a Studio")).click();
		if(studioPage.contentEquals(driver.getTitle())) {
			System.out.println("Front Page Title is Correct! Title: " + studioPage);
		} else {
			System.out.println ("ERROR: Front Page Title is not correct. Actual title is: " + driver.getTitle());
		}
		
		WebElement meetingSearch = driver.findElement(By.id("meetingSearch"));
		meetingSearch.sendKeys("10011");;
		meetingSearch.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		//Commands select the first time the element appears
		String firstName = driver.findElement(By.xpath("//span[@ng-if='!linkName']")).getText();
		String firstDist = driver.findElement(By.className("location__distance")).getText();
		System.out.println("Title of the first result" + firstName);
		System.out.println("Distance of the first result" + firstDist);
		
		driver.findElement(By.className("meeting-location")).click();
		
		Thread.sleep(3000);
		
		//Saves the Title from selected page
		String nextPage = driver.findElement(By.xpath("//span[@ng-if='!linkName']")).getText();
		
		//Verify that the titles match
		if(firstName.contentEquals(nextPage)) {
			System.out.println("The Titles match!");
		} else {
			System.out.println("ERROR: Titles do not match!");
		}
		
		//get TODAY Day
		String today = LocalDate.now().getDayOfWeek().name();
		String abrToday = today.substring(0,3);
		
		//Print out the hours of operation for Today
		for(int i = 1;i<8;i++) {
			if(abrToday.contentEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/ui-view/ui-view/div[1]/div[2]/div/div/div[2]/div[1]/hours-list/ul/li["+ i +"]/div/div[1]")).getText())) {
				System.out.println("Today's Hours of Operation: " + today + " " + driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/ui-view/ui-view/div[1]/div[2]/div/div/div[2]/div[1]/hours-list/ul/li["+ i +"]/div/div[2]/div")).getText());
			}
		}

		
		driver.close();
		System.exit(0);
	}
}
