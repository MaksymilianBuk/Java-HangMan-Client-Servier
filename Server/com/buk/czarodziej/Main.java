package com.buk.czarodziej;

import com.buk.czarodziej.entity.Enigma;
import com.buk.czarodziej.service.MainServices;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception{


        ServerSocket serverSocket= new ServerSocket(4999);
        Socket socket= serverSocket.accept();
        PrintWriter printWriter= new PrintWriter(socket.getOutputStream());
        InputStreamReader inputStreamReader= new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

        System.out.println("Client conected");
        Enigma enigma= MainServices.startNewGame();
        //Sets new enigma
        System.out.println("Password is: "+enigma.getPassword());

        MainServices.sendNewGame(enigma,printWriter);
        //Sends enigma to client

//        String lineFromClient=bufferedReader.readLine();
//        System.out.println(lineFromClient);
        while(true)
        {
            try{
            String letterFromClient=bufferedReader.readLine();
            if(letterFromClient.equals("!StartNewGame"))
            {
                enigma=MainServices.startNewGame();
                MainServices.sendNewGame(enigma,printWriter);
                System.out.println("Password is: "+enigma.getPassword());
                continue;
            }

            enigma=MainServices.checkLetter(enigma,letterFromClient.charAt(0));
            System.out.println(letterFromClient.charAt(0));
            MainServices.sendToClient(enigma,printWriter);
            }
            catch(SocketException e)
            {

                System.out.println("The end of game!");
                break;
            }
        }

        /*
        InputStreamReader inputStreamReader= new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

        System.out.println(string);*/


    }
}
