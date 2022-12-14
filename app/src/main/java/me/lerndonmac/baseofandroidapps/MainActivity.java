package me.lerndonmac.baseofandroidapps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView qounterView;
    private TextView priceTextView;
    private int price = 0;
    private int qounter = 0;
    private String massage;
    private boolean check1 = false;
    private boolean check2 = false;
    private boolean check3 = false;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qounterView = findViewById(R.id.qounterTextView);
        priceTextView = findViewById(R.id.PriceTextView);
        Button buttonOrder = findViewById(R.id.buttonOrder);
        Button plussBut = findViewById(R.id.buttonPluss);
        Button minBut = findViewById(R.id.buttonMinus);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox1);
        checkBox3 = findViewById(R.id.checkBox2);

        plussBut.setOnClickListener(view -> increment());
        minBut.setOnClickListener(view -> dicremint());
        buttonOrder.setOnClickListener(view -> displayPrice(qounter));
        checkBox1.setOnClickListener(view -> check1 = !check1);
        checkBox2.setOnClickListener(view -> check2 = !check2);
        checkBox3.setOnClickListener(view -> check3 = !check3);
    }
    private void increment(){
        qounter += 1;
        qounterView.setText(String.valueOf(qounter));
    }
    private void dicremint(){
        if ((qounter>=1)) {
            qounter -= 1;
            qounterView.setText(String.valueOf(qounter));
        }else {

            Toast.makeText(this,"значение не может быть меньше 0", Toast.LENGTH_LONG).show();
        }
    }
    @SuppressLint("SetTextI18n")
    private void displayPrice(int qounter){
        price = 5;
        if (check1){price += 1;}
        if (check2){price += 2;}
        if (check3){price += 5;}
        if (qounter == 0){
            massage = "Free";
        }else {
            massage = "Total price : $"+qounter*price+"\n Thanks for order";
        }
        priceTextView.setText(massage);
    }
}