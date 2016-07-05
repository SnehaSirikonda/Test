package test.sneha.page_objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import test.sneha.DriverManager;

public class HomePage extends DriverManager {

	@FindBy(id="searchInput")
	private WebElement _searchBoxTxt;
	
	@FindAll(@FindBy(id="searchInput"))
	private List<WebElement> _searchBoxTxtList;
	
	@FindBy(css=".pure-button.pure-button-primary-progressive")
	private WebElement _submitBtn;

	public HomePage search(String searchTerm){
		_searchBoxTxt.sendKeys(searchTerm);
		return this;
	}
	
	public ResultsPage clickSubmitBtn(){
		_submitBtn.click();
		return new ResultsPage();
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public boolean isOnHomePage(){
		return driver.getCurrentUrl().endsWith("www.wikipedia.org/");
	}
}
