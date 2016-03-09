package com.example.com.storyapp.model;

/**
 * Created by rohan on 3/9/16.
 */
public class Choice {
    private String text;
    private Page nextPage;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Page getNextPage() {
        return nextPage;
    }

    public void setNextPage(Page nextPage) {
        this.nextPage = nextPage;
    }


}
