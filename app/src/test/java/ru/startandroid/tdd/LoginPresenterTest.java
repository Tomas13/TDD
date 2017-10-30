package ru.startandroid.tdd;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by zhangali on 30.10.17.
 */

public class LoginPresenterTest {

    @Test
    public void checkIfLoginAttemptIsExceeded(){
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        assertEquals(1, loginPresenter.incrementLoginAttempt());
        assertEquals(2, loginPresenter.incrementLoginAttempt());
        assertEquals(3, loginPresenter.incrementLoginAttempt());
        assertTrue(loginPresenter.isLoginAttemptExceeded());
    }

    @Test
    public void checkUsernameAndPasswordIsCorrect(){
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
//        assertFalse(loginPresenter.isLoginAttemptExceeded());
        loginPresenter.doLogin("rafael", "tdd");
        verify(loginView).showLoginSuccessMessage();
    }

    @Test
    public void checkIfLoginAttemptIsNotExceeded(){
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        assertFalse(loginPresenter.isLoginAttemptExceeded());
    }

    @Test
    public void checkUsernameAndPasswordIsNotCorrect() {
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("xyz", "tdd");
        verify(loginView).showErrorMessageForUserNamePassword();
    }

    @Test
    public void checkIfLoginAttemptIsExceededAndViewMethodCalled() {
        LoginView loginView = mock(LoginView.class);
        LoginPresenter loginPresenter = new LoginPresenter(loginView);
        loginPresenter.doLogin("xyz", "tdd");
        loginPresenter.doLogin("xyz", "tdd");
        loginPresenter.doLogin("xyz", "tdd");
        loginPresenter.doLogin("xyz", "tdd");
        verify(loginView).showErrorMessageForMaxLoginAttempt();
    }
}
