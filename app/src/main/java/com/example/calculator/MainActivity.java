package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    TextView expView, resultView;
    MaterialButton btn0, btn1, btn2, btn3, btn4, btn5, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expView = findViewById(R.id.expression);
        resultView = findViewById(R.id.result);
        btn0 = findViewById(R.id.button_0);
        btn0.setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_1).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_2).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_3).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_4).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_5).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_6).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_7).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_8).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_9).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_add).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_mul).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_per).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_dot).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_min).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_div).setOnClickListener(view -> addViewTextToScreen(view));
        findViewById(R.id.button_equ).setOnClickListener(view -> evaluate());
        findViewById(R.id.button_ac).setOnClickListener(view -> clearAll());
        findViewById(R.id.button_c).setOnClickListener(view -> clearEnd());
    }

    private void clearEnd() {
        String expressionText = expView.getText().toString();
        if(expressionText.length() > 0)
            expressionText = expressionText.substring(0, expressionText.length() - 1);
        expView.setText(expressionText);
    }

    private void clearAll() {
        expView.setText("");
        resultView.setText("0");
    }

    private void evaluate() {
        String expressionText = expView.getText().toString();
        try {
            Expression expression = new ExpressionBuilder(expressionText).build();
            double result = expression.evaluate();
            String resultText = String.valueOf(result);
            if(resultText.endsWith(".0")){
                resultText = resultText.substring(0, resultText.length() - 2);
            }
            resultView.setText(resultText);
        }catch (Exception e){
            resultView.setText("Error");
        }
    }

    private void addViewTextToScreen(View view){
        MaterialButton button = (MaterialButton) view;
        String expressionText = expView.getText().toString();
        expressionText += button.getText().toString();
        expView.setText(expressionText);
    }
}