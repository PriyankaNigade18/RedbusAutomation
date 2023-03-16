package testAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SEarchBus
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
	
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
  @Test
  public void searchBus() throws InterruptedException
  {
	  WebDriver driver=new EdgeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.redbus.in");
	  driver.manage().window().maximize();
	  //Search buses
	  driver.findElement(By.id("src")).sendKeys("Viman Nagar");
	  driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]/div/ul/li[1]")).click();
	  driver.findElement(By.id("dest")).sendKeys("Bangalore");
	  driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[2]/div/ul/li[1]")).click();
	 
	  
	//Calender
			driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/span")).click();
			driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[7]/td[2]")).click();
			//Search Button
			driver.findElement(By.id("search_btn")).click();
				  
	  System.out.println("Clicked on button");
	  
	  // Select the first available bus and click on "View Seats"
	  driver.findElement(By.xpath("(//div[text()='View Seats'])[1]")).click();	
	  
	  
      //select randon seat
	  WebElement ele=driver.findElement(By.xpath("//div[@class='lower-canvas canvas-wrapper']"));

	  
	  Actions act=new Actions(driver);
      act.moveToElement(ele, 200, 150).build().perform();
//	  
//	  JavascriptExecutor js=(JavascriptExecutor)driver;
//	  	js.executeScript("document.getElementById('abs');");
	  
	  
	  WebElement seat=driver.findElement(By.xpath("//div[@class='abs' and contains(text(),'Seat No ')]"));
	  act.moveToElement(seat).click().build().perform();
	  
	  System.out.println("Mouse over done!");
	  
//	  WebElement seat=driver.findElement(By.xpath("//div[@class='abs' and contains(text(),'Seat No ')]"));
//	  
//	  act.moveToElement(seat).click().build().perform();
	  
	  
	  //for booking
	  
	  //click on view seats
	  //
	  
	  //seat
	  //driver.findElement(By.xpath("//div[@class='lower-canvas canvas-wrapper']//canvas[@class='pointer']")).click();
	  
	  
	  //driver.findElement(By.xpath("//canvas[@class='pointer']")).click();
	  
	  /*
	  //To get all records
	  Thread.sleep(2000);
	  for(int i=1;i<=13;i++)
	  {
	  scrollDown(driver);
	  
	  //get all list
	  List<WebElement> list1=driver.findElements(By.xpath("//ul[@class='bus-items']//div//li//div[contains(@class,'travels')]"));
	  //List<WebElement> list1=driver.findElements(By.xpath("//ul[@class='bus-items']//div//li"));
	  System.out.println(list1.size());
	  for(WebElement j:list1)
	  {
		  System.out.println(j.getText());
	  }
	  }*/
  }
  
}
