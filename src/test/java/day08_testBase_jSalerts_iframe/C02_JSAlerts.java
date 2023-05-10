package day08_testBase_jSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseBeforeClass;

public class C02_JSAlerts extends TestBaseBeforeClass {

    /*
    Otomasyon yaparken iki tur alert ile karsılasabiliriz
    1. HTML alert: HTML kodları ile olusturulmus alert'lerdir html ile olusturuldugu için
    inspect edilebilir locate edilebilir.
    2. JavaScript Alert: inspect yapılamaz locate edilemez
    Testlerimiz sırasında jsalert ile karsılasırsak driver.swichTo().alert() methodlarını kullanarak
     alert'e gecis yapabilir ve alert uzerinde  OK,Cancel,getText,sendKeys methodlarını kullanabiliriz
     */

    @Test
    public void test01() throws InterruptedException {
       // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin


          //      - OK tusuna basip alert’i kapatin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        //- 1.alert’e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //- Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        Thread.sleep(3000);
       String actualYazi=driver.switchTo().alert().getText();
       String expectedYazi="I am a JS Alert";
        Assert.assertEquals(expectedYazi,actualYazi);
        //      - OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02(){
      //  - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 2.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        //- Cancel’a basip,
        driver.switchTo().alert().dismiss();
        // cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        String actualSonucYazisi=driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        String expectedSonucYazisi="You clicked: Cancel";
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }
    @Test
    public void test03(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //3.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        // - 3.alert’e tiklayalim
        // - Cikan prompt ekranina “Abdullah” yazdiralim
        // - OK tusuna basarak alert’i kapatalim
        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Abdullah");
        driver.switchTo().alert().accept();
        String expectedIcerik="Abdullah";
        String actualIcerik=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }
    /*
    3 test method’u olusturup asagidaki gorevi tamamlayin
1. Test

2.Test





     */

}
