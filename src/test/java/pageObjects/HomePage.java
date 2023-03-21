package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[text()='✕']")
    WebElement cancelLogin;
    @FindBy(xpath="//a[text()='Login']")
    WebElement loginHeader;
    @FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
    WebElement email;

    @FindBy(xpath="//button[normalize-space()='Request OTP']")
    WebElement requestOtp;
    @FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
    WebElement otp;
    @FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
    WebElement searchProduct;

    @FindBy(xpath="//button[normalize-space()='Verify']")
    WebElement otpVerify;

    @FindBy(xpath="(//div[@class='_2kHMtA'])[1]")
    WebElement firstProduct;

    @FindBy(xpath="//button[normalize-space()='Add to cart']")
    WebElement addToCart;

    @FindBy(xpath="//button[@type='submit']//*[name()='svg']")
    WebElement searchProductButton;


    @FindBy(xpath="//span[normalize-space()='Cart']")
    WebElement cart;
    public void clickAccount()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginHeader));
        loginHeader.click();
    }

    public void setCellNumber(String cellNumber) throws InterruptedException
    {
        email.sendKeys(cellNumber);
    }

    public void searchProduct(String product) throws InterruptedException
    {
        searchProduct.sendKeys(product);
    }
    public void clickRequestOtp()
    {
        requestOtp.click();
    }
    public void cancelLogin()
    {
        cancelLogin.click();
    }
    public void clickSearchProductButton()
    {
        searchProductButton.click();
    }

    public void clickProduct1()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        firstProduct.click();
    }

    public void addToCart()
    {
        addToCart.click();
    }

    public void goToCart()
    {
        cart.click();
    }

    public void setOtp(String Otp)
    {
        otp.sendKeys(Otp);
    }

    public void verifyOtp()
    {
        otpVerify.click();
    }
}


