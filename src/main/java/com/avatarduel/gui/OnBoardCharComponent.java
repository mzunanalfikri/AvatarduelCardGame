package com.avatarduel.gui;

import com.avatarduel.gameplay.Gameplay;
import com.avatarduel.model.Skill;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.avatarduel.model.Character;
/**
 * OnBoardCharComponent is a controller for OnBoardCharComponent.fxml
 * use for layout on Board Character carh
 * @author 06 K1
 */
public class OnBoardCharComponent extends VBox implements OnBoard{
    @FXML private Text name;
    @FXML private Text attack;
    @FXML private Text defence;
    @FXML private Text power;
    @FXML private ImageView elementPict;
    @FXML private ImageView charPict;

    private final String cssOnClick = "-fx-border-color: yellow;\n" +
//            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 3;\n";
//            "-fx-border-style: dashed;\n";


    private Character character;
    private List<OnBoardSkillComponent> listSkillAttached;

    /**
     * Creates a new OnBoardCharComponent from fxml file and Character
     * @param character character that want to display
     */
    public OnBoardCharComponent(Character character){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/layout/onboard/OnBoardCharacter.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        this.character = character;
        listSkillAttached = new ArrayList<OnBoardSkillComponent>();

        try{
            fxmlLoader.load();
            refreshCard();
        } catch (IOException e) {
            System.out.println("Yang salah character: "+ character.getName());
            throw  new RuntimeException(e);
        }
//        this.setStyle(cssOnClick);
    }

    /**
     * Handle when Mouse Clicked
     * @param mouseEvent mouse event when object clicked
     */
    @FXML
    public void handleOnMouseClickedCharacter(MouseEvent mouseEvent){
        Controller.vBoxAfterClick.setStyle("");
        this.setStyle(cssOnClick);
        Controller.vBoxAfterClick = this;
    }

    /**
     * Set the character of the OnBoardCharComponent
     * @param character Character card
     */
    public void setCharacter(Character character){
        this.character = character;
        refreshCard();
    }

    /**
     * Get the character of the card
     * @return character of the card
     */
    public Character getCharacter(){
        return character;
    }
    /**
     * Refresh the card to match the character attribute
     */
    public void refreshCard(){
        name.setText(character.getName());
        attack.setText("atk: " + Integer.toString(character.getAttack()));
        defence.setText("def: " + Integer.toString(character.getDefense()));
        power.setText("pow: " + Integer.toString(character.getPower()));
        Path path = Paths.get(character.getImgPath());
        Path fileName = path.getFileName();
        System.out.println("char: " + fileName);
        Image image = new Image(getClass().getResource("/com/avatarduel/card/image/character/"+fileName).toString());
        charPict.setImage(image);
        elementPict.setImage(character.getImgElementPath());
    }
    /**
     * Apply skill aura to the character
     * @param skil Skill aura
     */
    public void applySkillAura(Skill skill){
        int prefAttack = character.getAttack();
        int prefDef = character.getDefense();
        character.applySkillAura(skill);
        attack.setText("atk: " + Integer.toString(prefAttack) + " + " + Integer.toString(skill.getAttack()));
        defence.setText("def: " + Integer.toString(prefDef) + " + " + Integer.toString(skill.getDefense()));
    }
    /**
     * Add skill in the character
     * @param onBoardSkillComponent skill component
     */
    public void addNewSkill(OnBoardSkillComponent onBoardSkillComponent){
        listSkillAttached.add(onBoardSkillComponent);
        applySkillAura(onBoardSkillComponent.getSkill());
        onBoardSkillComponent.attachToChar(this);
    }

    /**
     * ToRemove All skill on the character card
     */
    public void removeAllSkill(){
        for (int i  = 0; i<listSkillAttached.size(); ++i){
            ((VBox) listSkillAttached.get(i)).getChildren().clear();
        }
    }

    /**
     * To Remove skill with id of the skill
     * @param id of the skill
     */
    public void removeSkillWithId(String id){
        for (int i = 0; i<listSkillAttached.size(); ++i){
            if (listSkillAttached.get(i).getSkill().getID().equals(id)){
                listSkillAttached.remove(i);
                break;
            }
        }
    }

    /**
     * Check the skill power up og the card
     */
    public boolean isHasSkillPowerUp(){
        for (int i = 0; i<listSkillAttached.size(); ++i){
            if (listSkillAttached.get(i).getSkill().getID().equals("100")){
                return true;
            }
        }
        return false;
    }
}
