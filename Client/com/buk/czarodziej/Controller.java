package com.buk.czarodziej;

import com.buk.czarodziej.entity.EnigmaEncrypted;
import com.buk.czarodziej.service.MainService;
import com.buk.czarodziej.style.AlertBox;
import com.buk.czarodziej.web.WebService;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.*;
import java.net.Socket;
import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static final String PATH_7="src/com/buk/czarodziej/style/graphics/7.png";
    private File file=new File(PATH_7);

    @FXML
    MenuItem menuClose;
    @FXML
    MenuItem menuAuthor;
    @FXML
    ImageView imageView;
    @FXML
    ButtonBar firstButtonBar;
    @FXML
    ButtonBar secondButtonBar;
    @FXML
    ButtonBar thirdButtonBar;
    @FXML
    Button authorButton;
    @FXML
    Button closeButton;
    @FXML
    Button startGameButton;
    @FXML
    Button connectButton;
    @FXML
    Button qButton;
    @FXML
    Button wButton;
    @FXML
    Button eButton;
    @FXML
    Button rButton;
    @FXML
    Button tButton;
    @FXML
    Button yButton;
    @FXML
    Button uButton;
    @FXML
    Button iButton;
    @FXML
    Button oButton;
    @FXML
    Button pButton;
    @FXML
    Button aButton;
    @FXML
    Button sButton;
    @FXML
    Button dButton;
    @FXML
    Button fButton;
    @FXML
    Button gButton;
    @FXML
    Button hButton;
    @FXML
    Button jButton;
    @FXML
    Button kButton;
    @FXML
    Button lButton;
    @FXML
    Button zButton;
    @FXML
    Button xButton;
    @FXML
    Button cButton;
    @FXML
    Button vButton;
    @FXML
    Button bButton;
    @FXML
    Button nButton;
    @FXML
    Button mButton;

    @FXML
    Text textPassword;
    @FXML
    Text textLives;
    @FXML
    Text textCategory;


    private PrintWriter printWriter;
    private Socket socket;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private EnigmaEncrypted enigmaEncrypted;

    @FXML
    public void closeApplicationMenu(ActionEvent actionEvent)
    {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void showAboutAuthorMenu(ActionEvent actionEvent) {
        AlertBox.displayAuthor();
    }
    @FXML
    public void startNewGame(ActionEvent actionEvent)
    {
        try {
            printWriter.println("!StartNewGame");
            printWriter.flush();
            MainService.startNewEnigma(bufferedReader,enigmaEncrypted,imageView,textCategory,textLives,textPassword);
        }
        catch (Exception e)
        {
            AlertBox.displayNoConnection();
        }
        //... I know it looks terrible but it's the simples way
        qButton.setDisable(false);
        wButton.setDisable(false);
        eButton.setDisable(false);
        rButton.setDisable(false);
        tButton.setDisable(false);
        yButton.setDisable(false);
        uButton.setDisable(false);
        iButton.setDisable(false);
        oButton.setDisable(false);
        pButton.setDisable(false);
        aButton.setDisable(false);
        sButton.setDisable(false);
        dButton.setDisable(false);
        fButton.setDisable(false);
        gButton.setDisable(false);
        hButton.setDisable(false);
        jButton.setDisable(false);
        kButton.setDisable(false);
        lButton.setDisable(false);
        zButton.setDisable(false);
        xButton.setDisable(false);
        cButton.setDisable(false);
        vButton.setDisable(false);
        bButton.setDisable(false);
        nButton.setDisable(false);
        mButton.setDisable(false);

    }

    @FXML
    public void connect(ActionEvent actionEvent)
    {
        try {
            socket= new Socket("localhost",4999);
            printWriter = new PrintWriter(socket.getOutputStream());
            inputStreamReader= new InputStreamReader(socket.getInputStream());
            bufferedReader= new BufferedReader(inputStreamReader);
            String startLine=bufferedReader.readLine();
            enigmaEncrypted= new EnigmaEncrypted(startLine);
            //First line to set-up enigma

            //System.out.println(string);
            //PrintWriter printWriter= new PrintWriter(socket.getOutputStream());

            //Initializing first media
            Image image= new Image(file.toURL().toString());
            imageView.setImage(image);
            textPassword.setText(enigmaEncrypted.getQuestionEncrypted());
            textLives.setText(String.valueOf(enigmaEncrypted.getLivesRemaining()));
            textCategory.setText(enigmaEncrypted.getCategory());
            connectButton.setDisable(true);
            AlertBox.displayConnectInformation();

        } catch (IOException e) {
            System.out.println("Something went wrong with initializing. Try to re-connect");
        }
    }

    @FXML
    public void sendQ (ActionEvent actionEvent)
    {
        WebService.sendLetter("Q",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        qButton.setDisable(true);
    }
    @FXML
    public void sendW(ActionEvent actionEvent)
    {
        WebService.sendLetter("W",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        wButton.setDisable(true);
    }
    @FXML
    public void sendE(ActionEvent actionEvent)
    {
        WebService.sendLetter("E",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        eButton.setDisable(true);
    }
    @FXML
    public void sendR(ActionEvent actionEvent)
    {
        WebService.sendLetter("R",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        rButton.setDisable(true);
    }
    @FXML
    public void sendT(ActionEvent actionEvent)
    {
        WebService.sendLetter("T",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        tButton.setDisable(true);
    }
    @FXML
    public void sendY(ActionEvent actionEvent)
    {
        WebService.sendLetter("Y",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        yButton.setDisable(true);
    }
    @FXML
    public void sendU(ActionEvent actionEvent)
    {
        WebService.sendLetter("U",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        uButton.setDisable(true);
    }
    @FXML
    public void sendI(ActionEvent actionEvent)
    {
        WebService.sendLetter("I",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        iButton.setDisable(true);
    }
    @FXML
    public void sendO(ActionEvent actionEvent)
    {
        WebService.sendLetter("O",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        oButton.setDisable(true);
    }
    @FXML
    public void sendP(ActionEvent actionEvent)
    {
        WebService.sendLetter("P",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        pButton.setDisable(true);
    }
    @FXML
    public void sendA(ActionEvent actionEvent)
    {
        WebService.sendLetter("A",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        aButton.setDisable(true);
    }
    @FXML
    public void sendS(ActionEvent actionEvent)
    {
        WebService.sendLetter("S",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        sButton.setDisable(true);
    }
    @FXML
    public void sendD(ActionEvent actionEvent)
    {
        WebService.sendLetter("D",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        dButton.setDisable(true);
    }
    @FXML
    public void sendF(ActionEvent actionEvent)
    {
        WebService.sendLetter("F",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        fButton.setDisable(true);
    }
    @FXML
    public void sendG(ActionEvent actionEvent)
    {
        WebService.sendLetter("G",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        gButton.setDisable(true);
    }
    @FXML
    public void sendH(ActionEvent actionEvent)
    {
        WebService.sendLetter("H",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        hButton.setDisable(true);
    }
    @FXML
    public void sendJ(ActionEvent actionEvent)
    {
        WebService.sendLetter("J",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        jButton.setDisable(true);
    }
    @FXML
    public void sendK(ActionEvent actionEvent)
    {
        WebService.sendLetter("K",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        kButton.setDisable(true);
    }
    @FXML
    public void sendL(ActionEvent actionEvent)
    {
        WebService.sendLetter("L",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        lButton.setDisable(true);
    }
    @FXML
    public void sendZ(ActionEvent actionEvent)
    {
        WebService.sendLetter("Z",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        zButton.setDisable(true);
    }
    @FXML
    public void sendX(ActionEvent actionEvent)
    {
        WebService.sendLetter("X",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        xButton.setDisable(true);
    }
    @FXML
    public void sendC(ActionEvent actionEvent)
    {
        WebService.sendLetter("C",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        cButton.setDisable(true);
    }
    @FXML
    public void sendV(ActionEvent actionEvent)
    {
        WebService.sendLetter("V",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        vButton.setDisable(true);
    }
    @FXML
    public void sendB(ActionEvent actionEvent)
    {
        WebService.sendLetter("B",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        bButton.setDisable(true);
    }
    @FXML
    public void sendN(ActionEvent actionEvent)
    {
        WebService.sendLetter("N",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        nButton.setDisable(true);
    }
    @FXML
    public void sendM(ActionEvent actionEvent)
    {
        WebService.sendLetter("M",printWriter);
        MainService.buttonCallBack(bufferedReader,enigmaEncrypted,imageView,textPassword,textLives);
        mButton.setDisable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){


//        try {
//            socket= new Socket("localhost",4999);
//            printWriter = new PrintWriter(socket.getOutputStream());
//            inputStreamReader= new InputStreamReader(socket.getInputStream());
//            bufferedReader= new BufferedReader(inputStreamReader);
//            String startLine=bufferedReader.readLine();
//            enigmaEncrypted= new EnigmaEncrypted(startLine);
//            //First line to set-up enigma
//
//            //System.out.println(string);
//            //PrintWriter printWriter= new PrintWriter(socket.getOutputStream());
//
//            //Initializing first media
//            Image image= new Image(file.toURL().toString());
//            imageView.setImage(image);
//            textPassword.setText(enigmaEncrypted.getQuestionEncrypted());
//            textLives.setText(String.valueOf(enigmaEncrypted.getLivesRemaining()));
//            textCategory.setText(enigmaEncrypted.getCategory());
//
//
//
//
//
//        } catch (IOException e) {
//            System.out.println("Something went wrong with initializing. Try to re-connect");
//        }

    }

}
