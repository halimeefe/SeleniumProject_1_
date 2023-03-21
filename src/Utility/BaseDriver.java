package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {


    public static WebDriver driver;

    static { // BU PARANTEZ ARASINA YAZDIĞIMIZ KOMUTLAR STATİC OLDUĞU İÇİN AYRICA ÇAĞIRMAYA GEREK KALMADAN EXTEND YAPINCA İLK ÇALIŞAN KISIM OLACAKTIR
        closeAll();
        Logger logger = Logger.getLogger("");                  //TERMİNALDEKİ FAZLA KODLARI KALDIRDIK
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");// CHROME UN SESSİZ ÇALIŞMA ÖZELLİĞİ TRUE OLSUN
        driver = new ChromeDriver();  //ÖNCE SESSİZ ÇALIŞMA AYARINI YAPIP SONRA CHROME U ÇALIŞTIRIRIZ
        driver.manage().window().maximize(); //EKRANI MAXİMİZE ETTİK
        driver.manage().deleteAllCookies();
        Duration dr = Duration.ofSeconds(30);   //DURATION SINIFINDAN SANİYE TANIMLADIK
        driver.manage().timeouts().pageLoadTimeout(dr);//EĞER HATALI BİR WEB SAYFASI YADA LİNKSE VERDİYSEK YÜKLENMESİ İÇİN 30 SN BEKLER YÜKLENMEZSE HATA VERİR ,YÜKLENİRSE 30 SN TAMAMLANMASINI BEKLEMEZ
        driver.manage().timeouts().implicitlyWait(dr);//ARADIĞIMIZ ELEMENTİN LOCATOR INI BULANA KADAR VERDİĞİMİZ SÜREDİR, BUNUN İÇİNDE BİZİM VERDİĞİMİZ MAKSİMUM SÜREYİ KULLANIR
    }

    public static void waitClose(int sn) {  //BEKLE KAPAT FONKSİYONUNUN EN SON ÇALIŞTIRILMASI GEREKİR VE BİZİM GEREKTİĞİNDE ÇAĞIRMAMIZ GEREKİR
        try {
            Thread.sleep(4000 * sn);
        } catch (InterruptedException e) {                 //INTERRUPTEDEXCEPTİON LAR CHECKED EXCEPTİON DIR
            throw new RuntimeException(e);                 //YANİ DERLEME ZAMANI KONTROL ALTINA ALINMALI,BU HATALAR
        }                                                 //ÖNCEDEN BİLİNİR ,JAVA KODU YAZARKEN HATAYI GÖSTERİR VE ÖNLEM ALINMASINI İSTER
        driver.quit();// İŞLEM BİTTİKTEN SONRA TÜM PENCERELERİ KAPATIP SÜRÜCÜDEN ÇIKAR
    }

    public static void closeAll() {   // BİLGİSAYARIN DAHA PERFORMANSLI ÇALIŞMASI İÇİN      //RUNTİME EXCEPTİON GEÇERSİZ YADA HATALI BİR İŞLEM YAPILDIĞINDA
        try {                             //VE HAFIZADA KULLANILMAYAN PROGRAMLARI KAPATIR     //OLUŞAN HATALARDIR ,ANCAK RUN YAPILINCA ORTAYA ÇIKAR,UNCHECKED EXCEPTİONDUR,KONTROLSÜZ
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");                  //DERLEME SIRASINDA YAKALAMA ŞANSIMIZ YOKTUR
        } catch (
                Exception ignored) {    //İGNORED : GÖRMEZDEN GELİNDİ                         //DERLEME SIRASINDA OLUŞAN HATALAR COMPİLE ERROR HATALARIDIR
            //
        }
    }

    public static void wait(int sn) {
        try {
            Thread.sleep(1000 * sn);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
