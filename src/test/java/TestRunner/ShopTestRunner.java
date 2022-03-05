package TestRunner;

import Pages.Shop;
import Setup.Setup;
import org.testng.annotations.Test;

public class ShopTestRunner extends Setup {

    @Test(priority = 0, groups = "search", description = "Visit shop page")
    public void shopTabVisit() {
        driver.get("https://envothemes.com/envo-ecommerce/");
        Shop shop = new Shop(driver);
        shop.doClickNavShop();
    }

    @Test(priority = 1, groups = "search", description = "Search valid product which is found")
    public void validProduct() {
        driver.get("https://envothemes.com/envo-ecommerce/");
        Shop shop = new Shop(driver);
        shop.searchValidProduct();
    }

    @Test(priority = 2, groups = "search", description = "Search invalid product which is not found")
    public void invalidProduct() {
        driver.get("https://envothemes.com/envo-ecommerce/");
        Shop shop = new Shop(driver);
        shop.searchInvalidProduct();
    }

    @Test(priority = 3, groups = "search", description = "Product filter by color")
    public void filterColor() {
        driver.get("https://envothemes.com/envo-ecommerce/");
        Shop shop = new Shop(driver);
        shop.filterByColor();
    }

    @Test(priority = 4, groups = "search", description = "Product sort by different category")
    public void sortProducts() {
        driver.get("https://envothemes.com/envo-ecommerce/");
        Shop shop = new Shop(driver);
        shop.sortByCategory();
    }

    @Test(priority = 5, groups = "search", description = "Product add to cart")
    public void cartProduct() {
        driver.get("https://envothemes.com/envo-ecommerce/");
        Shop shop = new Shop(driver);
        shop.addCartProduct();
    }

}
