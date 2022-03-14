package week5.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Updateincident {

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
				
						
						//Enter Incident in filter navigator and press enter
						Thread.sleep(5000);
						WebElement Search = driver.findElement(By.xpath("//input[@name='filter']"));
						Search.sendKeys("incident");
						Thread.sleep(2000);
						Search.sendKeys(Keys.ENTER);
						
						//to store value ofexisting incident andclick incident
						driver.switchTo().frame(0);
				String del=	driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).getText();
					System.out.println(del);
					
					//search box incident to pass the exist value
					WebElement update=driver.findElement(By.xpath("//input[@class='form-control']"));
					update.sendKeys(del);
					Thread.sleep(2000);
					update.sendKeys(Keys.ENTER);
					
					driver.findElement(By.xpath("//td[@class='vt']/a")).click();
					
					//click urgency as high and state in progress
					WebElement dropUrgency = driver.findElement(By.xpath("(//select[@id='incident.urgency']/option)[3]"));
					 dropUrgency .click();
					String high = dropUrgency.getText();
					System.out.println(high);
					System.out.println("urgency is selescted"+" "+ dropUrgency.isSelected());
                   //state
					WebElement dropState = driver.findElement(By.xpath("(//select[@id='incident.state']/option)[2]"));
					dropState.click();
					String text = dropState.getText();
					System.out.println(text);
					System.out.println("state isselected"+" "+dropState.isSelected());
			
					// click update
					//
					driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click(); 
						
						
	}

}
