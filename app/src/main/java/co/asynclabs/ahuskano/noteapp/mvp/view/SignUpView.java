package co.asynclabs.ahuskano.noteapp.mvp.view;

import co.asynclabs.ahuskano.arhitecture.mvp.view.View;

public interface SignUpView extends View {

    void onSignUpSuccess();

    void onSignUpFail(String msg);

    void showProgress();

    void hideProgress();

    void goToLogIn();
}
