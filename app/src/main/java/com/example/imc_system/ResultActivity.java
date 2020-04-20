package com.example.imc_system;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView fieldResult, lblResult;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fieldResult = (TextView) findViewById(R.id.fieldResult);
        lblResult = (TextView) findViewById(R.id.lblResult);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(view);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        calculate(findViewById(R.id.result_activity));
    }

    public void calculate(View view) {
        Bundle extras = getIntent().getExtras();
        double height = extras.getDouble("HEIGHT");
        double weight = extras.getDouble("WEIGHT");
        displayResult(Math.round(weight / Math.pow(height, 2)));
    }

    public void displayResult(double result) {
        int resultColor = 0;
        String resultMessage = "";

        if (result < 18) {
            resultMessage = "Você está MAGRELO!";
            resultColor = Color.YELLOW;
        } else if (result > 18 && result < 25) {
            resultMessage = "Você está OK!";
            resultColor = Color.GREEN;
        } else {
            resultMessage = "Você está GORDO";
            resultColor = Color.RED;
        }

        lblResult.setText(resultMessage);
        lblResult.setTextColor(resultColor);
        fieldResult.setText(String.valueOf(result));
        fieldResult.setTextColor(resultColor);
    }

    public void back(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
