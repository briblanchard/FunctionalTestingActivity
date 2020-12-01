package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is for testing the classes tab.
 * 
 * @author briblanchard
 *
 */
public class ClassBoardTesting extends FunctionalTesting {

	/**
	 * This function opens the classes page 
	 * which is where the class boards are.
	 */
	public void openClassesTab() {
		//wait for the page to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[text()='Classes']")).click();
		
		//wait for the page to load
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://my.otus.com/classes/my-classes"));
		System.out.println("Opening classes passed.");
	}
	
	/**
	 * This function opens the class board.
	 */
	public void openClassBoards() {
		// open the class
		driver.findElement(By.xpath("//*[@id=\"classes-page\"]/home-course-component/home-student-course-component/div/div[2]/div/ot-class-card/div/div[2]/p")).click();
		
		// click load more
		driver.findElement(By.xpath("//*[@id=\"classes-page\"]/ot-class-board-outlet/ot-class-board/div/button")).click();
		System.out.println("Clicked load more.");
		
		// click on the class board post
		driver.findElement(By.xpath("//*[@id=\"classes-page\"]/ot-class-board-outlet/ot-class-board/ot-class-board-posts/ot-post-tile/ot-post-summary/div[1]")).click();
		System.out.println("Opening the class board post passed.");
	}
	
}
