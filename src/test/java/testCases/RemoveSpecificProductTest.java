package testCases;

import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.HomePage;
import utilities.ReadConfig;

public class RemoveSpecificProductTest extends BaseClass{
    @Test
    public void removeSpecificProduct() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        CartPage cp = new CartPage(driver);
        hp.cancelLogin();
        System.out.println("Adding first product (Mobile phone) to cart");
        hp.searchProduct(rc.getProduct1());
        hp.clickSearchProductButton();
        hp.clickProduct1();
        childWindow();
        hp.addToCart();
        System.out.println("Adding Second product (Laptop) to cart");
        hp.searchProduct(rc.getProduct2());
        hp.clickSearchProductButton();
        hp.clickProduct1();
        childWindow();
        hp.addToCart();
        System.out.println("Adding third product (TV) to cart");
        hp.searchProduct(rc.getProduct3());
        hp.clickSearchProductButton();
        hp.clickProduct1();
        childWindow();
        hp.addToCart();
        hp.goToCart();
        cp.removeProduct(rc.productToBeRemoved());

    }
}
