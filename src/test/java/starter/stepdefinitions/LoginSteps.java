package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.login.Login;
import starter.login.LoginResult;
import starter.navigation.NavigateTo;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class LoginSteps {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) am on Login Page")
    public void iAmOnLoginPage(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.theLoginPage());
    }

    @When("^(.*) login with Info")
    public void iLoginWithInfo(String actor, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String username = data.get(0).get("username");
        String password = data.get(0).get("password");
        theActorCalled(actor).attemptsTo(Login.withInfo(username, password));
    }

    @Then("Redirect to Order List Page")
    public void redirectToOrderListPage() throws InterruptedException {
        Thread.sleep(30000);
        theActorInTheSpotlight().should(
                seeThat("User info",LoginResult.userInfo(),equalToIgnoringCase("Gobiz test")));
    }
}
