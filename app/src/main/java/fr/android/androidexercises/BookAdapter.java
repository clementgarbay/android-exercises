package fr.android.androidexercises;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

public class BookAdapter extends AbstractListAdapter<Book> {

    public BookAdapter(Context context, List<Book> books) {
        super(books, R.layout.custom_view_item_book, LayoutInflater.from(context));
    }

    @Override
    public View bindView(int position, View convertView) {
        ((BookItemView) convertView).bindView(getItem(position));
        return convertView;
    }

}
