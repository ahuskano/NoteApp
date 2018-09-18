package co.asynclabs.ahuskano.noteapp.mvp.presenter;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.List;

import co.asynclabs.ahuskano.noteapp.data.User;
import co.asynclabs.ahuskano.noteapp.mvp.view.LoginView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginView view;

    @Mock
    private EditText etEmail;

    @Mock
    private EditText etPassword;


    private LoginPresenter presenter;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(view);

    }

    @Test
    public void logInWrong1() {
        InOrder inOrder = inOrder(view);

        presenter.logInPressed(null, null);
        inOrder.verify(view).showProgress();
        inOrder.verify(view).hideProgress();
        inOrder.verify(view).onLoginFail(any(String.class));
    }

    @Test
    public void logInWrong2() {

        presenter.logInPressed(null, null);
        Mockito.verify(view, Mockito.times(1)).showProgress();
        Mockito.verify(view, Mockito.times(1)).hideProgress();
        Mockito.verify(view, Mockito.times(1)).onLoginFail(any(String.class));
        Mockito.verify(view, Mockito.never()).onLoginSuccess();
    }

    @Test
    public void logInCorrect(){

        setupEditTexts();

        presenter.logInPressed(etEmail, etPassword);

        Mockito.verify(view, Mockito.times(1)).showProgress();
        Mockito.verify(view, Mockito.times(1)).onValidationSuccess();

    }

    private void setupEditTexts(){
        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return new SpannableStringBuilder("Email");
            }
        }).when(etEmail).getText();

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return new SpannableStringBuilder("Password");
            }
        }).when(etPassword).getText();
    }

    @Test
    public void checkForUser() {
        // nesto treba mockat ne mogu ovo lagano testirat
    }

    @Test
    public void response(){
        InOrder inOrder = inOrder(view);
        presenter.response(null);
        inOrder.verify(view).hideProgress();
        inOrder.verify(view).onLoginFail(any(String.class));

        presenter.response(new User());
        inOrder.verify(view).hideProgress();
        inOrder.verify(view).onLoginSuccess();
    }
}