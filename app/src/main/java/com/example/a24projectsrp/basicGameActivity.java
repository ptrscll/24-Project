package com.example.a24projectsrp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import static android.graphics.Color.rgb;

public class basicGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_game);
        generateNewNums();
    }

    //Setting global vars
    public static boolean opsEntered = false;
    public static boolean numsEntered = false;

    public void generateNewNums(){
        Random rand = new Random();
        /*boolean works = false;
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while(!works){

            //Generating new numbers
            n1 = rand.nextInt(13) + 1;
            n2 = rand.nextInt(13) + 1;
            n3 = rand.nextInt(13) + 1;
            n4 = rand.nextInt(13) + 1;
            double[] arrNums = {(double) n1, (double) n2, (double) n3, (double) n4};

            //Checking if they can produce a solution by checking all permutations of operations
            for(int op1 = 1; op1 <= 4; op1++){
                for(int op2 = 1; op2 <= 4; op2++){
                    for(int op3 = 1; op3 <= 4; op3++){
                        int arrOps [] = {op1, op2, op3};
                        if (MainActivity.evaluate(arrNums, arrOps) == 24.0)
                            works = true;
                    }
                }
            }
        }*/
        int randNum = rand.nextInt(34) + 1;
        String ints = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    getAssets().open("normalNums.txt")));

            // do reading, usually loop until end of file reading
            for(int i = 0; i < randNum; i++)
                ints = reader.readLine();
            reader.close();
        } catch (IOException e) {

        }
        String[] strValArr = ints.split(" ");
        int[] intValArr = new int[4];
        for(int i = 0; i < 4; i++)
            intValArr[i] = Integer.parseInt(strValArr[i]);
        //Adding correct numbers to buttons
        Button num1 = findViewById(R.id.btnNum1);
            num1.setText(Integer.toString(intValArr[0]));
        Button num2 = findViewById(R.id.btnNum2);
            num2.setText(Integer.toString(intValArr[1]));
        Button num3 = findViewById(R.id.btnNum3);
            num3.setText(Integer.toString(intValArr[2]));
        Button num4 = findViewById(R.id.btnNum4);
            num4.setText(Integer.toString(intValArr[3]));
    }

    //Function used in addNum/addOp to check if all inputs are entered and disable/enable buttons
    public void checkInputs(){
        if(numsEntered && opsEntered){
            Button btnChecker = findViewById(R.id.btnCheck);
            Button btnPlus = findViewById(R.id.btnAdd);
            Button btnMinus = findViewById(R.id.btnSub);
            Button btnTimes = findViewById(R.id.btnMult);
            Button btnDivBy = findViewById(R.id.btnDiv);
            btnChecker.setEnabled(true);
            btnPlus.setEnabled(false);
            btnMinus.setEnabled(false);
            btnTimes.setEnabled(false);
            btnDivBy.setEnabled(false);

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
        Button btnNum1 = findViewById(R.id.btnNum1);
        Button btnNum2 = findViewById(R.id.btnNum2);
        Button btnNum3 = findViewById(R.id.btnNum3);
        Button btnNum4 = findViewById(R.id.btnNum4);
        Button[] btns = {btnAdd, btnSub, btnMult, btnDiv, btnNum1, btnNum2, btnNum3, btnNum4};
        for(int i = 0; i < 8; i++){
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

        //Converting textbox info into arrays
        double[] arrNums = {0, 0, 0, 0};
        for(int i = 0; i < 4; i ++)
            arrNums[i] = Double.parseDouble(txtNums[i].getText().toString());

        int[] arrOps = {0, 0, 0};
        for(int i = 0; i < 3; i++)
            arrOps[i] = MainActivity.setOpVal(txtOps[i].getText().toString());

        //Evaluating operations and numbers
        double result = MainActivity.evaluate(arrNums, arrOps);

        //Sending answer to textview
        TextView txtAnswer = findViewById(R.id.txtAnswer);
        String answer;
        if(result == Math.floor(result))
            answer = Integer.toString((int)result);
        else
            answer = Double.toString(Math.round(result*1000.0)/1000.0);
        if(result == 24.0){
            answer += "        ✓";
            txtAnswer.setTextColor(rgb(0, 255, 0));
            generateNewNums();
            Button btnCheck = findViewById(R.id.btnCheck);
            btnCheck.setEnabled(false);
        }
        else{
            answer += "        X";
            txtAnswer.setTextColor(rgb(255, 0, 0));
        }
        txtAnswer.setText(answer);
    }
}
