package co.asynclabs.ahuskano.noteapp.mvp.presenter;

import android.widget.EditText;

import co.asynclabs.ahuskano.arhitecture.mvp.presenter.BasePresenter;
import co.asynclabs.ahuskano.noteapp.Noteapp;
import co.asynclabs.ahuskano.noteapp.data.Note;
import co.asynclabs.ahuskano.noteapp.mvp.view.NoteView;
import co.asynclabs.ahuskano.noteapp.utils.ValidationUtils;

public class NotePresenter extends BasePresenter<NoteView> {

    public NotePresenter(NoteView view) {
        super(view);
    }

    public void savePressed(EditText etName, EditText etDescription){
        if (ValidationUtils.isNullOrEmpty(etName) ||
                ValidationUtils.isNullOrEmpty(etDescription)) {
            view.onNoteFailed("Nemoze");
        } else {
            view.onValidationPassed();
        }
    }

    public void save(String name, String description){
        Noteapp.getInstance().getDatabase().saveNote(new Note(name, description));
        view.onNoteSaved();
    }
}
