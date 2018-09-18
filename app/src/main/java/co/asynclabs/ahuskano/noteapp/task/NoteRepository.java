package co.asynclabs.ahuskano.noteapp.task;


import android.os.AsyncTask;

import java.util.List;

import co.asynclabs.ahuskano.noteapp.Noteapp;
import co.asynclabs.ahuskano.noteapp.data.Note;
import co.asynclabs.ahuskano.noteapp.db.DbHelper;

public class NoteRepository extends AsyncTask<Void, Void, List<Note>> {

    private NoteRepository.NoteRepositoryActions listener;

    private DbHelper db;

    public NoteRepository(NoteRepository.NoteRepositoryActions listener, DbHelper db) {
        this.listener = listener;
        this.db = db;
    }

    @Override
    protected List<Note> doInBackground(Void... voids) {
        return db.getNotes();
    }

    @Override
    protected void onPostExecute(List<Note> items) {
        listener.onDataSuccess(items);
    }

    public interface NoteRepositoryActions {

        void onDataSuccess(List<Note> items);
    }

}
