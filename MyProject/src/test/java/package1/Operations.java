package package1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Operations {
	    static WebDriver driver;
	    public static void initialize(String browserName) {
	    	if(browserName.equalsIgnoreCase("chrome")) { 
	    		//WebDriverManager.chromedriver().setup();
	    		driver=new ChromeDriver();
	    		System.out.println("Chrome is launched");
	    	}
	    	else if(browserName.equalsIgnoreCase("edge")) {
	    		//WebDriverManager.edgedriver().setup();
	    		driver=new EdgeDriver();
	    		System.out.println("Edge is Launched");
	    	}
	    } 
	   
	    public static void GetIntoWebsite(String Link) {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    	driver.get("https://www.facebook.com/");
	    	System.out.println("https://www.facebook.com/ GOT OPENED");
	    }
	    
	    public static void Maximize() {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
            driver.manage().window().maximize();
			System.out.println("Window got MAXIMIZED!!");
	    }
	   
		public static Boolean faceBook(String fname,String lname,String phno,String password,String dob) throws InterruptedException, IOException {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
			
			driver.findElement(By.xpath("//div[@class='_6ltg']/child::a")).click();
			System.out.println("Create new Account button got clicked");
			
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fname);
			System.out.println("Firstname is filled as "+fname);
			
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lname);
			System.out.println("Firstname is filled as "+lname);
			
			WebElement phono=driver.findElement(By.xpath("//input[@name='reg_email__']"));
			phono.sendKeys(phno);
			System.out.println("PhoneNumber is filled as "+phno);
		
		    
			String DateOfBirth=dob;
			String[] arr=DateOfBirth.split("-");
			
			Select day=new Select(driver.findElement(By.xpath("//select[@name='birthday_day' and @id='day']")));
			day.selectByVisibleText(arr[0]);
		
			Select month=new Select(driver.findElement(By.xpath("//select[@name='birthday_month' and @id='month']")));
			month.selectByIndex(9);
			
			Select year=new Select(driver.findElement(By.xpath("//select[@name='birthday_year' and @id='year']")));
			year.selectByValue("2001");
			
		    System.out.println("DOB is Filled as "+dob);
			WebElement radio2=driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
		   
			radio2.click();
			System.out.println("Gender as male");
			
			driver.findElement(By.xpath("//button[@name='websubmit']")).click();
			System.out.println("Submit button got clicked");
			TakesScreenshot ts =(TakesScreenshot)driver;
			
			File src = ts.getScreenshotAs(OutputType.FILE);
			File trg = new File("C:\\Users\\2318390\\eclipse-workspace\\MyProject\\src\\main\\resources\\screenshots\\ss1.png");
			FileUtils.copyFile(src, trg);
			
	      
			
		  System.out.println("Errors are:");
	      String a1=driver.findElement(By.xpath("//div[contains(text(),'at least six numbers, letters and punctuation marks (such as ! and &).')]")).getText();
	      System.out.println(a1);
	      
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("//button[@name='websubmit']")).click();
	      
	        TakesScreenshot ts1 =(TakesScreenshot)driver;
			
			File src1 = ts1.getScreenshotAs(OutputType.FILE);
			File trg1 = new File("C:\\Users\\2318390\\eclipse-workspace\\MyProject\\src\\main\\resources\\screenshots\\ss2.png");
			FileUtils.copyFile(src1, trg1);
	      
	      
	      
	      
	      String a2=driver.findElement(By.xpath("//div[contains(text(),'valid mobile number or email address.')]")).getText();
	      System.out.println(a2);
	      
	      System.out.println("--------------------------------------------------------------------------------------------------------");
	      
	      if(a1.contains("at least six") && a2.contains("valid mobile number")) {
	    	  return true;
	      }
	      return false;
	      
	     
		}
		
		public static void End() {
			driver.quit();
		}
}
