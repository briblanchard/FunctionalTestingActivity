package testing;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is for testing the gradebook tab.
 * 
 * @author briblanchard
 *
 */
public class GradeBookTesting extends FunctionalTesting{
	
	/** This function opens the gradebook tab.
	 * 
	 */
	public void openGradebookTab() {
		//wait for the page to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[text()='Gradebook']")).click();
		
		//wait for the page to load
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://my.otus.com/gradebook/my/class/1677401/points"));
		System.out.println("Opening the gradebook passed. \n");
	}
	
	/**
	 * This function iterates through the rows in the gradebook grid
	 * and clicks on them.
	 */
	public void openGrades() {
		// get the table
		WebElement classTable;
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ot-student-family-gradebook-container/section/div/ot-student-family-gradebook/div/div[3]/ot-student-gradebook-grid/div")));
		try {
			classTable = driver.findElement(By.xpath("/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ot-student-family-gradebook-container/section/div/ot-student-family-gradebook/div/div[3]/ot-student-gradebook-grid/div"));
		}catch(org.openqa.selenium.StaleElementReferenceException ex) {
			classTable = driver.findElement(By.xpath("/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ot-student-family-gradebook-container/section/div/ot-student-family-gradebook/div/div[3]/ot-student-gradebook-grid/div"));
		}
		
		System.out.println("Gradebook table found.\n");

		// create a list of rows
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='gridcell']")));
		List<WebElement> rowList = classTable.findElements(By.xpath("//div[@role='gridcell']"));
		System.out.println(rowList.size() + " rows found.\n");
		
		//remove the header row
		rowList.remove(0);
		
		// count of rows
		int count = 1;
		
		// click all of the rows
		for (WebElement row : rowList) {
			// click the row
			row.click();
			
			System.out.println("Row " + count + " passed.\n");
			count = count + 1;
		}
	}
	
}
