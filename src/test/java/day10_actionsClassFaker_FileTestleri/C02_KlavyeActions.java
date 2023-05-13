package day10_actionsClassFaker_FileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KlavyeActions extends TestBase {

    @Test
    public void test01(){

      // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
      // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@*='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
      // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement adKutusu= driver.findElement(By.xpath("//*[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions.sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("Yucel")
                .sendKeys(Keys.TAB)
                .sendKeys("abc@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("abc123")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();




      // 4- Kaydol tusuna basalim

    }
}
