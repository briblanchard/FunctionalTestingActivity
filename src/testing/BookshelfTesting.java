package testing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is for testing the bookshelf tab.
 * 
 * @author briblanchard
 *
 */
public class BookshelfTesting extends FunctionalTesting {

	public void openBookshelfTab() {
		//click on the bookshelf link
		driver.findElement(By.xpath("//span[text()='Bookshelf']")).click();
		
		//wait for the page to load
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://my.otus.com/bookshelf/shared-with-me"));
		System.out.println("Opening bookshelf passed.\n");
	}
	
	/**
	 * This function iterates through the table of resources
	 * and clicks on them all to make sure they work.
	 * 
	 */
	public void openResources() {
		//wait for the page to load
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		// get the table
		WebElement resourcesTable;
		try{
			resourcesTable = driver.findElement(By.xpath("//*[@id=\"outerWrapper\"]/otus-app/ot-theme-provider/main/div/div/ng-component/shared-bookshelf/div[1]/div/div[2]/ot-list-resources/div/table"));
		}catch(org.openqa.selenium.StaleElementReferenceException ex) {
			resourcesTable = driver.findElement(By.xpath("//*[@id=\"outerWrapper\"]/otus-app/ot-theme-provider/main/div/div/ng-component/shared-bookshelf/div[1]/div/div[2]/ot-list-resources/div/table"));
		}
				
		// list of the rows
		List<WebElement> rowList;
		try {
			rowList = resourcesTable.findElements(By.tagName("tr"));
		}catch(org.openqa.selenium.StaleElementReferenceException ex) {
			rowList = resourcesTable.findElements(By.tagName("tr"));
		}
		System.out.println(rowList.size() + " rows found.");
		
		//remove the header row
		rowList.remove(0);
		
		// count of rows
		int count = 1;
		
		// click the items in the row list
		for(WebElement row : rowList) {
			//wait for the page to load
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(row));
			
			// click the items
			row.click();
			
			//open the resource link
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[16]/div/div[2]/ot-attachment-tile/div/div/div[2]/div/div/div/a")));
			driver.findElement(By.xpath("/html/body/div[16]/div/div[2]/ot-attachment-tile/div/div/div[2]/div/div/div/a")).click();
			
			//wait for the page to load
			new WebDriverWait(driver, 20).until(ExpectedConditions.numberOfWindowsToBe(2));
			
			// get a list of the tabs
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			
			
			// close the new resource tab link
			driver.switchTo().window(tabs.get(1));
			driver.close();
			driver.switchTo().window(tabs.get(0));
			
			System.out.println("Opening resource link passed.");
			
			// close the pop up
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[16]/div")));
			WebElement popup = driver.findElement(By.xpath("/html/body/div[16]/div"));
			popup.sendKeys(Keys.ESCAPE);
			
			System.out.println("Row " + count + " passed.\n");
			count = count + 1;
		}
		
	}
	
	/**
	 * This function opens the My Bookshelf page
	 */
	public void openMyBookshelfTab() {
		// click to open my bookshelf
		driver.findElement(By.xpath("//span[text()='My Bookshelf']")).click();
		
		// wait for the page to load
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://my.otus.com/bookshelf/my-bookshelf"));
		System.out.println("Opening my bookshelf passed.\n");
	}
	
	/**
	  * This function uploads an allowed file to the bookshelf.
	  */
	public void addFile() {
		// click the add resource button
		driver.findElement(By.xpath("//button[@aria-label='open actions menu']")).click();
		
		// click the resource under add resources
		driver.findElement(By.xpath("/html/body/div[19]/div[2]/div/ot-overlay/ul/li[1]")).click();
		System.out.println("Opened resource page.");
		
		// click upload file resource type
		driver.findElement(By.xpath("/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/div/div[1]")).click();
		
		// select the file to upload
		driver.findElement(By.className("inputfile")).sendKeys("/home/briblanchard/eclipse-workspace/Otus_FunctionalTesting/Data/integration.pdf");
		
		// save the file
		driver.findElement(By.xpath("/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/ot-attach-file/ot-drag-drop-area/div/div[3]/otus-button")).click();
		
		System.out.println("File uploaded successfully.");
		
	}

	/**
	 * This function uploads the correct format of a picture
	 */
	public void addPhoto() {
		// click the add resource button
		driver.findElement(By.xpath("//button[@aria-label='open actions menu']")).click();
		
		// click the resource under add resources
		driver.findElement(By.xpath("/html/body/div[19]/div[2]/div/ot-overlay/ul/li[1]")).click();
		System.out.println("Opened resource page.");
		
		// click upload photo resource type
		driver.findElement(By.xpath("/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/div/div[3]")).click();
		
		// select the file to upload
		driver.findElement(By.className("inputfile")).sendKeys("/home/briblanchard/eclipse-workspace/Otus_FunctionalTesting/Data/pumpkins.jpg");
		
		// save the file
		driver.findElement(By.xpath("/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/ot-attach-image/ot-drag-drop-area/div/div[3]/otus-button")).click();
		
		System.out.println("Photo uploaded successfully.");
		
	}
	
	/**
	 * This function tries to upload the wrong file format
	 * to make sure the error message pops up.
	 */
	public void addRainyPhoto() {
		// click the add resource button
		driver.findElement(By.xpath("//button[@aria-label='open actions menu']")).click();
		
		// click the resource under add resources
		driver.findElement(By.xpath("/html/body/div[19]/div[2]/div/ot-overlay/ul/li[1]")).click();
		System.out.println("Opened resource page.");
		
		// click upload photo resource type
		driver.findElement(By.xpath("/html/body/div[4]/div/div/ot-drag-drop-area/div/ot-attach-wrapper/div/div/div/div[3]")).click();
		
		// select the file to upload
		driver.findElement(By.className("inputfile")).sendKeys("/home/briblanchard/eclipse-workspace/Otus_FunctionalTesting/Data/integration.pdf");
		
		// find and close the error message
		driver.findElement(By.xpath("/html/body/div[20]/div/div/div"));
		System.out.println("Rainy day photo passed.");
		
		// close the pop up
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div")));
		WebElement popup = driver.findElement(By.xpath("/html/body/div[4]/div"));
		popup.sendKeys(Keys.ESCAPE);
		
	}
	
	/**
	 * This function iterates through the uploaded resource
	 * to ensure they open correctly
	 */
	public void openMyBookshelfResources() {
		//wait for the page to load
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		// get the table
		WebElement resourcesTable;
		try {
			resourcesTable = driver.findElement(By.xpath("//*[@id=\"outerWrapper\"]/otus-app/ot-theme-provider/main/div/div/ng-component/my-bookshelf/div[1]/div/div[2]/ot-list-resources/div/table"));
		}catch(org.openqa.selenium.StaleElementReferenceException ex) {
			resourcesTable = driver.findElement(By.xpath("//*[@id=\"outerWrapper\"]/otus-app/ot-theme-provider/main/div/div/ng-component/my-bookshelf/div[1]/div/div[2]/ot-list-resources/div/table"));
		}
		
		// list of the rows
		List<WebElement> rowList;
		try {
			rowList = resourcesTable.findElements(By.tagName("tr"));
		}catch(org.openqa.selenium.StaleElementReferenceException ex) {
			rowList = resourcesTable.findElements(By.tagName("tr"));
		}
		System.out.println(rowList.size() + " rows found.");
		
		//remove the header row
		rowList.remove(0);
		
		// count of rows
		int count = 1;
		
		// click the items in the row list
		for(WebElement row : rowList) {
			//wait for the page to load
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			// click the items
			try {
				row.click();
			}catch(org.openqa.selenium.StaleElementReferenceException ex) {
				row.click();
			}
			
			//open the resource link
			try{ // for resource link
				new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[16]/div/div[2]/ot-attachment-tile/div/div/div[2]/div/div/div/a")));
				driver.findElement(By.xpath("/html/body/div[16]/div/div[2]/ot-attachment-tile/div/div/div[2]/div/div/div/a")).click();
			}catch(org.openqa.selenium.TimeoutException e) {
				// for image file
				new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[16]/div/div[2]/ot-attachment-tile/div/div/div[2]/div/div/a/img")));
				driver.findElement(By.xpath("/html/body/div[16]/div/div[2]/ot-attachment-tile/div/div/div[2]/div/div/a/img")).click();
			}
			
			
			//wait for the page to load
			new WebDriverWait(driver, 20).until(ExpectedConditions.numberOfWindowsToBe(2));
			
			// get a list of the tabs
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			
			
			// close the new resource tab link
			driver.switchTo().window(tabs.get(1));
			driver.close();
			driver.switchTo().window(tabs.get(0));
			
			System.out.println("Opening resource link passed.");
			
			// close the pop up
			WebElement popup = driver.findElement(By.xpath("/html/body/div[16]/div"));
			popup.sendKeys(Keys.ESCAPE);
			
			System.out.println("Row " + count + " passed.");
			count = count + 1;
		}
		
	}
	
}
