import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ReportUtil;
import base.BaseCase;
import base.BaseDriver;


public class TestCase1
{

    //ReportUtil reporter=new ReportUtil("TestCase1", "C:\\Users\\olaez\\IdeProject\\SeleniumAndJava\\SeleniumJavaProject\\report");
    protected BaseDriver bd;
    public static void main(String[] args)
    {

        BaseCase bc=new BaseCase();

        ReportUtil reporter=new ReportUtil("TestCase1", "C:\\Users\\olaez\\IdeProject\\SeleniumAndJava\\SeleniumJavaProject\\report");



        System.setProperty("webdriver.chrome.driver", "C:/Users/olaez/IdeProject/SeleniumAndJava/SeleniumJavaProject/driver/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        BaseDriver bd2=new BaseDriver(driver);
        String appUrl = "https://www.cologuardhcp.com/";
        driver.get(appUrl);
        driver.manage().window().maximize();

       bc.setReporter(reporter);
        reporter.printExpectResult("Should be displayed the URL");
        reporter.printStep("User access to the Website", 1);
       WebElement frmPolicy= bd2.findElement(By.xpath("/html/body/div[3]/div[2]/div/div"));
        bd2.elementHighlightBorderRed(frmPolicy);
        reporter.printActualResult("User is able to access to the Cologuard site");
        reporter.printImageIntoReport(bd2.getCaptureScreenshotFile());
       bc.afterClass();
        System.out.println("End");
    }
}
