package co.asynclabs.ahuskano.noteapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import co.asynclabs.ahuskano.arhitecture.mvp.activity.MVPActivity;
import co.asynclabs.ahuskano.noteapp.mvp.presenter.LoginPresenter;
import co.asynclabs.ahuskano.noteapp.mvp.view.LoginView;

public class LoginActivity extends MVPActivity<LoginPresenter> implements LoginView {

    private EditText etEmail;
    private EditText etPassword;
    private Button btLogIn;
    private ProgressBar progressBar;

    @Override
    protected void setup() {
        setupMVP(new LoginPresenter(this));
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btLogIn = findViewById(R.id.btnLogin);

        progressBar = findViewById(R.id.progressBar);

        btLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.logInPressed(etEmail, etPassword);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, getString(R.string.login_success_msg), Toast.LENGTH_SHORT).show();
        logIn();
    }

    @Override
    public void onLoginFail(String msg) {
        Toast.makeText(this, getString(R.string.login_failed_msg), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationSuccess() {
        presenter.checkForUser(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void logIn() {
        Intent intent = new Intent(getBaseContext(), DashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
}
