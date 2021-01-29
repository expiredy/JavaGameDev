package com.example.megaextrathiccapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;
import static com.example.megaextrathiccapp.R.id.startButton;


public class MainActivity extends AppCompatActivity {
    public static boolean gameStarterFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    @Override
    protected void onStart() {
//        setContentView(R.layout.activity_main);
        super.onStart();
    }
    public void gameStart(){
        setContentView(new DrawView(this));
    }
}