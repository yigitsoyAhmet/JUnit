package day07_jUnit_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {

    //● https://www.amazon.com/ adresine gidin.
    //- Test 1


    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @After
    public static void teardown() {
        driver.close();
    }

    public void test01() {
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        //element dropdown menu olduguiçin select classından olusturacagım obje ile ilgili methodları kullanacagız

        WebElement dropdownElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownElementi);
        int expectedOptionSayisi = 45;
        int actualOptionSayisi = select.getOptions().size();
        Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);

    }

    @Test
    public void test02() {


        WebElement dropdownElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownElementi);

        //	-Test 2
        // 1. Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");
        // 2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        // 3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayiElementi = driver.findElement(By.xpath("(//div[@class=‘sg-col-inner’])[1]"));
        System.out.println(sonucSayiElementi.getText());
        // 4. Sonucun Java kelimesini icerdigini test edin
        String expectedIcerik = "Java";
        String actualSonucYazisi = sonucSayiElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }
}
