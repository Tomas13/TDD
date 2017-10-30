package ru.startandroid.tdd;

/**
 * Created by zhangali on 30.10.17.
 */

public class LoginPresenter {

    private static final int MAX_LOGIN_ATTEMPT = 3;
    private final LoginView loginView;
    private int loginAttempt;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public int incrementLoginAttempt() {
        return ++loginAttempt;
    }

    public boolean isLoginAttemptExceeded() {
        return loginAttempt >= MAX_LOGIN_ATTEMPT;
    }

    public void doLogin(String username, String password) {
        if (isLoginAttemptExceeded()){
            loginView.showErrorMessageForMaxLoginAttempt();
            return;
        }

        if(username.equals("rafael") && password.equals("tdd")){
            loginView.showLoginSuccessMessage();
            return;
        }

        //increment login attempt if it fails
        incrementLoginAttempt();
        loginView.showErrorMessageForUserNamePassword();
    }
}
