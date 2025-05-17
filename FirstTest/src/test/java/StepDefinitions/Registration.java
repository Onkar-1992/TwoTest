package StepDefinitions;

//import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import io.cucumber.java.en.*;

public class Registration {
	private WebDriver driver = DriverFactory.getDriver();
	private Properties OR = new Properties();
	private Properties CONFIG = new Properties();
	
	public Registration() {
		 try {
	            // Load OR.properties file
	            FileInputStream fis = new FileInputStream("src/test/resources/Properties/OR.properties");
	            OR.load(fis);
	         // Load CONFIG.properties file
	            FileInputStream fis1 = new FileInputStream("src/test/resources/Properties/CONFIG.properties");
	            CONFIG.load(fis1);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	// 02_registration.feature
	// # Scenario 1: Navigate to Registration form
	// 02_registration.feature Scenario 1 - Step 1
	@Given("I Click on the Registration Form link")
	public void i_click_on_the_registration_form_link() throws InterruptedException {
		System.out.println("===== 02_registration.feature Scenario 1 - Step 1 =======");
		Thread.sleep(10000);
		WebElement registerationForm = driver.findElement(By.xpath(OR.getProperty("registrationform"))); // Finding the web element
		registerationForm.click(); // Perform click operation on link
		
	}
	
	// # Scenario 1: Navigate to Registration form
	// 02_registration.feature Scenario 1 - Step 2
	@When("I fill out the registration form and submit")
	public void i_fill_out_the_registration_form_and_submit() {
		System.out.println("===== 02_registration.feature Scenario 1 - Step 2 =======");
	}

	// # Scenario 1: Navigate to Registration form
	// 02_registration.feature Scenario 1 - Step 3
	@Then("I should see the registration success message")
	public void i_should_see_the_registration_success_message() {
		System.out.println("===== 02_registration.feature Scenario 1 - Step 3 =======");
	}

	// # Scenario 2: Validate mandatory field error messages
	// 02_registration.feature Scenario 2 - Step 1 Here we will reuse the code define in scenario 1 step 1
	// 02_registration.feature Scenario 2 - Step 2
	@When("I leave the email, password, and confirm password fields blank and click submit button")
	public void i_leave_the_email_password_and_confirm_password_fields_blank_and_click_submit_button() throws InterruptedException {
		System.out.println("===== 02_registration.feature Scenario 2 - Step 2 =======");
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)"); // Scroll down by 350 pixels
        Thread.sleep(5000);
        // Find web element by using XPath defined in OR.properties file
        WebElement registerationSubmitButton = driver.findElement(By.xpath(OR.getProperty("registrationSubmit_btn")));
        registerationSubmitButton.click(); // Perform click operation on button
	}

	// # Scenario 2: Validate mandatory field error messages
	// 02_registration.feature Scenario 2 - Step 3
	@Then("I should see the {string} message for email, user password, and confirm password")
	public void i_should_see_the_message_for_email_user_password_and_confirm_password(String string) {
		System.out.println("===== 02_registration.feature Scenario 2 - Step 2 =======");
		// Initialize WebDriverWait with Duration
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    // Wait until error message gets displayed on web browser
	        WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated
	        		(By.xpath(OR.getProperty("emailErrorMessage"))));
	        WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated
	        		(By.xpath(OR.getProperty("passwordErrorMessage"))));
	        WebElement confirmPasswordError = wait.until(ExpectedConditions.visibilityOfElementLocated
	        		(By.xpath(OR.getProperty("confirmPasswordErrorMessage"))));

	        Assert.assertTrue(emailError.isDisplayed(), "Email error message is not displayed");
	        Assert.assertTrue(passwordError.isDisplayed(), "Password error message is not displayed");
	        Assert.assertTrue(confirmPasswordError.isDisplayed(), "Confirm password error message is not displayed");
	       
	        String expectedMessage = CONFIG.getProperty("blankFieldMessage");

	        // Store actual error messages in variables
	        WebElement emailMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("emailErrorMessage"))));
	        String emailActualMessage = emailMessage.getText();
	        WebElement passwordMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("passwordErrorMessage"))));
	        String passwordActualMessage = passwordMessage.getText();
	        WebElement confirmpasswordMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("confirmPasswordErrorMessage"))));
	        String confirmpasswordActualMessage = confirmpasswordMessage.getText();
	        
	        // Validate actual error message with expected error message
	        Assert.assertEquals(emailActualMessage, expectedMessage, "Error message not displayed correctly.");
	        Assert.assertEquals(passwordActualMessage, expectedMessage, "Error message not displayed correctly.");
	        Assert.assertEquals(confirmpasswordActualMessage, expectedMessage, "Error message not displayed correctly.");
	}
	
	// # Scenario 3: Complete registration and validate success message
	// 02_registration.feature Scenario 3 - Step 1	
	@When("I enter all the details and click submit button")
	public void i_enter_all_the_details_and_click_submit_button() throws InterruptedException {
		System.out.println("===== 02_registration.feature Scenario 3 - Step 1 =======");
		Thread.sleep(10000);	
		WebElement firstNameInput = driver.findElement(By.xpath(OR.getProperty("firstName_txt")));
		WebElement lastNameInput = driver.findElement(By.xpath(OR.getProperty("lastName_txt")));
		WebElement userNameInput = driver.findElement(By.xpath(OR.getProperty("userName_txt")));
		WebElement emailInput = driver.findElement(By.xpath(OR.getProperty("email_txt")));
		WebElement userPasswordInput = driver.findElement(By.xpath(OR.getProperty("userPassword_txt")));
		WebElement confirmPasswordInput = driver.findElement(By.xpath(OR.getProperty("confirmPassword_txt")));
		
		// Send data to input boxes
		firstNameInput.sendKeys(CONFIG.getProperty("firstName")); Thread.sleep(3000);
		lastNameInput.sendKeys(CONFIG.getProperty("lastName")); Thread.sleep(3000);
		userNameInput.sendKeys(CONFIG.getProperty("userName")); Thread.sleep(3000);
		emailInput.sendKeys(CONFIG.getProperty("email")); Thread.sleep(3000);
		userPasswordInput.sendKeys(CONFIG.getProperty("userPassword")); Thread.sleep(3000);
		confirmPasswordInput.sendKeys(CONFIG.getProperty("confirmPassword")); Thread.sleep(3000);
		
        WebElement registerationSubmitButton = driver.findElement(By.xpath(OR.getProperty("registrationSubmit_btn")));
        registerationSubmitButton.click(); Thread.sleep(3000);
        
        
	}

	// # Scenario 3: Complete registration and validate success message
	// 02_registration.feature Scenario 3 - Step 2	
	@Then("I should see the success message")
	public void i_should_see_the_success_message() {
		System.out.println("===== 02_registration.feature Scenario 3 - Step 2 =======");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement registrationSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("registrationSuccessMsg"))));
        String registrationSuccessActualMessage = registrationSuccessMessage.getText();
        String expectedRegistrationMessage = CONFIG.getProperty("registrationSuccessMessage");
        Assert.assertEquals(registrationSuccessActualMessage, expectedRegistrationMessage, "Error message not displayed correctly.");
	}

}
