package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvtext,tvresult;
    EditText et_text;
    String fullStory;
    long Starttime,endtime;

    boolean gamestarted=false;
    Button b_new;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvtext=(TextView) findViewById(R.id.tv1);
        tvresult=(TextView)findViewById(R.id.tv2);
        et_text=(EditText)findViewById(R.id.et1);
        b_new=(Button)findViewById(R.id.b_new);


        fullStory = tvtext.getText().toString();

        et_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String currentStory = et_text.getText().toString();

                if(currentStory.length() == 1 && !gamestarted)
                {
                    Starttime= System.currentTimeMillis();
                    tvresult.setText("Started");
                    gamestarted = true;


                }
                if(currentStory.equals(fullStory))
                {
                    endtime = System.currentTimeMillis();

                    long currenttime= (endtime-Starttime)/1000;
                    tvresult.setText("Finished in"+currenttime+"Seconds");
                    et_text.setEnabled(false);
                    et_text.clearFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        b_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_text.setEnabled(true);
                et_text.setText("");
                tvresult.setText("");
                gamestarted=false;
            }
        });
    }
}