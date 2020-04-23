package com.avatarduel.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Start page is a controller class for StartPage.fxml
 * @author 06 K1
 */
public class StartPage {
    /**
     * Button for start the game
     */
    public Button startGame;
    /**
     * TextField for save player 1 name
     */
    public TextField player1Name;
    /**
     * TextField for save player 2 name
     */
    public TextField player2Name;

    /**
     * Handle On mouse clicked on button start
     * @param mouseEvent mouseEvent clicked
     * @throws IOException when read a fxml file
     */
    public void handleOnMouseClicked(MouseEvent mouseEvent) throws IOException, URISyntaxException {
        if (mouseEvent.getSource().equals(startGame)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/avatarduel/layout/Layout.fxml"));
            Parent root = loader.load();
            Controller controller = loader.getController();
            controller.start(player1Name.getText(), player2Name.getText());
            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 1215, 680);
            window.setScene(scene);
            window.show();
        } else if (mouseEvent.getSource().equals(player1Name)){
            this.player1Name.clear();
        } else if (mouseEvent.getSource().equals(player2Name)) {
            this.player2Name.clear();
        }
    }
}
