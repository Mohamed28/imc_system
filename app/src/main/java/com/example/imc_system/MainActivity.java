package com.example.imc_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        btnCalc = (Button) findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToResults(view);
            }
        });
    }

    public void goToResults(View view) {
        if (TextUtils.isEmpty(inputHeight.getText())) {
            Toast.makeText(getApplicationContext(), "O campo de altura está vazio!", Toast.LENGTH_SHORT);
            inputHeight.setError("Altura é um campo obrigatório!");
        } else if (TextUtils.isEmpty(inputWeight.getText())) {
            Toast.makeText(getApplicationContext(), "O campo de peso está vazio!", Toast.LENGTH_SHORT);
            inputHeight.setError("Peso é um campo obrigatório!");
        } else {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("HEIGHT", inputHeight.getText().toString());
            intent.putExtra("WEIGHT", inputWeight.getText().toString());
            startActivity(intent);
        }
    }

}
