package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://demo.automationtesting.in/Register.html")
public class AutomationDSPage extends PageObject {

    public static final Target FIRSTNAME_INPUT = Target.the("Firstname input")
            .located(By.xpath("//input[@placeholder='First Name']"));
    public static final Target LASTNAME_INPUT = Target.the("Lastname input")
            .located(By.xpath("//input[@placeholder='Last Name']"));
    public static final Target ADDRESS_INPUT = Target.the("Address input")
            .located(By.xpath("//textarea"));
    public static final Target EMAIL_INPUT = Target.the("Email input")
            .located(By.xpath("//input[@type='email']"));
    public static final Target PHONE_INPUT = Target.the("Phone input")
            .located(By.xpath("//input[@type='tel']"));

    public static Target genderRadiobutton(String gender){
        return Target.the("Gender radiobutton").located(By.xpath("//input[@type='radio' and @value='"+ gender +"']"));
    }
    //°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°|
    public static Target hobbyCheckbox(String strHobby) {
        return Target.the("Hobby checkbox").located(By.xpath("//input[@type='checkbox' and @value='"+ strHobby +"']"));
    }
//              ----------------------------------------------------------
    public static final Target LANGUAGES_DIV = Target.the("Lenguages div")
            .located(By.id("msdd"));
    public static Target languageOption(String language){
        return Target.the("Especific lenguage option").locatedBy("//li[@class='ng-scope']//a[text()='"+ language +"']");
    }
//              ----------------------------------------------------------
    public static Target skillOption(String strSkills) {
        return Target.the("Select the specified skill").locatedBy("//select[@id='Skills']/option[@value='"+ strSkills +"']");
    }
    public static final Target SELECT_COUNTRY_DIV = Target.the("Select country select")
            .located(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']"));
    public static Target selectCountryOption(String country){
        return Target.the("Select Denmark country option").located(By.xpath("//option[@value='"+ country +"']"));
    }
//              ----------------------------------------------------------
    public static final Target SELECT_YEAR = Target.the("Select year")
            .located(By.id("yearbox"));
    public static final Target SELECT_MONTH = Target.the("Select month")
            .located(By.xpath("//select[@placeholder='Month']"));
    public static final Target SELECT_DAY = Target.the("Select day")
            .located(By.id("daybox"));
    public static final Target PASSWORD_INPUT = Target.the("Password input")
            .located(By.id("firstpassword"));
    public static final Target CONFIRM_PASSWORD_INPUT = Target.the("Confirm Password input")
            .located(By.id("secondpassword"));
    public static final Target SUBMIT_BUTTON = Target.the("Submit button")
            .located(By.id("submitbtn"));
//              ----------------------------------------------------------
    public static final Target ADD_INS = Target.the("Add intercepting click")
            .located(By.xpath("//ins[@class='ee']"));
//              ----------------------------------------------------------
    public static final Target MESSAGE = Target.the("Welcome message")
            .located(By.xpath("h3"));
}