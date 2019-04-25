package com.example.englishnepalidictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class MeaningActivity extends AppCompatActivity {

    private TextView tvMeaning;
    private Map<String,String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);
        readFromFile();

        /*Bundle bundle = getIntent().getExtras();

        if(bundle!=null) {
            String convert = bundle.getString("convert");
            tvMeaning = findViewById(R.id.tvMeaning);
            tvMeaning.setText(convert);
        }
        else
        {
            Toast.makeText(this, "No Meaning", Toast.LENGTH_SHORT).show();
        }*/
    }
    private void readFromFile(){
        try {
            FileInputStream fos = openFileInput("words.txt");
            InputStreamReader isr = new InputStreamReader(fos);
            BufferedReader br = new BufferedReader(isr);
            String line="";
            while ((line=br.readLine()) !=null){
                String[] parts = line.split("->");
                dictionary.put(parts[0], parts[1]);
            }

        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
