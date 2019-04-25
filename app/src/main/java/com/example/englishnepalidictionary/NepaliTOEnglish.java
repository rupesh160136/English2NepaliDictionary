package com.example.englishnepalidictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NepaliTOEnglish extends AppCompatActivity {

    private ListView lstDictionary;


    private Map<String,String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nepali_toenglish);

        lstDictionary = findViewById(R.id.lstDictionary);
        dictionary = new HashMap<>();



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

                Intent intent = new Intent(NepaliTOEnglish.this,MeaningActivity.class);
                intent.putExtra("convert",convert);
                startActivity(intent);
            }
        });

    }

}
