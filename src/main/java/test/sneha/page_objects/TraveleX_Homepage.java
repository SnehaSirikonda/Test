package test.sneha.page_objects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test.sneha.DriverManager;


public class TraveleX_Homepage extends DriverManager {

	@FindBy(xpath = "html/body/div[1]/div[3]/div/section[2]/article/div[1]/ul/li[2]/button")
	private WebElement slider;

	@FindBy(xpath = "html/body/div[1]/div[3]/div/section[2]/article/div[1]/ul/li[3]/button")
	private WebElement _sliderAgain;

	@FindBy(xpath = "html/body/div[1]/div[3]/div/section[2]/article/div[1]/div/div/div[3]/div/h4/span/a")
	private WebElement thirdItem;

	public void TravelX() {
		driver.navigate().to("https://www.travelex.co.uk/");
	}

	public boolean isOnHomePage() {
		return driver.getCurrentUrl().endsWith("www.travelex.co.uk/");
	}

	public void windowResize() {
		Dimension d = new Dimension(550, 650);
		driver.manage().window().setSize(d);
	}

	public void swipeSlider() {
		slider.click();
		_sliderAgain.click();
	}

	public String thirdItemIsDisplayed() {
		return thirdItem.getText();
	}
}