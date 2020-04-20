package com.example.imc_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity {
    private EditText inputHeight, inputWeight;
//    private RadioGroup radioGenderGroup;
//    private RadioButton radioGenderButton;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputHeight = findViewById(R.id.inputHeight);
        inputWeight = findViewById(R.id.inputWeight);
//        radioGenderGroup = findViewById(R.id.radioGenderGroup);
//        radioGenderButton = findViewById(radioGenderGroup.getCheckedRadioButtonId());
        btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(view);
            }
        });
    }

    public void calculate(View view) {
        double height, weight, result;
//        char gender = radioGenderButton.getText().charAt(0);

        if (TextUtils.isEmpty(inputHeight.getText())) {
            Toast.makeText(MainActivity.this, "O campo de altura está vazio!", Toast.LENGTH_SHORT).show();
            inputHeight.setError("Altura é um campo obrigatório!");

        } else if (TextUtils.isEmpty(inputWeight.getText())) {
            Toast.makeText(MainActivity.this, "O campo de peso está vazio!", Toast.LENGTH_SHORT).show();
            inputWeight.setError("Peso é um campo obrigatório!");
//
//        } else if (radioGenderButton == null) {
//            Toast.makeText(MainActivity.this, "Por favor, informe o seu genêro!", Toast.LENGTH_SHORT).show();

        } else {
            height = Double.parseDouble(inputHeight.getText().toString());
            weight = Double.parseDouble(inputWeight.getText().toString());
            result = Math.round(weight / Math.pow(height, 2));

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            System.out.println("+++++++++++++++++++++++++++++++++++++\n "+ result+"++++++++++++++++++++++++++++++++++++\n");
            intent.putExtra("result", result);
            System.out.println("+++++++++++++++++++++++++++++++++++++\n "+ intent.getStringExtra("result") +"++++++++++++++++++++++++++++++++++++\n");

//            intent.putExtra("GENDER", gender);
            startActivity(intent);
        }
    }

}
