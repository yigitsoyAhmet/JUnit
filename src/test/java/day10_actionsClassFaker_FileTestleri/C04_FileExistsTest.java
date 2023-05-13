package day10_actionsClassFaker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExistsTest {


    @Test
    public void test01(){
        //com.Team113JUnit projesi içerisinde deneme.txt dosyasının var oldugunu test edin

        String dosyayolu="day10_actionsClassFaker_FileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));

    }
}
