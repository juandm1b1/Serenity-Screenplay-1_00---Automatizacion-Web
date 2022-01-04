package tasks;

import model.AutomationDemoSiteRegData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import userinterfaces.AutomationDSPage;

import java.util.List;

public class Registration implements Task {

    private final List<AutomationDemoSiteRegData> automationDemoSiteRegData;
    private String[] hobbies;
    private String[] languages;

    public Registration(List<AutomationDemoSiteRegData> automationDemoSiteRegData) {
        this.automationDemoSiteRegData = automationDemoSiteRegData;
        this.hobbies = automationDemoSiteRegData.get(0).getStrHobbies().split(",");
        this.languages = automationDemoSiteRegData.get(0).getStrLanguages().split(",");
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
//              ----------------------------------------------------------
                Enter.theValue(automationDemoSiteRegData.get(0).getStrFirstName()).into(AutomationDSPage.FIRSTNAME_INPUT),
                Enter.theValue(automationDemoSiteRegData.get(0).getStrLastName()).into(AutomationDSPage.LASTNAME_INPUT),
                Enter.theValue(automationDemoSiteRegData.get(0).getStrAddress()).into(AutomationDSPage.ADDRESS_INPUT),
                Enter.theValue(automationDemoSiteRegData.get(0).getStrEmail()).into(AutomationDSPage.EMAIL_INPUT),
                Enter.theValue(automationDemoSiteRegData.get(0).getStrPhone()).into(AutomationDSPage.PHONE_INPUT),

                Click.on(AutomationDSPage.genderRadiobutton(automationDemoSiteRegData.get(0).getStrGender()))
        );

        for(String hobby : hobbies){
            actor.attemptsTo(Click.on(AutomationDSPage.hobbyCheckbox(hobby.trim())));
        }

        for(String language : languages){
            actor.attemptsTo(Click.on(AutomationDSPage.LANGUAGES_DIV),
                    Click.on(AutomationDSPage.languageOption(language.trim())));
        }

        actor.attemptsTo(
                Click.on(AutomationDSPage.skillOption(automationDemoSiteRegData.get(0).getStrSkills())),
                Click.on(AutomationDSPage.SELECT_COUNTRY_DIV),
                Click.on(AutomationDSPage.selectCountryOption(automationDemoSiteRegData.get(0).getStrCountry())),
//              ----------------------------------------------------------
                Enter.keyValues(automationDemoSiteRegData.get(0).getStrYearOfBirth()).into(AutomationDSPage.SELECT_YEAR),
                Enter.keyValues(automationDemoSiteRegData.get(0).getStrMonthOfBirth()).into(AutomationDSPage.SELECT_MONTH),
                Enter.keyValues(automationDemoSiteRegData.get(0).getStrDayOfBirth()).into(AutomationDSPage.SELECT_DAY),
//              ----------------------------------------------------------
                Enter.theValue(automationDemoSiteRegData.get(0).getStrPassword()).into(AutomationDSPage.PASSWORD_INPUT),
                Enter.theValue(automationDemoSiteRegData.get(0).getStrConfirmPassword()).into(AutomationDSPage.CONFIRM_PASSWORD_INPUT),
//              ----------------------------------------------------------
                Click.on(AutomationDSPage.SUBMIT_BUTTON)
        );
    }
}


//actor.attemptsTo(
//        Wait.until(WebElementQuestion.the(AutomationDemoSitePage.ADD_INS),WebElementStateMatchers.isEnabled())
//        .forNoLongerThan(30).seconds(),
//        Click.on(AutomationDemoSitePage.ADD_INS),
////              ----------------------------------------------------------
//        Enter.theValue(automationDemoSiteRegistrationData.get(0).getStrFirstName()).into(AutomationDemoSitePage.FIRSTNAME_INPUT),
//        Enter.theValue(automationDemoSiteRegistrationData.get(0).getStrLastName()).into(AutomationDemoSitePage.LASTNAME_INPUT),
//        Enter.theValue(automationDemoSiteRegistrationData.get(0).getStrAddress()).into(AutomationDemoSitePage.ADDRESS_INPUT),
//        Enter.theValue(automationDemoSiteRegistrationData.get(0).getStrEmail()).into(AutomationDemoSitePage.EMAIL_INPUT),
//        Enter.theValue(automationDemoSiteRegistrationData.get(0).getStrPhone()).into(AutomationDemoSitePage.PHONE_INPUT),
//
//        Click.on(AutomationDemoSitePage.genderRadiobutton(automationDemoSiteRegistrationData.get(0).getStrGender())),
//
////              NECESITO PASAR ESTO A UN BUCLE:
//        Click.on(AutomationDemoSitePage.hobbieCheckbox(hobbies[0])),
//        Click.on(AutomationDemoSitePage.hobbieCheckbox(hobbies[1])),
////              ----------------------------------------------------------
//        Click.on(AutomationDemoSitePage.LENGUAGES_DIV),
//        Click.on(AutomationDemoSitePage.languageOption(automationDemoSiteRegistrationData.get(0).getStrLenguages())),
////              ----------------------------------------------------------
//        Click.on(AutomationDemoSitePage.skillOption(automationDemoSiteRegistrationData.get(0).getStrSkills())),
//        Click.on(AutomationDemoSitePage.SELECT_COUNTRY_DIV),
//        Click.on(AutomationDemoSitePage.selectCountryOption(automationDemoSiteRegistrationData.get(0).getStrCountry())),
////              ----------------------------------------------------------
//        Enter.keyValues(automationDemoSiteRegistrationData.get(0).getStrYearOfBirth()).into(AutomationDemoSitePage.SELECT_YEAR),
//        Enter.keyValues(automationDemoSiteRegistrationData.get(0).getStrMonthOfBirth()).into(AutomationDemoSitePage.SELECT_MONTH),
//        Enter.keyValues(automationDemoSiteRegistrationData.get(0).getStrDayOfBirth()).into(AutomationDemoSitePage.SELECT_DAY),
////              ----------------------------------------------------------
//        Enter.theValue(automationDemoSiteRegistrationData.get(0).getStrPassword()).into(AutomationDemoSitePage.PASSWORD_INPUT),
//        Enter.theValue(automationDemoSiteRegistrationData.get(0).getStrConfirmPassword()).into(AutomationDemoSitePage.CONFIRM_PASSWORD_INPUT),
////              ----------------------------------------------------------
//        Click.on(AutomationDemoSitePage.SUBMIT_BUTTON)
//        );