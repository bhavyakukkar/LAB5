package com.bhavyakukkar.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initialize();
    }

    private void initialize() {
        final EditText name = (EditText) findViewById(R.id.nameInput);
        final EditText age = (EditText) findViewById(R.id.ageInput);

        final EditText cia1 = (EditText) findViewById(R.id.cia1Input);
        final EditText cia2 = (EditText) findViewById(R.id.cia2Input);
        final EditText cia3 = (EditText) findViewById(R.id.cia3Input);

        final Button calculateButton = (Button) findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = calculateTotal(cia1, cia2, cia3);
                float gpa = calculateGpa(cia1, cia2, cia3);
                proceed(name, age, total, gpa);
            }
        });
    }

    private int calculateTotal(EditText cia1, EditText cia2, EditText cia3) {
        int cia1Marks = Integer.parseInt(cia1.getText().toString());
        int cia2Marks = Integer.parseInt(cia2.getText().toString());
        int cia3Marks = Integer.parseInt(cia3.getText().toString());

        int total = cia1Marks + cia2Marks + cia3Marks;
        return total;
    }

    private float calculateGpa(EditText cia1, EditText cia2, EditText cia3) {
        float cia1Grade = (float)Integer.parseInt(cia1.getText().toString())/4;
        float cia2Grade = (float)Integer.parseInt(cia2.getText().toString())/4;
        float cia3Grade = (float)Integer.parseInt(cia3.getText().toString())/4;

        float gpa = (cia1Grade*30 + cia2Grade*30 + cia3Grade*30)/90;
        return gpa;
    }

    private void proceed(EditText name, EditText age, int total, float gpa) {
        String nameText = name.getText().toString();
        String ageText = age.getText().toString();

        //Intent switchTo
    }
}