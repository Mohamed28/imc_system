package com.example.imc_system;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity {
    private double result;
//    private char gender;
    private TextView fieldResult, lblResult;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = Double.parseDouble(getIntent().getStringExtra("RESULT"));
//        gender = Character.toUpperCase(intent.getStringExtra("GENDER").charAt(0));
        displayResult(result);
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

//        switch (gender){
//            case 'M':
//                if (result < 18) {
//                    resultMessage = "Você está MAGRELO!";
//                    resultColor = Color.YELLOW;
//                } else if (result > 18 && result < 25) {
//                    resultMessage = "Você está OK!";
//                    resultColor = Color.GREEN;
//                } else {
//                    resultMessage = "Você está GORDO";
//                    resultColor = Color.RED;
//                }
//                break;
//            case 'F':
//                if (result < 18) {
//                    resultMessage = "Você está MAGRELA!";
//                    resultColor = Color.YELLOW;
//                } else if (result > 18 && result < 25) {
//                    resultMessage = "Você está BEEM!";
//                    resultColor = Color.GREEN;
//                } else {
//                    resultMessage = "Você está GORDA";
//                    resultColor = Color.RED;
//                }
//                break;
//        }

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
