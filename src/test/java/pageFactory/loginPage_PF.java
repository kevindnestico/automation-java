package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class loginPage_PF {
	
	@FindBy(id = "name")
	WebElement	txt_username;
	
	@FindBy(id = "password")
	WebElement txt_password;
	
	@FindBy(id = "login")
	WebElement	btn_login;
	
	WebDriver driver;
	
	public loginPage_PF(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		
	}
			
	public void enterUsername(String Username) {
		
		txt_username.sendKeys(Username);
	}
	
	public void enterPassword(String Password) {
		
		txt_password.sendKeys(Password);
	}
	
	public void clickOnLogin() {
		
		btn_login.click();
	}

}