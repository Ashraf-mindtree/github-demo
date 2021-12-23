import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class herokuapp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sdetmindc127\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Hovers")).click();
		//image hover xpath : //*[@id='content']/div/div[1]/div/h5
		//image hover css selector : #content > div > div:nth-child(3) > div > h5
		System.out.println(driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > div > h5")).getText());
		//Actions actions = new Actions(driver);
		//actions.moveToElement(null)
		System.out.println("----1.Done----");
		driver.navigate().back();
		System.out.println("MainPage");
		driver.findElement(By.linkText("Checkboxes")).click();
		//xpath : //*[@id='checkboxes']/input[2]
		driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).click();
		System.out.println("Unchecked");
		Thread.sleep(200);
		//xpath1: //*[@id='checkboxes']/input[1]
		driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).click();
		System.out.println("Checked");
		System.out.println("----2.Done----");
		driver.navigate().back();
		Thread.sleep(200);
		driver.findElement(By.linkText("Inputs")).click();
		//xpath : //*[@id='content']/div/div/div/input
		driver.findElement(By.xpath("//*[@id='content']/div/div/div/input")).sendKeys("4");
		System.out.println("4 Entered");
		System.out.println("----3.Done----");
		driver.navigate().back();
		Thread.sleep(200);
		driver.findElement(By.linkText("Dropdown")).click();
		Select d= new Select(driver.findElement(By.id("dropdown")));
		d.selectByIndex(2);
		System.out.println("Option2 Selected");
		System.out.println("----4.Done----");
		driver.navigate().back();
		Thread.sleep(200);
		driver.findElement(By.linkText("File Upload")).click();
		WebElement uploadfile= driver.findElement(By.id("file-upload"));
				//filr path : C:\Users\sdetmindc127\Desktop
		uploadfile.sendKeys("C:\\Users\\sdetmindc127\\Desktop\\FileUpload.txt");
		driver.findElement(By.id("file-submit")).click();
		System.out.println("FileUploaded");
		System.out.println("----5.Done----");
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(200);
		driver.findElement(By.linkText("Key Presses")).click();
		driver.findElement(By.id("target")).sendKeys(Keys.SHIFT);
		driver.findElement(By.id("target")).sendKeys("A");
		System.out.println("KeyPress - Shift and A sent");
		System.out.println("----7.Done----");
		driver.navigate().back();
		Thread.sleep(200);
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebElement text=driver.findElement(By.className("example"));
		System.out.println(text.getText());
		driver.close();
		driver.switchTo().window(winHandleBefore);
		System.out.println("----8.Done----");
		driver.navigate().back();
		Thread.sleep(200);
		driver.findElement(By.linkText("Context Menu")).click();
		WebElement btn=driver.findElement(By.id("hot-spot"));
		Actions actions=new Actions(driver);
		actions.contextClick(btn).perform();
		Alert al=driver.switchTo().alert();
		al.accept();
		System.out.println("----9.Done----");
		
		
		
		
		
		driver.close();
	}
