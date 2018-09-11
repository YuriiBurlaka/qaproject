package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class GoogleSearchPage extends BasePage{

    @FindBy(xpath = "//div[@class='rc']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private static WebElement secondPageLink;

    @FindBy(xpath = "//div[@id='resultStats']")
    private static WebElement searchCounter;

    public GoogleSearchPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public boolean isLoaded() {
        waitUntilElementIsVisible(searchCounter,5);
        return
                browser.getCurrentUrl().contains("google.com/search");
    }

    public List<String> getSearchResultsList() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchresult : searchResults){
            searchResultsList.add(searchresult.getText());
        }
        return searchResultsList;
    }

    public static GoogleSecondSearchPage navigateToNextPage(){
        secondPageLink.click();
        return new GoogleSecondSearchPage(browser);
    }
}

