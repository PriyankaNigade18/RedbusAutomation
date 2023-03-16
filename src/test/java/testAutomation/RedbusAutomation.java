package testAutomation;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RedbusAutomation 
{
	public static void dateselection(WebDriver driver,String month,String year,String date)
	{
		//Month selection
				while(true)
				{
					String text=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
					//System.out.println(text);
					String arr[]=text.split(" ");
					String mon=arr[0];
					String yer=arr[1];
					
					if(mon.equals(month) && yer.equals(year))
					{
						break;
					}else
					{
						driver.findElement(By.xpath("//button[text()='>']")).click();
						
					}
								
//					System.out.println(arr[0]);
//					System.out.println(arr[1]);
//					break;
				}
				
				//Date selection
				
				List<WebElement> alldates=driver.findElements(By.xpath("//table//tbody//tr//td"));		
				
				for(WebElement i:alldates)
				{
					//System.out.println(i.getText());
					if(i.getText().equals(date))
					{
						i.click();
						break;
					}
					
				}
				
				
	}
  @Test
  public void testLogin() throws InterruptedException
  {
	  Scanner sc=new Scanner(System.in);
	  //WebDriver driver=new EdgeDriver();
	  WebDriver driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.redbus.in");
	  driver.manage().window().maximize();
	  
	  /*//Search buses
	  driver.findElement(By.id("src")).sendKeys("Viman Nagar, Pune",Keys.ENTER);
	  driver.findElement(By.id("dest")).sendKeys("Bangalore",Keys.ENTER);
	  driver.findElement(By.id("onward_cal")).click();
	  Thread.sleep(2000);
	  dateselection( driver,"Mar","2023","31");
	  //Thread.sleep(2000); 
	  
	 // driver.findElement(By.cssSelector("button.fl.button#search_btn")).click();
	  WebElement ele=driver.findElement(By.xpath("(//*[normalize-space()='Search Buses'])[1]"));
	 Actions act=new Actions(driver);
	  act.moveToElement(ele).click();
	  //driver.findElement(By.xpath("//section[@id='search'] //button[@id='search_btn']")).click();
	  
	  
	  System.out.println("Clicked on button");
	  
	  driver.navigate().to("https://www.redbus.in/search?fromCityName=Viman%20Nagar%2C%20Pune&fromCityId=66927&toCityName=Bangalore&toCityId=122&onward=31-Mar-2023&srcCountry=IND&destCountry=IND&opId=0&busType=Any");
	  
	  Thread.sleep(2000);
	  List<WebElement> listofbuses=driver.findElements(By.xpath("//ul[@class='bus-items']//div//li//div[contains(@class,'bus-type')]"));
	  
	  System.out.println(listofbuses.size());
	  for(WebElement i:listofbuses)
	  {
		  System.out.println(i.getText());
	  }
	  
	  */
	  driver.findElement(By.xpath("//i[@id='i-icon-profile']")).click();
	  
	  driver.findElement(By.xpath("//ul//li[@id='signInLink']")).click();
	  
	  Thread.sleep(2000);
	
	  WebElement frame1=driver.findElement(By.xpath("//div[@class='modalFrame']//div[@class=\"modalContent\"]//iframe"));
	  
	  driver.switchTo().frame(frame1);
	  System.out.println("Switched to the frame!");
	  WebElement number=driver.findElement(By.xpath("//div[@class='mobileInput clearfix']//input[@placeholder='Enter your mobile number']"));
	  number.click();
	  number .sendKeys("9552671595");
	  //captch
	  WebElement frame2=driver.findElement(By.xpath("//div[@class='otpContainerRecaptcha clearfix']//iframe"));
	  driver.switchTo().frame(frame2);
	  System.out.println("Switched to the capcha frame!");
	  
	  driver.findElement(By.xpath("(//div[@class='rc-anchor-content']//span[@id='recaptcha-anchor'])[1]")).click();
	  
	  Thread.sleep(5000);
	  //to generate otp
	 // driver.findElement(By.xpath("//span[@class='f-w-b']")).click();
	  //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[6]")).click();
	 // driver.findElement(By.xpath("//div[@class='social FC DIB']//div[@id='otp-container']//span")).click();
	 // driver.switchTo().frame(0);
	  //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[6]")).click();
	  
	  
	  System.out.println("OtpEnters,....");
	 //Or  lets try with google login
	  
	 // driver.findElement(By.xpath("//div[@class='nsm7Bb-HzV7m-LgbsSe-Bz112c']")).click();
	  
	  
	  
	  
	  
	  
  }
  
}
