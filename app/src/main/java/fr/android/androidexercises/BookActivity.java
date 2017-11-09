package fr.android.androidexercises;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import static fr.android.androidexercises.Constants.BOOK;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        Book book = intent.getParcelableExtra(BOOK);

        TextView authorTextView = (TextView) findViewById(R.id.authorTextView);
        authorTextView.setText(book.getAuthor());

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        nameTextView.setText(book.getName());

        Button selectDateBtn = findViewById(R.id.selectDateBtn);
        selectDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());

                new DatePickerDialog(BookActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        Toast.makeText(BookActivity.this, dayOfMonth + "/" + (monthOfYear+1) + "/" + year, Toast.LENGTH_LONG).show();
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

}
