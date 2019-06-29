package com.buk.czarodziej.web;

import com.buk.czarodziej.entity.EnigmaEncrypted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class WebService {

    public static void sendLetter(String letter,PrintWriter printWriter)
    {
        printWriter.println(letter);
        printWriter.flush();
    }


}
