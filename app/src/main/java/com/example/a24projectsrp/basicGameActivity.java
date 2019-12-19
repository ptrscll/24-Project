package com.example.a24projectsrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class basicGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_game);
        Intent baseGameIntent = getIntent();
        generateNewNums();
    }

    public void generateNewNums(){
        Random rand = new Random();
        Button num1 = (Button)findViewById(R.id.btnNum1);
        num1.setText(Integer.toString(rand.nextInt(13) + 1));
        Button num2 = (Button)findViewById(R.id.btnNum2);
        num2.setText(Integer.toString(rand.nextInt(13) + 1));
        Button num3 = (Button)findViewById(R.id.btnNum3);
        num3.setText(Integer.toString(rand.nextInt(13) + 1));
        Button num4 = (Button)findViewById(R.id.btnNum4);
        num4.setText(Integer.toString(rand.nextInt(13) + 1));
    }

    //This is for checkNums to help convert operations into ints
    public int setOpVal(String op){
        if(op == "+" || op == "1"){
            return 1;
        }
        else if(op == "-" || op == "2"){
            return 2;
        }
        else if(op =="×" || op == "3"){
            return 3;
        }
        else if(op == "÷" || op == "4"){
            return 4;
        }
        else{
            return 0;
        }
    }
    public void checkNums(View view){
        //Creating vars for the textboxes
        EditText txtNum1 = (EditText)findViewById(R.id.txtNum1);
        EditText txtOp1 = (EditText)findViewById(R.id.txtOp1);
        EditText txtNum2 = (EditText)findViewById(R.id.txtNum2);
        EditText txtOp2 = (EditText)findViewById(R.id.txtOp2);
        EditText txtNum3 = (EditText)findViewById(R.id.txtNum3);
        EditText txtOp3 = (EditText)findViewById(R.id.txtOp3);
        EditText txtNum4 = (EditText)findViewById(R.id.txtNum4);
        EditText[] txtNums = {txtNum1, txtNum2, txtNum3, txtNum4};
        EditText[] txtOps = {txtOp1, txtOp2, txtOp3};

        //Converting textbox info into ints
        List<Integer> arrInts = new ArrayList<>();
        for(int i = 0; i < 4; i ++){
            arrInts.add(Integer.parseInt(txtNums[i].getText().toString()));
        }
        List<Integer> firstOps = new ArrayList<>();
        List<Integer> secondOps = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            int opVal = setOpVal(txtOps[i].toString());
            if(opVal > 2){
                firstOps.add(opVal);
                secondOps.add(0);
            }
            else{
                firstOps.add(0);
                secondOps.add(opVal);
            }
        }

        //Multiplying and Dividing
        for(int i = 0; i < firstOps.size(); i++){
            if (firstOps.get(i) != 0){
                if(firstOps.get(i) == 3) {
                    arrInts.set(i, arrInts.get(i) * arrInts.get(i + 1));
                }
                else if(firstOps.get(i) == 4){
                    arrInts.set(i, arrInts.get(i)/arrInts.get(i+1));
                }
                arrInts.remove(i+1);
                firstOps.remove(i);
                secondOps.remove(i);
                i--;
            }
        }

        //Adding and Subtracting
        int result = arrInts.get(0);
        for(int i = 0; i < secondOps.size(); i++) {
            if (secondOps.get(i) == 1) {
                result += arrInts.get(i + 1);
            } else if (secondOps.get(i) == 2) {
                result -= arrInts.get(i + 1);
            }
        }
        TextView txtAnswer = (TextView) findViewById(R.id.txtAnswer);
        txtAnswer.setText(Integer.toString(result));

        //FOR DEBUGGING
        if(firstOps.get(0) == 0){
            txtAnswer.setText(txtOp1.getText().toString());
        }

        if(result == 24){
            generateNewNums();
        }
    }
}
