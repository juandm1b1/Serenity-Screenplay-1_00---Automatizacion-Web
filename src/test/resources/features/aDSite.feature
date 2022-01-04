@stories
Feature: Automation Demo Site Registration
  A user want to Sign up to Automation Demo Site

  @Scenario1:
    Scenario Outline: Sign up to Automation Demo Site
      Given that Carlos wants to register on the Web Automation Demo Site
      When he makes the registration
        | strFirstName  | strLastName    | strAddress | strEmail   | strPhone   | strGender | strHobbies | strLanguages | strSkills | strCountry | strYearOfBirth | strMonthOfBirth  | strDayOfBirth   | strPassword   | strConfirmPassword   |
        | <strFirstName>| <strLastName>  |<strAddress>|<strEmail>  | <strPhone> |<strGender>|<strHobbies>|<strLanguages>|<strSkills>|<strCountry>|<strYearOfBirth>|<strMonthOfBirth> | <strDayOfBirth> | <strPassword> | <strConfirmPassword> |
      Then he verifies the message
        |strMessage                                     |
        |Double Click on Edit Icon to EDIT the Table Row|
    Examples:
      |strFirstName|strLastName| strAddress           | strEmail          | strPhone   |strGender |strHobbies             |strLanguages              | strSkills | strCountry |strYearOfBirth|strMonthOfBirth|strDayOfBirth|strPassword|strConfirmPassword|
      | Juan David | Botero    |Calle 9 sur # 79 -70  |soundga226@yahoo.es| 3003696969 |Male      |Movies, Hockey         |Spanish, Urdu             |Java       |Denmark     |1985          |July           | 8           | cualquiera| cualquiera       |
      | Yuyeimi    | Lopez     |Cra 29 # 79 - 3 int 20|grilla@grillas.com | 3003003030 |FeMale    |Cricket, Movies, Hockey|Estonian, English, Italian|MySQL      |India       |1999          |March          |30           | cualquiera| cualquiera       |