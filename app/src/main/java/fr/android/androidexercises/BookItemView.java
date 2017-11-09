package fr.android.androidexercises;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BookItemView extends LinearLayout {

    private TextView nameTextView;
    private TextView priceTextView;

    public BookItemView(Context context) {
        this(context, null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        nameTextView = findViewById(R.id.nameTextView);
        priceTextView = findViewById(R.id.priceTextView);
    }

    public void bindView(Book book) {
        nameTextView.setText(book.name);
        priceTextView.setText(String.valueOf(book.price));
    }
}
