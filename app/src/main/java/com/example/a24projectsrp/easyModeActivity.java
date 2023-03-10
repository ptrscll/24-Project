package com.example.a24projectsrp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.graphics.Color.rgb;

public class easyModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_easy_mode);
        super.onCreate(savedInstanceState);
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
            n1 = rand.nextInt(13) + 1;
            n2 = rand.nextInt(13) + 1;
            n3 = rand.nextInt(13) + 1;
            n4 = rand.nextInt(13) + 1;
            if((n1 + n2 + n3 + n4) == 24) {
                works = true;
            }
            else if ((n1+ n2 + n3 + n4) > 24){
                if((n1 + n2 + n3 - n4) == 24)
                    works = true;
                else if((n1 + n2 - n3 + n4) == 24)
                    works = true;
                else if((n1 - n2 + n3 + n4) == 24)
                    works = true;
                else if((n1 - n2 + n3 - n4) == 24)
                    works = true;
                else if((n1 + n2 - n3 - n4) == 24)
                    works = true;
                else if((n1 - n2 - n3 + n4) == 24)
                    works = true;
            }
        }
        Button num1 = findViewById(R.id.btnNum1);
        num1.setText(Integer.toString(n1));
        Button num2 = findViewById(R.id.btnNum2);
        num2.setText(Integer.toString(n2));
        Button num3 = findViewById(R.id.btnNum3);
        num3.setText(Integer.toString(n3));
        Button num4 = findViewById(R.id.btnNum4);
        num4.setText(Integer.toString(n4));*/

        int randNum = rand.nextInt(33) + 1;
        String ints = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    getAssets().open("easyNums.txt")));

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
            btnChecker.setEnabled(true);
            btnPlus.setEnabled(false);
            btnMinus.setEnabled(false);

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
        Button btnNum1 = findViewById(R.id.btnNum1);
        Button btnNum2 = findViewById(R.id.btnNum2);
        Button btnNum3 = findViewById(R.id.btnNum3);
        Button btnNum4 = findViewById(R.id.btnNum4);
        Button[] btns = {btnAdd, btnSub, btnNum1, btnNum2, btnNum3, btnNum4};
        for(int i = 0; i < 6; i++){
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
        List<Integer> allOps = new ArrayList<>();
        for(int i = 0; i < 3; i++)
            allOps.add(MainActivity.setOpVal(txtOps[i].getText().toString()));

        //Adding and Subtracting
        int result = arrInts.get(0);
        for(int i = 0; i < allOps.size(); i++) {
            if (allOps.get(i) == 1) {
                result += arrInts.get(i + 1);
            } else if (allOps.get(i) == 2) {
                result -= arrInts.get(i + 1);
            }
        }

        //Sending Answer to TextView
        TextView txtAnswer = findViewById(R.id.txtAnswer);
        String answer = Integer.toString(result);
        if(result == 24){
            answer += "        ???";
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
