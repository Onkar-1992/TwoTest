package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import org.junit.Assert;

public class SetupBrowser {
	private WebDriver driver = DriverFactory.getDriver();

	// 01_setupBrowser.feature
	// # Scenario 1: Setting up browser and navigate to the URL
	// 01_setupBrowser.feature Scenario 1 - Step 1
    @Given("I open the Chrome browser")
    public void open_browser() throws InterruptedException {
        driver = DriverFactory.getDriver();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("===== 01_setupBrowser.feature Scenario 1 - Step 1 =======");
        Thread.sleep(1000);
    }

	// # Scenario 1: Setting up browser and navigate to the URL
	// 01_setupBrowser.feature Scenario 1 - Step 2
    @When("I navigate to the URL")
    public void navigate_to_url() throws InterruptedException {
        DriverFactory.navigateToURL();
        System.out.println("===== 01_setupBrowser.feature Scenario 1 - Step 2 =======");
        Thread.sleep(1000);
    }

	// # Scenario 1: Setting up browser and navigate to the URL
	// 01_setupBrowser.feature Scenario 1 - Step 3
    @Then("I should see the page title")
    public void verify_page_title() {
    	System.out.println("===== 01_setupBrowser.feature Scenario 1 - Step 3 =======");
        String title = driver.getTitle();
        Assert.assertNotNull("The page title should not be null", title);
        System.out.println("Page Title: " + title);
    }

}

