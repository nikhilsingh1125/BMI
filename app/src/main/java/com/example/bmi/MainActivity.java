package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    TextView currentHeight,currentAge,currentWeight;
    ImageView incrementAge,incrementWeight,decrementWeight,decrementAge;
    SeekBar seekBarHeight;
    RelativeLayout male,female;

    int weight1 =55;
    int age1=22;
    int currentProgress;
    String intprogress = "170";
    String typeOfUser ="0";
    String weight2="55";
    String age2 = "22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =findViewById(R.id.toolbar);
        toolbar.setTitle("BMI");
        setSupportActionBar(toolbar);

        android.widget.Button btncalculate = findViewById(R.id.calculate);
        currentHeight = findViewById(R.id.currentHeight);
        currentWeight = findViewById(R.id.currentWeight);
        currentAge = findViewById(R.id.currentAge);
        incrementWeight = findViewById(R.id.increment);
        incrementAge = findViewById(R.id.agePlus);
        decrementWeight = findViewById(R.id.decrement);
        decrementAge = findViewById(R.id.ageMinus);
        male = findViewById(R.id.male);
        female= findViewById(R.id.female);
        seekBarHeight = findViewById(R.id.seekBarHeight);

        /*
        btncalculate=(Button)findViewById(R.id.calculate);
        currentHeight.findViewById(R.id.currentHeight);
        currentAge.findViewById(R.id.currentAge);
        currentWeight.findViewById(R.id.currentWeight);
        incrementAge.findViewById(R.id.agePlus);
        decrementAge.findViewById(R.id.ageMinus);
        incrementWeight.findViewById(R.id.increment);
        decrementWeight.findViewById(R.id.decrement);
        seekBarHeight.findViewById(R.id.seekBarHeight);
        male.findViewById(R.id.male);
        female.findViewById(R.id.female);
*/



        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.genderfocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.gendernotfocus));
                typeOfUser="Male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.genderfocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.gendernotfocus));
                typeOfUser="Female";
            }
        });

        seekBarHeight.setMax(300);
        seekBarHeight.setProgress(170);
        seekBarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                currentProgress=progress;
                intprogress = String.valueOf(currentProgress);
                currentHeight.setText(intprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        incrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age1 = age1+1;
                age2 = String.valueOf(age1);
                currentAge.setText(age2);
            }
        });

        decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age1 = age1-1;
                age2 = String.valueOf(age1);
                currentAge.setText(age2);
            }
        });

        incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight1 = weight1+1;
                weight2 = String.valueOf(weight1);
                currentWeight.setText(weight2);
            }
        });

        decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight1 = weight1-1;
                weight2 = String.valueOf(weight1);
                currentWeight.setText(weight2);
            }
        });

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (typeOfUser.equals("0")){
                    Toast.makeText(MainActivity.this, "Select Your Gender First", Toast.LENGTH_SHORT).show();
                }
                else if (intprogress.equals("0")){
                    Toast.makeText(MainActivity.this, "Select Your Height First", Toast.LENGTH_SHORT).show();
                }
                else if (age1==0 || age1<0){
                    Toast.makeText(MainActivity.this, "Age is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else if (weight1==0 || weight1<0){
                    Toast.makeText(MainActivity.this, "Weight is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this,BmiActivity.class);
                    intent.putExtra("gender",typeOfUser);
                    intent.putExtra("height",intprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);

                }


            }
        });

    }
}