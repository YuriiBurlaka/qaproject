package Tests;
import Pages.GoogleSearchPage;
import Pages.GoogleSecondSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class GoogleSearchTest extends BaseTest{
    String searchTerm = "selenium";


    @Test
    public void googleSearchTest() {
        Assert.assertTrue(googleMainPage.isLoaded(), "GoogleMainPage is not loaded");
        GoogleSearchPage googleSearchPage = googleMainPage.search(searchTerm);
        Assert.assertTrue(googleSearchPage.isLoaded(), "Search page is not loaded");

        List<String> searchResults = googleSearchPage.getSearchResultsList();
        for (String searchResult: searchResults){
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm), "searchterm " +searchTerm+" not found in \n" +searchResult);
        }

        GoogleSecondSearchPage googleSecondSearchPage = GoogleSearchPage.navigateToNextPage();
        Assert.assertTrue(googleSecondSearchPage.isLoaded(), "Second search page is not loaded");

        List<String> searchResults2ndPage = googleSearchPage.getSearchResultsList();
        for (String searchResult2ndPage: searchResults2ndPage){
            Assert.assertTrue(searchResult2ndPage.toLowerCase().contains(searchTerm), "searchterm " +searchTerm+" not found in \n" +searchResult2ndPage);
        }
    }
}
