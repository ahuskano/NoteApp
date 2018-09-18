package co.asynclabs.ahuskano.noteapp.task;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import co.asynclabs.ahuskano.noteapp.data.Note;
import co.asynclabs.ahuskano.noteapp.db.DbHelper;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NoteRepositoryTest {

    private NoteRepository task;

    private List<Note> items;

    @Mock
    private DbHelper dbHelper;

    @Mock
    private NoteRepository.NoteRepositoryActions listener;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        task = new NoteRepository(listener, dbHelper);

/*        doAnswer(new Answer() {
            @Override
            public List<Note> answer(InvocationOnMock invocation) throws Throwable {
                return getNotes();
            }
        }).when(dbHelper).getNotes();*/
    }


    @Test
    public void onPostExecute() {
        task.onPostExecute(getNotes());
        verify(listener, atLeastOnce()).onDataSuccess(getNotes());
    }

    private List<Note> getNotes() {
        if (items == null || items.size() == 0) {
            items = new ArrayList<>();
            items.add(new Note());
        }

        return items;
    }
}