package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_SwichingWindows extends TestBase {
    /*
    driver.swichTo().newWindow() kullanarak actıgımız windowa driver otomatik olarak gecer
    ancak; biz new window methodunu kullanmadan bir link tıkladıgımızda yeni sayfa window acılıyorsa
    driver eski window da kalır yeni windowa driver'i gecirebilmek için
    yeni windowun windowHandle degerine ihtiyacımız vardır.
     */


    @Test
    public void test01() throws InterruptedException {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingWindowYaziElementi= driver.findElement(By.tagName("h3"));

        String expectedYazi="Opening a new window";
        String actualYaziElementi=openingWindowYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYaziElementi);
        String ilkSayfaWHD= driver.getWindowHandle();
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //bu satır itibariyle yeni window acıldı artık iki window var
        Set<String> whdDegerleriSeti=driver.getWindowHandles();
        String ikinciWindowWHD="";
        for (String eachWhd:whdDegerleriSeti) {
            if (!eachWhd.equals(ilkSayfaWHD)){
                ikinciWindowWHD=eachWhd; //Artik acilan ikinci windowun whandle degerine sahibiz.
            }
        }
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciWindowWHD);
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
        expectedTitle="New Window";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);




        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindowYaziElementi= driver.findElement(By.tagName("h3"));
        expectedYazi="New Window";
        actualYaziElementi=newWindowYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYaziElementi);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        expectedTitle="The Internet";
        actualTitle=newWindowYaziElementi.getText();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
}
