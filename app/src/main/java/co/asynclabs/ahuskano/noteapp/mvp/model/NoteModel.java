package co.asynclabs.ahuskano.noteapp.mvp.model;

import co.asynclabs.ahuskano.noteapp.Noteapp;
import co.asynclabs.ahuskano.noteapp.task.NoteRepository;

public class NoteModel {

    private NoteRepository.NoteRepositoryActions listener;

    public NoteModel(NoteRepository.NoteRepositoryActions listener) {
        this.listener = listener;
    }

    public void getNotes() {
        new NoteRepository(listener, Noteapp.getInstance().getDatabase()).execute();
    }

}

