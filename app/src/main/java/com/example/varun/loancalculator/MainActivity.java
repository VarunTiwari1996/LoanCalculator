package com.example.varun.loancalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


public void calculate(View view){
    EditText Salary_text = (EditText)findViewById(R.id.Enter_Your_Salary);
    EditText Months_text = (EditText)findViewById(R.id.Enter_No_of_Months);
    EditText loan_amount_text = (EditText)findViewById(R.id.Enter_the_Loan_Amount);
    EditText interest_rate_text = (EditText)findViewById(R.id.Enter_Your_Salary);

    if(isEmpty(Salary_text)){
        Toast toast = Toast.makeText(this, "Salary can't be empty!", Toast.LENGTH_LONG);
        toast.show();
        return;
    }

    if(inputCheck(Salary_text)){
        Toast toast = Toast.makeText(this, "Enter valid salary!", Toast.LENGTH_LONG);
        toast.show();
        return;
    }

    if(isEmpty(loan_amount_text)){
        Toast toast = Toast.makeText(this, "Loan Amount can't be empty!", Toast.LENGTH_LONG);
        toast.show();
        return;
    }

    if(inputCheck(loan_amount_text)){
        Toast toast = Toast.makeText(this, "Enter valid Loan Amount!", Toast.LENGTH_LONG);
        toast.show();
        return;
    }

    if(isEmpty(interest_rate_text)){
        Toast toast = Toast.makeText(this, "Interest Rate can't be empty!", Toast.LENGTH_LONG);
        toast.show();
        return;
    }

    if(inputCheck(interest_rate_text)){
        Toast toast = Toast.makeText(this, "Enter valid Interest rate!", Toast.LENGTH_LONG);
        toast.show();
        return;
    }

    if(isEmpty(Months_text)){
        Toast toast = Toast.makeText(this, "Months can't be empty!", Toast.LENGTH_LONG);
        toast.show();
        return;
    }

    double salary = Double.parseDouble(Salary_text.getText().toString());
    double loanAmount = Double.parseDouble(loan_amount_text.getText().toString());
    double interestRate = Double.parseDouble(interest_rate_text.getText().toString());
    int months = Integer.parseInt(Months_text.getText().toString());

    double emi = 0;
    interestRate = interestRate *(12.0/100);

    emi = (loanAmount * interestRate) * (pow((1.0+interestRate),months)/((pow((1.0+interestRate),months))-1.0));

    double eligible_salary = salary * (20.0/100);


    final double emi_final = emi;


    Button more = (Button) findViewById(R.id.submit);
    more.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("EMI Amount");
            alertDialog.setMessage("EMI: Rs." + new DecimalFormat("##.##").format(emi_final));

            alertDialog.setButton("OK",new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){

                        }
                    }

            );

            alertDialog.show();

        }
    });



}

    private double pow(double x, int y) {
        double result = x;
        for (int i = 0; i < y; i++) {
            result = result * x *1.0;
        }
        return result;
    }

    private boolean isEmpty(EditText myeditText){
        return myeditText.getText().toString().trim().length() == 0;
    }

    private boolean inputCheck(EditText myeditText){
        if(myeditText.getText().toString().equals(".")){
            return true;
        }
        else{
            return false;
        }

    }


}