package com.mambobryan.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView activity_b_text_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        overridePendingTransition(0,0);

        Intent my_intent = getIntent();
        String random_number_string = my_intent.getStringExtra("random_number_string_activity_a");

        activity_b_text_View = findViewById(R.id.activity_b_text_view);
        activity_b_text_View.setText(random_number_string);
    }

    public int generateRandomNumber() {
        final int max = 200;
        final int min = 50;

        Random rand = new Random();
        return rand.nextInt(max - min) + 1;
    }

    public String convertIntToString(int number) {
        return String.valueOf(number);
    }

    public void regenerateRandomNumber(View view) {
        int random = generateRandomNumber();
        String random_number = convertIntToString(random);

        Intent activityBIntent = new Intent(SecondActivity.this, StartUpActivity.class);
        activityBIntent.putExtra("random_number_string", random_number);
        SecondActivity.this.startActivity(activityBIntent);

        Toast.makeText(this, random_number, Toast.LENGTH_SHORT).show();
    }
}
