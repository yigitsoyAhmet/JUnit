package day14_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JavaScriptExecutor extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //wisequarter anasayfaya gidin asagıya inerek SDET kursunda Explore the Course butonuna basin

        driver.get("https://www.wisequarter.com");

        WebElement exploreButonu= driver.findElement(By.xpath("(//div[@class='btn-wraper'])[2]"));

        exploreButonu.click();

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView();",exploreButonu);


        //click
        jse.executeScript("arguments[0].click()",exploreButonu);
        //alert
        jse.executeScript("alert(yasasinnnn);");

        Thread.sleep(5000);
    }
}
