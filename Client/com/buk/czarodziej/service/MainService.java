package com.buk.czarodziej.service;

import com.buk.czarodziej.entity.EnigmaEncrypted;
import com.buk.czarodziej.style.AlertBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public abstract class MainService {

    public static void startNewEnigma(BufferedReader bufferedReader,EnigmaEncrypted enigmaEncrypted,ImageView imageView,Text textCategory, Text textLives, Text textPassword)
    {
        String lineFromServer="";
        try {
            lineFromServer=bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Error with reading line from server");
        }
        String[] linesArray=lineFromServer.split("/");
        enigmaEncrypted.setCategory(linesArray[0]);
        enigmaEncrypted.setLivesRemaining(7);
        enigmaEncrypted.setQuestionEncrypted(linesArray[1]);
        MainService.setLivesText(textLives,enigmaEncrypted);
        MainService.setCategoryText(textCategory,enigmaEncrypted);
        MainService.setPicture(imageView,enigmaEncrypted);
        MainService.setPasswordText(textPassword,enigmaEncrypted);

        AlertBox.displayStartNewGameInformation();

    }
    private static void reloadEnigma(EnigmaEncrypted enigmaEncrypted, String line)
    {
        String[] linesArray=line.split("/");
        enigmaEncrypted.setLivesRemaining(Integer.parseInt(linesArray[0]));
        enigmaEncrypted.setQuestionEncrypted(linesArray[1]);
    }

    private static void checkLifeAndGameStatus(EnigmaEncrypted enigmaEncrypted)
    {
        if(enigmaEncrypted.getLivesRemaining()<=0)
        {
            AlertBox.displayLoseInformation();
            System.out.println("Lives have ended. You lost");
            //System.exit(0);
        }

        if(!(enigmaEncrypted.getQuestionEncrypted().contains("_")))
        {
            if (enigmaEncrypted.getLivesRemaining() > 0)
            {
                AlertBox.displayWinInformation(enigmaEncrypted.getLivesRemaining());
                System.out.println("Congratulation! You have won!");
                //System.exit(0);
            } else {
                AlertBox.displayLoseInformation();
                System.out.println("Sorry. You lost");
                //System.exit(0);
            }
        }
    }
        public static void buttonCallBack(BufferedReader bufferedReader, EnigmaEncrypted enigmaEncrypted, ImageView imageView,Text textPassword, Text textLives)
    {
        String lineFromServer="";
        try {
            lineFromServer=bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Error with reading line from server");
        }
        MainService.reloadEnigma(enigmaEncrypted,lineFromServer);

        setLivesText(textLives,enigmaEncrypted);
        setPasswordText(textPassword,enigmaEncrypted);
        System.out.println(enigmaEncrypted.getQuestionEncrypted());
        try {
            MainService.setPicture(imageView,enigmaEncrypted);
        } catch (Exception e) {
            System.out.println("Error with picture opening");
        }
        MainService.checkLifeAndGameStatus(enigmaEncrypted);

    }

    private static void setPicture(ImageView imageView, EnigmaEncrypted enigmaEncrypted)
    {
        String path="";
        File file;
        if(enigmaEncrypted.getLivesRemaining()==7)
        {
            path="src/com/buk/czarodziej/style/graphics/7.png";
        }
        if(enigmaEncrypted.getLivesRemaining()==6)
        {
            path="src/com/buk/czarodziej/style/graphics/6.png";
        }
        if(enigmaEncrypted.getLivesRemaining()==5)
        {
            path="src/com/buk/czarodziej/style/graphics/5.png";
        }
        if(enigmaEncrypted.getLivesRemaining()==4)
        {
            path="src/com/buk/czarodziej/style/graphics/4.png";
        }
        if(enigmaEncrypted.getLivesRemaining()==3)
        {
            path="src/com/buk/czarodziej/style/graphics/3.png";
        }
        if(enigmaEncrypted.getLivesRemaining()==2)
        {
            path="src/com/buk/czarodziej/style/graphics/2.png";
        }
        if(enigmaEncrypted.getLivesRemaining()==1)
        {
            path="src/com/buk/czarodziej/style/graphics/1.png";
        }
        if(enigmaEncrypted.getLivesRemaining()==0)
        {
            path="src/com/buk/czarodziej/style/graphics/0.png";
        }
        file=new File(path);
        Image image= null;
        try {
            image = new Image(file.toURL().toString());
        } catch (Exception e) {
            System.out.println("Something went wrong with trying to set image");
        }
        imageView.setImage(image);
    }
    private static void setPasswordText(Text textPassword, EnigmaEncrypted enigmaEncrypted)
    {
        textPassword.setText(enigmaEncrypted.getQuestionEncrypted());
    }
    private static void setCategoryText(Text textCategory, EnigmaEncrypted enigmaEncrypted)
    {
        textCategory.setText(enigmaEncrypted.getCategory());
    }
    private static void setLivesText(Text textLives, EnigmaEncrypted enigmaEncrypted)
    {
        String text=String.valueOf(enigmaEncrypted.getLivesRemaining());
        textLives.setText(text);
    }


}
