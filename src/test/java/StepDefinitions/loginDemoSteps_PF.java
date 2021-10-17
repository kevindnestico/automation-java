package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.homePage_PF;
import pageFactory.loginPage_PF;

public class loginDemoSteps_PF {

	WebDriver driver = null;
	loginPage_PF login;
	homePage_PF home;

	@Given("browser is open")
	public void browser_is_open() {

		String proyectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",proyectPath+"/src/test/resources/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		
		driver.navigate().to("https://example.testproject.io/web/");

	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		
		login = new loginPage_PF(driver);
		login.enterUsername(username);
		login.enterPassword(password);

	}

	@And("user clicks on login")
	public void user_clicks_on_login() {
		login.clickOnLogin();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		
		home = new homePage_PF(driver);
		home.checkLogoutIsDisplayed();
		driver.close();
		driver.quit();
	}

}
