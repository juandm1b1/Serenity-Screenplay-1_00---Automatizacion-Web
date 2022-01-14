package actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class JSDisabled implements Interaction {

    private final Target target;

    public JSDisabled(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T theActor) {
        WebElement targetElement = target.resolveFor(theActor);
        BrowseTheWeb.as(theActor).evaluateJavascript("document.getElementById('countries').required = false", targetElement);
        BrowseTheWeb.as(theActor).evaluateJavascript("document.getElementById('countries').disabled = true", targetElement);
    }

    public static Interaction on(Target target) {
        return instrumented(JSDisabled.class, target);
    }

}