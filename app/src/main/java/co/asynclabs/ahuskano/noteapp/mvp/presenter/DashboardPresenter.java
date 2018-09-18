package co.asynclabs.ahuskano.noteapp.mvp.presenter;

import java.util.List;

import co.asynclabs.ahuskano.arhitecture.mvp.presenter.BasePresenter;
import co.asynclabs.ahuskano.noteapp.data.Note;
import co.asynclabs.ahuskano.noteapp.mvp.model.NoteModel;
import co.asynclabs.ahuskano.noteapp.mvp.view.DashboardView;
import co.asynclabs.ahuskano.noteapp.task.NoteRepository;

public class DashboardPresenter extends BasePresenter<DashboardView> implements NoteRepository.NoteRepositoryActions{

    private NoteModel model;

    public DashboardPresenter(DashboardView view) {
        super(view);
        this.model = new NoteModel(this);
    }

    public void getNotes(){
        this.model.getNotes();
    }

    @Override
    public void onDataSuccess(List<Note> items) {
        view.showData(items);
    }
}
