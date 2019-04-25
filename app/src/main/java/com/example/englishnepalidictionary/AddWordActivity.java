package com.example.englishnepalidictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddWordActivity extends AppCompatActivity {
    private EditText etword, etdefination;
    private Button btnAddWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etword= findViewById(R.id.etWord);
        etdefination= findViewById(R.id.etMeaning);
        btnAddWord= findViewById(R.id.btnaddword);

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });

    }
    private void Save(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("word.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(etword.getText().toString()+ "->"+ etdefination.getText().toString());
            printStream.close();
            Toast.makeText(this, "save to"+ getFilesDir(),Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Log.d("Dictionary app", "error" + e.toString());
            e.printStackTrace();
        }
    }
}
