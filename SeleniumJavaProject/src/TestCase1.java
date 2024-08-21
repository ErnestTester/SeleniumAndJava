import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/olaez/IdeProject/SeleniumAndJava/SeleniumJavaProject/driver/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        String appUrl = "https://www.cologuardhcp.com/";
        driver.get(appUrl);
        driver.manage().window().maximize();

    }
}
