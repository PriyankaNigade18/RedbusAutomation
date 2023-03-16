package testAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BusSearchScenario 
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
  public void f() 
    { 	
	  	ChromeOptions sc=new ChromeOptions();
	  	sc.addArguments("--remote-allow-origins=*");
	  	  WebDriver driver=new ChromeDriver(sc);
	  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  	  driver.get("https://www.redbus.in");
	  	  driver.manage().window().maximize();
	  	  //Search buses
	  	  driver.findElement(By.id("src")).sendKeys("Viman Nagar",Keys.ENTER);
	  	  driver.findElement(By.id("dest")).sendKeys("Bangalore",Keys.ENTER);
	  	  driver.findElement(By.id("onward_cal")).click();
	  	  dateselection(driver,"Mar","2023","31");
	  	  driver.findElement(By.id("search_btn")).click();
	  			
	  	  
	  	  
	  	  System.out.println("Clicked on button");
	  	  
    }
  }