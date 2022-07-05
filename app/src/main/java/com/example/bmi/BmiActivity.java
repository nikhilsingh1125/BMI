package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Objects;

public class BmiActivity extends AppCompatActivity {



    TextView display,category,gender;
    String bmi;
    float intbmi;

    float intHeight,intWeight;
    RelativeLayout background;
    LottieAnimationView lottie;

    String height;
    String weight;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        Objects.requireNonNull(getSupportActionBar()).setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font Color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);



        display = findViewById(R.id.display);
        category = findViewById(R.id.category);
        gender = findViewById(R.id.gender);
        background = findViewById(R.id.contentLayout);
        lottie = findViewById(R.id.lottie);
        android.widget.Button recalculate = findViewById(R.id.recalculate);


        Intent intent =getIntent();

         height = intent.getStringExtra("height");
         weight = intent.getStringExtra("weight");

         intHeight = Float.parseFloat(height);
         intWeight = Float.parseFloat(weight);

         intHeight = intHeight/100;
         intbmi = intWeight/(intHeight*intHeight);

         bmi = Float.toString(intbmi);
         display.setText(bmi);




        if (intbmi<16){
            category.setText("Severe thinness");
            background.setBackgroundColor(Color.RED);
            lottie.setAnimation(R.raw.cross);
            lottie.playAnimation();
        }
        else if (intbmi<16.9 && intbmi>16){
            category.setText("Moderate thinness");
            background.setBackgroundColor(Color.RED);
            lottie.setAnimation(R.raw.cross);
            lottie.playAnimation();
        }
        else if (intbmi<18.4 && intbmi>17){
            category.setText("Mild thinness");
            background.setBackgroundColor(Color.RED);
            lottie.setAnimation(R.raw.cross);
            lottie.playAnimation();
        }
        else if (intbmi<25 && intbmi>18.4){
            category.setText("Normal");
          //  background.setBackgroundColor(Color.GREEN);
            lottie.setAnimation(R.raw.right);
            lottie.playAnimation();
        }
        else if (intbmi<29.4 && intbmi>25){
            category.setText("Overweight");
            background.setBackgroundColor(Color.RED);
            lottie.setAnimation(R.raw.cross);
            lottie.playAnimation();
        }
        else {
            category.setText("Obese Class 1");
            background.setBackgroundColor(Color.RED);
            lottie.setAnimation(R.raw.cross);
            lottie.playAnimation();

        }
        gender.setText(intent.getStringExtra("gender"));


        recalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BmiActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}