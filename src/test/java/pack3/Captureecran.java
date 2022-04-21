package pack3;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Captureecran {

	@Test
	public void TakeScreenshot() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		File screen = driver.findElement(By.cssSelector("#HTML29 > div.widget-content > img"))
				.getScreenshotAs(OutputType.FILE);
		File toFile = new File("screenshot\\image2.png");
		FileHandler.copy(screen, toFile);
		driver.close();
	}

	@Test
	public void TakeScreenshot2() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File toFile = new File("screenshot\\image3.png");
		FileHandler.copy(screen, toFile);
		driver.close();
	}

	@Test
	public void ScreenshotAndReport() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Reporter.log("Ouverture de la page");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		Reporter.log("Remplir formulaire login");
		driver.findElement(By.cssSelector("#login-button")).click(); 
		Reporter.log("Affichage Homepage");
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.cssSelector("#react-burger-menu-btn")).click(); 
		Thread.sleep(2000);
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File toFile = new File("screenshot\\image4.png");
		FileHandler.copy(screen, toFile);
		driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
		Thread.sleep(1000);
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\RK\\eclipse-workspace\\Selenium_Maven\\screenshot\\image4.png\">screenshot</a>");
		Reporter.log("Fermeture du navigateur");
		driver.close();
	}

	
	@Test
	public void navigateMethod() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(1000);
		driver.navigate().refresh();	
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		driver.close();
	}
	
	@Test
	public void findMultipleElementsMethod() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		List<WebElement> maListe = driver.findElements(By.cssSelector("input"));
		System.out.println("maListe ="+maListe);
		for (WebElement element:maListe) {
			String monAttribut = element.getAttribute("name");
			System.out.println("Attribut="+ monAttribut);
		}
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void compteLesaMethod() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		Reporter.log("Remplir formulaire login");
		driver.findElement(By.cssSelector("#login-button")).click(); 
		// driver.findElements(By.tagName("a"));
		// recuperer les a puis les href et les linktext 
		List<WebElement> maListe = driver.findElements(By.tagName("a"));
		System.out.println("maListe ="+maListe);
		for (WebElement element:maListe) {
			String href = element.getAttribute("href");
			String linkText = element.getText();
			System.out.println("href ="+ href);
			System.out.println("Link text ="+ linkText);
		}
		Thread.sleep(2000);
		
		Thread.sleep(1000);
		driver.navigate().forward();
		driver.close();
	}
	
	@Test
	public void getDifferentValues() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		//driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		//driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		//driver.findElement(By.cssSelector("#login-button")).click(); 
		// driver.findElements(By.tagName("a"));
		// recuperer les a puis les href et les linktext 
		WebElement element = driver.findElement(By.cssSelector("#login-button"));
		String color = element.getCssValue("background-color");
		List<WebElement> maListe = driver.findElements(By.tagName("a"));
		System.out.println("ma couleur ="+color);
		
		Thread.sleep(1000);
		driver.close();
	}
	@Test
	public void getNavigatorClass() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		String nomDriver = driver.getClass().getSimpleName();
		System.out.println("Driver  ="+nomDriver);
		driver.close();
	}
	@Test
	public void displayText() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		String idPage1 = driver.getWindowHandle();
		driver.findElement(By.linkText("Open a popup window")).click();
		Set<String> windows = driver.getWindowHandles();
		//String text = driver.findElement(By.id("paral")).getText();	
		System.out.println("Paragraphe  ="+idPage1);
		Iterator<String> iterateur = windows.iterator();
		while(iterateur.hasNext() ) {
			String window = iterateur.next();
			driver.switchTo().window(window);
			if(driver.getTitle().equals("Basic Web Page Title")) {
				String text = driver.findElement(By.id("para1")).getText();
				System.out.println("Paragraphe " +text);
			}
		}
		driver.close();
	}
	@Test
	public void dropdownclick() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
		WebElement facebook = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")));
		driver.findElement(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")).click();
		String url = driver.getCurrentUrl();
		
		System.out.println("Url  ="+url);
		driver.close();
	}
}
