package fr.android.androidexercises;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class BookAdapterRecycler extends RecyclerView.Adapter<BookAdapterRecycler.MyViewHolder> {

    private final List<Book> books;
    private final LayoutInflater inflater;

    public BookAdapterRecycler(Context context, List<Book> books) {
        this.books = books;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.custom_view_item_book, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ((BookItemView) holder.itemView).bindView(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
