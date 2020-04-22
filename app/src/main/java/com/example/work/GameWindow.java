package com.example.work;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

public class GameWindow extends AppCompatActivity {
    private EditText enter ;
    private Button option1 ;
    private Button option2;
    private Button option3 ;
    private Button go ;
    private Button exit ;
    private Button reset ;
    private TextView   res;
    private List<Integer> correct;       //correct answers
    private List<Integer> incorrect;      //wrong answers
    private List<Integer> l;            // for 3 option buttons
    private List<Integer> c;                // for displaying correct answer



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_window);

        enter = findViewById(R.id.et1);
        go= findViewById(R.id.btnGo);
        exit = findViewById(R.id.btnExit);
        reset = findViewById(R.id.btnReset);
        option1 =  findViewById(R.id.btn1);
        option2 =  findViewById(R.id.btn2);
        option3 =  findViewById(R.id.btn3);
        res = findViewById(R.id.textView);

        correct = new ArrayList<>();
        incorrect = new ArrayList<>();
        l =  new ArrayList<>();
        c =  new ArrayList<>();


        exit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
               // finish();
                finishAffinity();
                //System.exit(0);
            }
        });







        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              int entered_num = Integer.parseInt(enter.getText().toString());
              boolean fst=FirstCheck(entered_num);
              if(fst) {
             // correct.add(entered_num);
                  Factors(entered_num);
                  Random random = new Random();
                  int f = random.nextInt(correct.size());
                  int g=1;
                  int h=1;
                  while(g==h) {
                      g = random.nextInt(incorrect.size());
                      h = random.nextInt(incorrect.size());
                  }
                  l.add(incorrect.get(g));
                  l.add(incorrect.get(h));
                  l.add(correct.get(f));

                  c.add(correct.get(f));

                  Collections.shuffle(l);

                  option1.setText(Integer.toString(l.get(1)));
                  option2.setText(Integer.toString(l.get(0)));
                  option3.setText(Integer.toString(l.get(2)));
                //  Toast.makeText(GameWindow.this, "" + entered_num, Toast.LENGTH_SHORT).show();
              }
            }
        });


            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int entered_num = Integer.parseInt(enter.getText().toString());
                  int q =Integer.parseInt( option1.getText().toString());
                   Check(entered_num,q);
                 //  Toast.makeText(GameWindow.this, ""+b, Toast.LENGTH_SHORT).show();
                   // res.setText(""+Boolean.toString(b));
                }
            });


        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int entered_num = Integer.parseInt(enter.getText().toString());
                int q =Integer.parseInt( option2.getText().toString());
                 Check(entered_num,q);

              // Toast.makeText(GameWindow.this, ""+b, Toast.LENGTH_SHORT).show();
               // res.setText(""+Boolean.toString(b));


            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int entered_num = Integer.parseInt(enter.getText().toString());
                int q =Integer.parseInt( option3.getText().toString());
                Check(entered_num,q);
              // Toast.makeText(GameWindow.this, ""+b, Toast.LENGTH_SHORT).show();
                // res.setText(""+Boolean.toString(b) );


            }
        });


            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    enter.setText("");
//                    option1.setText("-__-");
//                    option3.setText("-__-");
//                    option2.setText("-__-");
                    if (v==reset) {
                        startActivity(new Intent(GameWindow.this ,GameWindow.class));
                    }
                }
            });















    }

private boolean FirstCheck(int number ){
        if(number<=5){
                Toast.makeText(this, "Enter a number greater than 5", Toast.LENGTH_SHORT).show();
                return false;
            }else{
               return true;
        }
}



 private void Factors(int n){
        for(int i=1;i<=n;i++){
            if(n%i==0){
                correct.add(i);
            }else{
                incorrect.add(i);
            }
        }
 }


 private void Check(int num,int i){

        if (num%i==0){
            res.setText("Right Answer");

        }else{
            res.setText("Wrong Answer! Right Answer is "+Integer.toString(c.get(0)));


        }
 }

}

