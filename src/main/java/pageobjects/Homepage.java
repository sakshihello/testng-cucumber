package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Homepage{
	WebDriver driver;
	
	public Homepage (WebDriver driver) {
		this.driver=driver;
		}
	By location=By.xpath("//input[@placeholder='Enter your location for delivery']");
	By firstSelect=By.xpath("//button[2]");
	By DealTxt=By.xpath("//a[contains(@class,'capitalize lg:border-r text-red lg:text-white side-menu__link--active')]");
    By Sidemenu=By.xpath("//a[@data-synth='link--sides--side']");
    By Addbtn=By.xpath("//button[@data-synth='button--masala-keema-garlic-bread-single--one-tap']");
    By checkitem=By.xpath("//div[@class='leading-tight typography-4 basket-item-product-title leading-tight mb-5 flex-1 mr-5 font-bold text-black']");
    By validatecheckoutprice=By.xpath("//div[@class='hidden md:flex md:bg-white md:text-black md:font-semibold justify-center sm:pb-5 typography-6']//span[contains(text(),'Minimum cart value for delivery is ₹200')]");
    By drink=By.xpath("//a[contains(@data-synth,'link--drinks--side')]");
    By price=By.xpath("//span[contains(@class,'ml-auto text-right')]");
    By adddrink1=By.xpath("//a[3]//div[3]//div[1]//button[1]");
    By adddrink2=By.xpath("//a[4]//div[3]//div[1]//button[1]");
    By pricemore=By.xpath("//span[@class='ml-auto text-right']");
    By checkbuttonbox=By.xpath("//a[contains(@class,'justify-between')]//span[contains(@class,'absolute inset-0 flex-center')]");
    By paymentradiobtn=By.xpath("//i[@class='mt-4']");
    By cashradiobtn=By.xpath("//label[@for='payment-method--cash']//span[@class='mr-auto flex items-center']");
    By checkboxagre=By.xpath(" //input[@id='marketingOptIn']");
    By inputname=By.xpath(" //input[@id='checkout__name']");
    By inputmobile=By.xpath("//input[@id='checkout__phone']");
    By inputemail=By.xpath(" //input[@id='checkout__email']");
    By linkapplygift=By.xpath("//span[normalize-space()='Apply Gift Card']");
    By couponlink=By.xpath("//span[normalize-space()='Coupon']");
    By couponcode=By.xpath("//input[@placeholder='e.g. ABC1234']");
    By codesubmit=By.xpath("//button[@type='submit']");
    By errorcode=By.xpath("//span[contains(text(),'Sorry, we don’t currently support that coupon code')]");
    By popupvoucher=By.xpath("//button[@class='icon-remove-3 absolute top-0 right-0 mr-20 mt-20']");
    //By Basketcart=By.xpath("//span[normalize-space()='Your Basket']");

    public void Location(String writelocation) {
    	WebElement loc=driver.findElement(location);
    	
    	
    	   loc.sendKeys(writelocation);
    	}
    	
    public void selectfirstoption() {
		
		WebElement firstitem=driver.findElement(firstSelect);
		firstitem.click();
        
		}
    public void validateurltxt(String string) {
  
    	String url=driver.getCurrentUrl();
    	System.out.println(url);
    	if(url.contains(string))
    	{
    		System.out.println("true");
    	}
    	else {
    		System.out.println("false");
    	}
    }
    
    public void side1() {
        
		WebElement Sidemenus=driver.findElement(Sidemenu);
          Sidemenus.click();
          String lessprice =driver.findElement(By.xpath("//a[4]//div[3]//div[1]//button[1]//span[2]")).getText();
          String l=lessprice.replace("₹", " ".trim());
          int lessthan=Integer.parseInt(l);
          if(lessthan<=200) {
          WebElement add = driver.findElement(Addbtn);
  		add.click();
		}
    }
    public void itemvalidate(String stringval) {
		WebElement itempresent=driver.findElement(checkitem);
		boolean present=itempresent.isDisplayed();
		System.out.println(present);
		String valcheckout=driver.findElement(validatecheckoutprice).getText().trim();
		if(valcheckout.equals(stringval)) {
			System.out.println("price item is not showing on checkoutbuton");
			
		}
		else {
			System.out.println("price item is showing on checkoutbutton");
		}
    }
		public void drinksmenu() {
			WebElement 	drinkbtn=driver.findElement(drink);

			drinkbtn.click();
		}
		public void add2drink() {
			WebElement 	drinkbtn1=driver.findElement(adddrink1);
			drinkbtn1.click();
			WebElement 	drinkbtn2=driver.findElement(adddrink2);
			drinkbtn1.click();
			String moreprice=driver.findElement(price).getText();
			String l1=moreprice.replace("₹", " ".trim());
	          float morethan=Float.parseFloat(l1);
	          System.out.println(morethan);
	         if(morethan>200) {
	          System.out.println("cart price is more than 200");
			}
	          else {
	          System.out.println("cart price is not  more than 200");
		}
		}
	         public void clickcheckoutbtn() {
	     		WebElement 	checkbtn1=driver.findElement(checkbuttonbox);
	     		checkbtn1.click();

	     		System.out.println("user click on checkout button");
			
}
	         public void radiobtnpayment() {
	     		WebElement 	radiobuttonpayment=driver.findElement(paymentradiobtn);
	     		
	     		/*boolean b=radiobuttonpayment.isSelected();
	     		System.out.println(b);*/
	     		if(radiobuttonpayment.isSelected())
	     		{
	     			System.out.println("radiobutton is selected");
	     		}
	     		else
	     		{
	     			System.out.println("radiobutton is not selected");
	     		}
}
	         public void cashradiobtn() {
	     		WebElement 	radiobuttoncash=driver.findElement(cashradiobtn);
	     	   boolean selectstate = radiobuttoncash.isSelected();
	     		 if(selectstate ==true) {
	     				System.out.println(" cash radiobutton is selected");
	     	}
	     		 else {
	     			radiobuttoncash.click();	

	     		 }}
	         public void checkboxbtn() {
	  		   WebElement 	agreecheckbox=driver.findElement(checkboxagre);
	  		   boolean selectstate =agreecheckbox.isSelected();
	  		   if(selectstate = true)
	  		   {
	  				System.out.println("checkboxagree button is selected");	

	  			   
	  		   }
	  		   else
	  		   {
	  				System.out.println("checkboxagree button not selected");	

	  		   }
}
	         public void details(String name,String email,String phone) {
	  		   WebElement pname=driver.findElement(inputname);
	  		   pname.sendKeys(name);
	  		   WebElement pmobile=driver.findElement(inputmobile);
	  		   pmobile.sendKeys(email);
	  		   WebElement pemail=driver.findElement(inputemail);
	  		   pemail.sendKeys(phone);
	  		   }
	         
	         public void giftcard() {
	  		   WebElement linkgiftapply=driver.findElement(linkapplygift);
	  		   linkgiftapply.click();
	  		}
	         public void voucherlink() {
	    		 WebElement linkcoupon=driver.findElement(couponlink);
	    		 linkcoupon.click();
	    		
}
	         public void vouchercode(String string) {
	    		 WebElement Inputcoupon=driver.findElement(couponcode);
	    		 Inputcoupon.sendKeys(string);
	    		 WebElement Submitbtn=driver.findElement(codesubmit);
	    		 Submitbtn.click();
	    		
}
	         public void errorcode(String Expected)
	         {
	        	 String codeerror=driver.findElement(errorcode).getText();
	        	 if(codeerror.equals(Expected)) {
	        		 System.out.println("error is there");
	        	 }
	        	 else {
	        		 System.out.println("error is not there");
	        	 }
	    	     //toString();
	         }
	         public void popupclose() {
	    		 WebElement closebtn=driver.findElement(popupvoucher);
	    		 closebtn.click();
	          	}
	         public void basketpage(String string) {
	        	 String url=driver.getCurrentUrl();
	         	System.out.println(url);
	         	if(url.contains(string))
	         	{
	         		System.out.println("User navigates to basket page ");
	         	}
	         	else {
	         		System.out.println("User is not on basket page ");
	         	}
			}
	    		
}
