package co.asynclabs.ahuskano.noteapp;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import co.asynclabs.ahuskano.arhitecture.mvp.activity.MVPActivity;
import co.asynclabs.ahuskano.noteapp.mvp.presenter.NotePresenter;
import co.asynclabs.ahuskano.noteapp.mvp.view.NoteView;

public class NoteActivity extends MVPActivity<NotePresenter> implements NoteView {

    private EditText etName;
    private EditText etDescription;

    @Override
    protected void setup() {

        setupMVP(new NotePresenter(this));

        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDescription);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_note;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:
                //save
                presenter.savePressed(etName, etDescription);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNoteSaved() {
        finish();
    }

    @Override
    public void onNoteFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationPassed() {
        presenter.save(etName.getText().toString(), etDescription.getText().toString());
    }
}
