package co.asynclabs.ahuskano.noteapp.mvp.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import co.asynclabs.ahuskano.noteapp.data.Note;
import co.asynclabs.ahuskano.noteapp.mvp.model.NoteModel;
import co.asynclabs.ahuskano.noteapp.mvp.view.DashboardView;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DashboardPresenterTest {

    @Mock
    private DashboardView view;

    @Mock
    private NoteModel model;

    @Captor
    private ArgumentCaptor<DashboardView> listenerCaptor;

    private DashboardPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new DashboardPresenter(view);
    }

    @Test
    public void onDataSuccess() {
        InOrder inOrder = inOrder(view);
        List<Note> items = new ArrayList<>();
        presenter.onDataSuccess(items);
        inOrder.verify(view).showData(items);
    }

    @Test
    public void getData(){

    }
}