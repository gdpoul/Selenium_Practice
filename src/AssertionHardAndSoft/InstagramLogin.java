package AssertionHardAndSoft;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InstagramLogin {
	
	@Test
	public void invalidLogin() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.instagram.com/");
		WebElement loginBtn = driver.findElement(By.xpath("//div[text()='Log in']"));
				
		SoftAssert softAssert=new SoftAssert();
		
		// AssertionOfLoginButton
		boolean Actualstatus=loginBtn.isEnabled();
		softAssert.assertEquals(Actualstatus, false,"Button is Enabled");
		
		// Assertion Of Enable Login Button
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("Password");
		boolean loginAfterEnterEmailAndPassword = loginBtn.isEnabled();
		softAssert.assertEquals(loginAfterEnterEmailAndPassword, true,"Button is disabled");
		
		// Assertion Of ErrorMessage
		loginBtn.click();
	    String ExpectedErrorMessage="The username you entered doesn't belong to an account."
	    		+ " Please check your username and try again.";	
	    String actualErrorMessage = driver.findElement(By.xpath("//div[@class='_ab2z']")).getText();
	    softAssert.assertNotEquals(actualErrorMessage, ExpectedErrorMessage,"Error Message is not correct");
	    
	    //Error message Colour Assertion
	    String acctualColour = driver.findElement(By.xpath("//div[@class='_ab2z']")).getCssValue("color");
	    String expectedColour="rgba(237, 73, 86, 1)";
	    softAssert.assertEquals(acctualColour, expectedColour,"colour is not red");
	    
	    driver.quit();
//	    softAssert.assertAll();
		}

}
