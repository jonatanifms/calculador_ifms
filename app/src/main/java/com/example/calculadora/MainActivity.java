package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    TextView t1;
    double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // a public method to get the input numbers
    public boolean getNumbers() {

        e1 = (EditText) findViewById(R.id.num1);

        e2 = (EditText) findViewById(R.id.num2);

        t1 = (TextView) findViewById(R.id.result);

        String s1 = e1.getText().toString();

        String s2 = e2.getText().toString();

        // condition to check if box is not empty
        if ((s1.equals(null) && s2.equals(null)) || (s1.equals("") && s2.equals(""))) {

            String result = "Por favor insira um valor!";
            t1.setText(result);

            return false;
        } else {
            num1 = Double.parseDouble(s1);

            num2 = Double.parseDouble(s2);
        }

        return true;
    }

    // a public method to perform addition
    public void doSum(View v) {

        // get the input numbers
        if (getNumbers()) {
            double sum = num1 + num2;
            t1.setText(Double.toString(sum));
        }
    }

    // a public method to perform power function
    public void doPow(View v) {

        // get the input numbers
        if (getNumbers()) {
            double sum = Math.pow(num1, num2);
            t1.setText(Double.toString(sum));
        }
    }

    // a public method to perform subtraction
    public void doSub(View v) {

        // get the input numbers
        if (getNumbers()) {
            double sum = num1 - num2;
            t1.setText(Double.toString(sum));
        }
    }

    public void doMul(View v) {
        if (getNumbers()) {
            double sum = num1 * num2;
            t1.setText(Double.toString(sum));
        }
    }

    public void doDiv(View v) {

        // get the input numbers
        if (getNumbers()) {

            // displaying the text in text view assigned as t1
            double sum = num1 / (num2 * 1.0);
            t1.setText(Double.toString(sum));
        }
    }

    // a public method to perform modulus function
    public void doMod(View v) {

        // get the input numbers
        if (getNumbers()) {
            double sum = num1 % num2;
            t1.setText(Double.toString(sum));
        }
    }
}