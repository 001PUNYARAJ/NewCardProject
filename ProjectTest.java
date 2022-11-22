package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProjectTest {

public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
		
	System.setProperty("webdriver.chrome.driver",
	"C:\\Users\\manan\\OneDrive\\Desktop\\Selenium 4 files\\chromedriver_win32\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();    	
	driver.get("https://qatest.commentsoldrt.com/webstore-login?destination=/account");
	driver.manage().window().maximize();
			
	driver.findElement(By.id("email")).sendKeys("manandhar.punyaraj@gmail.com");
	driver.findElement(By.id("password")).sendKeys("USANepal@123");
	driver.findElement(By.cssSelector("button[class=\"ws-v2-button-primary mt-1r\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"vue-app-account\"]/div/header/div/div/div[3]/a[3]")).click();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	driver.findElement(By.cssSelector("body > div.ReactModalPortal > div > div > div > button > svg")).click();
	
//	Add card
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[1]/div/div/div[1]/div/nav/ul/li[2]/a")).click();
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("[alt=\"Product: You Look Good Bath Mat\"]")).click();
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
	
//	Payment	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[2]/div/div[2]/a")).click();
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("[value=\"delivery\"]")).click();
	
//	Address fill up
//	Thread.sleep(5000);
//	driver.findElement(By.cssSelector("input[autocomplete=\"address-line1\"]")).sendKeys("168 Hyde Stree");
//	driver.findElement(By.cssSelector("input[autocomplete=\"address-line2\"]")).sendKeys("APT 1000");
//	driver.findElement(By.id("locality")).sendKeys("San Francisco");
//	driver.findElement(By.cssSelector("select[name=\"state\"]")).sendKeys("California");
//	driver.findElement(By.cssSelector("input[autocomplete=\"postal-code\"]")).sendKeys("94103");
//	driver.findElement(By.id("save-button")).click();

//	Add Credit Card
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("input[id=\"credit-card\"]")).click();
	WebElement a = driver.findElement(By.xpath("(//iframe[@allow=\"payment *\"])[1]"));
	driver.switchTo().frame(a);
	Thread.sleep(5000);
	
	driver.findElement(By.cssSelector("[aria-label=\"Credit or debit card number\"]")).sendKeys("4242 4242 4242 4242");
	driver.findElement(By.cssSelector("[autocomplete=\"cc-exp\"]")).sendKeys("11/27");
	driver.findElement(By.xpath("(//input[@class=\"InputElement is-empty Input Input--empty\"])[1]")).sendKeys("111");
	driver.findElement(By.cssSelector("[name=\"postal\"]")).sendKeys("12345");
	driver.switchTo().parentFrame();
	Thread.sleep(5000);
	driver.findElement(By.id("stripe-button")).click();
	driver.findElement(By.xpath("(//button[@class=\"_pill-button\"])[4]")).click();
	driver.findElement(By.cssSelector("[class=\"default-input coupon-input\"]")).sendKeys("5OFF20");
	driver.findElement(By.id("save-button")).click();
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("[class=\"_cta-button\"]")).click();
	Thread.sleep(10000);

//	Close
	driver.findElement(By.cssSelector("[class=\"webstore-checkout-btn\"]")).click();

	
	driver.close();
	}	
	}