package co.asynclabs.ahuskano.noteapp.data;

import java.util.List;

import co.asynclabs.ahuskano.arhitecture.base.DataBinder;
import co.asynclabs.ahuskano.arhitecture.base.DataBinderAdapter;

public class NoteappAdapter<Note> extends DataBinderAdapter {

    private List<Note> items;

    public static int KEY_NOTE = 1;

    public NoteappAdapter() {

    }

    public NoteappAdapter(List<Note> items) {
        this.items = items;
    }


    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }


    @Override
    public int getItemViewType(int position) {
        return KEY_NOTE;
    }

    @Override
    public <T extends DataBinder> T getDataBinder(int viewType) {
        return (T) new NoteBinder(this);
    }

    @Override
    public int getPosition(DataBinder binder, int binderPosition) {
        return binderPosition;
    }

    public void setItems(List<Note> items) {
        this.items = items;
    }

    @Override
    public int getBinderPosition(int position) {
        return position;
    }

    public Note getItem(int position) {
        return items.get(position);
    }

}
