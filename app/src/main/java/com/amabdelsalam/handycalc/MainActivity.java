package com.amabdelsalam.handycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Boolean mIsOperation;
    private String mScreen;
    private String mMemory;
    private String mOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIsOperation = false;
    }

    private void updateScreen(String value){
        EditText screen = (EditText) findViewById(R.id.textFieldScreen);
        if (mIsOperation == false) {
            mScreen = screen.getText().toString();

            if (mScreen.equals("0")) {
                mScreen = value;
            } else {
                mScreen = mScreen + value;
            }

            screen.setText(mScreen);
        }else{
            mScreen = value;
            screen.setText(mScreen);
            mIsOperation = false;
        }
    }

    private void setScreen(String digit){
        EditText screen = (EditText) findViewById(R.id.textFieldScreen);
        screen.setText(digit);
        mIsOperation = false;
    }

    public void zeroClicked(View view){
        updateScreen("0");
    }

    public void oneClicked(View view){
        updateScreen("1");

    }

    public void twoClicked(View view){
        updateScreen("2");

    }

    public void threeClicked(View view){
        updateScreen("3");

    }

    public void fourClicked(View view){
        updateScreen("4");

    }

    public void fiveClicked(View view){
        updateScreen("5");
    }

    public void sixClicked(View view){
        updateScreen("6");
    }

    public void sevenClicked(View view){
        updateScreen("7");
    }

    public void eightClicked(View view){
        updateScreen("8");
    }

    public void nineClicked(View view){
        updateScreen("9");
    }

    public void plusClicked(View view){
        mMemory = mScreen;
        mIsOperation = true;
        mOperation = "Add";

    }

    public void minusClicked(View view){
        mMemory = mScreen;
        mIsOperation = true;
        mOperation = "Subtract";
    }

    public void multiplyClicked(View view){
        mMemory = mScreen;
        mIsOperation = true;
        mOperation = "Multiply";
    }

    public void divideClicked(View view){
        mMemory = mScreen;
        mIsOperation = true;
        mOperation = "Divide";
    }

    public void equalClicked(View view){
        mIsOperation = true;
        int screen = Integer.parseInt(mScreen);
        int memory = Integer.parseInt(mMemory);
        if (mOperation.equals("Add")){
            updateScreen(Integer.toString(screen + memory));
        }else if (mOperation.equals("Subtract")){
            updateScreen(Integer.toString(screen - memory));
        }else if(mOperation.equals("Multiply")){
            updateScreen(Integer.toString(screen * memory));
        }else if(mOperation.equals("Divide")){
            if (memory != 0) {
                updateScreen(Integer.toString(screen / memory));
            }else{
                updateScreen("ERROR");
            }
        }

        mMemory = "";

    }

    public void cClicked(View view){
        mScreen = "";
        mMemory = "";
        updateScreen("0");

    }
}
