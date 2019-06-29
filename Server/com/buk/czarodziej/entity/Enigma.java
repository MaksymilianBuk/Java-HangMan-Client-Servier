package com.buk.czarodziej.entity;

public class Enigma {
    private String category;
    private String password;
    private String passwordEncrypted="";
    private int lives;

    public Enigma() {
    }
    public Enigma(String line)
    {
        String[] lineArray;
        lineArray=line.split("/");
        this.category=lineArray[0];
        this.password=lineArray[1];
        this.lives=7;

        for(int i=0; i<password.length();i++)
        {
            if(password.charAt(i)==' ')
            {
                this.passwordEncrypted+=" ";
            }
            else
            {
                this.passwordEncrypted+="_";
            }
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
