package takimCalismasi01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class RegisterUser extends TestBase {
    //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
    //6. Adı ve e-posta adresini girin
    //7. 'Kaydol' düğmesini tıklayın
    //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
    //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
    //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
    //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
    //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
    //13. 'Hesap Oluştur düğmesini' tıklayın
    //14. 'HESAP OLUŞTURULDU!' görünür
    //15. 'Devam Et' düğmesini tıklayın
    //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
    //17. 'Hesabı Sil' düğmesini tıklayın
    //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın


    @Test
    public void registerUser() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homepage = driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue(homepage.isDisplayed());

        if (homepage.isDisplayed()){
            System.out.println("Homepage testsi PASSED");
        }else {
            System.out.println("Homepage testsi FAİLED");
        }

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(newUser.isDisplayed());

        //6. Enter name and email address
        WebElement name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("Ahmet");
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("fcyazilim92@gmail.com");

        //7. Click 'Signup' button
       driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccound = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccound.isDisplayed());

        //9. Fill details: Title, Password, Date of birth
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("1234");

        WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
        Select selectd = new Select(day);
        selectd.selectByIndex(3);

        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectm = new Select(month);
        selectm.selectByIndex(8);

        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        Select selecty = new Select(year);
        selecty.selectByValue("1993");

        Thread.sleep(5000);

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.sendKeys("FC");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.sendKeys("Crk");
        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("Holding");
        WebElement address = driver.findElement(By.xpath("//input[@id='address1']"));
        address.sendKeys("cıkmaz sokak");
        WebElement address2 = driver.findElement(By.xpath("//input[@id='address2']"));
        address2.sendKeys("mahalle");
        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select selectcountry = new Select(country);
        selectcountry.selectByValue("Canada");
        WebElement state = driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys("asb");
        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("asddf");
        WebElement zip = driver.findElement(By.xpath("//input[@id='zipcode']"));
        zip.sendKeys("1233");
        WebElement mobileNumber = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        mobileNumber.sendKeys("05555555555");

        Thread.sleep(5000);
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement account = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(account.isDisplayed());


        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        // driver.findElement(By.xpath("//span[@dir='auto']")).click();

        //16. Verify that 'Logged in as username' is visible
     //   WebElement logged = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
       // Assert.assertTrue(logged.isDisplayed());


        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(deleted.isDisplayed());

    }
}
