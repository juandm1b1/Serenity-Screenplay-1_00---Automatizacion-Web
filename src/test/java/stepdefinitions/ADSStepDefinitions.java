package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.AutomationDemoSiteRegData;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.Answer;
import tasks.OpenUp;
import tasks.Registration;

import java.util.List;


public class ADSStepDefinitions {

    @Before
    public void setStage(){ OnStage.setTheStage(new OnlineCast());}

    @Given("^that Carlos wants to register on the Web Automation Demo Site$")
    public void thatCarlosWantsToRegisterOnTheWebAutomationDemoSite() {
        OnStage.theActorCalled("Carlos").wasAbleTo(OpenUp.thePage());
    }

    @When("^he makes the registration$")
    public void heMakesTheRegistration(List<AutomationDemoSiteRegData> automationDemoSiteRegData) {
        OnStage.theActorInTheSpotlight().attemptsTo(Registration.signUp(automationDemoSiteRegData));
    }

    @Then("^he verifies the message (.*)$")
    public void heVerifiesTheMessage(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(message)));
    }
}
