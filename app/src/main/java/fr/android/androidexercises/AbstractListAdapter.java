package fr.android.androidexercises;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import static java.util.Objects.isNull;

public abstract class AbstractListAdapter<T> extends BaseAdapter  {
    private final List<T> elements;
    private final int resource;
    private final LayoutInflater inflater;

    public AbstractListAdapter(List<T> elements, int resource, LayoutInflater inflater) {
        this.elements = elements;
        this.resource = resource;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return elements.size();
    }

    @Override
    public T getItem(int i) {
        return elements.get(i);
    }

    @Override
    public long getItemId(int i) {
        return elements.get(i).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (isNull(convertView)) {
            convertView = inflater.inflate(resource, parent, false);
        }

        return bindView(position, convertView);
    }

    public abstract View bindView(int position, View convertView);

}
