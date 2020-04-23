package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * LandView is a controller class for LandView.fxml
 * use for layout on hover Land Card
 * @author 06 K1
 */
public class LandView extends AnchorPane implements View {
    @FXML private Text name;
    @FXML private Text description;
    @FXML private ImageView elementPict;
    @FXML private ImageView landPict;

    /**
     * Creates a new LandView form fxml file
     */
    public LandView(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/layout/hoverPreview/LandView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    /**
     * Set name of the landView
     * @param name name of the land
     */
    public void setName(String name){
        this.name.setText(name);
    }
    /**
     * Set description of the landView
     * @param desc description of the landview
     */
    public void setDescription(String desc){
        this.description.setText(desc);
    }
    /**
     * Set image of land picture
     * @param img image of the land picture
     */
    public void setLandPict(Image img){
        this.landPict.setImage(img);
    }
    /**
     * Set image of element
     * @param inmg image of the element
     */
    public void setElementPict(Image img) {
        this.elementPict.setImage(img);
    }
}
