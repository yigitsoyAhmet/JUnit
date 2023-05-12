package day09_switchingWindow_actionsClass;

import org.junit.Test;

import java.time.LocalTime;

public class C03_ActionsClass {

    @Test
    public void test01(){
        //x saniyelik bir sayac yapalım
        int x=3;
        LocalTime baslangic=LocalTime.now();
        int baslangicSaniye=baslangic.getSecond();
        int saniyeKontrol=123;
        int bitisSaniyesi=baslangicSaniye>60 ? baslangicSaniye+x-60:baslangicSaniye+x;

        while (bitisSaniyesi!=saniyeKontrol){
            saniyeKontrol=LocalTime.now().getSecond();

        }
        System.out.println("baslangic saniyesi : " +baslangicSaniye);
        System.out.println("saniye kontrol :" +saniyeKontrol);
    }
}
