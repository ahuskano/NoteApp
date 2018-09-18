package co.asynclabs.ahuskano.noteapp.mvp.presenter;

import android.util.Log;
import android.widget.EditText;

import co.asynclabs.ahuskano.arhitecture.mvp.presenter.BasePresenter;
import co.asynclabs.ahuskano.noteapp.Noteapp;
import co.asynclabs.ahuskano.noteapp.data.User;
import co.asynclabs.ahuskano.noteapp.db.DbHelper;
import co.asynclabs.ahuskano.noteapp.mvp.view.SignUpView;
import co.asynclabs.ahuskano.noteapp.utils.ValidationUtils;

public class SignUpPresenter extends BasePresenter<SignUpView> {

    public SignUpPresenter(SignUpView view) {
        super(view);
    }


    public void onSignUpPressed(EditText name, EditText email, EditText password, EditText passwordRepeat) {
        view.showProgress();
        if (ValidationUtils.isNullOrEmpty(name) ||
                ValidationUtils.isNullOrEmpty(email) ||
                ValidationUtils.isNullOrEmpty(password) ||
                ValidationUtils.isNullOrEmpty(passwordRepeat)) {
            view.hideProgress();
            view.onSignUpFail("Nemoze");
        } else {
            view.hideProgress();
            view.onSignUpSuccess();
        }
    }

    public void saveUser(User user){
        Noteapp.getInstance().getDatabase().saveUser(user);
        view.goToLogIn();
    }

}
