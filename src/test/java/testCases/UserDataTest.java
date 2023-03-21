package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.HomePage;
import utilities.ReadConfig;

import java.io.IOException;
import java.util.Scanner;

public class UserDataTest extends BaseClass{
    static String firstProduct;
    static String secondProduct;
    static String thirdProduct;

    static String tobeRemoved;

    @Test
    public static void main(String [] args) throws InterruptedException, IOException {
        BaseClass.setup();
        Scanner sc = new Scanner(System.in);
        System.out.println(" please enter the First product to buy : ");
        firstProduct = sc.nextLine();
        System.out.println(" please enter the Second product to buy : ");
        secondProduct = sc.nextLine();
        System.out.println(" please enter the Third product to buy : ");
        thirdProduct = sc.nextLine();
        System.out.println(" please enter the product to be removed : ");
        tobeRemoved = sc.nextLine();
        HomePage hp = new HomePage(driver);
        CartPage cp = new CartPage(driver);
        hp.cancelLogin();
        System.out.println("Adding first product (Mobile phone) to cart");
        hp.searchProduct(firstProduct);
        hp.clickSearchProductButton();
        hp.clickProduct1();
        childWindow();
        hp.addToCart();
        System.out.println("Adding Second product (Laptop) to cart");
        hp.searchProduct(secondProduct);
        hp.clickSearchProductButton();
        hp.clickProduct1();
        childWindow();
        hp.addToCart();
        System.out.println("Adding third product (TV) to cart");
        hp.searchProduct(thirdProduct);
        hp.clickSearchProductButton();
        hp.clickProduct1();
        childWindow();
        hp.addToCart();
        hp.goToCart();
        cp.removeProduct(tobeRemoved);
        driver.quit();
    }
}
