package testing;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is for testing the lessons tab.
 * @author briblanchard
 *
 */
public class LessonsTesting extends FunctionalTesting{

	/**
	 * This function opens the lessons tab.
	 */
	public void openLessonsTab() {
		//wait for the page to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//click on the lessons tab from the navbar
		driver.findElement(By.xpath("//span[text()='Lessons']")).click();
		
		//wait for the page to load
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://my.otus.com/lesson"));
		System.out.println("Opening lessons passed. \n");
	}
	
	/**
	 * This function iterates through the lessons
	 * in the lesson table and clicks on each row
	 * then saves and closes the lesson to go back
	 * and click on the next one.
	 */
	public void clickLesson() {
		// get the table
		WebElement lessonsTable;
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/ng-component/otus-lesson-list-student/div/div/ot-table/table")));
		try {
			lessonsTable = driver.findElement(By.xpath("/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/ng-component/otus-lesson-list-student/div/div/ot-table/table"));
		}catch(org.openqa.selenium.StaleElementReferenceException ex) {
			lessonsTable = driver.findElement(By.xpath("/html/body/div[1]/otus-app/ot-theme-provider/main/div/div/ng-component/section/ng-component/otus-lesson-list-student/div/div/ot-table/table"));
		}
		
		System.out.println("Lessons table found. \n");
		
		// list of rows
		List<WebElement> rowList = lessonsTable.findElements(By.tagName("tr"));
		System.out.println(rowList.size() + " rows found. \n");
		
		//remove the header row
		rowList.remove(0);
		
		// count of rows
		int count = 1;
		
		// click all of the rows
		for (WebElement row : rowList) {
			row.click();
			
			//wait for the page to load
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
			// save and exit
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"otus-lesson-page\"]/student-lesson/div/div/div[1]/div[2]/div/button")));
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"otus-lesson-page\"]/student-lesson/div/div/div[1]/div[2]/div/button")));
			driver.findElement(By.xpath("//*[@id=\"otus-lesson-page\"]/student-lesson/div/div/div[1]/div[2]/div/button")).click();
					
			System.out.println("Row " + count + " passed.\n");
			count = count + 1;
		}
		
	}
}
