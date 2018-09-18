package co.asynclabs.ahuskano.noteapp.mvp.view;

import co.asynclabs.ahuskano.arhitecture.mvp.view.View;

public interface LoginView extends View {

    void onLoginSuccess();

    void onLoginFail(String msg);

    void onValidationSuccess();

    void showProgress();

    void hideProgress();

    void logIn();
}
