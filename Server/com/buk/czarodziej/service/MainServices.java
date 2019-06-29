package com.buk.czarodziej.service;

import com.buk.czarodziej.entity.Enigma;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;


public class MainServices  {
    private static final String PATH_DATABASE="src/com/buk/czarodziej/database/database.txt";

    public static Enigma checkLetter(Enigma enigma, char letter)
    {
        boolean letterExist=false;
        char[] enigmaCharArray=enigma.getPasswordEncrypted().toCharArray();

        for(int i=0; i<enigma.getPassword().length();i++)
        {
            if(enigma.getPassword().charAt(i)==letter)
            {
                enigmaCharArray[i]=letter;
                letterExist=true;
            }
        }

        if(!letterExist)
        {
            enigma.setLives(enigma.getLives()-1);
        }
        enigma.setPasswordEncrypted(String.valueOf(enigmaCharArray));
        return enigma;
    }


    public static Enigma startNewGame() throws IOException {

        int index= 0;
        File file= new File(PATH_DATABASE);
        Path path = Paths.get(file.getAbsolutePath());
        List<String> allLinesFromFile= Files.readAllLines(path);

        Random random=new Random();
        index=random.nextInt(allLinesFromFile.size());
        //From 0 to max count of lines

        Enigma enigma=new Enigma(allLinesFromFile.get(index));

        return enigma;
    }

    public static void sendToClient(Enigma enigma, PrintWriter printWriter)
    {
        String toSendString=enigma.getLives()+"/"+enigma.getPasswordEncrypted();
        printWriter.println(toSendString);
        printWriter.flush();
    }

    public static void sendNewGame(Enigma enigma, PrintWriter printWriter)
    {
        String toSendString=enigma.getCategory()+"/"+enigma.getPasswordEncrypted();
        printWriter.println(toSendString);
        printWriter.flush();
    }



}
