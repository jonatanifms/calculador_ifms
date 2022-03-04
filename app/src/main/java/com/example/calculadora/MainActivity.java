package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText e1, e2;
    TextView t1;
    Button sum, div, mul, sub;
    double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sum = findViewById(R.id.sum);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        sum.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
    }

    public boolean getNumbers() {
        e1 = (EditText) findViewById(R.id.num1);
        e2 = (EditText) findViewById(R.id.num2);
        t1 = (TextView) findViewById(R.id.result);

        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();

        if ((s1.equals(null) && s2.equals(null)) || (s1.equals("") && s2.equals(""))) {
            Toast.makeText(this, "Por favor insira um valor!", Toast.LENGTH_SHORT).show();

            return false;
        } else {
            num1 = Double.parseDouble(s1);
            num2 = Double.parseDouble(s2);
        }

        return true;
    }

    public void doSum(View v) {
        if (getNumbers()) {
            double sum = num1 + num2;
            t1.setText(String.format("%.2f", sum));
        }
    }

    public void doSub(View v) {
        if (getNumbers()) {
            double sum = num1 - num2;
            t1.setText(String.format("%.2f", sum));
        }
    }

    public void doMul(View v) {
        if (getNumbers()) {
            double sum = num1 * num2;
            t1.setText(String.format("%.2f", sum));
        }
    }

    public void doDiv(View v) {
        if (getNumbers()) {
            if (num1 == 0 || num2 == 0) {
                Toast.makeText(this, "Não é possivel fazer divisão por 0!", Toast.LENGTH_SHORT).show();
            } else {
                double sum = num1 / (num2 * 1.0);
                t1.setText(String.format("%.2f", sum));
            }
        }
    }

    public void clearAll(View v) {
        e1.setText("");
        e2.setText("");
        t1.setText("");
    }

    public void changeScreen(View v) {
        Intent intent = new Intent(this, OutherActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sum:
                this.doSum(v);
                break;
            case R.id.sub:
                this.doSub(v);
                break;
            case R.id.mul:
                this.doMul(v);
                break;
            case R.id.div:
                this.doDiv(v);
                break;
        }
    }
}