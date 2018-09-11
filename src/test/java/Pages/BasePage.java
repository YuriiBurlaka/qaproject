package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

        protected static WebDriver browser;

        public WebElement waitUntilElementIsVisible(WebElement webElement, int timeOutInSeconds) {
            WebDriverWait wait = new WebDriverWait(browser, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return webElement;
        }
    }



