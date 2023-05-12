package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_NewWindow extends TestBase {
    //driver.swichTo().newWindow() kullanılırsa driver otomatik olarak yeni sayfaya gider

//eger gorevde yeni windowa gittikten sonra eski windowa donme windowlar arası geçis islemi varsa işlemi varsa o zaman
//uzerinde calıstıgımız windowslarin windwHandle degerlerini alıp kaydetmek de fayda var.
    @Test
    public void test01() throws InterruptedException {
        // Gerekli ayarlamaları yapıp amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        //title in amazon kelimesi içerdiğini test edin
        String expectedIcerik="Amazon";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        //yeni bir tab acarak wisequarter anasayfaya gidin ve url'in wisequarter içerdiğini test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String ikinciSayfaHandleDegeri= driver.getWindowHandle();
        expectedIcerik= "wisequarter";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        //tekrar amazonun acık oldugu sayfaya geçin ve url in amazon içerdiğini test edin
        driver.switchTo().window(ilkSayfaHandleDegeri);
        expectedIcerik= "amazon";
        actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Thread.sleep(3000);

    }


}
