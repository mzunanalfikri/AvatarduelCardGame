package com.avatarduel.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
/**
 * SkillView is a controller class for SkillView.fxml
 * use for layout on hover Skill Card
 * @author 06 K1
 */
public class SkillView extends AnchorPane implements View {
    @FXML private Text name;
    @FXML private Text description;
    @FXML private Text deltaAtk;
    @FXML private Text deltaDef;
    @FXML private Text pow;
    @FXML private ImageView elementPict;
    @FXML private ImageView skillPict;
    /**
     * Creates a new SkillView form fxml file
     */
    public SkillView(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/layout/hoverPreview/SkillView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }
    /**
     * Set name of the SkillView
     * @param name name of the Skill
     */
    public void setName(String name){
        this.name.setText(name);
    }
    /**
     * Set description of the SkillView
     * @param desc description of the Skillview
     */
    public void setDescription(String desc){
        this.description.setText(desc);
    }
    /**
     * Set delta of Attack
     * @param deltaAtk value of attack
     */
    public void setDeltaAtk(String deltaAtk){
        this.deltaAtk.setText(deltaAtk);
    }
    /**
     * Set delta of Defence
     * @param deltaDef value of defence
     */
    public void setDeltaDef(String deltaDef){
        this.deltaDef.setText(deltaDef);
    }
    /**
     * Set power
     * @param power Power of the skill
     */
    public void setPower(String power){ this.pow.setText(power);}
    /**
     * Set image of Skill picture
     * @param img image of the Skill picture
     */
    public void setSkillPict(Image img){
        this.skillPict.setImage(img);
    }
    /**
     * Set image of element
     * @param inmg image of the element
     */
    public void setElementPict(Image img) {
        this.elementPict.setImage(img);
    }

}
