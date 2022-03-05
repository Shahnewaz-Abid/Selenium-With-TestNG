package TestRunner;

import Pages.Sale;
import Setup.Setup;
import org.testng.annotations.Test;

public class SaleTestRunner extends Setup {

    @Test(priority = 0, groups = "cart", description = "Visit sale page")
    public void saleTabVisit() {
        driver.get("https://envothemes.com/envo-ecommerce/");
        Sale sale = new Sale(driver);
        sale.doClickSaleNav();
    }

    @Test(priority = 1, groups = "cart", description = "Verification sale tag")
    public void saleVerification() {
        driver.get("https://envothemes.com/envo-ecommerce/");
        Sale sale = new Sale(driver);
        sale.verifySaleTag();
    }

    @Test(priority = 2, groups = "cart", description = "Discount product add to cart")
    public void productAddCart() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/");
        Sale sale = new Sale(driver);
        sale.addToCard();
    }

    @Test(priority = 3, groups = "cart", description = "View the cart")
    public void viewCartDetails() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/");
        Sale sale = new Sale(driver);
        sale.viewCart();
    }

    @Test(priority = 4, groups = "cart", description = "Checkout product from cart")
    public void orderConfirm() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/");
        Sale sale = new Sale(driver);
        sale.addToCard();
        sale.viewCart();
        sale.proceedToCheckout();
    }

}
