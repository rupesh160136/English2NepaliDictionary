package com.example.englishnepalidictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private TextView tvfirst;
    private Button btnclick;



    private ListView lstDictionary;

    public static  final String words[] = {
            "k xa", "How are you?",
            "Sanchai xu", "I am fine!",
            "k gardai", "What are you doing?",
            "jaum ghumna", "Let's go for visit!"
    };
    private Map<String,String> dictionary;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnclick = findViewById(R.id.btnclick);


        lstDictionary = findViewById(R.id.lstDictionary);
        dictionary = new HashMap<>();
        readFromFile();


        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<>(dictionary.keySet())
        );

        lstDictionary.setAdapter(adapter);

        lstDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = parent.getItemAtPosition(position).toString();
                String convert = dictionary.get(key);

                Intent intent = new Intent(MainActivity.this,MeaningActivity.class);
                intent.putExtra("convert",convert);
                startActivity(intent);
            }
        });

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
