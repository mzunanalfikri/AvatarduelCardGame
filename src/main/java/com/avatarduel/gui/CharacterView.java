package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
/**
 * CharacterView is a controller class for CharacterView.fxml
 * use for layout on hover Character Card
 * @author 06 K1
 */
public class CharacterView extends AnchorPane implements View{
    @FXML private Text name;
    @FXML private Text description;
    @FXML private Text atk;
    @FXML private Text def;
    @FXML private Text pow;
    @FXML private ImageView elementPict;
    @FXML private ImageView charPict;

    /**
     * Creates a new CharacterView form fxml file
     */
    public CharacterView(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/layout/hoverPreview/CharacterView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    /**
     * Set name of the CharacterView
     * @param name name of the Character
     */
    public void setName(String name){
        this.name.setText(name);
    }
    /**
     * Set description of the CharacterView
     * @param desc description of the Characterview
     */
    public void setDescription(String desc){
        this.description.setText(desc);
    }
    /**
     * Set image of Character picture
     * @param img image of the Character picture
     */
    public void setCharacterPict(Image img){
        this.charPict.setImage(img);
    }
    /**
     * Set image of element
     * @param inmg image of the element
     */
    public void setElementPict(Image img) {
        this.elementPict.setImage(img);
    }
    /**
     * Set attack of the character
     * @param atk attack value
     */
    public void setAtk(String atk){
        this.atk.setText(atk);
    }
    /**
     * Set defence of the character
     * @param def defence value
     */
    public void setDef(String def){
        this.def.setText(def);
    }
    /**
     * Set power of the character
     * @param pow power value
     */
    public void setPow(String pow){
        this.pow.setText(pow);
    }
}
