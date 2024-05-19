package pageobjects;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class practice {

	WebDriver driver1;
  @Test
	public void launchbrowser()
	{
		System.setProperty("webriver.gecko.driver","C://Users//hp/geckodriver.exe");
		driver1=new FirefoxDriver();
		driver1.get("http://omayo.blogspot.com/");
		//driver1.navigate().to("www.google.com");
	}
	@Test
	public void mousehover()
	{
		Actions actions=new Actions(driver1);
		actions.moveToElement(driver1.findElement(By.xpath("//a[@href='#']"))).perform();
		
	}
	@Test
	public void linktest()
	{
		driver1.findElement(By.linkText("onlytestingblog")).click();
	}
	@Test
	public void Partiallinktest()
	{
		driver1.findElement(By.partialLinkText("automatedtester")).click();
	}
	
     @After
	public void teardown()
	{
		driver1.quit();// it closes all the open browser windows.
		//driver1.close();//closes the browser’s current window. If multiple windows are open, the current window of focus will be closed.
	}
}
