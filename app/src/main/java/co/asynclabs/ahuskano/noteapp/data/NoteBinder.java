package co.asynclabs.ahuskano.noteapp.data;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.asynclabs.ahuskano.arhitecture.base.AdapterItem;
import co.asynclabs.ahuskano.arhitecture.base.DataBinder;
import co.asynclabs.ahuskano.noteapp.R;

public class NoteBinder extends DataBinder<NoteBinder.ViewHolder> {

    private NoteappAdapter adapter;

    public NoteBinder(NoteappAdapter dataBindAdapter) {
        this.adapter = dataBindAdapter;
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        return new ViewHolder(getView(parent));
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int position) {
        holder.findViews();
        holder.fillDate((Note)adapter.getItem(position));
    }

    @Override
    public int getItemCount() {
        return adapter.getItemCount();
    }

    @Override
    public int provideLayout() {
        return R.layout.list_item_note;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements AdapterItem<Note> {

        private View mRoot;
        private TextView name, description;
        private CardView cardView;
        private Note model;


        public ViewHolder(View view) {
            super(view);
            this.mRoot = view;
        }


        @Override
        public void findViews() {
            name = mRoot.findViewById(R.id.tvName);
            description =  mRoot.findViewById(R.id.tvDescription);
        }


        @Override
        public void fillDate(Note model) {
            this.model = model;
            //TODO this is bad, needs rewrite
            name.setText(model.name);
            description.setText(model.description);
        }
    }
}
