package co.asynclabs.ahuskano.noteapp.mvp.presenter;

import android.widget.EditText;

import co.asynclabs.ahuskano.arhitecture.mvp.presenter.BasePresenter;
import co.asynclabs.ahuskano.noteapp.Noteapp;
import co.asynclabs.ahuskano.noteapp.data.User;
import co.asynclabs.ahuskano.noteapp.mvp.view.LoginView;
import co.asynclabs.ahuskano.noteapp.utils.ValidationUtils;

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        super(view);
    }

    public void logInPressed(EditText etEmail, EditText etPassword) {

        view.showProgress();
        if (ValidationUtils.isNullOrEmpty(etEmail) ||
                ValidationUtils.isNullOrEmpty(etPassword)) {
            view.hideProgress();
            view.onLoginFail("Nisu popunjena sva polja");
        } else {
            view.onValidationSuccess();
        }
    }


    public void checkForUser(String email, String password) {
        response(Noteapp.getInstance().getDatabase().getUser(email, password));
    }

    public void response(User user){
        if (user != null) {
            view.hideProgress();
            view.onLoginSuccess();
        } else {
            view.hideProgress();
            view.onLoginFail("Korisnik ne postoji u sustavu");
        }
    }
}