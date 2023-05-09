package day06_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;

import java.time.Duration;

public class C02_Assert {
 //Amazona gidip title'in AMAZON içerdiğini test edin

   /*
    JUnit calistirilan test method(lar)indan kac tanesinin

    passed,failed veya ignore oldugunu otomatik olarak raporlar
    Eger JUnit'in test sonuclarini dogru olarak raporlamasini istiyorsak
    Assert class'indan hazir method'lar kullanarak test yapmaliyiz.
  */
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        String expectedTitle="AMAZON";
        String actualTitle= driver.getTitle();

       /*
        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Actual Title" +actualTitle);
            System.out.println("Title testi FAILED");
        }
        */
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        driver.close();
    }
}
