package day06_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
    1-Google anasayfaya gidip url in google içerdiğinin test edin


     */

    //JUnitin bize sağladıgı ilk ve en onemli ozellik test methodlarının bağımsız olarak
    // çalıstırılmasını sağlayan @Test notasyonudur.

    //Birden fazla test methodu çalıstırırsak
    // hangi siralama ile çalıstıracagını ongoremeyız ve yonetemeyız.

    //diyelimki bir test methodu içinde çalısıyoruz ama o methodun
    // toplu çalıstırılmalarda çalısmasını istemiyoruz @Ignore KULLANILIR

    WebDriver driver;
    @Test@Ignore
    public void googleTest(){
       // 1-Google anasayfaya gidip url in google içerdiğinin test edin

    mahserin4Atlisi();
    driver.get("https://www.google.com");
    String expectedIcerik="google";
    String actualUrl=driver.getCurrentUrl();

    if (actualUrl.contains(expectedIcerik)){
        System.out.println("google testi, PASSED");
    }else{
        System.out.println("google testi, FAILED");
    }
    driver.close();
    }
    @Test
    public void wiseTest(){
       // 2-wisequarter ansayfaya gidip url'in wisequarter içerdiğini test edin
       mahserin4Atlisi();
       driver.get("https://www.wisequarter.com");
       String expectedUrl="wisequarter";
       String actualIcerik=driver.getCurrentUrl();

       if (actualIcerik.contains(expectedUrl)){
           System.out.println("wise testi PASSED");
       }else{
           System.out.println("wise testi FAILED");
       }
       driver.close();

    }
    @Test
    public void amazonTest(){
       // 3- Amazon anasayfaya gidip amazon logosunun gorundugunu test edin
        mahserin4Atlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi= driver.findElement(By.id("nav-logo-sprites"));
        if (amazonLogoElementi.isDisplayed()){
            System.out.println("amazon logo testi PASSED");
        }else{
            System.out.println("amazon logo testi FAILED");
        }
        driver.close();
    }

    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

}
