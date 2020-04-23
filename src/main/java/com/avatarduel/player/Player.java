package com.avatarduel.player;

import com.avatarduel.model.Card;

import java.util.ArrayList;
import java.util.List;
/**
 * Player adalah kelas yang merepresentasikan pemain dari game ini.
 * Player terdiri dari deck kartu yang dimiliki, HP, state, dan status - status lainnya
 * @author Kelompok 6 OOP K1
 */
public class Player
{
    /*
    Atribut
    - list of card di deck
    - array of card di hand
    - array of card di board
    - nyawa
    - state" lainnya yang penting (power elemen, dll)

    method:
    - pick card dari deck
    - put card ke board
    - buang card
    */

    //ATRIBUT
    private List<Card> onDeck;
    private List<Card> onHand;
    private List<Card> onBoard;
    private int health;
    private String elemen;
    private int playerBerapa; // Player 1 atau 2
    private String charState; //"Menyerang" atau "Bertahan"
    private int cntCardInDeck;
    /**
     * If set to true, Land is used.
     */
    private boolean isAlreadyUseLand;
    /**
     * If set to true, Player already draw a card.
     */
    private boolean isAlreadyDrawCard;

    private int powerAvailableAIR, powerAvailableWATER, powerAvailableFIRE, powerAvailableEARTH, powerAvailableENERGY;
    private int powerMaxAIR, powerMaxWATER, powerMaxFIRE, powerMaxEARTH, powerMaxENERGY;

    /**
     * Creates a new Player form list of card onDeck, onhand, and status player
     * @param _onDeck list card on deck
     * @param _onHand list card on hand
     * @param _playerBerapa status player
     */
    public Player(List<Card> _onDeck, List<Card> _onHand, int _playerBerapa)
    {
        this.onDeck = _onDeck; //Minimal 40 kartu maksimal 60 kartu. Perlu kesepakatan atau jumlahnya random juga?
        this.onHand = _onHand; //Dikasih 7 kartu
        this.onBoard = new ArrayList<Card>();
        this.health = 80;
//        this.elemen = _elemen; //Dibilang sama Taufiq di grup tapi gak nemu penjelasannya
        this.playerBerapa = _playerBerapa;
//        this.charState = "Menyerang"; // Cuma "Menyerang" atau "Bertahan". Nilai defaultnya menyerang aja
        cntCardInDeck = 60;
        powerAvailableAIR = 0;
        powerAvailableWATER = 0;
        powerAvailableFIRE = 0;
        powerAvailableEARTH = 0;
        powerAvailableENERGY = 0;
        powerMaxAIR = 0;
        powerMaxEARTH = 0;
        powerMaxFIRE = 0;
        powerMaxWATER = 0;
        powerMaxENERGY = 0;
        isAlreadyUseLand = false;
        isAlreadyDrawCard = false;
    }

    public Player(){
        this.health = 80;
//        this.elemen = _elemen; //Dibilang sama Taufiq di grup tapi gak nemu penjelasannya
//        this.charState = "Menyerang"; // Cuma "Menyerang" atau "Bertahan". Nilai defaultnya menyerang aja
        cntCardInDeck = 60;
        powerAvailableAIR = 0;
        powerAvailableWATER = 0;
        powerAvailableFIRE = 0;
        powerAvailableEARTH = 0;
        powerAvailableENERGY = 0;
        powerMaxAIR = 0;
        powerMaxEARTH = 0;
        powerMaxFIRE = 0;
        powerMaxWATER = 0;
        powerMaxENERGY = 0;
        isAlreadyUseLand = false;
        isAlreadyDrawCard = false;
    }

    /**
     * Get payer status (dead or not)
     */
    public boolean isPlayerDead()
    {
        return (this.health == 0);
    }
    /**
     * Get payer status (attack or not)
     */
    public boolean isMenyerang()
    {
        return (this.charState.equals("Menyerang"));
    }
    /**
     * Get payer status (defend or not)
     */
    public boolean isBertahan()
    {
        return (this.charState.equals("Bertahan"));
    }
    /**
     * Get payer health
     */
    public int getHealth(){
        return this.health;
    }
    /**
     * Get number of card player in deck
     */
    public int getCntCardInDeck(){
        return cntCardInDeck;
    }
    /**
     * Get player card on deck
     */
    public List<Card> getOnDeck(){
        return onDeck;
    }
    /**
     * Get player status use land in main phase
     */
    public boolean getIsAlreadyUseLand(){
        return isAlreadyUseLand;
    }
    /**
     * Get player status (use land in draw phase)
     */
    public boolean getIsAlreadyDrawCard(){
        return isAlreadyDrawCard;
    }
    /**
     * Get available power of the card
     */
    public int getPowerAvailable(String element) {
        if (element.equals("AIR")) return powerAvailableAIR;
        if (element.equals("WATER")) return powerAvailableWATER;
        if (element.equals("FIRE")) return powerAvailableFIRE;
        if (element.equals("EARTH")) return powerAvailableEARTH;
        if (element.equals("ENERGY")) return powerAvailableENERGY;
        return -1;
    }
    /**
     * Get max power of the card
     */
    public int getPowerMax(String element) {
        if (element.equals("AIR")) return powerMaxAIR;
        if (element.equals("WATER")) return powerMaxWATER;
        if (element.equals("FIRE")) return powerMaxFIRE;
        if (element.equals("EARTH")) return powerMaxEARTH;
        if (element.equals("ENERGY")) return powerMaxENERGY;
        return -1;
    }

    /**
     * Set health of the player
     * @param health health of the player
     */
    public void setHealth(int health){
        this.health = health;
    }
    /**
     * Set number of card in deck
     * @param cnt number of card
     */
    public void setCntCardInDeck(int cnt){
        cntCardInDeck = cnt;
    }
    /**
     * Set power availabel
     * @param element element to set
     * @param val value of power
     */
    public void setPowerAvailable(String element, int val) {
        if (element.equals("AIR")) powerAvailableAIR = val;
        if (element.equals("WATER"))  powerAvailableWATER = val;
        if (element.equals("FIRE"))  powerAvailableFIRE = val;
        if (element.equals("EARTH"))  powerAvailableEARTH = val;
        if (element.equals("ENERGY")) powerAvailableENERGY = val;
    }
    /**
     * Set max power
     * @param element element to set
     * @param val value of power
     */
    public void setPowerMax(String element, int val) {
        if (element.equals("AIR")) powerMaxAIR = val;
        if (element.equals("WATER")) powerMaxWATER = val;
        if (element.equals("FIRE")) powerMaxFIRE= val;
        if (element.equals("EARTH")) powerMaxEARTH = val;
        if (element.equals("ENERGY")) powerMaxENERGY = val;
    }
    /**
     * Reset the power of the card
     */
    public void resetPowerPlayer(){
        powerAvailableENERGY = powerMaxENERGY;
        powerAvailableEARTH = powerMaxEARTH;
        powerAvailableAIR = powerMaxAIR;
        powerAvailableFIRE = powerMaxFIRE;
        powerAvailableWATER = powerMaxWATER;
    }

    /**
     * Get list on hand card
     */
    public List<Card> getListHandCard(){
        return onHand;
    }

    public void setIsAlreadyUseLand(boolean isAlreadyUseLand){
        this.isAlreadyUseLand = isAlreadyUseLand;
    }
    public void setIsAlreadyDrawCard(boolean isAlreadyDrawCard){
        this.isAlreadyDrawCard = isAlreadyDrawCard;
    }
}


