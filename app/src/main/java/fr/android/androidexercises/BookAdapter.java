package fr.android.androidexercises;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import static java.util.Objects.isNull;

public class BookAdapter extends BaseAdapter {

    private final List<Book> books;
    private final LayoutInflater inflater;

    public BookAdapter(Context context, List<Book> books) {
        this.books = books;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Book getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return books.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (isNull(convertView)) {
            convertView = inflater.inflate(R.layout.custom_view_item_book, parent, false);
        }

        ((BookItemView) convertView).bindView(getItem(position));

        return convertView;
    }

}
