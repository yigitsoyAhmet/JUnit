package day06_jUnitFramework;

import org.junit.Assert;
import org.junit.Test;

public class C04_AssertionMethodlari {
    @Test
    public void test01(){
        //eger testin sonucunu turkçe olarak olumlu bir cumle ile sorduysa "sayi1>sayi2"gibi
        // assertTrue kullanırız, olumsuz ise "sayi1 kucuk değildir sayi2 " gibi assertFalse tercih edilir
        int sayi1=20;
        int sayi2=10;
        int sayi3=30;

        //sayi1'in sayi2 den buyuk oldugunu test edin
        Assert.assertTrue(sayi1>sayi2);//PASSED

        //sayi1'in sayi3 den buyuk olmadığını test edin
        Assert.assertFalse(sayi1>sayi3);//PASSED

        //sayi1'in sayi3'den kucuk olduguu deseydi
        Assert.assertTrue(sayi1<sayi3);

    }
}
