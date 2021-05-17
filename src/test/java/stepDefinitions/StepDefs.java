package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pageObjects.*;
import java.util.List;
import static org.hamcrest.Matchers.*;

/**************************
 *  (C) L Somni            *
 ***************************/

public class StepDefs {
    TestContext testContext;
    CardsHomePage cardsHomePage;

    public StepDefs(TestContext context) {
        testContext = context;

        cardsHomePage = testContext.getPageObjectManager().getCardsHomePage();
    }

    @Given("^user is on the Home Page$")
    public void userIsOnHomePage() {
        cardsHomePage.navigateToHomePage();
    }


    @When("I enter user details as {string} {string} {string}")
    public void iEnterUserDetailsAs(final String name, final String address, final String email) {
        cardsHomePage.enterName(name);
        cardsHomePage.enterAddress(address);
        cardsHomePage.enterEmail(email);
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        cardsHomePage.submitForm();
    }

    @Then("Following message should be displayed to the user")
    public void followingMessageShouldBeDisplayed(final DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        String expected_msg = data.get(0).get(0);

        Assert.assertThat( cardsHomePage.getSubmissionMsg(), equalTo(expected_msg));
    }

    @And("{string} should be shown in the result")
    public void shouldBeShownInTheResult(final String eligibleCard) throws Exception {
        if(eligibleCard.equalsIgnoreCase("C1")){
            Assert.assertTrue("Error: Card1 suggestion not displayed", cardsHomePage.isCardSuggestionDisplayed(1));
        }else if(eligibleCard.equalsIgnoreCase("C2")){
            Assert.assertTrue("Error: Card2 suggestion not displayed", cardsHomePage.isCardSuggestionDisplayed(2));
        }else if(eligibleCard.equalsIgnoreCase("C1, C2")){
            Assert.assertTrue("Error: Card1 suggestion not displayed", cardsHomePage.isCardSuggestionDisplayed(1));
            Assert.assertTrue("Error: Card2 suggestion not displayed", cardsHomePage.isCardSuggestionDisplayed(2));
        }
    }

    @Then("{string} message should be displayed to the user")
    public void messageShouldBeDisplayedToTheUser(final String errorMsg) {
        Assert.assertThat( cardsHomePage.getErrorMsg(), equalToIgnoringWhiteSpace(errorMsg));
    }
}
