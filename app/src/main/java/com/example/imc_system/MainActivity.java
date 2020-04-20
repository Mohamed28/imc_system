package com.example.imc_system;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity {
    private EditText inputHeight, inputWeight;
    private TextView fieldResult, lblResult;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputHeight = (EditText) findViewById(R.id.inputHeight);
        inputWeight = (EditText) findViewById(R.id.inputWeight);
        fieldResult = (TextView) findViewById(R.id.fieldResult);
        lblResult = (TextView) findViewById(R.id.lblResult);
        btnCalc = (Button) findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc(view);
            }
        });
    }

    public void calc(View view) {
        double altura = Double.parseDouble(inputHeight.getText().toString());
        double peso = Double.parseDouble(inputWeight.getText().toString());
        displayResult(Math.round(peso / Math.pow(altura, 2)));
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

}
