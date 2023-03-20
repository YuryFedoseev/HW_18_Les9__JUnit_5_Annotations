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
                .setGender(userGender)
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
                .checkGender(userGender)
                .checkPhone(userPhone)
                .checkSubject(userSubject)
                .checkImage(userImageName)

                .checkAddress(userAddress)
                .checkState(userState)
                .checkCity(userCity);
    }

    @ValueSource(strings = {"Music", "Sports", "Reading"})
    @DisplayName("В форме заполнения выбор Хобби {0}")
    @ParameterizedTest

    @Tag("Web")
    void checkingWhetherTheHobbyFieldWithDifferentValuesTest(String testData) {

        registrationPage
                .setHobby(testData)
                .setClickSubmit();
        checkRegistrationPage
                .checkHobby(testData);


    }

    @Test
    void checkingTheHobbyIsNullTest() {
        userHobby = null;
        registrationPage
                .setClickSubmit();


    }


}
