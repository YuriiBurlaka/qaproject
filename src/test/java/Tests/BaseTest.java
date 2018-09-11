package Tests;
import Pages.GoogleMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseTest {
    WebDriver browser;
    GoogleMainPage googleMainPage;

    @BeforeMethod
    public void beforeMethod (){
            browser = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\yurii.burlaka.ext\\IdeaProjects\\qaproject\\chromedriver.exe");
        browser.get("https://www.google.com/");
        browser.manage().window().maximize();

        googleMainPage = new GoogleMainPage(browser);
    }

    @AfterMethod
    public void afterMethod(){
       browser.close();
    }

    public WebElement waitUntilElementIsVisible(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(browser, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
}