package com.example.com.storyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonSubmit;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSubmit = (Button)findViewById(R.id.buttonSubmit);
        editTextName = (EditText)findViewById(R.id.editTextName);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                startStory(name);
            }
        });
    }

    public void startStory(String name){
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }

}
