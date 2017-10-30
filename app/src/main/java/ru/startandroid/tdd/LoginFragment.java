package ru.startandroid.tdd;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginView {


    public LoginFragment() {
        // Required empty public constructor
    }

    Button btnLogin;
    EditText etUsername, etPassword;
    LoginPresenter loginPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btnLogin = view.findViewById(R.id.btn_login);
        etUsername = view.findViewById(R.id.et_username);
        etPassword = view.findViewById(R.id.et_pswd);
        btnLogin.setOnClickListener(view1 -> loginPresenter
                .doLogin(etUsername.getText().toString(),
                        etPassword.getText().toString()));


        setRetainInstance(true);
        return view;
    }

    public void initPresenter(){
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void showErrorMessageForUserNamePassword() {
        Snackbar.make(btnLogin, "Please check username or password", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessageForMaxLoginAttempt() {
        Snackbar.make(btnLogin, "You have exceeded MAX attempt", Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void showLoginSuccessMessage() {
        Snackbar.make(btnLogin, "Login Successful", Snackbar.LENGTH_SHORT).show();

    }
}
