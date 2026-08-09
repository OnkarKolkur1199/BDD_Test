package StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class loginSteps {
	
	static WebDriver driver;
	
	@Before
	public void startScenario() {
		driver = new ChromeDriver();
	}
	
	@After
	public void endScenario() {
		driver.quit();
	}
	
	@Given("User is on login page")
	public void User_is_on_login_page() {
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		
	@When("User enters valid username and password")
	public void User_Enters_Creds() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");
		Thread.sleep(2000);
	}
	
	@And("Click on login button")
	public void Click_on_login_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@Then("User navigated to home page")
	public void User_navigated_to_Home_page() throws InterruptedException, AWTException {
		Boolean logo = driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		if(logo==true) {
			System.out.println("Login Success");
		}
		else {
			System.out.println("Login Fail");
		}
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@And("Close the browser")
	public void Close_the_browser() throws InterruptedException {
		Thread.sleep(3000);
	}
}
