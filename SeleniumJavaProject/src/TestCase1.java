import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ReportUtil;
import base.BaseCase;
import base.BaseDriver;
import pageObjects.Main_Page;

public class TestCase1
{

    //ReportUtil reporter=new ReportUtil("TestCase1", "C:\\Users\\olaez\\IdeProject\\SeleniumAndJava\\SeleniumJavaProject\\report");
    //protected BaseDriver bd;
    public static void main(String[] args)
    {

        BaseCase bc=new BaseCase();


        ReportUtil reporter=new ReportUtil("TestCase1", "C:\\Users\\olaez\\IdeProject\\SeleniumAndJava\\SeleniumJavaProject\\report");



        System.setProperty("webdriver.chrome.driver", "C:/Users/olaez/IdeProject/SeleniumAndJava/SeleniumJavaProject/driver/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        BaseDriver bd2=new BaseDriver(driver);
        Main_Page mp=new Main_Page(bd2);
        String appUrl = "https://www.cologuardhcp.com/";
        driver.get(appUrl);
        driver.manage().window().maximize();

        bc.setReporter(reporter);
        reporter.printExpectResult("Should be displayed the URL");
        reporter.printStep("User access to the Website", 1);

        //Identify the Element
        WebElement frmPolicy= bd2.findElement(By.xpath("/html/body/div[3]/div[2]/div/div"));
        bd2.elementHighlightBorderRed(frmPolicy);

        WebElement btnPolicy=mp.getBtnPolicy();
        btnPolicy.click();

        reporter.printActualResult("User is able to access to the Cologuard site");
        reporter.printImageIntoReport(bd2.getCaptureScreenshotFile());

        //Identify a WebElement
        WebElement EnvolveCRC=mp.getMenuEnvolveCRC();
        bd2.elementHighlightBorderBlue(EnvolveCRC);
        EnvolveCRC.click();

        //Identify a Submenu from the Main Page
        WebElement MnuCRCRise=mp.getMenuCRCRise();
        bd2.elementHighlightBorderBlue(MnuCRCRise);
        reporter.printStep("User Clicks on CRC Rise Menu", 2);
        reporter.printImageIntoReport(bd2.getCaptureScreenshotFile());
        reporter.printActualResult("User is able to Perform Click on the Menu");


        MnuCRCRise.click();
        driver.navigate().back();


       bc.afterClass();
        System.out.println("End");
    }
}
