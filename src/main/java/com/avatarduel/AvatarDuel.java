package com.avatarduel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AvatarDuel extends Application {

  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/avatarduel/layout/startpage/StartPage.fxml"));
    Parent root = loader.load();
    //set Scene
    Scene scene = new Scene(root, 1215, 680);
    //set stage
    primaryStage.getIcons().add(new Image(getClass().getResource("/com/avatarduel/image/icon3.png").toString()));
    primaryStage.setTitle("Avatar Duel");
    primaryStage.setScene(scene);
    primaryStage.setResizable(true);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}