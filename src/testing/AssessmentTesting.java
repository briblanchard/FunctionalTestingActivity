package testing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is for testing the assessments tab.
 * 
 * @author briblanchard
 *
 */
public class AssessmentTesting extends FunctionalTesting {
	
	/**
	 * This function opens the assessments tab.
	 */
	public void openAssessmentTab() {
		//wait for the page to load
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[text()='Assessments']")).click();
		
		//wait for the page to load
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://my.otus.com/assessment/list"));
		System.out.println("Opening assessments passed.");
	}
	
	/**
	 * This function opens and starts the assessment.
	 */
	public void openAssessments() {
		// open the assessment
		driver.findElement(By.xpath("/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/ng-component/ot-assess-list-student/div/ot-table/table/tbody/tr")).click();
		
		// click start		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/otus-button")).click();
		System.out.println("Starting the assessment passed.");
		
		// click save and exit
		driver.findElement(By.xpath("//*[@id=\"otus-assess-page\"]/student-simple-assess/div/div[2]/div[2]/otus-button[1]")).click();
		System.out.println("Saving and exiting the assessment passed.");
		
	}
}
