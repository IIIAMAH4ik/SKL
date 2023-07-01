package ru.netologi.test;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netologi.data.DataHelper;
import ru.netologi.data.SQLHelper;
import ru.netologi.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class BankTest {

    @AfterAll
    static void teardown() {cleanDatabase();}

    private static void cleanDatabase() {
    }


    @Test
    @DisplayName("Should successfully login to dash exist login and pssword from sut test data")
    void shouldSuccessfulLogin() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var autInfo = DataHelper.getAutInfoTestData();
        var verificationPage = loginPage.validlogin(autInfo);
        verificationPage.verifyVerificationPageVisibility();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }
}
