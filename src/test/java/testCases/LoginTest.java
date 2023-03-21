package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.ReadConfig;

import java.time.Duration;
import java.util.Scanner;

public class LoginTest extends BaseClass{
    ReadConfig rc=new ReadConfig();
    @Test
    public void login() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Scanner sc = new Scanner(System.in);
        HomePage hp = new HomePage(driver);
        hp.setCellNumber(rc.getCellNumber());
        hp.clickRequestOtp();
        System.out.println("Please Enter the OTP you have received : ");
        String otpReceieved= sc.nextLine();
        hp.setOtp(otpReceieved);
        hp.verifyOtp();
    }
}
