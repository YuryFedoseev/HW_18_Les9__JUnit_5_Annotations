package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CheckRegistrationPage;
import pages.RegistrationPage;

public class TestWebFormParametrizeHobby extends TestBase {
    private TestData testData = new TestData() ;
    RegistrationPage registrationPage = new RegistrationPage();
    CheckRegistrationPage checkRegistrationPage = new CheckRegistrationPage();


    @BeforeEach
    void openPageAndKillBannerAndSetFieldsExceptHobby() {
        registrationPage
                .openPage()
                .closeBanner()
                .setFirstName(testData.userName)
                .setLastName(testData.userLastName)
                .setEmail(testData.userEmail)
                .setPhone(testData.userPhone)
                .setSubject(testData.userSubject)
                .setImage(testData.userImage)
                .setAddress(testData.userAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .setGender(testData.userGender)
                .setHobby(testData.userHobby)
                .setGender(testData.userGender)
                .setHobby(testData.userHobby);



    }



    @ValueSource(strings = {"Music", "Sports", "Reading"})
    @DisplayName("Параметризованный тест выбора хобби на форме регистрации")
    @ParameterizedTest (name ="В форме заполнения выбор Хобби -  {0}")

    @Tag("Web")
    void checkingWhetherTheHobbyFieldWithDifferentValuesTest(String testData) {


        registrationPage
                .setHobby(testData)
                .setClickSubmit();
        checkRegistrationPage
                .checkHobby(testData);


    }

    @ValueSource(strings = {"Female", "Male", "Other"})
    @DisplayName("В форме заполнения параметризованный выбор Пола {0}")
    @ParameterizedTest

    @Tag("Web")
    void checkingWhetherTheGenderFieldWithDifferentValuesTest(String testData) {

        registrationPage
                .setGender(testData)
                .setClickSubmit();
        checkRegistrationPage
                .checkGender(testData);


    }


   // @CsvSource (value = "a,b")
    @CsvFileSource(resources = "/testData/checkingWhetherTheSityFieldWithDifferentValuesTest.csv")
//    @DisplayName
    @ParameterizedTest (name = "В форме заполнения параметризованный выбор страны -{0}  и города {1}")

    @Tag("Web")
    void checkingWhetherTheSityFieldWithDifferentValuesTest(String testData, String expectedText) {

        registrationPage

                .setState(testData)
                .setCity(expectedText)
                .setClickSubmit();
        checkRegistrationPage
                .checkState(testData)
               .checkCity(expectedText);


    }
}

