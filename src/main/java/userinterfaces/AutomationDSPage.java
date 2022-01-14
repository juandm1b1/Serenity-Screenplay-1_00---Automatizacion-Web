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

    public static final Target GENDER_RADIOBUTTON = Target.the("Gender radiobutton")
            .locatedBy("//input[@type='radio' and @value='{0}']");
    public static final Target HOBBY_CHECKBOX = Target.the("Hobby checkbox")
            .locatedBy("//input[@type='checkbox' and @value='{0}']");

    public static final Target LANGUAGES_DIV = Target.the("Languages div")
            .located(By.id("msdd"));
    public static final Target LANGUAGE_OPTION = Target.the("Specific language option")
            .locatedBy("//li[@class='ng-scope']//a[text()='{0}']");

    public static final Target SKILL_OPTION = Target.the("Select the specified skill")
            .locatedBy("//select[@id='Skills']/option[@value='{0}']");

    public static final Target COUNTRIES_REQUIRED = Target.the("Select Countries with no options")
            .locatedBy("#countries");

    public static Target COUNTRIES_REQUIRED_OPTION = Target.the("Option Select Country")
            .locatedBy("//select[@id='countries']/option[contains(text(),'Select Country')]");

    public static final Target SELECT_COUNTRY_DIV = Target.the("Select country select")
            .located(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']"));
    public static final Target SELECT_COUNTRY_OPTION = Target.the("Select an specific country option")
            .locatedBy("//option[@value='{0}']");

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

    public static final Target ADD_INS = Target.the("Add intercepting click")
            .located(By.xpath("//ins[@class='ee']"));

    public static final Target IMG_UPLOAD = Target.the("For uploading a photo")
            .located(By.id("imagesrc"));

    public static final Target MESSAGE = Target.the("Welcome message")
            .located(By.xpath("//h4[contains(text(),' - Double Click on Edit Icon to ')]"));
}