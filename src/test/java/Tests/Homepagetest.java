package Tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import Base.base;
import Utilities.ExcelUtils;
import pageobjects.Homepage;

@Listeners(ListenersD.AppListeners.class)
public class Homepagetest extends base{
	
  	 
	public WebDriver driver;
	base b=new base();
	
	@BeforeSuite
	public void setup() throws IOException
	{	 
		driver=initializeBrowser();
		//driver.get(prop.getProperty("url"));
		
		}
	@AfterSuite
	public void teardown()
	{
		driver.quit();
		
	}
	
	
	@Test(priority = 1, dataProvider = "urlData",dataProviderClass = ExcelUtils.class)
	public void exceldata(String TestName,String TestData)
	{
		driver.get(TestData);
	}
	/*@Test    
    public void testfb() throws IOException, InterruptedException{
   	 String [][] dataip = ExcelUtils.readexcel("data", "Sheet1");
   	 
   	 for(int i=1; i<dataip.length ; i++){//to avoid the heading
   		 String user = dataip[i][0];
   		 String pass = dataip[i][1];
   		 driver.get(user);
   	 }
	}*/
	

	@Test(priority=2)
	public void Enterlocation () throws IOException 
	{
		
		Homepage ln=new Homepage(driver);
		ln.Location(prop.getProperty("writelocation"));
		b.takeScreenshot("enterlocation", driver);
		}
		
	@Test(priority=3)
	public void SelectDropdown () throws IOException
	{
		Homepage ln=new Homepage(driver);
	
		ln.selectfirstoption();
		b.takeScreenshot("selectdrop", driver);
		
		}
	@Test(priority=5)
	public void txt() throws IOException
	{
		Homepage ln=new Homepage(driver);
		ln.validateurltxt(prop.getProperty("string"));
		b.takeScreenshot("txt", driver);
	}
	@Test(priority=4)
	public void side()
	{
		Homepage ln=new Homepage(driver);
		ln.side1();
		try {
			b.takeScreenshot("side", driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=6)
	public void checkprice() throws IOException
	{
		Homepage ln=new Homepage(driver);
		ln.itemvalidate(prop.getProperty("stringval"));
		b.takeScreenshot("checkprice", driver);
	}
	@Test(priority=7)
		public void drinkspage() throws IOException
		{
			Homepage ln=new Homepage(driver);
			ln.drinksmenu();
			b.takeScreenshot("drinkspage", driver);
		}
	@Test(priority=8)
	public void drinkspage1()
	{
		Homepage ln=new Homepage(driver);
		ln.add2drink();
}
	@Test(priority=9)
	public void btncheckout() throws IOException
	{
		Homepage ln=new Homepage(driver);
		ln.clickcheckoutbtn();
		b.takeScreenshot("btncheckout", driver);
	}
    @Test(priority=10)
    public void radioselect()
    {
    	Homepage ln=new Homepage(driver);
		ln.radiobtnpayment();
    }
    @Test(priority=11)
    public void cashselect()
    {
    	Homepage ln=new Homepage(driver);
		ln.cashradiobtn();
    }
    @Test(priority=12)
    public void checkboxselection()
    {
    	Homepage ln=new Homepage(driver);
		ln.checkboxbtn();
    }
   
    @Test(priority=13)
    public void persondetails() throws IOException
    {
    	Homepage ln=new Homepage(driver);
    	ln.details(prop.getProperty("name"),prop.getProperty("email"),prop.getProperty("phone"));
    	b.takeScreenshot("persondetail", driver);
    	
    }
    @Test(priority=14)
    public void card()
    {
    	Homepage ln=new Homepage(driver);
    	ln.giftcard();
    }
    @Test(priority=15)
    public void voucherlink()
    {
    	Homepage ln=new Homepage(driver);
    	ln.voucherlink();
    }
    @Test(priority=16)
    public void enterdetails()
    {
    	Homepage ln=new Homepage(driver);
    	ln.vouchercode(prop.getProperty("code"));
    }
   @Test(priority=17)
    public void errormessage()
    {
    	Homepage ln=new Homepage(driver);
    	ln.errorcode(prop.getProperty("Expected"));
    } 
   @Test(priority=18)
   public void crossbtn()
   {
	   Homepage ln=new Homepage(driver);
   	ln.popupclose();
   }
    @Test(priority=19)
    public void navigatetopage()
    {
 	   Homepage ln=new Homepage(driver);
    	ln.basketpage(prop.getProperty("string"));
    }
   
   
}


