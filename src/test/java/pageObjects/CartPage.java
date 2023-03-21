package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;


    public CartPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="(//div[@class='z4Ha90']//span)[2]")
    WebElement totalCartValue;

    @FindBy(xpath="//div[normalize-space()='Remove']")
    List<WebElement> removeFromCartlist;

    @FindBy(xpath="(//div[@class='_3dsJAO'][normalize-space()='Remove'])[1]")
    WebElement removeFromCart;


    @FindBy(xpath="//div[@class='_3dsJAO _24d-qY FhkMJZ']")
    WebElement removeConfirmation;

    @FindBy(xpath="(//a[contains(@href,'pid=COM')]//parent::div//parent::div//parent::div)[14]")
    WebElement removeLaptop;

    @FindBy(xpath="(//a[contains(@href,'pid=MOB')]//parent::div//parent::div//parent::div)[14]")
    WebElement removeMobile;

    @FindBy(xpath="(//a[contains(@href,'pid=TV')]//parent::div//parent::div//parent::div)[14]")
    WebElement removeTV;
    public void getTotalCartValue(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(totalCartValue));
        String totalCart = totalCartValue.getText();
        System.out.println("Customer has to pay "+totalCart);
    }

    public void removeCartItem() throws InterruptedException {
        int numberOfProducts = removeFromCartlist.size();
        for (int i = 0; i < numberOfProducts; i++) {
            if (removeFromCart.isDisplayed()) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(removeFromCart));
                removeFromCart.click();
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait1.until(ExpectedConditions.elementToBeClickable(removeConfirmation));
                removeConfirmation.click();
                Thread.sleep(2000);
            }
        }
        System.out.println("Number of Products available in the cart is : " + numberOfProducts);
    }
    public void removeProduct(String s){
        switch(s){
            case "Laptop" -> {
                System.out.println("Removing Laptop from Cart");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(removeLaptop));
                removeLaptop.click();
                removeConfirmation.click();
            }
            case "Mobile" -> {
                System.out.println("Removing Mobile from Cart");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(removeMobile));
                removeMobile.click();
                removeConfirmation.click();
            }
            case "TV" -> {
                System.out.println("Removing TV from Cart");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(removeTV));
                removeTV.click();
                removeConfirmation.click();
            }
        }
    }
}
