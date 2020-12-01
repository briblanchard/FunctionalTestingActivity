package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

/**
 * This is the base testing class for every other testing class.
 * It creates the web driver and has the login and close functions.
 * It also holds the login page URL, username, and password
 * for the login function.
 * 
 * @author briblanchard
 *
 */
public class FunctionalTesting {

	// the webdriver
	public WebDriver driver = new ChromeDriver();
	
	//inputs for login
	public String loginURL = "https://my.otus.com/login";
	private String username = "briblanchard13@gmail.com";
	private String password = "@Aquamarine13";
	
	/**
	 * This function logs into otus.
	 */
	public void Login() {
		// navigate to the webpage
		driver.get(this.loginURL);
		
		// find the username input
		WebElement usernameEl = driver.findElement(By.id("otus-input-1"));
		
		// find the password input
		WebElement passwordEl = driver.findElement(By.id("otus-input-3"));
		
		// find the login button
		WebElement loginEl = driver.findElement(By.className("btn-login"));
		
		// use the web elements found above to login
		usernameEl.sendKeys(this.username);
		passwordEl.sendKeys(this.password);
		loginEl.click();
		
		//wait for the page to load
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://my.otus.com/home"));
	}
	
	/**
	 * This function quits and closes the webdriver used in the session.
	 * If it's not called then the WebDriver session will not close properly
	 * and files will not be cleared off of memory.
	 */
	public void Close() {
		driver.close();
		driver.quit();
	}
}
