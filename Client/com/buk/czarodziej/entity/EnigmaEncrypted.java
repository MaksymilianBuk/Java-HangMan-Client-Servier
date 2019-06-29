package com.buk.czarodziej.entity;

public class EnigmaEncrypted {
    private String category;
    private String questionEncrypted;
    private int livesRemaining;

    public EnigmaEncrypted() {
    }

    public EnigmaEncrypted(String line) {
        String[] linesArray=line.split("/");
        this.category=linesArray[0];
        this.questionEncrypted=linesArray[1];
        this.livesRemaining=7;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestionEncrypted() {
        return questionEncrypted;
    }

    public void setQuestionEncrypted(String questionEncrypted) {
        this.questionEncrypted = questionEncrypted;
    }

    public int getLivesRemaining() {
        return livesRemaining;
    }

    public void setLivesRemaining(int livesRemaining) {
        this.livesRemaining = livesRemaining;
    }
}
