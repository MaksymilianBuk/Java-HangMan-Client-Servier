package com.buk.czarodziej.style;

import javafx.scene.control.Alert;

public class AlertBox {
    public static void displayAuthor()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About author");
        alert.setHeaderText("This application was made by:");
        alert.setContentText("Maksymililan Buk\nStudent of Applied Computer Science\n31 May 2019");
        alert.showAndWait();
    }
    public static void displayWinInformation(int livesRemaining)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Congratulation!");
        alert.setHeaderText("You have won!");
        alert.setContentText("You have "+String.valueOf(livesRemaining)+" lives left!");
        alert.showAndWait();
    }
    public static void displayLoseInformation()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sorry!");
        alert.setHeaderText("You have lost");
        alert.setContentText("All lives have ended...");
        alert.showAndWait();
    }
    public static void displayStartNewGameInformation()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Information!");
        alert.setHeaderText("New game started");
        alert.setContentText("Good luck!");
        alert.showAndWait();
    }
    public static void displayConnectInformation()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Information!");
        alert.setHeaderText("Network Connected!");
        alert.setContentText("Have a good time!");
        alert.showAndWait();
    }
    public static void displayNoConnection()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Game Information!");
        alert.setHeaderText("No connection!");
        alert.setContentText("Press connect button first!");
        alert.showAndWait();
    }
}