package com.avatarduel.gui;

import com.avatarduel.model.Character;
import com.avatarduel.model.Land;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * OnBoardLandComponent is a controller for OnBoardLandComponent.fxml
 * use for layout on Board Land COmponent
 * @author 06 K1
 */
public class OnBoardLandComponent extends VBox implements OnBoard {
    @FXML Text name;
    @FXML Text elementText;
    @FXML ImageView elementPict;
    @FXML ImageView landPict;

    private Land land;

    private final String cssOnClick = "-fx-border-color: yellow;\n" +
//            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 3;\n";
//            "-fx-border-style: dashed;\n";

    /**
     * Creates a new OnBoardLandComponent from fxml file and Lnad
     * @param land Land that want to display
     */
    public OnBoardLandComponent(Land land){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(  "/com/avatarduel/layout/onboard/OnBoardLand.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        this.land = land;

        try{
            fxmlLoader.load();
            refreshCard();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    /**
     * Handle when Mouse Clicked
     * @param mouseEvent mouse event when object clicked
     */
    public void handleOnMouseClickedLand(MouseEvent mouseEvent){
        Controller.vBoxAfterClick.setStyle("");
        this.setStyle(cssOnClick);
        Controller.vBoxAfterClick = this;
    }

    /**
     * Set the land of the OnBoardLandComponent
     * @param land land card
     */
    public void setLand(Land land){
        this.land = land;
        refreshCard();
    }

    /**
     * Get the land of the card
     * @return land of the card
     */
    public Land getLand(){
        return land;
    }

    /**
     * Refresh the card to match the land attribute
     */
    public void refreshCard(){
        name.setText(land.getName());
        elementText.setText(land.getElement());
        Path path = Paths.get(land.getImgPath());
        Path fileName = path.getFileName();
        System.out.println("land: " + fileName);
        Image image = new Image(getClass().getResource("/com/avatarduel/card/image/land/"+fileName).toString());
        landPict.setImage(image);
        elementPict.setImage(land.getImgElementPath());
    }

}
