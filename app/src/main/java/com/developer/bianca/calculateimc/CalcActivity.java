package com.developer.bianca.calculateimc;

import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {

    EditText weightField;
    EditText heightField;
    TextView showResultField;
    String showResult;

    double imc;
    double weight;
    double height;
    double roundResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        weightField = findViewById(R.id.weight_field);
        heightField = findViewById(R.id.height_field);
        showResultField = findViewById(R.id.show_result);
    }

    public void calcule(View view) {
        if(heightField.getText().toString().contains(",") || heightField.getText().toString().equals("")){
            heightField.setError("Insira o valor com ponto ao invés de vírgula. Campo obrigatório");
        } else {
            weight = Double.parseDouble(weightField.getText().toString());
            height = Double.parseDouble(heightField.getText().toString());
            roundResult = (weight)/(height * 2);
            imc = Math.round(roundResult);

            showResult = String.valueOf(imc);

            verifyResult();
            showResultField.setText(showResult);
            showResultField.setVisibility(View.VISIBLE);
        }
    }

    public void verifyResult(){
        if(imc < 16){
            showResultField.setTextColor(Color.RED);
        }
        if(imc == 16 || imc < 17){
            showResultField.setTextColor(Color.rgb(255,69,0));
        }
        if(imc == 17 || imc < 18.5){
            showResultField.setTextColor(Color.YELLOW);
        }
        if(imc == 18.5 || imc < 25){
            showResultField.setTextColor(Color.blue(Color.BLUE));
        }
        if(imc == 25 || imc < 30){
            showResultField.setTextColor(Color.rgb(153, 102, 204));
        }
        if(imc == 30 || imc < 35){
            showResultField.setTextColor(Color.rgb(255,184,61));
        }
        if(imc == 35 || imc < 40){
            showResultField.setTextColor(Color.rgb(255,69,0));
        }
        if(imc >= 40){
            showResultField.setTextColor(Color.RED);
        }
    }
}
