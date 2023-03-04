package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
       WebDriver driver;
       String projectPath = System.getProperty("user.dir");
       String osName = System.getProperty("os.name");
       
       @BeforeClass
       public void beforeClass() {
    	if (osName.contains("Windows")) {
   			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
   		} else {
   			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
   		}

   		driver = new FirefoxDriver();
   		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   		
   		// Mở trang Register ra
   		driver.get("https://demo.nopcommerce.com/register/");
    	   
    	}
       
       // HTML cua FirstName textbox
      // <input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
       // tên thẻ của element (Tagname HTML): input
       // Tên của thuộc tính (Attribute name): type    data-val-requires    id  name  
       // Giá trị của thuộc tính (Attribute value): text true  First name is required.  FirstName
       
       
    	@Test
       public void TC_01_ID() {
    		driver.findElement(By.id("FirstName")).sendKeys("Automation");
    	
    		
    	}
    	
    	@Test
    	public void TC_02_Class() {
    		// Mở màn hình Search
    		driver.get("https://demo.nopcommerce.com/search");
    		
    		// Nhập text vào Search textbox
    		driver.findElement(By.className("search-text")).sendKeys("Macbook");
    		
    	}
    	
    	@Test
    	public void TC_03_Name() {
    		driver.findElement(By.name("advs")).click();;
    		
    	}
    	
    	@Test
    	public void TC_04_TagName() {
    		
    		// Tìm ra bao nhiêu thẻ input trên màn hình hiện tại
    		//driver.findElements(By.tagName("input")).size();
    		System.out.println(driver.findElements(By.tagName("input")).size());
    		
    	}
    	
    	
    	@Test
    	public void TC_05_LinkText() {
    		
    		//Click vào đường link Addresses (lấy link địa chỉ tuyệt đối)
    		driver.findElement(By.linkText("Addresses")).click();
    		
    	}
    	
    	@Test
    	public void TC_06_PartialLinkText() {
    		// Click vào đường link Apply for vendor account (tương đối)
    		driver.findElement(By.partialLinkText("vendor account")).click();
    		
    		
    	}
    	
    	@Test
    	public void TC_07_Css() {
    		// Mở lại trang Register
    		driver.get("https://demo.nopcommerce.com/register/");
    		//1 lấy theo cách input#FirstName
    		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Selenium");
    		
    		// 2 lấy theo địa chỉ tuyệt đối của id input[id='LastName']
    		driver.findElement(By.cssSelector("input[id=LastName]")).sendKeys("Locator");
    		
    		// 3 
    		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("duongthu2093@gmail.com");
    		
    		
    		
    	}
    	
    	@Test
    	public void TC_08_XPath() {
    		
    		// Mở lại trang Register
    		driver.get("https://demo.nopcommerce.com/register/");
    		//1 lấy theo cách input#FirstName
    		driver.findElement(By.xpath("//input[@data-val-required='First name is required.']")).sendKeys("Selenium");
    		
    		// 2 lấy theo địa chỉ tuyệt đối của id input[id='LastName']
    		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Locator");
    		
    		// 3 
    		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("duongthu2093@gmail.com");
    		
    	}
    	
    	@AfterClass
    	public void afterClass() {
    		 driver.quit();
    	}
       
}

