package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Shop {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Shop')]")
    WebElement navShop;
    @FindBy(xpath = "//h1[contains(text(),'Shop')]")
    WebElement shopTitle;
    @FindBy(className = "header-search-input")
    WebElement searchBar;
    @FindBy(className = "header-search-button")
    WebElement searchSubmitBtn;
    @FindBy(xpath = "//h2[contains(text(),'Single Shirt')]")
    WebElement shirtName;
    @FindBy(className = "woocommerce-info")
    WebElement searchResultNotFound;
    @FindBy(className = "select2-search__field")
    WebElement colorFilter;
    @FindBy(xpath = "//li[contains(text(),'White')]")
    WebElement optionWhite;
    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    WebElement btnApply;
    @FindBy(className = "orderby")
    WebElement sortByOption;
    @FindBy(xpath = "//h2[contains(text(),'Polo T-shirt')]")
    WebElement lowPriceProduct;
    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    WebElement btnAddCart;

    public Shop(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doClickNavShop() {
        navShop.click();
        String title = shopTitle.getText();
        Assert.assertTrue(title.contains("Shop"));
    }

    public void searchValidProduct() {
        navShop.click();
        searchBar.click();
        searchBar.sendKeys("Shirt");
        searchSubmitBtn.click();
        String name = shirtName.getText();
        Assert.assertTrue(name.contains("Single Shirt"));
    }

    public void searchInvalidProduct() {
        navShop.click();
        searchBar.click();
        searchBar.sendKeys("Saree");
        searchSubmitBtn.click();
        String resultNotFound = searchResultNotFound.getText();
        Assert.assertTrue(resultNotFound.contains("No products were found matching your selection."));
    }

    public void filterByColor() {
        navShop.click();
        colorFilter.click();
        optionWhite.click();
        btnApply.click();
    }

    public void sortByCategory() {
        navShop.click();
        Select sort = new Select(sortByOption);
        sort.selectByValue("price");
        String lowCostProduct = lowPriceProduct.getText();
        Assert.assertTrue(lowCostProduct.contains("Polo T-shirt"));
    }

    public void addCartProduct() {
        navShop.click();
        searchBar.click();
        searchBar.sendKeys("Shirt");
        btnAddCart.click();
    }

}
