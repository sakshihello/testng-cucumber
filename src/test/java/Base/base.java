package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
    
    public Properties prop;
    
    WebDriver driver;
    
    public WebDriver initializeBrowser() throws IOException {
   	 
   	 prop = new Properties();
   	 
   	 File file = new File("src\\main\\java\\resources\\Data.properties");
   	 
   	 FileInputStream fis = new FileInputStream(file);
   	 
   	 prop.load(fis);
   	 
   	 
   	 String browser = prop.getProperty("browser");
   	 
   	 if(browser.equals("chrome")) {
   		 
   		 WebDriverManager.chromedriver().setup();
   		 driver = new ChromeDriver();
   		 
   	 }else if(browser.equals("firefox")) {
   		 
   		 //WebDriverManager.firefoxdriver().setup();
   		 System.setProperty("webdriver.gecko.driver", "C://Users//hp/geckodriver.exe");
   		 driver = new FirefoxDriver();
   		 
   	 }else if(browser.equals("edge")) {
   		 
   		 WebDriverManager.edgedriver().setup();
   		 driver = new EdgeDriver();
   		 
   	 }
   	 
   	 driver.manage().window().maximize();
   	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   	 
   	 return driver;
   	 
    }
    
    public String generateNewEmailTimeStamp() {
   	 
   	 Date date = new Date();
   	 return date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
   	 
    }
    
    public String takeScreenshot(String testName,WebDriver driver) throws IOException {
   	 
   	 File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   	 String screenshotFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
   	 FileUtils.copyFile(srcScreenshot, new File(screenshotFilePath));
   	 return screenshotFilePath;
    }
 /*   @DataProvider(name="testdata")
    public static Object[][] getexceldata() throws IOException
    { 
    	Object[][] data=base.ExcelData("sheet1");
    	return data;
    	
    	
    }
public static Object[][] ExcelData(String sheetname) throws IOException
{
	String projectpath= ".\\Excel\\data.xlsx";
	FileInputStream inputstream=new FileInputStream(projectpath);
	 XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
	 XSSFSheet sheet=workbook.getSheet(sheetname);
	
	//sheet=workbook.getSheet("sheet1");
	int rows=sheet.getLastRowNum();
	int cols=sheet.getRow(0).getLastCellNum();
	Object[][] data=new Object[rows][cols];
	for(int i=0;i<rows;i++) {
		XSSFRow row=sheet.getRow(i+1);
		
		for(int j=0;j<cols;j++)
		{
			XSSFCell cell=row.getCell(j);
			switch(cell.getCellType())
			{

			case STRING:
			     data[i][j]=cell.getStringCellValue();
			     break;
			case NUMERIC:data[i][j]=Integer.toString((int)cell.getNumericCellValue());
			break;
			
			
			}
		}
		
}
	return data;
}*/
}


