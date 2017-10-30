package ru.startandroid.tdd;

/**
 * Created by zhangali on 30.10.17.
 */

public interface LoginView {

    void showErrorMessageForUserNamePassword();

    void showErrorMessageForMaxLoginAttempt();

    void showLoginSuccessMessage();
}
