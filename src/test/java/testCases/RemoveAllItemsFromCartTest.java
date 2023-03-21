package testCases;

import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.HomePage;

public class RemoveAllItemsFromCartTest extends BaseClass{
    @Test
    public void removeAllItems() throws InterruptedException {
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
        hp.goToCart();
        System.out.println("Removing all products from cart");
        cp.removeCartItem();
}
}
