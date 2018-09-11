package Pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleMainPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchField;

    public GoogleMainPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public boolean isLoaded() {
        waitUntilElementIsVisible(searchField, 4);
        return
                browser.getCurrentUrl().contains("google.com");
    }

    public GoogleSearchPage search (String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new GoogleSearchPage(browser);
    }

}