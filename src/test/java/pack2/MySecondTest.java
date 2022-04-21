package pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySecondTest {
	@Test
	public void forgetPassw() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.className("username")).sendKeys("Admin");
		driver.findElement(By.className("password")).sendKeys("Admin");
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		String monUrl = driver.getCurrentUrl();
		System.out.println("Url :" + monUrl);
		Thread.sleep(3000);
		driver.close();

	}
	@Test
	public void unAutre() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.className("username")).sendKeys("Admin");
		Thread.sleep(3000);
		driver.findElement(By.className("username")).clear();
		Thread.sleep(3000);
		driver.findElement(By.className("password")).sendKeys("Admin");
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		String monUrl = driver.getCurrentUrl();
		System.out.println("Url :" + monUrl);
		Thread.sleep(3000);
		String codeSource = driver.getPageSource();
		System.out.println(codeSource);
		driver.close();

	}
	@Test
	public void encoreUnAutre() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Open a popup")).click();
		Thread.sleep(3000);
		driver.quit();

	}
}
