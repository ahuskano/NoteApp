package co.asynclabs.ahuskano.noteapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import co.asynclabs.ahuskano.arhitecture.mvp.activity.MVPActivity;
import co.asynclabs.ahuskano.noteapp.data.Note;
import co.asynclabs.ahuskano.noteapp.data.NoteappAdapter;
import co.asynclabs.ahuskano.noteapp.mvp.presenter.DashboardPresenter;
import co.asynclabs.ahuskano.noteapp.mvp.view.DashboardView;

public class DashboardActivity extends MVPActivity<DashboardPresenter> implements DashboardView {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private NoteappAdapter adapter;

    @Override
    protected void setup() {
        setupMVP(new DashboardPresenter(this));
        fab = findViewById(R.id.fab_add);
        recyclerView = findViewById(R.id.rvNotes);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), NoteActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });


        adapter = new NoteappAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        presenter.getNotes();

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showData(List<Note> items) {
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}
