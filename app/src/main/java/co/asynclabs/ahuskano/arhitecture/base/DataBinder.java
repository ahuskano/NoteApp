package co.asynclabs.ahuskano.arhitecture.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

abstract public class DataBinder<T extends RecyclerView.ViewHolder> {


    public DataBinder() {
    }

    public View getView(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                provideLayout(), parent, false);
        return view;
    }

    abstract public T newViewHolder(ViewGroup parent);

    abstract public void bindViewHolder(T holder, int position);

    abstract public int getItemCount();

    abstract public int provideLayout();

}
