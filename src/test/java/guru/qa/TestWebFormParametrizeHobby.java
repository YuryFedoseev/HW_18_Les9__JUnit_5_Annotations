package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CheckRegistrationPage;
import pages.RegistrationPage;

public class TestWebFormParametrizeHobby extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    CheckRegistrationPage checkRegistrationPage = new CheckRegistrationPage();

    @BeforeEach
    void openPageAndKillBannerAndSetFieldsExceptHobby() {
        registrationPage
                .openPage()
                .closeBanner()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setPhone(userPhone)
                .setSubject(userSubject)
                .setImage(userImage)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity);


    }

    @AfterEach
    void checkAllFieldExceptHobby() {
        checkRegistrationPage
                .checkNameAndLastName(userName, userLastName)
                .checkEmail(userEmail)
                .checkPhone(userPhone)
                .checkSubject(userSubject)
                .checkImage(userImageName)
                .checkAddress(userAddress)
                .checkState(userState)
                .checkCity(userCity);
    }

    @ValueSource(strings = {"Music", "Sports", "Reading"})
    @DisplayName("В форме заполнения параметризованный выбор Хобби {0}")
    @ParameterizedTest

    @Tag("Web")
    void checkingWhetherTheHobbyFieldWithDifferentValuesTest(String testData) {

        registrationPage
                .setGender(userGender)
                .setHobby(testData)
                .setClickSubmit();
        checkRegistrationPage
                .checkHobby(testData)
                .checkGender(userGender);


    }

    @ValueSource(strings = {"Female", "Male", "Other"})
    @DisplayName("В форме заполнения параметризованный выбор Пола {0}")
    @ParameterizedTest

    @Tag("Web")
    void checkingWhetherTheGenderFieldWithDifferentValuesTest(String testData) {
        registrationPage
                .setGender(testData)
                .setHobby(userHobby)
                .setClickSubmit();
        checkRegistrationPage
                .checkHobby(userHobby)
                .checkGender(testData);


    }
}

