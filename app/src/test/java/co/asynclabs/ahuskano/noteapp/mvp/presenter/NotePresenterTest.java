package co.asynclabs.ahuskano.noteapp.mvp.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import co.asynclabs.ahuskano.noteapp.mvp.view.NoteView;

import static org.junit.Assert.*;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class NotePresenterTest {

    @Mock
    private NoteView view;

    private NotePresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new NotePresenter(view);
    }

    @Test
    public void savePressed() {
        InOrder inOrder = inOrder(view);
        presenter.savePressed(null, null);
        inOrder.verify(view).onNoteFailed("Nemoze");
    }
}