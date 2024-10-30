package com.example.calculatorius;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView txtDisplay;
    private StringBuilder input = new StringBuilder();
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplay = findViewById(R.id.txtDisplay);
        findViewById(R.id.btn0).setOnClickListener(v -> appendNumber("0"));
        findViewById(R.id.btn1).setOnClickListener(v -> appendNumber("1"));
        findViewById(R.id.btn2).setOnClickListener(v -> appendNumber("2"));
        findViewById(R.id.btn3).setOnClickListener(v -> appendNumber("3"));
        findViewById(R.id.btn4).setOnClickListener(v -> appendNumber("4"));
        findViewById(R.id.btn5).setOnClickListener(v -> appendNumber("5"));
        findViewById(R.id.btn6).setOnClickListener(v -> appendNumber("6"));
        findViewById(R.id.btn7).setOnClickListener(v -> appendNumber("7"));
        findViewById(R.id.btn8).setOnClickListener(v -> appendNumber("8"));
        findViewById(R.id.btn9).setOnClickListener(v -> appendNumber("9"));
        findViewById(R.id.btnDecimal).setOnClickListener(v -> appendNumber("."));

        findViewById(R.id.btnAdd).setOnClickListener(v -> setOperator("+"));
        findViewById(R.id.btnSubtract).setOnClickListener(v -> setOperator("-"));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> setOperator("*"));
        findViewById(R.id.btnDivide).setOnClickListener(v -> setOperator("/"));

        findViewById(R.id.btnEquals).setOnClickListener(v -> calculate());
        findViewById(R.id.btnClear).setOnClickListener(v -> clearDisplay());
        findViewById(R.id.btnDelete).setOnClickListener(v -> deleteLastCharacter());
        findViewById(R.id.btnSignChange).setOnClickListener(v -> changeSign());
    }

    private void appendNumber(String number) {
        input.append(number);
        txtDisplay.setText(input.toString());
    }

    private void setOperator(String op) {
        if (input.length() > 0) {
            firstNumber = Double.parseDouble(input.toString());
            input.setLength(0);
            operator = op;
        }
    }

    private void calculate() {
        if (input.length() > 0 && !operator.isEmpty()) {
            secondNumber = Double.parseDouble(input.toString());
            double result = 0;
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        txtDisplay.setText("Error");
                        input.setLength(0);
                        return;
                    }
                    break;
            }
            txtDisplay.setText(String.valueOf(result));
            input.setLength(0);
            input.append(result);
            operator = "";
        }
    }

    private void clearDisplay() {
        input.setLength(0);
        txtDisplay.setText("0");
        firstNumber = 0;
        secondNumber = 0;
        operator = "";
    }

    private void deleteLastCharacter() {
        if (input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
            txtDisplay.setText(input.length() > 0 ? input.toString() : "0");
        }
    }

    private void changeSign() {
        if (input.length() > 0) {
            double value = Double.parseDouble(input.toString()) * -1;
            input.setLength(0);
            input.append(value);
            txtDisplay.setText(input.toString());
        }
    }
}
