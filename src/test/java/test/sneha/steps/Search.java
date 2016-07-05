package test.sneha.steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.sneha.page_objects.HomePage;
import test.sneha.page_objects.ResultsPage;

/**
 * Created by ${Sneha} on 05/07/2016.
 */
public class Search {
	HomePage homePage;
	ResultsPage resultsPage;

	public Search(HomePage diHomePage, ResultsPage diResultsPage) {
		homePage = diHomePage;
		resultsPage = diResultsPage;
	}

	@Given("^I am on wikipedia home page$")
	public void i_am_on_wikipedia_home_page() {
		Assert.assertTrue(homePage.isOnHomePage());
	}

	@Given("^I see title of page is \"([^\"]*)\"$")
	public void i_see_title_of_page_is(String title) {
		Assert.assertEquals(title, homePage.getTitle());
	}

	@When("^I search for a \"([^\"]*)\"$")
	public void i_search_for_a(String searchTerm) {
		homePage.search(searchTerm).clickSubmitBtn();
	}

	@When("^I see suggestion as \"([^\"]*)\"$")
	public void i_see_suggestion_as(String expected) {
		Assert.assertEquals(expected, resultsPage.getDidYouMeanText());
	}

	@When("^I click on suggestion$")
	public void i_click_on_suggestion() {
		resultsPage.clickOnSuggestion();
	}

	@Then("^I see first search result displayed (\\d+) results$")
	public void i_see_first_search_result_displayed_results(int expected) {
		Assert.assertEquals(expected, resultsPage.getCountOfLinks());
	}

	@Then("^I see article has a title$")
	public void i_see_article_has_a_title() {
		Assert.assertTrue(resultsPage.isArticleDisplayed());
	}

	@Then("^I see tables of contents$")
	public void i_see_tables_of_contents() {
		Assert.assertTrue(resultsPage.isContentIsDisplayed());
	}

	@When("^I click on any link$")
	public void i_click_on_any_link() {
		resultsPage.clickOnLink();
	}
}
