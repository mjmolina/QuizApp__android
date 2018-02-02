package com.example.mariajosemolina.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button_start = (Button) findViewById(R.id.Start);
        final Button button_exit = (Button) findViewById(R.id.B1_Exit);

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askExit();
            }
        });
    }
    public void askExit() {

        String button_yes = "Yes";
        String button_no = "No";
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Are you sure you want to Exit?")
                .setCancelable(false)
                .setPositiveButton(button_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(1);
                    }
                })
                .setNegativeButton(button_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
    public void sendMessage(View v) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
