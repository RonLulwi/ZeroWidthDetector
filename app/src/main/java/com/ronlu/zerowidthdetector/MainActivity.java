package com.ronlu.zerowidthdetector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText main_EDT_input;
    private AppCompatButton main_BTN_submit;
    private TextView main_LBL_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initViews();

    }

    private void findViews() {
        main_EDT_input = findViewById(R.id.main_EDT_input);
        main_BTN_submit = findViewById(R.id.main_BTN_submit);
        main_LBL_result = findViewById(R.id.main_LBL_result);
    }

    private void initViews() {
        main_BTN_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findWZ(main_EDT_input.getText()+"");
            }
        });

    }

    private void findWZ(String input){
        char[] inputAsChar = input.toCharArray();
        StringBuffer result =new StringBuffer();
        for (int i = 0; i < inputAsChar.length; i++) {
            switch (inputAsChar[i]){
                case '\u200A':
                case '\u200D':
                case '\u200B':
                case '\u200C':
                    result.append("🔴");
                    break;
                default:
                    result.append(inputAsChar[i]);
                    break;
            }
        }
        main_LBL_result.setText(result);

    }

//    str = str.replace("\\u200a","00");
//    str = str.replace("\\u200b","01");
//    str = str.replace("\\u200c","10");
//    str = str.replace("\\u200d","11");
}