package test.sneha.page_objects;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import test.sneha.DriverManager;

public class ResultsPage extends DriverManager {

	@FindBy(className = "searchdidyoumean")
	private WebElement _didUmeanlbl;
	
	@FindBy(css = "#mw-search-DYM-suggestion>em")
	private WebElement _suggestionLink;
	
	
	@FindAll(@FindBy(css = ".mw-search-result-heading>a"))
	private List<WebElement> _allLinks;

	@FindBy(css = "#toctitle>h2")
	private WebElement _contentLbl;

	@FindBy(className = "mbox-image")
	private WebElement _articleLbl;

	public String getDidYouMeanText() {
		return StringUtils.substringBefore(_didUmeanlbl.getText(), ":");
	}

	
	public void clickOnSuggestion() {
		_suggestionLink.click();
	}
	
	public void clickOnLink(){
		_allLinks.get(0).click();
	}

	public int getCountOfLinks() {
		return _allLinks.size();
	}

	public boolean isContentIsDisplayed() {
		return _contentLbl.getText().matches("Contents");
	}

	public boolean isArticleDisplayed() {
		return _articleLbl.isDisplayed();
	}

}
