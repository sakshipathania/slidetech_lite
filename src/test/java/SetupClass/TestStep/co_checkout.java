package SetupClass.TestStep;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class co_checkout extends Set{
	

	WebDriverWait wait = new WebDriverWait(driver,50);
        JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^user is already on Website Home Page (\\d+)CO$")
	public void user_is_already_on_Website_Home_Page_CO(int arg1) throws Throwable {
		
		driver.get(AppURL);
		//driver.getSessionStorage().clear();
                driver.getLocalStorage().clear();
		Thread.sleep(14000);
		//driver.navigate().to(AppURL);
		//Thread.sleep(3000);
		//driver.navigate().refresh();
		//Thread.sleep(3000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
	    Thread.sleep(2000);
	   try {
		   String incheckoutPage = driver.getCurrentUrl(); 
		            System.out.println("incheckoutPage = " + incheckoutPage);
			WebElement logout = driver.findElement(By.xpath("//a[normalize-space()='Sign Out']"));
			if (logout.isDisplayed()) {
				 boolean value = logout.isDisplayed();
				System.out.println("logoutvalue = " + value);
				//Thread.sleep(3000);
				logout.click();
				Thread.sleep(3000);
				//logout.click();
				Thread.sleep(8000);
				String afterlogout = driver.getCurrentUrl(); 
		            System.out.println("Afterlogout = " + afterlogout);
				
				driver.navigate().refresh();
				Thread.sleep(2000);
				String afterrefresh = driver.getCurrentUrl(); 
		            System.out.println("Afterrefresh = " + afterrefresh);
			}
		} catch (NoSuchElementException Ext) {

		}
	    Thread.sleep(3000);
		try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if(iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);   
				 Actions act = new Actions(driver);
				 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				 Thread.sleep(3000);
					WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
					 Thread.sleep(1000);
						chat1.click();
						 Thread.sleep(1000);
						 driver.switchTo().defaultContent();
						 Thread.sleep(1000);
						 driver.switchTo().parentFrame();
					 Thread.sleep(1000);
			}
			else {
				

			System.out.println("chat window does not open");
			}
		}
				catch(NoSuchElementException NCP) {
					
				}
		//Thread.sleep(3000);
	    
	    
	}

	@Then("^user navigates to sign up page (\\d+)CO$")
	public void user_navigates_to_sign_up_page_CO(int arg1) throws Throwable {
		Thread.sleep(3000);
		try {
			String inSignuppageurl = driver.getCurrentUrl(); 
		            System.out.println("inSignuppageurl = " + inSignuppageurl);
			WebElement Sign_Up = driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)"));
			Thread.sleep(3000);
			Sign_Up.click();
			String aftersignup = driver.getCurrentUrl(); 
		            System.out.println("AfterSignUpurl = " + aftersignup);
			Thread.sleep(2000);
			log.info("It's opening the website URL and redirect user to sign up page");
		} 
		catch (NoSuchElementException popup) {
		}
	}

	@Then("^user create a new ac count (\\d+)CO$")
	public void user_create_a_new_ac_count_CO(int arg1) throws Throwable {
		// create new email for sign up
		Thread.sleep(5000);
				int leftLimit = 97; // letter 'a'
			    int rightLimit = 122; // letter 'z'
			    int targetStringLength = 10;
			    Random random = new Random();
			    StringBuilder buffer = new StringBuilder(targetStringLength);
			    for (int i = 0; i < targetStringLength; i++) {
			        int randomLimitedInt = leftLimit + (int) 
			          (random.nextFloat() * (rightLimit - leftLimit + 1));
			        buffer.append((char) randomLimitedInt);
			    }
			    String generatedString = buffer.toString();
			 
			    System.out.println(generatedString);
			    
			    String signup_email=generatedString;
			    String full_email="selenium.testing."+generatedString+"@gmail.com";
			    System.out.println(full_email);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				//driver.findElement(By.id("email_address")).sendKeys(full_email);
				String URLsign_up = driver.getCurrentUrl(); 
		            System.out.println("AfterSignUpurl = " + URLsign_up);

				Thread.sleep(3000);
			    WebElement new_email_signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/div[1]/div[2]/div[1]/form[1]/fieldset[1]/div[4]/div[1]/input[1]")));
				//Thread.sleep(2000);
			    new_email_signup.sendKeys(full_email);
				Thread.sleep(1000);
				
				// enter name

			    WebElement new_fname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("firstname")));
				//Thread.sleep(2000);
			    new_fname_signup.sendKeys("Selenium");
				Thread.sleep(1000);

			    WebElement new_lname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("lastname")));
				//Thread.sleep(2000);
			    new_lname_signup.sendKeys("Testing");
				Thread.sleep(1000);
				
				//enter password
				 WebElement new_pwd_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
					//Thread.sleep(2000);
				    new_pwd_signup.sendKeys("selenium@123");
					//Thread.sleep(1000);

				    WebElement new_pwd1_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password-confirmation")));
					//Thread.sleep(2000);
				    new_pwd1_signup.sendKeys("selenium@123");
					//Thread.sleep(1000);
					
					// enter captcha
					WebElement new_captcha_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_user_create")));
					//Thread.sleep(2000);
				    new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");
					//Thread.sleep(2000);
				    
				    // sign  up button
				    WebElement new_btn_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".submit")));
					//Thread.sleep(2000);
				    new_btn_signup.click();
					Thread.sleep(1000);
	}

	@Then("^user is redirected to pricing page and choose a plan to pay (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_choose_a_plan_to_pay_CO(int arg1) throws Throwable {
		// choose a plan
		
		driver.get("https://www.slideteam.net/pricing?utm_expid=.ob6CI18MTrailD_9AQRC-g.0&utm_referrer=https%3A%2F%2Fwww.slideteam.net%2Fpricing");
		//Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)");
		 WebElement join_now_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(.,'Join now')])[8]")));
			//Thread.sleep(2000);
		    join_now_btn.click();
			//Thread.sleep(6000);

	}

	@Then("^user is redirected to checkout page (\\d+)CO$")
	public void user_is_redirected_to_checkout_page_CO(int arg1) throws Throwable {
		//Thread.sleep(6000);
	}

	@Then("^user proceed to pay with (\\d+)CO (\\d+)CO$")
	public void user_proceed_to_pay_with_CO_CO(int arg1, int arg2) throws InterruptedException {
	     try {
		Thread.sleep(1000);
		// select 2co option
		WebElement co_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amasty_stripe']")));
		//Thread.sleep(2000);
	         co_btn.click();
		//Thread.sleep(5000);
	     } catch( NoSuchElementException popup) { 
	     }
		
		// place order button 
		try {
			
		 WebElement place_order_btn  =  driver.findElement(By.cssSelector("#place-order-trigger > span"));
			//Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();",place_order_btn);	
			//js.executeScript("arguments[0].click();", place_order_btn);
			//Thread.sleep(2000);
		    place_order_btn.click();
			//Thread.sleep(5000);
		} catch (NoSuchElementException popup) {
		}
		
		
	}

	@Then("^paypal popup appears and user navigates back to my account (\\d+)CO$")
	public void paypal_popup_appears_and_user_navigates_back_to_my_account_CO(int arg1) throws Throwable {
	    String co_page_title=driver.getTitle();
		//Thread.sleep(3000);
	    System.out.println("Title of the Page is --> "+co_page_title);
	    
	    String page_title="2Checkout";
	    
	    if(page_title.equalsIgnoreCase(co_page_title))
	    {
	    	System.out.println(" user is on the 2checkout page");
	    	log.info("USER IS ON THE 2CHECKOUT PAGE");
	    }
	    else
	    {
	    	System.out.println("user is on the wrong page");
	    	log.info("USER IS ON THE WRONG PAGE");
	    }
		//Thread.sleep(3000);
	}

	@Then("^user deleted the account (\\d+)CO$")
	public void user_deleted_the_account_CO(int arg1) throws Throwable {
		Thread.sleep(3000);
	    driver.get("https://www.slideteam.net/");
		Thread.sleep(2000);
		

		driver.findElement(By.xpath("//a[contains(.,'My Account')]")).click();
		 Thread.sleep(3000);
		 
		


try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if(iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);   
				 Actions act = new Actions(driver);
				 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				Thread.sleep(2000);
					WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
					 Thread.sleep(1000);
						chat1.click();
						Thread.sleep(1000);
						 driver.switchTo().defaultContent();
						 Thread.sleep(1000);
						 driver.switchTo().parentFrame();
					 Thread.sleep(1000);
			}
			else {
				

			System.out.println("chat window does not open");
			}
		}
				catch(NoSuchElementException NCP) {
					
				}


      Thread.sleep(3000);
		WebElement Delete_Account = driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Delete_Account);
		Thread.sleep(4000);
		Delete_Account.click();
		String currentWindow = driver.getWindowHandle();
		String popupWindowHandle = null;

		// Switch To Popup Window

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(currentWindow)) {

				popupWindowHandle = handle;
				driver.switchTo().window(popupWindowHandle);
				System.out.println("window handled");

				//Thread.sleep(2000);

			}
		}
		WebElement select_Radiobutton = driver.findElement(By.xpath("//input[@id='exampleRadios5']"));
		select_Radiobutton.click();

		Boolean value = driver.findElement(By.xpath("//input[@id='exampleRadios5']")).isSelected();
		System.out.println("value = " + value);

		WebElement delete_Profile = driver.findElement(By.xpath("//button[normalize-space()='Delete Profile']"));

		delete_Profile.click();

		js.executeScript("window.scrollTo(0,0)");
		WebElement copy_code = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@id='copy-code']")));
		String code = copy_code.getAttribute("value");
		System.out.println("code = " + code);

		WebElement delete = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[normalize-space()='I love discounts']")));

		delete.click();

	}


	
}
