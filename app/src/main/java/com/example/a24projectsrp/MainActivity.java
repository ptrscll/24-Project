package com.example.a24projectsrp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getMainInfo(View view){
        Intent mainHelpIntent = new Intent(this, MainInfoActivity.class);
        startActivity(mainHelpIntent);
    }
    public void goToLevels(View view){
        Intent levelMenuIntent = new Intent(this, levelMenuActivity.class);
        startActivity(levelMenuIntent);
    }
    public void goToCasualMenu(View view){
        Intent casualMenuIntent = new Intent(this, casualMenuActivity.class);
        startActivity(casualMenuIntent);
    }

    //All of the remaining methods are used in the game modes' code
    //This is for checkNums in the game modes to help convert operations into ints
    public static int setOpVal(String op){
        switch (op){
            case "+":
                return 1;
            case "-":
                return 2;
            case "×":
                return 3;
            case "÷":
                return 4;
            case "^":
                return 5;
        }
        return 0;
    }

    //The next 3 methods are all modified from https://www.geeksforgeeks.org/expression-evaluation/
    //This method takes arrays of the numbers and operations entered and finds what they combine to
    public static double evaluate(double[] numbers, int[] operations){
        //Declaring Stacks
        Stack<Double> nums = new Stack<>();
        Stack<Integer> ops = new Stack<>();

        //Adding numbers and operations to stacks
        nums.push(numbers[0]);
        for (int i = 0; i < 3; i++){

            //Performing earlier operations if they have precedence over the new operation
            while (!ops.empty() && hasPrecedence(operations[i], ops.peek()))
                nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));

            //Adding next number and operation
            ops.push(operations[i]);
            nums.push(numbers[i+1]);
        }

        //Performing remaining operations and returning reuslt
        while (!ops.empty())
            nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
        return nums.pop();
    }

    // This method determines if the first operation comes before the second in order of operations
    public static boolean hasPrecedence(int op1, int op2) {
        return !(((op1 == 3 || op1 == 4) && (op2 == 1 || op2 == 2)) || ((op1 == 5) && (op2 != 5)));
    }

    // This method is used to perform an operation on two numbers from an integer operation
    public static double applyOp(int op, double b, double a) {
        switch (op) {
            case 1:
                return a + b;
            case 2:
                return a - b;
            case 3:
                return a * b;
            case 4:
                return a / b;
            case 5:
                return Math.pow(a, b);
        }
        return 0;
    }

}
