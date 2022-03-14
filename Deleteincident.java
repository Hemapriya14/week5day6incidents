package week5.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Deleteincident {

	public static void main(String[] args) throws InterruptedException {
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
						
						
		//Enter Incident in filter navigator and press enter
				Thread.sleep(5000);
		WebElement Search = driver.findElement(By.xpath("//input[@name='filter']"));
		Search.sendKeys("incident");
			Thread.sleep(2000);
			Search.sendKeys(Keys.ENTER);

			//to store value ofexisting incident andclick incident
			driver.switchTo().frame(0);
	String del=		driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).getText();
		System.out.println(del);
		
		//search box incident to pass the exist value
		WebElement delete=driver.findElement(By.xpath("//input[@class='form-control']"));
		delete.sendKeys(del);
		Thread.sleep(2000);
		delete.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//td[@class='vt']/a")).click();
		//delete
		driver.findElement(By.xpath("//button[@id='sysverb_delete_bottom']")).click();
		//delete ok alert
		driver.findElement(By.id("ok_button")).click();
		
		//verify delete or not
		String verify=driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		System.out.println(verify);
		String text="No records to display";
		
		
		if(verify.equals(text)) {
			System.out.println("Incident is deleted");
		}
			
			else {
				System.out.println("Incident is not deleted");
			}
			
	}

}
