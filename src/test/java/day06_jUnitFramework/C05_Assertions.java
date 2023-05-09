package day06_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions {

    WebDriver driver;

    public void mahserin4Atlisi() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.bestbuy.com/");
        //  1) Bir class oluşturun: BestBuyAssertions
        // 2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    }
@Test
    public void test01() {
        //Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
        mahserin4Atlisi();
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);//once expected yazılır.
    driver.close();

    }
    @Test
    public void test02() {
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        mahserin4Atlisi();
        String unexpectedIcerik="Rest";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(unexpectedIcerik));
        driver.close();

    }
    @Test
      public void test03(){
          //logoTest => BestBuy logosunun görüntülendigini test edin
        mahserin4Atlisi();
          WebElement logoElementi=driver.findElement(By.xpath("//img[@width='80'][1]"));

          Assert.assertTrue(logoElementi.isDisplayed());
          driver.close();

      }
    @Test
      public void test04(){
          //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        mahserin4Atlisi();
          WebElement fransizcaLink= driver.findElement(By.xpath("//button[@lang='fr']"));
          Assert.assertTrue(fransizcaLink.isDisplayed());
          driver.close();
      }
}
