package tasks;

import actions.JSDisabled;
import model.AutomationDemoSiteRegData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import userinterfaces.AutomationDSPage;

import java.nio.file.Paths;
import java.util.List;

public class Registration implements Task {

    private final List<AutomationDemoSiteRegData> automationDemoSiteRegData;
    private String[] hobbies;
    private String[] languages;
    private String photo;

    public Registration(List<AutomationDemoSiteRegData> automationDemoSiteRegData) {
        this.automationDemoSiteRegData = automationDemoSiteRegData;
        this.hobbies = automationDemoSiteRegData.get(0).getStrHobbies().split(",");
        this.languages = automationDemoSiteRegData.get(0).getStrLanguages().split(",");
        this.photo = "src/main/resources/images/" + automationDemoSiteRegData.get(0).getStrImgName();
    }

    public static Registration signUp(List<AutomationDemoSiteRegData> automationDemoSiteRegData) {
        return Tasks.instrumented(Registration.class, automationDemoSiteRegData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.until(WebElementQuestion.the(AutomationDSPage.ADD_INS),WebElementStateMatchers.isEnabled())
                        .forNoLongerThan(30).seconds(),
                Click.on(AutomationDSPage.ADD_INS),

                Enter.theValue(automationDemoSiteRegData.get(0).getStrFirstName()).into(AutomationDSPage.FIRSTNAME_INPUT),
                Enter.theValue(automationDemoSiteRegData.get(0).getStrLastName()).into(AutomationDSPage.LASTNAME_INPUT),
                Enter.theValue(automationDemoSiteRegData.get(0).getStrAddress()).into(AutomationDSPage.ADDRESS_INPUT),
                Enter.theValue(automationDemoSiteRegData.get(0).getStrEmail()).into(AutomationDSPage.EMAIL_INPUT),
                Enter.theValue(automationDemoSiteRegData.get(0).getStrPhone()).into(AutomationDSPage.PHONE_INPUT),
                Upload.theFile(Paths.get(photo)).to(AutomationDSPage.IMG_UPLOAD),
                Click.on(AutomationDSPage.GENDER_RADIOBUTTON.of(automationDemoSiteRegData.get(0).getStrGender()))
        );

        for(String hobby : hobbies){
            actor.attemptsTo(Click.on(AutomationDSPage.HOBBY_CHECKBOX.of(hobby.trim())));
        }

        for(String language : languages){
            actor.attemptsTo(Click.on(AutomationDSPage.LANGUAGES_DIV),
                    Click.on(AutomationDSPage.LANGUAGE_OPTION.of(language.trim())));
        }

        actor.attemptsTo(Click.on(AutomationDSPage.SKILL_OPTION.of(automationDemoSiteRegData.get(0).getStrSkills())),
                Click.on(AutomationDSPage.COUNTRIES_REQUIRED),
                JSDisabled.on(AutomationDSPage.COUNTRIES_REQUIRED),

                Click.on(AutomationDSPage.SELECT_COUNTRY_DIV),
                Click.on(AutomationDSPage.SELECT_COUNTRY_OPTION.of(automationDemoSiteRegData.get(0).getStrCountry())),

                Enter.keyValues(automationDemoSiteRegData.get(0).getStrYearOfBirth()).into(AutomationDSPage.SELECT_YEAR),
                Enter.keyValues(automationDemoSiteRegData.get(0).getStrMonthOfBirth()).into(AutomationDSPage.SELECT_MONTH),
                Enter.keyValues(automationDemoSiteRegData.get(0).getStrDayOfBirth()).into(AutomationDSPage.SELECT_DAY),

                Enter.theValue(automationDemoSiteRegData.get(0).getStrPassword()).into(AutomationDSPage.PASSWORD_INPUT),
                Enter.theValue(automationDemoSiteRegData.get(0).getStrConfirmPassword()).into(AutomationDSPage.CONFIRM_PASSWORD_INPUT),

                Click.on(AutomationDSPage.SUBMIT_BUTTON)
        );
    }
}