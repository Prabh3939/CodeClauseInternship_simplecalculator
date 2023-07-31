package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView display;
    private String currentNumber;
    private double operand1;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        currentNumber = "";
        operand1 = 0;
        operator = "";

        Button btnZero = findViewById(R.id.btn_zero);
        Button btnzerozero=findViewById(R.id.btn_zerozero);
        Button btnOne = findViewById(R.id.btn_one);
        Button btnTwo = findViewById(R.id.btn_two);
        Button btnThree = findViewById(R.id.btn_three);
        Button btnFour = findViewById(R.id.btn_four);
        Button btnFive = findViewById(R.id.btn_five);
        Button btnSix = findViewById(R.id.btn_six);
        Button btnSeven = findViewById(R.id.btn_seven);
        Button btnEight = findViewById(R.id.btn_eight);
        Button btnNine = findViewById(R.id.btn_nine);
        Button btnDot = findViewById(R.id.btn_dot);
        Button btnEquals = findViewById(R.id.btn_equals);
        Button btnPlus = findViewById(R.id.btn_plus);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnMultiply = findViewById(R.id.btn_multiply);
        Button btnDivide = findViewById(R.id.btn_divide);
        Button btnClear = findViewById(R.id.btn_clear);

        btnZero.setOnClickListener(this);
        btnzerozero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zero:
                updateDisplay("0");
                break;
            case R.id.btn_one:
                updateDisplay("1");
                break;
            case R.id.btn_two:
                updateDisplay("2");
                break;
            case R.id.btn_three:
                updateDisplay("3");
                break;
            case R.id.btn_four:
                updateDisplay("4");
                break;
            case R.id.btn_five:
                updateDisplay("5");
                break;
            case R.id.btn_six:
                updateDisplay("6");
                break;
            case R.id.btn_seven:
                updateDisplay("7");
                break;
            case R.id.btn_eight:
                updateDisplay("8");
                break;
            case R.id.btn_nine:
                updateDisplay("9");
                break;
            case R.id.btn_zerozero:
                updateDisplay("00");
                break;
            case R.id.btn_dot:
                if (!currentNumber.contains(".")) {
                    updateDisplay(".");
                }
                break;
            case R.id.btn_equals:
                calculateResult();
                break;
            case R.id.btn_plus:
                setOperator("+");
                break;
            case R.id.btn_minus:
                setOperator("-");
                break;
            case R.id.btn_multiply:
                setOperator("*");
                break;
            case R.id.btn_divide:
                setOperator("/");
                break;
            case R.id.btn_clear:
                clearDisplay();
                break;
        }
    }

    private void updateDisplay(String digit) {
        currentNumber += digit;
        display.setText(currentNumber);
    }

    private void calculateResult() {
        double result = 0;
        double operand2 = Double.parseDouble(currentNumber);

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }

        display.setText(String.valueOf(result));
        currentNumber = "";
        operand1 = result;
    }

    private void setOperator(String op) {
        operand1 = Double.parseDouble(currentNumber);
        operator = op;
        currentNumber = "";
    }

    private void clearDisplay() {
        display.setText("");
        currentNumber = "";
        operand1 = 0;
        operator = "";
    }
}
