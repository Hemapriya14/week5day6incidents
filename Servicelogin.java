package week5.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Servicelogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev68389.service-now.com");
		driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			
			
			driver.switchTo().frame(0);
driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("Servicenow@123");
	driver.findElement(By.id("sysverb_login")).click();
			driver.switchTo().defaultContent();
	
	//to go incident navigator
			//Enter Incident in filter navigator and press enter
			Thread.sleep(5000);
			WebElement Search = driver.findElement(By.xpath("//input[@name='filter']"));
			Search.sendKeys("incident");
			Thread.sleep(2000);
			Search.sendKeys(Keys.ENTER);
	
	//click new button and fill it
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("(//button[text()='New'])")).click();
		driver.switchTo().defaultContent();
			
			//to get incident number
			driver.switchTo().frame(0);
			WebElement incidentno= driver.findElement(By.id("incident.number"));
			String text = incidentno.getAttribute("value");
		System.out.println(text);
		
			//fill short description and click submit
		driver.findElement(By.id("incident.short_description")).sendKeys("Testleaf");
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		driver.switchTo().defaultContent();
		
		//copy incident number in search box
		driver.switchTo().frame(0);
		WebElement search = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		search.sendKeys(text);
		search.sendKeys(Keys.ENTER);
		
		//incident number verify
		WebElement verifyNo = driver.findElement(By.xpath("//td[@class='vt']//a"));
		String numb= verifyNo.getText();
		System.out.println(numb);
		driver.switchTo().defaultContent();
		
		// verify the instance number created or not)
				if(text.equals(numb)) {
					System.out.println("instance is Created");
				}else {
					System.out.println("instance is Not Created");
				}
	}		
		
}


