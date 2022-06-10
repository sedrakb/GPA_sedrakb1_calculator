package com.example.gpacalculator;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.gpacalculator.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText CreditHours, Grade;
    private Button addCourse, computeGpa, clear;
    private TextView textView;
    double total = 0, totalCredit = 0, credit = 0, grade = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreditHours = findViewById(R.id.enterhours);
        Grade  = findViewById(R.id.entergrade);

        addCourse = findViewById(R.id.addbutton);
        computeGpa = findViewById(R.id.computebutton);
        clear = findViewById(R.id.clear);
        textView = findViewById(R.id.result);


        addCourse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                credit = Double.parseDouble(CreditHours.getText().toString());
                grade = Double.parseDouble(Grade.getText().toString());

                total = (grade * credit);
                totalCredit += credit;
                Toast.makeText(getApplicationContext(),"Credit : " + credit + "\ngrade: " + grade, Toast.LENGTH_LONG).show();
                CreditHours.setText("");
                Grade.setText("");

            }
        });

        computeGpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = total /totalCredit;
                textView.setText("Your GPA : " + result);


            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = 0;
                totalCredit = 0;
                credit = 0;
                grade = 0;

                CreditHours.setText("");
                Grade.setText("");
                textView.setText("");

            }
        });

    }
}
