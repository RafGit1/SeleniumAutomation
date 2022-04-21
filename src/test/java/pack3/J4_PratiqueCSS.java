package pack3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class J4_PratiqueCSS {
       
       @Test
       public void loginTest() throws Exception {
             
             WebDriverManager.chromedriver().setup();
             WebDriver driver = new ChromeDriver();
             driver.manage().window().maximize();
             driver.get("https://the-internet.herokuapp.com/login");

             // Tester changement du code au niveau du CSS
              driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
       driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
             Thread.sleep(2000);
             driver.findElement(By.cssSelector("[type=submit]")).click();
             Thread.sleep(2000);
              //driver.findElement(By.cssSelector("[href='/logout']")).click(); //A1
              driver.findElement(By.cssSelector("[href=\"/logout\"]")).click(); //idem A1
             //driver.close();
       }

       
       @Test
       public void forgotPasswordTest() throws Exception {
             
             WebDriverManager.chromedriver().setup();
             WebDriver driver = new ChromeDriver();
             driver.manage().window().maximize();
             driver.get("https://the-internet.herokuapp.com/forgot_password");

             // Tester changement du code au niveau du CSS
             driver.findElement(By.cssSelector("#email")).sendKeys("test@test.com");
             Thread.sleep(2000);
             driver.findElement(By.cssSelector(".icon-signin")).click();
             //driver.findElement(By.cssSelector("#form_submit")).click();
             Thread.sleep(2000);
             //driver.close();
       }

       @Test
       public void getAttributeTest() throws Exception {
             
             WebDriverManager.chromedriver().setup();
             WebDriver driver = new ChromeDriver();
             driver.manage().window().maximize();
             driver.get("https://the-internet.herokuapp.com/forgot_password");

             System.out.println("La valeur de l'attribut est:"+driver.findElement(By.cssSelector("#form_submit")).getAttribute("id"));
             
             Thread.sleep(2000);
             //driver.close();
       }
       
       @Test
       public void getAttributeImageTest() throws Exception {
             
             WebDriverManager.chromedriver().setup();
             WebDriver driver = new ChromeDriver();
             driver.manage().window().maximize();
             driver.get("http://automationpractice.com");
             String url = driver.findElement(By.cssSelector("a[title='My Store']>img")).getAttribute("src");

             System.out.println("La valeur de l'attribut src est:"+url);
             
             Thread.sleep(2000);
             //driver.close();
       }
       
       @Test
       public void getAttributeImageTest2() throws Exception {
             
             WebDriverManager.chromedriver().setup();
             WebDriver driver = new ChromeDriver();
             driver.manage().window().maximize();
             driver.get("http://automationpractice.com");
             
             

       }
       
       
}

