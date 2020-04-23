package com.avatarduel.gui;

import com.avatarduel.gameplay.Gameplay;
import com.avatarduel.loader.GameLoader;
import com.avatarduel.model.Card;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.player.Player;
import com.avatarduel.model.Character;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.CharConversionException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {
    //On hand P1
    public VBox onHandP1_1;
    public VBox onHandP1_2;
    public VBox onHandP1_3;
    public VBox onHandP1_4;
    public VBox onHandP1_5;
    public VBox onHandP1_6;
    public VBox onHandP1_7;
    //On hand P2
    public VBox onHandP2_1;
    public VBox onHandP2_2;
    public VBox onHandP2_3;
    public VBox onHandP2_4;
    public VBox onHandP2_5;
    public VBox onHandP2_6;
    public VBox onHandP2_7;
    //VBox Character P1
    public VBox boxCharP1_1;
    public VBox boxCharP1_2;
    public VBox boxCharP1_3;
    public VBox boxCharP1_4;
    public VBox boxCharP1_5;
    public VBox boxCharP1_6;
    //VBox Character P2
    public VBox boxCharP2_1;
    public VBox boxCharP2_2;
    public VBox boxCharP2_3;
    public VBox boxCharP2_4;
    public VBox boxCharP2_5;
    public VBox boxCharP2_6;
    //Rectangle Character P1
    public Rectangle recCharP1_1;
    public Rectangle recCharP1_2;
    public Rectangle recCharP1_3;
    public Rectangle recCharP1_4;
    public Rectangle recCharP1_5;
    public Rectangle recCharP1_6;
    //Rectangle Character for P2
    public Rectangle recCharP2_1;
    public Rectangle recCharP2_2;
    public Rectangle recCharP2_3;
    public Rectangle recCharP2_4;
    public Rectangle recCharP2_5;
    public Rectangle recCharP2_6;
    //VBox Skill for P1
    public VBox boxSkillP1_1;
    public VBox boxSkillP1_2;
    public VBox boxSkillP1_3;
    public VBox boxSkillP1_4;
    public VBox boxSkillP1_5;
    public VBox boxSkillP1_6;
    //VBox Skill for P2
    public VBox boxSkillP2_1;
    public VBox boxSkillP2_2;
    public VBox boxSkillP2_3;
    public VBox boxSkillP2_4;
    public VBox boxSkillP2_5;
    public VBox boxSkillP2_6;
    //Rectangle Skill for P1
    public Rectangle recSkillP1_1;
    public Rectangle recSkillP1_2;
    public Rectangle recSkillP1_3;
    public Rectangle recSkillP1_4;
    public Rectangle recSkillP1_5;
    public Rectangle recSkillP1_6;
    //Rectangle SKill for P2
    public Rectangle recSkillP2_1;
    public Rectangle recSkillP2_2;
    public Rectangle recSkillP2_3;
    public Rectangle recSkillP2_4;
    public Rectangle recSkillP2_5;
    public Rectangle recSkillP2_6;
    //Power , text berbentuk 0/0
    public Text powerAir_P1;
    public Text powerFire_P1;
    public Text powerWater_P1;
    public Text powerEarth_P1;
    public Text powerEnergy_P1;
    //Power, text berbentuk 0/0
    public Text powerAir_P2;
    public Text powerFire_P2;
    public Text powerWater_P2;
    public Text powerEarth_P2;
    public Text powerEnergy_P2;
    //Health player, bentuknya text langsung nunjukin angka
    public Text healthP1;
    public Text healthP2;
    //Player Name , String
    public Text player1Name;
    public Text player2Name;
    //Deck card player, bentuknya 60/60
    public Text deckP2;
    public Text deckP1;
    //Text indicator for gameplay
    public Text drawPhase;
    public Text main1Phase;
    public Text battlePhase;
    public String phase ;
    //Button for gameplay
    public Button buttonGamePlay;
    //for card preview in hover
    public AnchorPane hoverPreview;
    //progress Bar
    public ProgressBar progressBarP1;
    public ProgressBar progressBarP2;


    public Label turnLabel;

    private GameLoader gameLoader;
    public static Gameplay gameplay;
    private VBox[] onHandP1;        // array vbox buat card di tangan
    private VBox[] onHandP2;
    private VBox[] boxCharP1, boxCharP2;

    private static boolean isCardHandCharClicked = false, isCardHandSkillClicked = false, isCardHandLandClicked = false;
    private static boolean isCardBoardSkillClicked = false;
    private static boolean isCardCharAttackClicked = false;
    private static boolean isCardCharAttackedClicked = false;
    private static boolean isRemoveSkillButtonClicked = false;
    private static boolean isRemoveHandButtonClicked = false;

    public static VBox vBoxAfterClick = new VBox();

    private OnBoardCharComponent characterClicked, charAttackClicked, charAttackedClicked;
    private OnBoardLandComponent landClicked;
    private OnBoardSkillComponent skillClicked;
    private VBox boxBoardClicked = new VBox();
    private VBox boxHandClicked = new VBox();

    public void start(String nameP1, String nameP2) throws URISyntaxException, IOException {
        this.phase = "draw";
        this.buttonGamePlay.setText("Go To Main");
        this.drawPhase.setUnderline(true);
        this.player1Name.setText(nameP1);
        this.player2Name.setText(nameP2);
        progressBarP1.setProgress(1);
        progressBarP2.setProgress(1);
//        System.out.println(getClass().getResource("../card/data/land.csv").toURI());
        File landCSVFile = new File(getClass().getResource("../card/data/land.csv").toURI());
        File characterCSVFile = new File(getClass().getResource("../card/data/character.csv").toURI());
        File skillCSVFile = new File(getClass().getResource("../card/data/skill.csv").toURI());

        GameLoader gameLoader = new GameLoader(characterCSVFile, landCSVFile, skillCSVFile);
        gameplay = new Gameplay(gameLoader);

        onHandP1 = new VBox[]{onHandP1_1, onHandP1_2, onHandP1_3, onHandP1_4, onHandP1_5, onHandP1_6, onHandP1_7};
        onHandP2 = new VBox[]{onHandP2_1, onHandP2_2, onHandP2_3, onHandP2_4, onHandP2_5, onHandP2_6, onHandP2_7};
        boxCharP1 = new VBox[]{boxCharP1_1,boxCharP1_2,boxCharP1_3,boxCharP1_4,boxCharP1_5,boxCharP1_6};
        boxCharP2 = new VBox[]{boxCharP2_1,boxCharP2_2,boxCharP2_3,boxCharP2_4,boxCharP2_5,boxCharP1_6};

        // player 1
        for (int i = 0; i<7; ++i){
            if (gameplay.getPlayer(1).getListHandCard().get(i) instanceof Character){
                OnBoardCharComponent x = new OnBoardCharComponent((Character) gameplay.getPlayer(1).getListHandCard().get(i));
                onHandP1[i].getChildren().add(x);
            }
            else if (gameplay.getPlayer(1).getListHandCard().get(i) instanceof Skill){
                OnBoardSkillComponent x = new OnBoardSkillComponent((Skill) gameplay.getPlayer(1).getListHandCard().get(i));
                onHandP1[i].getChildren().add(x);
            }
            else {
                OnBoardLandComponent x = new OnBoardLandComponent((Land) gameplay.getPlayer(1).getListHandCard().get(i));
                onHandP1[i].getChildren().add(x);
            }
        }

        // player 2
        for (int i = 0; i<7; ++i){
            if (gameplay.getPlayer(2).getListHandCard().get(i) instanceof Character){
                OnBoardCharComponent x = new OnBoardCharComponent((Character) gameplay.getPlayer(2).getListHandCard().get(i));
                onHandP2[i].getChildren().add(x);
            }
            else if (gameplay.getPlayer(1).getListHandCard().get(i) instanceof Skill){
                OnBoardSkillComponent x = new OnBoardSkillComponent((Skill) gameplay.getPlayer(2).getListHandCard().get(i));
                onHandP2[i].getChildren().add(x);
            }
            else {
                OnBoardLandComponent x = new OnBoardLandComponent((Land) gameplay.getPlayer(2).getListHandCard().get(i));
                onHandP2[i].getChildren().add(x);
            }
        }

        // flip card p2
        for (int i = 0; i<7; ++i){
            onHandP2[i].setVisible(false);
        }
    }


    public void handleOnMouseClickedGamePlay(MouseEvent mouseEvent) {
//        if (buttonGamePlay.getText().equals("DRAW")){
//            System.out.println("draw kartu");
//            buttonGamePlay.setText("Go To Main");
//        } else {
            gameplay.nextPhase();
            System.out.println(gameplay.getPhaseNow());

            if (phase.equals("draw")) {
                phase = "main1";
//            main1Phase.setS;
                drawPhase.setUnderline(false);
                main1Phase.setUnderline(true);
                buttonGamePlay.setText("Go To Battle");
            } else if (phase.equals("main1")) {
                phase = "battle";
//            battlePhase.setFont(Font.font(28));
                main1Phase.setUnderline(false);
                battlePhase.setUnderline(true);
                buttonGamePlay.setText("END");

            } else if (phase.equals("battle")) {
//            main2Phase.setFont(Font.font(28));
                phase = "end";
                phase = "draw";
                drawPhase.setUnderline(true);
                battlePhase.setUnderline(false);
                buttonGamePlay.setText("Go To Main");

                if (gameplay.getTurnNow()==1){
                    turnLabel.setText("Turn: Player 1");
                }
                else{
                    turnLabel.setText("Turn: Player 2");
                }

                // cek win
                if (gameplay.getKondisiGame()==1){
                    showWinDialog(1);
                }
                else if (gameplay.getKondisiGame()==2){
                    showWinDialog(2);
                }

                // reset power
                gameplay.getPlayer(1).resetPowerPlayer();
                gameplay.getPlayer(2).resetPowerPlayer();
                updateDisplayPowerPlayer1();
                updateDisplayPowerPlayer2();

                // reset land
                gameplay.getPlayer(1).setIsAlreadyUseLand(false);
                gameplay.getPlayer(2).setIsAlreadyUseLand(false);

                //reset draw card
                gameplay.getPlayer(1).setIsAlreadyDrawCard(false);
                gameplay.getPlayer(2).setIsAlreadyDrawCard(false);

                // reset char udah boleh attack
                for (int i = 0; i<6; ++i){
                    if (!boxCharP1[i].getChildren().isEmpty()){
                        ((OnBoardCharComponent) boxCharP1[i].getChildren().get(0)).getCharacter().setIsValidToAttack(true);
                    }
                    if (!boxCharP2[i].getChildren().isEmpty()){
                        ((OnBoardCharComponent) boxCharP2[i].getChildren().get(0)).getCharacter().setIsValidToAttack(true);
                    }
                }

                // flip card hand sesuai turn
                if (gameplay.getTurnNow()==2){
                    for (int i = 0; i<7; ++i){
                        onHandP1[i].setVisible(false);
                    }
                    for (int i = 0; i<7; ++i){
                        onHandP2[i].setVisible(true);
                    }
                }
                else{
                    for (int i = 0; i<7; ++i){
                        onHandP2[i].setVisible(false);
                    }
                    for (int i = 0; i<7; ++i){
                        onHandP1[i].setVisible(true);
                    }
                }
            }
//        }
//        if (!boxCharP1_1.getChildren().isEmpty()){
//            System.out.println("ada node nya");
//            boxCharP1_1.getChildren().clear();
//        } else {
//            System.out.println("gaada node, ditambah ya");
//            OnBoardCharComponent x = new OnBoardCharComponent();
//            boxCharP1_1.getChildren().add(x);
//        }
//        OnBoardSkillComponent y = new OnBoardSkillComponent();
//        onHandP2_1.getChildren().add(y);
//        onHandP2_2.getChildren().clear();
//        OnBoardLandComponent z = new OnBoardLandComponent();
//        onHandP2_2.getChildren().add(z);

//        hoverPreview.getChildren().add(a);
    }

    public void handleOnMouseEntered(MouseEvent mouseEvent) {
//        System.out.println("Mouse masukk");
        VBox x = (VBox) mouseEvent.getSource();
        if (!x.getChildren().isEmpty()){
            if (x.getChildren().get(0) instanceof OnBoardCharComponent) {
                CharacterView charView = new CharacterView();
                Character charBoard = ((OnBoardCharComponent) x.getChildren().get(0)).getCharacter();
                charView.setName(charBoard.getName());
                charView.setDescription(charBoard.getDesc());
                charView.setAtk(String.valueOf(charBoard.getAttack()));
                charView.setDef(String.valueOf(charBoard.getDefense()));
                charView.setPow(String.valueOf(charBoard.getPower()));
                Path path = Paths.get(charBoard.getImgPath());
                Path fileName = path.getFileName();
                Image image = new Image(getClass().getResource("/com/avatarduel/card/image/character/"+fileName).toString());
                charView.setCharacterPict(image);
                charView.setElementPict(charBoard.getImgElementPath());
                hoverPreview.getChildren().add(charView);

            }
            else if (x.getChildren().get(0) instanceof OnBoardSkillComponent){
                SkillView skillView = new SkillView();
                Skill skillBoard = ((OnBoardSkillComponent) x.getChildren().get(0)).getSkill();
                skillView.setName(skillBoard.getName());
                skillView.setDescription(skillBoard.getDesc());
                skillView.setDeltaAtk((String.valueOf(skillBoard.getAttack())));
                skillView.setDeltaAtk(String.valueOf(skillBoard.getDefense()));
                skillView.setPower(String.valueOf(skillBoard.getPower()));
                Path path = Paths.get(skillBoard.getImgPath());
                Path fileName = path.getFileName();
                Image image = new Image(getClass().getResource("/com/avatarduel/card/image/skill/"+fileName).toString());
                skillView.setSkillPict(image);
                skillView.setElementPict(skillBoard.getImgElementPath());
                hoverPreview.getChildren().add(skillView);
            }
            else if (x.getChildren().get(0) instanceof OnBoardLandComponent){
                LandView landView = new LandView();
                Land landBoard = ((OnBoardLandComponent) x.getChildren().get(0)).getLand();
                landView.setName(landBoard.getName());
                landView.setDescription(landBoard.getDesc());
                Path path = Paths.get(landBoard.getImgPath());
                Path fileName = path.getFileName();
                Image image = new Image(getClass().getResource("/com/avatarduel/card/image/land/"+fileName).toString());
                landView.setLandPict(image);
                landView.setElementPict(landBoard.getImgElementPath());
                hoverPreview.getChildren().add(landView);
            }
        }
    }

    public void handleOnMouseExited(MouseEvent mouseEvent) {
//        System.out.println("Mouse Keluar");
        VBox x = (VBox) mouseEvent.getSource();
        if (!x.getChildren().isEmpty()){
            hoverPreview.getChildren().clear();
        }
    }

    public void handleOnMouseClickedVBoxChar(MouseEvent mouseEvent){    // buat yang di board character
        boxBoardClicked = (VBox) mouseEvent.getSource();
        if (gameplay.getPhaseNow().equals("Main Phase")){
            if (isCardHandCharClicked){
                isCardHandCharClicked = false;
                String elementCharacter = characterClicked.getCharacter().getElement();
                int powerAvailable = gameplay.getPlayer(gameplay.getTurnNow()).getPowerAvailable(elementCharacter);
                if (powerAvailable>=characterClicked.getCharacter().getPower()){
                    boxBoardClicked.getChildren().add(characterClicked);
                    gameplay.getPlayer(gameplay.getTurnNow()).setPowerAvailable(elementCharacter,powerAvailable-characterClicked.getCharacter().getPower());
                    if (gameplay.getTurnNow()==1){
                        updateDisplayPowerPlayer1();
                    }
                    else{
                        updateDisplayPowerPlayer2();
                    }
                }
                else{
                    System.out.println(elementCharacter + " : power kurang (needed : "  + characterClicked.getCharacter().getPower() + ", available: " + powerAvailable + ")");
                }
            }
            else if(isCardBoardSkillClicked){
                isCardBoardSkillClicked = false;
                if (!boxBoardClicked.getChildren().isEmpty()){
                    if (skillClicked.getSkill().getIsSkillDestroy()){
                        ((OnBoardCharComponent) boxBoardClicked.getChildren().get(0)).addNewSkill(skillClicked);
                        ((OnBoardCharComponent) boxBoardClicked.getChildren().get(0)).removeAllSkill();
                        boxBoardClicked.getChildren().clear();
                    }
                    else if (skillClicked.getIsAlreadyAttached()){
                        System.out.println("skill already attached");
                    }
                    else {
                        ((OnBoardCharComponent) boxBoardClicked.getChildren().get(0)).addNewSkill(skillClicked);
                        skillClicked.setIsAlreadyAttached(true);
                    }
                }
            }
            else if (!boxBoardClicked.getChildren().isEmpty()){
                Character charComponent = ((OnBoardCharComponent) boxBoardClicked.getChildren().get(0)).getCharacter();
                if (charComponent.getIsAttacking()){
                    boxBoardClicked.setRotate(90);
                    charComponent.setIsAttacking(false); // jadi defense;
                }
                else{
                    boxBoardClicked.setRotate(360);
                    charComponent.setIsAttacking(true); // jadi attack;
                }
            }
        }
        else if (gameplay.getPhaseNow().equals("Battle Phase")){
            OnBoardCharComponent charComponent = (OnBoardCharComponent) boxBoardClicked.getChildren().get(0);
            if (isCardCharAttackClicked){
                isCardCharAttackClicked = false;
                if (!charAttackClicked.getCharacter().getIsValidToAttack() || !charAttackClicked.getCharacter().getIsAttacking()){
                    System.out.println("Belum boleh attack");
                }
                else{
                    System.out.println("diserang: " + charComponent.getCharacter().getName());
                    if (Controller.gameplay.getTurnNow()==1){
                        int diffAttack = gameplay.attackCardToCard(charAttackClicked.getCharacter(),charComponent.getCharacter(),gameplay.getPlayer(2));
                        if (diffAttack!=0){
                            charAttackClicked.getCharacter().setIsValidToAttack(false);
                            System.out.println("attack success");
                            ((OnBoardCharComponent)boxBoardClicked.getChildren().get(0)).removeAllSkill();
                            if (((OnBoardCharComponent)boxBoardClicked.getChildren().get(0)).getCharacter().getIsAttacking()==false){ //kalau bertahan damage nya ga ke player
                                if (charAttackClicked.isHasSkillPowerUp()){
                                    healthP2.setText(Integer.toString(Integer.parseInt(healthP2.getText())-diffAttack));
                                    progressBarP2.setProgress(Integer.parseInt(healthP2.getText())/80.0);
                                    gameplay.getPlayer(2).setHealth(gameplay.getPlayer(2).getHealth()-diffAttack);
                                }
                            }
                            else{
                                healthP2.setText(Integer.toString(Integer.parseInt(healthP2.getText())-diffAttack));
                                progressBarP2.setProgress(Integer.parseInt(healthP2.getText())/80.0);
                                gameplay.getPlayer(2).setHealth(gameplay.getPlayer(2).getHealth()-diffAttack);
                            }
                            boxBoardClicked.getChildren().clear();


                            // cek win
                            if (gameplay.getKondisiGame()==1){
                                showWinDialog(1);
                            }
                        }
                    }
                    else{
                        int diffAttack = gameplay.attackCardToCard(charAttackClicked.getCharacter(),charComponent.getCharacter(),gameplay.getPlayer(1));
                        if (diffAttack!=0){
                            charAttackClicked.getCharacter().setIsValidToAttack(false);
                            System.out.println("attack success");
                            ((OnBoardCharComponent)boxBoardClicked.getChildren().get(0)).removeAllSkill();
                            if (((OnBoardCharComponent)boxBoardClicked.getChildren().get(0)).getCharacter().getIsAttacking()==false) { //kalau bertahan damage nya ga ke player
                                if (charAttackClicked.isHasSkillPowerUp()) {
                                    healthP1.setText(Integer.toString(Integer.parseInt(healthP1.getText())-diffAttack));
                                    progressBarP1.setProgress(Integer.parseInt(healthP1.getText())/80.0);
                                    gameplay.getPlayer(1).setHealth(gameplay.getPlayer(1).getHealth()-diffAttack);
                                }
                            }
                            else{
                                healthP1.setText(Integer.toString(Integer.parseInt(healthP1.getText())-diffAttack));
                                progressBarP1.setProgress(Integer.parseInt(healthP1.getText())/80.0);
                                gameplay.getPlayer(1).setHealth(gameplay.getPlayer(1).getHealth()-diffAttack);
                            }
                            boxBoardClicked.getChildren().clear();


                            // cek win
                            if (gameplay.getKondisiGame()==2){
                                showWinDialog(2);
                            }
                        }
                    }
                }

            }
            else{

                isCardCharAttackClicked = true;
                charAttackClicked = charComponent;
                System.out.println("Penyerang: " + charComponent.getCharacter().getName());


            }

        }
        progressBarP2.setProgress(Integer.parseInt(healthP2.getText())/80.0);
        progressBarP1.setProgress(Integer.parseInt(healthP1.getText())/80.0);
    }

    public void handleOnMouseClickedVBoxSkill(MouseEvent mouseEvent){
        boxBoardClicked = (VBox) mouseEvent.getSource();
        if (isRemoveSkillButtonClicked){
            ((OnBoardSkillComponent) boxBoardClicked.getChildren().get(0)).removeSkill();
        }
        else if (gameplay.getPhaseNow().equals("Main Phase")){
            if (isCardHandSkillClicked){
                isCardHandSkillClicked = false;
                String elementSkill = skillClicked.getSkill().getElement();
                int powerAvailable = gameplay.getPlayer(gameplay.getTurnNow()).getPowerAvailable(elementSkill);
                if (powerAvailable>=skillClicked.getSkill().getPower()){
                    boxBoardClicked.getChildren().add(skillClicked);
                    gameplay.getPlayer(gameplay.getTurnNow()).setPowerAvailable(elementSkill,powerAvailable-skillClicked.getSkill().getPower());
                    if (gameplay.getTurnNow()==1){
                        updateDisplayPowerPlayer1();
                    }
                    else{
                        updateDisplayPowerPlayer2();
                    }
                }
                else{
                    System.out.println(elementSkill + " : power kurang (needed : "  + skillClicked.getSkill().getPower() + ", available: " + powerAvailable + ")");
                }
            }
            else{
                skillClicked = (OnBoardSkillComponent) boxBoardClicked.getChildren().get(0);
                isCardBoardSkillClicked = true;
            }
        }
    }

    public void handleOnMouseClickedVBoxHand(MouseEvent mouseEvent){
        boxHandClicked = (VBox) mouseEvent.getSource();
        if (gameplay.getPhaseNow().equals("Draw Phase")){
            if (!boxHandClicked.getChildren().isEmpty() && isRemoveHandButtonClicked){
                System.out.println("remove card");
                isRemoveHandButtonClicked = false;
                boxHandClicked.getChildren().clear();
            }
            else if (boxHandClicked.getChildren().isEmpty()){
                if (gameplay.getPlayer(gameplay.getTurnNow()).getIsAlreadyDrawCard()){
                    System.out.println("tadi sudah draw card");
                }
                else{
                    gameplay.getPlayer(gameplay.getTurnNow()).setIsAlreadyDrawCard(true);
                    if (gameplay.getTurnNow()==1){
                        Card cardDraw = gameplay.getPlayer(1).getOnDeck().get(gameplay.getPlayer(1).getCntCardInDeck()-1);
                        gameplay.getPlayer(1).setCntCardInDeck(gameplay.getPlayer(1).getCntCardInDeck()-1);
                        deckP1.setText(gameplay.getPlayer(1).getCntCardInDeck()+"/60");
                        if (cardDraw instanceof Character){
                            boxHandClicked.getChildren().add(new OnBoardCharComponent((Character) cardDraw));
                        }
                        else if (cardDraw instanceof Skill){
                            boxHandClicked.getChildren().add(new OnBoardSkillComponent((Skill) cardDraw));
                        }
                        else {
                            boxHandClicked.getChildren().add(new OnBoardLandComponent((Land) cardDraw));
                        }
                    }
                    else{
                        Card cardDraw = gameplay.getPlayer(2).getOnDeck().get(gameplay.getPlayer(2).getCntCardInDeck()-1);
                        gameplay.getPlayer(2).setCntCardInDeck(gameplay.getPlayer(2).getCntCardInDeck()-1);
                        deckP2.setText(gameplay.getPlayer(2).getCntCardInDeck()+"/60");
                        if (cardDraw instanceof Character){
                            boxHandClicked.getChildren().add(new OnBoardCharComponent((Character) cardDraw));
                        }
                        else if (cardDraw instanceof Skill){
                            boxHandClicked.getChildren().add(new OnBoardSkillComponent((Skill) cardDraw));
                        }
                        else{
                            boxHandClicked.getChildren().add(new OnBoardLandComponent((Land) cardDraw));
                        }
                    }
                }

            }
        }
        else if (gameplay.getPhaseNow().equals("Main Phase")){
            if (boxHandClicked.getChildren().get(0) instanceof OnBoardCharComponent){
                isCardHandCharClicked = true;
                characterClicked = (OnBoardCharComponent) boxHandClicked.getChildren().get(0);
            }
            else if (boxHandClicked.getChildren().get(0) instanceof OnBoardSkillComponent){
                isCardHandSkillClicked = true;
                skillClicked = (OnBoardSkillComponent) boxHandClicked.getChildren().get(0);
            }
            else if (boxHandClicked.getChildren().get(0) instanceof OnBoardLandComponent){
                if (gameplay.getPlayer(gameplay.getTurnNow()).getIsAlreadyUseLand()) {
                    System.out.println("udah pakai land tadi 1 kali");
                }
                else{
                    gameplay.getPlayer(gameplay.getTurnNow()).setIsAlreadyUseLand(true);
                    String element = ((OnBoardLandComponent)boxHandClicked.getChildren().get(0)).getLand().getElement();
                    boxHandClicked.getChildren().clear();
                    int turn = gameplay.getTurnNow();
                    if (turn==1){
                        if (element.equals("AIR")){
                            gameplay.getPlayer(1).setPowerAvailable("AIR",gameplay.getPlayer(1).getPowerAvailable("AIR")+1);
                            gameplay.getPlayer(1).setPowerMax("AIR",gameplay.getPlayer(1).getPowerMax("AIR")+1);

                        }
                        else if (element.equals("WATER")){
                            gameplay.getPlayer(1).setPowerAvailable("WATER",gameplay.getPlayer(1).getPowerAvailable("WATER")+1);
                            gameplay.getPlayer(1).setPowerMax("WATER",gameplay.getPlayer(1).getPowerMax("WATER")+1);
                        }
                        else if (element.equals("EARTH")){
                            gameplay.getPlayer(1).setPowerAvailable("EARTH",gameplay.getPlayer(1).getPowerAvailable("EARTH")+1);
                            gameplay.getPlayer(1).setPowerMax("EARTH",gameplay.getPlayer(1).getPowerMax("EARTH")+1);
                        }
                        else if (element.equals("FIRE")){
                            gameplay.getPlayer(1).setPowerAvailable("FIRE",gameplay.getPlayer(1).getPowerAvailable("FIRE")+1);
                            gameplay.getPlayer(1).setPowerMax("FIRE",gameplay.getPlayer(1).getPowerMax("FIRE")+1);
                        }
                        else if (element.equals("ENERGY")){
                            gameplay.getPlayer(1).setPowerAvailable("ENERGY",gameplay.getPlayer(1).getPowerAvailable("ENERGY")+1);
                            gameplay.getPlayer(1).setPowerMax("ENERGY",gameplay.getPlayer(1).getPowerMax("ENERGY")+1);
                        }
                        System.out.println(gameplay.getPlayer(1).getPowerMax(element));
                        updateDisplayPowerPlayer1();
                    }
                    else{
                        if (element.equals("AIR")){
                            gameplay.getPlayer(2).setPowerAvailable("AIR",gameplay.getPlayer(2).getPowerAvailable("AIR")+1);
                            gameplay.getPlayer(2).setPowerMax("AIR",gameplay.getPlayer(2).getPowerMax("AIR")+1);
                        }
                        else if (element.equals("WATER")){
                            gameplay.getPlayer(2).setPowerAvailable("WATER",gameplay.getPlayer(2).getPowerAvailable("WATER")+1);
                            gameplay.getPlayer(2).setPowerMax("WATER",gameplay.getPlayer(2).getPowerMax("WATER")+1);
                        }
                        else if (element.equals("EARTH")){
                            gameplay.getPlayer(2).setPowerAvailable("EARTH",gameplay.getPlayer(2).getPowerAvailable("EARTH")+1);
                            gameplay.getPlayer(2).setPowerMax("EARTH",gameplay.getPlayer(2).getPowerMax("EARTH")+1);
                        }
                        else if (element.equals("FIRE")){
                            gameplay.getPlayer(2).setPowerAvailable("FIRE",gameplay.getPlayer(2).getPowerAvailable("FIRE")+1);
                            gameplay.getPlayer(2).setPowerMax("FIRE",gameplay.getPlayer(2).getPowerMax("FIRE")+1);
                        }
                        else if (element.equals("ENERGY")){
                            gameplay.getPlayer(2).setPowerAvailable("ENERGY",gameplay.getPlayer(1).getPowerAvailable("ENERGY")+1);
                            gameplay.getPlayer(2).setPowerMax("ENERGY",gameplay.getPlayer(1).getPowerMax("ENERGY")+1);
                        }
                        updateDisplayPowerPlayer2();
                    }
                }

            }
        }
    }

    public void handleMouseOnClickPlayer1(MouseEvent mouseEvent){
        if (isCardCharAttackClicked){
            isCardCharAttackClicked = false;
            if (!charAttackClicked.getCharacter().getIsValidToAttack() || !charAttackClicked.getCharacter().getIsAttacking()){
                System.out.println("Belum boleh attack");
            }
            else{
                boolean isValidDirectAttack = true;
                for (int i = 0; i<6; ++i){
                    if (!boxCharP1[i].getChildren().isEmpty()){
                        isValidDirectAttack = false;
                        break;
                    }
                }
                if (isValidDirectAttack){
                    charAttackClicked.getCharacter().setIsValidToAttack(false);
                    int healthNow = gameplay.getPlayer(1).getHealth()-characterClicked.getCharacter().getAttack();
                    System.out.println(healthNow);
                    gameplay.getPlayer(1).setHealth(healthNow);
                    healthP1.setText(Integer.toString(healthNow));
                    if (gameplay.getKondisiGame()==2){
                        showWinDialog(2);
                    }
                }
                else{
                    System.out.println("not valid direct attack");
                }
            }

        }
    }

    public void handleMouseOnClickPlayer2(MouseEvent mouseEvent){
        if (isCardCharAttackClicked){
            isCardCharAttackClicked = false;
            if (!charAttackClicked.getCharacter().getIsValidToAttack() || !charAttackClicked.getCharacter().getIsAttacking()){
                System.out.println("Belum boleh attack");
            }
            else{
                boolean isValidDirectAttack = true;
                for (int i = 0; i<6; ++i){
                    if (!boxCharP2[i].getChildren().isEmpty()){
                        isValidDirectAttack = false;
                        break;
                    }
                }
                if (isValidDirectAttack){
                    charAttackClicked.getCharacter().setIsValidToAttack(false);
                    int healthNow = gameplay.getPlayer(2).getHealth()-characterClicked.getCharacter().getAttack();
                    System.out.println(healthNow);
                    gameplay.getPlayer(2).setHealth(healthNow);
                    healthP2.setText(Integer.toString(healthNow));
                    if (gameplay.getKondisiGame()==1){
                        showWinDialog(1);
                    }
                }
                else{
                    System.out.println("not valid direct attack");
                }
            }

        }
    }


    public void showWinDialog(int player){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Ended");
        alert.setHeaderText(null);
        alert.setContentText("Congratulation for player " + player + " ,you win the game");

        alert.showAndWait();
    }

    public void updateDisplayPowerPlayer1(){
        powerAir_P1.setText(Integer.toString(gameplay.getPlayer(1).getPowerAvailable("AIR"))+" / "+Integer.toString(gameplay.getPlayer(1).getPowerMax("AIR")));
        powerEarth_P1.setText(Integer.toString(gameplay.getPlayer(1).getPowerAvailable("EARTH"))+" / "+Integer.toString(gameplay.getPlayer(1).getPowerMax("EARTH")));
        powerFire_P1.setText(Integer.toString(gameplay.getPlayer(1).getPowerAvailable("FIRE"))+" / "+Integer.toString(gameplay.getPlayer(1).getPowerMax("FIRE")));
        powerWater_P1.setText(Integer.toString(gameplay.getPlayer(1).getPowerAvailable("WATER"))+" / "+Integer.toString(gameplay.getPlayer(1).getPowerMax("WATER")));
        powerEnergy_P1.setText(Integer.toString(gameplay.getPlayer(1).getPowerAvailable("ENERGY"))+" / "+Integer.toString(gameplay.getPlayer(1).getPowerMax("ENERGY")));
    }

    public void updateDisplayPowerPlayer2(){
        powerAir_P2.setText(Integer.toString(gameplay.getPlayer(2).getPowerAvailable("AIR"))+" / "+Integer.toString(gameplay.getPlayer(2).getPowerMax("AIR")));
        powerEarth_P2.setText(Integer.toString(gameplay.getPlayer(2).getPowerAvailable("EARTH"))+" / "+Integer.toString(gameplay.getPlayer(2).getPowerMax("EARTH")));
        powerFire_P2.setText(Integer.toString(gameplay.getPlayer(2).getPowerAvailable("FIRE"))+" / "+Integer.toString(gameplay.getPlayer(2).getPowerMax("FIRE")));
        powerWater_P2.setText(Integer.toString(gameplay.getPlayer(2).getPowerAvailable("WATER"))+" / "+Integer.toString(gameplay.getPlayer(2).getPowerMax("WATER")));
        powerEnergy_P2.setText(Integer.toString(gameplay.getPlayer(2).getPowerAvailable("ENERGY"))+" / "+Integer.toString(gameplay.getPlayer(2).getPowerMax("ENERGY")));
    }

    public void HandleOnMouseClickedRemoveSkill(){
        isRemoveSkillButtonClicked = true;
    }

    public void handleOnMouseClickedRectangle(MouseEvent mouseEvent){


    }

    public  void HandleOnMouseClickedRemoveHand(){
        isRemoveHandButtonClicked = true;
        System.out.println("remove hand clicked");
    }

}
