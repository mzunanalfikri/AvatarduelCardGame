package com.avatarduel.gui;

import com.avatarduel.model.Character;
import com.avatarduel.model.Skill;
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
 * OnBoardSKillComponent is a controller for OnBoardSkillComponent.fxml
 * use for layout on Skill Character COmponent
 * @author 06 K1
 */
public class OnBoardSkillComponent extends VBox implements OnBoard{
    @FXML private Text name;
    @FXML private Text atkdef;
    @FXML private Text effect;
    @FXML private ImageView skillPict;
    @FXML private ImageView elementPict;

    private Skill skill;
    private OnBoardCharComponent boardCharAttached;
    private boolean isAlreadyAttached;

    private final String cssOnClick = "-fx-border-color: yellow;\n" +
//            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 3;\n";
//            "-fx-border-style: dashed;\n";

    /**
     * Creates a new OnBoardSkillComponent from fxml file and Skill
     * @param skill skill that want to display
     */
    public OnBoardSkillComponent(Skill skill)  {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/layout/onboard/OnBoardSkill.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        this.skill = skill;
        isAlreadyAttached = false;

        try{
            fxmlLoader.load();
            refreshCard();
        } catch (IOException e) {
            System.out.println("Yang salah skill: "+ skill.getName());
            throw  new RuntimeException(e);
        }
//        name.setText(nama);
//        effect.setText(efek);
        // src/res/image/Air Funnel.png
//        Image image = new Image(getClass().getResource("/com/avatarduel/card/image/skill/Trebuchets.png").toString());
//        skillPict.setImage(image);
    }

    /**
     * Handle when Mouse Clicked
     * @param mouseEvent mouse event when object clicked
     */
    public void handleOnMouseClickedSkill(MouseEvent mouseEvent) {
        Controller.vBoxAfterClick.setStyle("");
        this.setStyle(cssOnClick);
        Controller.vBoxAfterClick = this;
    }

    /**
     * Set the skill of the OnBoardCharComponent
     * @param skill skill card
     */
    public void setSkill(Skill skill){
        this.skill = skill;
    }

    /**
     * Get the skill of the card
     * @return skill of the card
     */
    public Skill getSkill(){
        return skill;
    }

    /**
     * Refresh the card to match the skill attribute
     */
    public void refreshCard(){
        name.setText(skill.getName());
        atkdef.setText("atk: " + Integer.toString(skill.getAttack()) + " def: " + Integer.toString(skill.getDefense()) + "\npower: " + Integer.toString(skill.getPower()));
        effect.setText("aura");
        Path path = Paths.get(skill.getImgPath());
        Path fileName = path.getFileName();
        System.out.println("skill: " + fileName);
        Image image = new Image(getClass().getResource("/com/avatarduel/card/image/skill/"+fileName).toString());
        skillPict.setImage(image);
        elementPict.setImage(skill.getImgElementPath());
    }

    /**
     * Attach skill to character component
     * @param boardCharAttaced char class on board
     */
    public void attachToChar(OnBoardCharComponent boardCharAttached){
        this.boardCharAttached = boardCharAttached;
    }

    /**
     * to remove the skill
     */
    public void removeSkill(){
        Character charAttached = boardCharAttached.getCharacter();
        charAttached.setAttack(charAttached.getAttack()-skill.getAttack());
        charAttached.setDefense(charAttached.getDefense()-skill.getDefense());
        boardCharAttached.refreshCard();
        boardCharAttached.removeSkillWithId(skill.getID());
        ((VBox) this.getParent()).getChildren().clear();
    }

    /**
     * Get the status attached
     * @return the status attached
     */
    public boolean getIsAlreadyAttached(){
        return isAlreadyAttached;
    }

    /**
     * Set of skill attached
     * @param isAlreadyAttached status attached (true / false)
     */
    public void setIsAlreadyAttached(boolean isAlreadyAttached){
        this.isAlreadyAttached = isAlreadyAttached;
    }

}
