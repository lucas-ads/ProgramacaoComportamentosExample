package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private TextView textViewMessage;
    private Button buttonExecute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        textViewMessage = findViewById(R.id.textViewMessage);
        buttonExecute = findViewById(R.id.buttonExecute);

        buttonExecute.setOnClickListener(this);
        Log.i("LOG_LIFECICLE", "MainActivity: onCreate!");

        if(savedInstanceState!=null){
            String message = savedInstanceState.getString("TEXT_MESSAGE");
            if(message!=null){
                textViewMessage.setText(message);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LOG_LIFECICLE", "MainActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LOG_LIFECICLE", "MainActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LOG_LIFECICLE", "MainActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LOG_LIFECICLE", "MainActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LOG_LIFECICLE", "MainActivity: onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LOG_LIFECICLE", "MainActivity: onRestart");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("TEXT_MESSAGE", textViewMessage.getText().toString());
        Log.i("LOG_LIFECICLE", "MainActivity: onSaveInstanceState");
    }

    @Override
    public void onClick(View v) { //View = Widgets = Componente de Layout
        if(v.getId() == R.id.buttonExecute) {
            String name = editTextName.getText().toString();
            if (!name.equals("")) {
                String message = getText(R.string.textMessageWithName).toString();
                message = String.format(message, name);
                textViewMessage.setText(message);
                editTextName.setText("");
            }
        }
    }
}