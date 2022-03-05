package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Sale {
    WebDriver driver;

    @FindBy(className = "nav-link")
    List<WebElement> saleTab;
    @FindBy(xpath = "//h1[contains(text(),'Sale')]")
    WebElement saleTitle;
    @FindBy(className = "onsale")
    List<WebElement> saleTag;
    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    List<WebElement> btnCart;
    @FindBy(className = "cart-contents")
    List<WebElement> viewCartContents;
    @FindBy(xpath = "//a[contains(text(), 'Checkout')]")
    List<WebElement> btnCheckout;

    public Sale(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doClickSaleNav() {
        saleTab.get(2).click();
        String title = saleTitle.getText();
        Assert.assertTrue(title.contains("SALE"));
    }

    public void verifySaleTag() {
        saleTab.get(2).click();
        String title = saleTag.get(1).getText();
        Assert.assertTrue(title.contains("Sale!"));
    }

    public void addToCard() throws InterruptedException {
        saleTab.get(2).click();
        btnCart.get(2).click();
        Thread.sleep(5000);
    }

    public void viewCart() throws InterruptedException {
        saleTab.get(2).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(viewCartContents.get(0)).perform();
        Thread.sleep(5000);
    }

    public void proceedToCheckout() {
        btnCheckout.get(0).click();
    }

}
