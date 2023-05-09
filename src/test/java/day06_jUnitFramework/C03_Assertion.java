package day06_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {

    //Bir assertion failed olursa assertion'un oldugu satırda
    // exception olusur ve assertion satırından sonraki kodlar çalısmaz
    WebDriver driver;
    @Test
    public void googleTest(){
        // 1-Google anasayfaya gidip url in google içerdiğinin test edin

        mahserin4Atlisi();
        driver.get("https://www.google.com");
        String expectedIcerik="google";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        driver.close();
    }
    @Test
    public void wiseTest(){
        // 2-wisequarter ansayfaya gidip url'in wisequarter içerdiğini test edin
        mahserin4Atlisi();
        driver.get("https://www.wisequarter.com");
        String expectedUrl="wisequarter";
        String actualIcerik=driver.getCurrentUrl();

       Assert.assertTrue(actualIcerik.contains(expectedUrl));
        driver.close();

    }
    @Test
    public void amazonTest(){
        // 3- Amazon anasayfaya gidip amazon logosunun gorundugunu test edin
        mahserin4Atlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi= driver.findElement(By.id("nav-logo-sprites"));
      Assert.assertTrue(amazonLogoElementi.isDisplayed());
        driver.close();
    }

    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}
