package com.example.com.storyapp.model;

/**
 * Created by rohan on 3/9/16.
 */
public class Page {

    private int image;
    private String text;
    private Choice choice1;
    private Choice choice2;
    private boolean isFinal = true;

    public Page(int image, String text, Choice choice1, Choice choice2) {
        this.image = image;
        this.text = text;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public Page(int image, String text) {
        this.image = image;
        this.text = text;
        this.isFinal = true;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }
}
