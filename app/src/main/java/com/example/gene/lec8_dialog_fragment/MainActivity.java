package com.example.gene.lec8_dialog_fragment;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateText = new TextView(this);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_main);
        LinearLayout childLayout = new LinearLayout(this);
        childLayout.setOrientation(LinearLayout.VERTICAL);

        childLayout.addView(dateText);
        for(int i=0; i<=9; i++){
            Button bttn = new Button(this);
            bttn.setText("" + i);
            bttn.setWidth(30);
            bttn.setHeight(10);
            bttn.setOnClickListener(new Listener());

            childLayout.addView(bttn);
        }
        linearLayout.addView(childLayout);

    }
    class Listener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            String str = ((Button)view).getText().toString();
            Toast.makeText(MainActivity.this, "You clicked this " + str, Toast.LENGTH_LONG).show();

            switch(str){
                case "0":
                    AlertDialog.Builder alertBox = new AlertDialog.Builder(MainActivity.this);
                    alertBox.setTitle("Alert when click");
                    alertBox.setMessage("Button one is clicked");
                    alertBox.show();
                    break;
                case "1":
                    final DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            dateText.setText(month+1+"/"+dayOfMonth+"/"+year);

                        }
                    },2017,0,1);
                    datePickerDialog.show();

            }
        }
    }


}
