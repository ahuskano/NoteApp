package co.asynclabs.ahuskano.noteapp.mvp.view;

import java.util.List;

import co.asynclabs.ahuskano.arhitecture.mvp.view.View;
import co.asynclabs.ahuskano.noteapp.data.Note;

public interface DashboardView extends View {

    void showData(List<Note> items);

}
