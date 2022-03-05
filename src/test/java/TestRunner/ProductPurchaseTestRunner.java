package TestRunner;

import Pages.ProductPurchase;
import Setup.Setup;
import org.testng.annotations.Test;

public class ProductPurchaseTestRunner extends Setup {
    @Test(priority = 0, groups = "purchase", description = "Select a product")
    public void selectMyProduct() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        ProductPurchase productPurchase = new ProductPurchase(driver);
        productPurchase.selectProduct();
    }

    @Test(priority = 1, groups = "purchase", description = "Add product in cart")
    public void addCart() throws InterruptedException {
        ProductPurchase productPurchase = new ProductPurchase(driver);
        productPurchase.addCart();
    }
}
