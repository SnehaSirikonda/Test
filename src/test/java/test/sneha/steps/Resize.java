package test.sneha.steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import test.sneha.page_objects.TraveleX_Homepage;

/**
 * Created by ${Sneha} on 05/07/2016.
 */
public class Resize {
    TraveleX_Homepage traveleX_homepage;

    public Resize(TraveleX_Homepage diTraveleX_Homepage ){
        this.traveleX_homepage=diTraveleX_Homepage;
    }

    @Given("^I am on travelX site$")
    public void I_am_on_travelX_site(){
        traveleX_homepage.TravelX();
        Assert.assertTrue(traveleX_homepage.isOnHomePage());

    }

    @When("^I resize the window$")
    public void I_resize_the_window() {
        traveleX_homepage.windowResize();
    }

    @And("^I swipe the slider to left again left$")
    public void I_swipe_the_slider_to_left_again_left(){
        traveleX_homepage.swipeSlider();

    }

    @Then("^I see the third item is displayed$")
    public void I_see_the_third_item_is_displayed() {
        Assert.assertEquals(traveleX_homepage.thirdItemIsDisplayed(),"Buy currency");
    }
}
