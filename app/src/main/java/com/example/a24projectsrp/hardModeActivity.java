package com.example.a24projectsrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class hardModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_mode);
        Intent hardModeIntent = getIntent();
        generateNewNums();
    }

    //Setting global vars
    public static boolean opsEntered = false;
    public static boolean numsEntered = false;

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
        if(op.equals("+") || op.equals("1")){
            return 1;
        }
        else if(op.equals("-") || op.equals("2")){
            return 2;
        }
        else if(op.equals("×") || op.equals("3")){
            return 3;
        }
        else if(op.equals("÷") || op.equals("4")){
            return 4;
        }
        else if(op.equals("^") || op.equals("5")){
            return 5;
        }
        else{
            return 0;
        }
    }

    //Function used in addNum/addOp to check if all inputs are entered and disable/enable buttons
    public void checkInputs(){
        if(numsEntered == true && opsEntered == true){
            Button btnChecker = findViewById(R.id.btnCheck);
            Button btnPlus = findViewById(R.id.btnAdd);
            Button btnMinus = findViewById(R.id.btnSub);
            Button btnTimes = findViewById(R.id.btnMult);
            Button btnDivBy = findViewById(R.id.btnDiv);
            Button btnPow = findViewById(R.id.btnPow);
            btnChecker.setEnabled(true);
            btnPlus.setEnabled(false);
            btnMinus.setEnabled(false);
            btnTimes.setEnabled(false);
            btnDivBy.setEnabled(false);
            btnPow.setEnabled(false);
        }
    }

    //Function to call in number Buttons
    public void addNum(Button btnNewNum){
        TextView txtNum1 = findViewById(R.id.txtNum1);
        TextView txtNum2 = findViewById(R.id.txtNum2);
        TextView txtNum3 = findViewById(R.id.txtNum3);
        TextView txtNum4 = findViewById(R.id.txtNum4);
        TextView[] txtNums = {txtNum1, txtNum2, txtNum3, txtNum4};
        boolean notBlank = true;
        int i = 0;
        while (notBlank && i < 4) {
            if(txtNums[i].getText().toString().equals("_")){
                notBlank = false;
                txtNums[i].setText(btnNewNum.getText());
                btnNewNum.setEnabled(false);
                if(i == 3){
                    numsEntered = true;
                }
            }
            i++;
        }
        checkInputs();
    }

    //Function to call in operation buttons
    public void addOp(Button btnNewOp){
        TextView txtOp1 = findViewById(R.id.txtOp1);
        TextView txtOp2 = findViewById(R.id.txtOp2);
        TextView txtOp3 = findViewById(R.id.txtOp3);
        TextView[] txtOps = {txtOp1, txtOp2, txtOp3};
        boolean notBlank = true;
        int i = 0;
        while (notBlank && i < 3) {
            if(txtOps[i].getText().toString().equals("_")){
                notBlank = false;
                txtOps[i].setText(btnNewOp.getText());
                if(i == 2){
                    opsEntered = true;
                }
            }
            i++;
        }
        checkInputs();
    }

    //Methods for #/operation buttons
    public void addNum1(View view){
        addNum((Button) findViewById(R.id.btnNum1));
    }

    public void addNum2(View view){
        addNum((Button) findViewById(R.id.btnNum2));
    }

    public void addNum3(View view){
        addNum((Button) findViewById(R.id.btnNum3));
    }

    public void addNum4(View view){
        addNum((Button) findViewById(R.id.btnNum4));
    }

    public void addPlus(View view){
        addOp((Button) findViewById(R.id.btnAdd));
    }

    public void addMinus(View view){
        addOp((Button) findViewById(R.id.btnSub));
    }

    public void addTimes(View view){
        addOp((Button) findViewById(R.id.btnMult));
    }

    public void addDivBy(View view){
        addOp((Button) findViewById(R.id.btnDiv));
    }

    public void addPow(View view) { addOp((Button) findViewById(R.id.btnPow)); }

    //Method for clearing textViews
    public void clearTxts(View view){
        TextView txtNum1 = findViewById(R.id.txtNum1);
        TextView txtOp1 = findViewById(R.id.txtOp1);
        TextView txtNum2 = findViewById(R.id.txtNum2);
        TextView txtOp2 = findViewById(R.id.txtOp2);
        TextView txtNum3 = findViewById(R.id.txtNum3);
        TextView txtOp3 = findViewById(R.id.txtOp3);
        TextView txtNum4 = findViewById(R.id.txtNum4);
        TextView[] txts = {txtNum1, txtOp1, txtNum2, txtOp2, txtNum3, txtOp3, txtNum4};
        for(int i = 0; i < 7; i++){
            txts[i].setText("_");
        }
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMult = findViewById(R.id.btnMult);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnPow = findViewById(R.id.btnPow);
        Button btnNum1 = findViewById(R.id.btnNum1);
        Button btnNum2 = findViewById(R.id.btnNum2);
        Button btnNum3 = findViewById(R.id.btnNum3);
        Button btnNum4 = findViewById(R.id.btnNum4);
        Button[] btns = {btnAdd, btnSub, btnMult, btnDiv, btnNum1, btnNum2, btnNum3, btnNum4, btnPow};
        for(int i = 0; i < 9; i++){
            btns[i].setEnabled(true);
        }
        Button btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setEnabled(false);
        TextView txtAnswer = findViewById(R.id.txtAnswer);
        txtAnswer.setText("");
        opsEntered = false;
        numsEntered = false;
    }

    //Check if numbers reach 24
    public void checkNums(View view){
        //Creating vars for the textboxes
        TextView txtNum1 = findViewById(R.id.txtNum1);
        TextView txtOp1 = findViewById(R.id.txtOp1);
        TextView txtNum2 = findViewById(R.id.txtNum2);
        TextView txtOp2 = findViewById(R.id.txtOp2);
        TextView txtNum3 = findViewById(R.id.txtNum3);
        TextView txtOp3 = findViewById(R.id.txtOp3);
        TextView txtNum4 = findViewById(R.id.txtNum4);
        TextView[] txtNums = {txtNum1, txtNum2, txtNum3, txtNum4};
        TextView[] txtOps = {txtOp1, txtOp2, txtOp3};

        //Converting textbox info into ints
        List<Integer> arrInts = new ArrayList<>();
        for(int i = 0; i < 4; i ++){
            arrInts.add(Integer.parseInt(txtNums[i].getText().toString()));
        }
        List<Integer> zerothOps = new ArrayList<>();
        List<Integer> firstOps = new ArrayList<>();
        List<Integer> secondOps = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            int opVal = setOpVal(txtOps[i].getText().toString());
            if (opVal == 5){
                zerothOps.add(opVal);
                firstOps.add(0);
                secondOps.add(0);
            }
            else if(opVal > 2){
                zerothOps.add(0);
                firstOps.add(opVal);
                secondOps.add(0);
            }
            else{
                zerothOps.add(0);
                firstOps.add(0);
                secondOps.add(opVal);
            }
        }

        //Raising to a Power
        for(int i = 0; i < zerothOps.size(); i++){
            if (zerothOps.get(i) != 0){
                arrInts.set(i, (int) Math.pow(arrInts.get(i), arrInts.get(i+1)));
                arrInts.remove(i+1);
                zerothOps.remove(i);
                firstOps.remove(i);
                secondOps.remove(i);
                i--;
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
        if(result == 24){
            generateNewNums();
        }
    }
}
