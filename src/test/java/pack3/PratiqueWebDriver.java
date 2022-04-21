package pack3;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PratiqueWebDriver {

		@Test
		public void TakeScreenshot() throws Exception {
		  
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");
        File screen = driver.findElement(By.cssSelector("[value='orange']")).getScreenshotAs(OutputType.FILE);
		File toFile = new File( "screenshot\\image1.png");
        FileHandler.copy(screen, toFile);
        
	}

}
