package TwitterBot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class TwitterBotOtomasyon {


    public static void twitterBot() throws InterruptedException {

        //otomatik tweet atılacak liste
       List<String> list= TwitterBotList.listDepo();
       //counter
       int count=0;
       //tweet yazılacak yer için kullanılacak string variable
       String keys="";
       // tag
        String tag = ".......";
        //kullanici adi
        String username="kullanici adi";
        //şifre
        String password="şifre";

        do {
            //listteki her bir elemanı String variable'nin içine at
            keys = tag + "   " +list.get(count);
            System.setProperty("chromeDriver", "src/main/resources/drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

            //hazır web sayfası aç tam ekran yap
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //twitter'a git
            driver.get("https://twitter.com");
            //giriş yap
            driver.findElement(By.xpath("//*[text()='Giriş yap']")).click();
            Thread.sleep(5000);

            //kullanıcı adı bölümünü tıkla
            driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-16y2uox r-1wbh5a2 r-1wzrnnt r-1udh08x r-xd6kpl r-1pn2ns4 r-ttdzmv']")).click();
            //kullanıcı adını gir
            WebElement kullaniciAdi = driver.findElement(By.xpath("//input[@class='r-30o5oe r-1niwhzg r-17gur6a r-1yadl64 r-deolkf r-homxoj r-poiln3 r-7cikom r-1ny4l3l r-t60dpp r-1dz5y72 r-fdjqy7 r-13qz1uu']"));
            kullaniciAdi.sendKeys(username, Keys.ENTER);

            //pasword bölümünü tıkla
            WebElement passwordArea = driver.findElement(By.cssSelector("div[class='css-901oao r-1awozwy r-18jsvk2 r-6koalj r-37j5jr r-1inkyih r-16dba41 r-135wba7 r-bcqeeo r-13qz1uu r-qvutc0'"));
            passwordArea.click();

            //password gir
            WebElement pswLogin = driver.findElement(By.cssSelector("input[class='r-30o5oe r-1niwhzg r-17gur6a r-1yadl64 r-deolkf r-homxoj r-poiln3 r-7cikom r-1ny4l3l r-t60dpp r-1dz5y72 r-fdjqy7 r-13qz1uu']"));
            pswLogin.sendKeys(password, Keys.ENTER);

            //tweet yazılacak yeri tıkla
            driver.findElement(By.cssSelector("div[class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")).click();

            //tweet'i yaz
            driver.findElement(By.cssSelector("div[style= 'outline: none; user-select: text; white-space: pre-wrap; overflow-wrap: break-word;']")).sendKeys(keys);

            //tweet'i gönder
            driver.findElement(By.xpath("//div[@data-testid='tweetButtonInline']")).click();

            Thread.sleep(5000);
            driver.close();

            count++;
        }while (count<list.size());
    }
}
