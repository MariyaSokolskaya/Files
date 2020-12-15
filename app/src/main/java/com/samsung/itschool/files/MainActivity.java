package com.samsung.itschool.files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText saveText;
    TextView loadText;
    Button save, load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveText = findViewById(R.id.saveText);
        loadText = findViewById(R.id.loadText);
        save = findViewById(R.id.save);
        load = findViewById(R.id.load);

    }
    public void saveLoad(View v){
        int id = v.getId();
        switch (id){
            case R.id.save:
                String s = saveText.getText().toString();
                try {
                    FileOutputStream fos = openFileOutput("myInfo.txt", MODE_APPEND);
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    osw.append(s);
                    osw.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.load:
                try {
                    FileInputStream fis = openFileInput("myInfo.txt");
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    String s1 = "";
                    loadText.setText("");
                    while ((s1 = br.readLine()) != null){
                        s1 += "\n";
                        loadText.append(s1);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
