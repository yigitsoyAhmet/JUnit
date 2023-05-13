package day10_actionsClassFaker_FileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUploadTesti extends TestBase {

    @Test
    public void test01() {
        /*
        driver ile gittiğimiz bir web sayfasında pcdeki bir dosyayı upload etmek istersek
        pcmizdeki klasorlere erişmemiz gerekir selenium pcdeki dosyalara erişemez bunun yerine
        1- choose file butonunu locate edelim
        2-pc den yuklemek istediğimiz dosyanın dosya yolunu olusturalım(dinamik olsun mumkunse)
        3-chooseButonu.sendKeys(dosyaYolu) ile dosyayı sisteme atalım
         */

         //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
         //chooseFile butonunu kullanarak
         // projemizdeki deneme.txt dosyasini secelim.
        WebElement chooseFileButonu= driver.findElement(By.id("file-upload"));
        String herkesteFarkliOlan=System.getProperty("user.dir");
        String herkesteAyniOlan="/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";
        String dosyaYolu=herkesteAyniOlan+herkesteFarkliOlan;
        chooseFileButonu.sendKeys(dosyaYolu);
         //Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
         //"File Uploaded!" textinin goruntulendigini test edelim.
    }
}
