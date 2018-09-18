package co.asynclabs.ahuskano.noteapp;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import co.asynclabs.ahuskano.arhitecture.mvp.activity.MVPActivity;
import co.asynclabs.ahuskano.noteapp.data.User;
import co.asynclabs.ahuskano.noteapp.mvp.presenter.SignUpPresenter;
import co.asynclabs.ahuskano.noteapp.mvp.view.SignUpView;

public class SignUpActivity extends MVPActivity<SignUpPresenter> implements SignUpView {

    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPasswordRepeat;
    private Button btSignUp;
    private ProgressBar progressBar;

    @Override
    protected void setup() {
        setupMVP(new SignUpPresenter(this));
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPasswordRepeat = findViewById(R.id.etPasswordRepeat);
        progressBar = findViewById(R.id.progressBar);

        btSignUp = findViewById(R.id.btnRegistration);

        btSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("test", "onClick");
                presenter.onSignUpPressed(etName,
                        etEmail,
                        etPassword,
                        etPasswordRepeat);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_signup;
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "moze", Toast.LENGTH_SHORT).show();
        presenter.saveUser(new User(etName.getText().toString(),
                etEmail.getText().toString(),
                etPassword.getText().toString()));
    }

    @Override
    public void onSignUpFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
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
    public void goToLogIn() {
        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
}
