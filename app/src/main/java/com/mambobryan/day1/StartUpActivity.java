package com.mambobryan.day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class StartUpActivity extends AppCompatActivity {

    TextView random_number_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        random_number_text_view = findViewById(R.id.random_number_text_view);
        Intent myIntent = getIntent();
        String random_number_string = myIntent.getStringExtra("random_number_string");

        Toast.makeText(this, random_number_string, Toast.LENGTH_LONG).show();

        if (random_number_string == null){

            int initial_random_number = generateRandomNumber();
            String initial_number_string = convertIntToString(initial_random_number);
            random_number_text_view.setText(initial_number_string);

        } else {

            random_number_text_view.setText(random_number_string);
        }

    }

    public int generateRandomNumber() {
        final int max = 200;
        final int min = 50;

        Random myRandomObject = new Random();
        int number = myRandomObject.nextInt(max - min) + 1;

        return number;
    }

    public String convertIntToString(int number) {
        return String.valueOf(number);
    }

    public void setRandomTextView(View view) {
        int random = generateRandomNumber();
        String random_number_string = convertIntToString(random);

        Intent my_intent_variable = new Intent(StartUpActivity.this, SecondActivity.class);
        my_intent_variable.putExtra("random_number_string_activity_a", random_number_string);
        StartUpActivity.this.startActivity(my_intent_variable);
    }

}
