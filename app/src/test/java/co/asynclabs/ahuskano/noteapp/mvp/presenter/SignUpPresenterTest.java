package co.asynclabs.ahuskano.noteapp.mvp.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import co.asynclabs.ahuskano.noteapp.mvp.view.SignUpView;

import static org.junit.Assert.*;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class SignUpPresenterTest {

    @Mock
    private SignUpView view;

    private SignUpPresenter presenter;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new SignUpPresenter(view);
    }

    @Test
    public void onSignUpPressed() {
        InOrder inOrder = inOrder(view);
        presenter.onSignUpPressed(null, null, null, null);
        inOrder.verify(view).showProgress();
        inOrder.verify(view).hideProgress();
        inOrder.verify(view).onSignUpFail("Nemoze");
    }

    @Test
    public void saveUser() {
    }
}