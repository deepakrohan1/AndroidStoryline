package com.example.com.storyapp.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.storyapp.R;
import com.example.com.storyapp.model.Page;
import com.example.com.storyapp.model.Story;

public class StoryActivity extends AppCompatActivity {

    Story story = new Story();
    private ImageView imageViewStory;
    private Button buttonChoice1;
    private Button buttonChoice2;
    private TextView textViewText;
    private String name;
    private Page page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        if (getIntent().getExtras() != null) {
            name = getIntent().getExtras().getString(getString(R.string.NAME));
            Log.d("StoryAct", name);
        }

        buttonChoice1 = (Button) findViewById(R.id.buttonChoice1);
        buttonChoice2 = (Button) findViewById(R.id.buttonChoice2);
        imageViewStory = (ImageView) findViewById(R.id.imageViewPage);
        textViewText = (TextView) findViewById(R.id.textViewText);
        loadStory(0);
    }

    public void loadStory(int pageNumber) {
        page = story.getPage(pageNumber);
        Drawable drawable = getResources().getDrawable(page.getImage());
        imageViewStory.setImageDrawable(drawable);

        String pageText = page.getText();
        pageText = String.format(pageText, name);
        textViewText.setText(pageText);
        if (page.isFinal()) {
            buttonChoice1.setVisibility(View.INVISIBLE);
            buttonChoice2.setText("PLAY AGAIN");
            buttonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else{
            buttonChoice1.setText(page.getChoice1().getText());
            buttonChoice2.setText(page.getChoice2().getText());
            buttonChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = page.getChoice1().getNextPage();
                    loadStory(nextPage);
                }
            });

            buttonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = page.getChoice2().getNextPage();
                    loadStory(nextPage);
                }
            });
        }

    }

}
