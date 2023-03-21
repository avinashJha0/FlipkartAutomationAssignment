package testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.ReadConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BaseClass {
    static ReadConfig rc = new ReadConfig();

    public static String baseURL = rc.getApplicationURL();
    public static WebDriver driver;
    @BeforeClass
    public static void setup() throws IOException
    {

        System.setProperty("webdriver.chrome.driver",rc.getChromepath());
        driver = new ChromeDriver();
        System.out.println("Chrome Browser opened");
        driver.get(baseURL);
        System.out.println("Flipkart website");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void teardown()
    {
        driver.quit();
        System.out.println("Browser closed");
    }

    public static void childWindow(){

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        int size = tabs.size();
        driver.switchTo().window(tabs.get(size-1));
    }

}
