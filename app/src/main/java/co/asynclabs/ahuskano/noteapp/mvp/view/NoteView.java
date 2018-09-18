package co.asynclabs.ahuskano.noteapp.mvp.view;

import co.asynclabs.ahuskano.arhitecture.mvp.view.View;

public interface NoteView extends View {
    void onNoteSaved();

    void onNoteFailed(String msg);

    void onValidationPassed();

}
