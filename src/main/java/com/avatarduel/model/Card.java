package com.avatarduel.model;

import javafx.scene.Node;
import javafx.scene.image.Image;
/**
 * Card adalah kelas yang merepresentasikan sebuah blueprint dari kartu.
 * Kartu pada umumnya terdapat ic, nama, elemen, deskrips, gambar
 * @author Kelompok 6 OOP K1
 */
public class Card {
    protected String id;
    protected String name;
    protected String element;
    protected String description;
    protected String imagePath;
    protected String cardType;

    /**
     * Creates a new new Card using tehir identity
     * @param id id kartu
     * @param name nama kartu
     * @param element nama elemen
     * @param description deskripsi kartu
     * @param imagePath path gambar kartu
     * @param cardType tipe kartu (charcter, skill, land)
     *
     */
    public Card(String id, String name, String element, String description, String imagePath, String cardType){
        this.id = id;
        this.name = name;
        this.element = element;
        this.description = description;
        this.imagePath = imagePath;
        this.cardType = cardType;
    }

    /**
     * Creates a new reader from card (copy constructor)
     * @param card Kartu yang ingin dikopi
     */
    public Card(Card card){
        this.id = card.id;
        this.name = card.name;
        this.element = card.element;
        this.description = card.description;
        this.imagePath = card.imagePath;
        this.cardType = card.cardType;
    }



    /**
     * Get value of id
     */
    public String getID(){
        return this.id;
    }
    /**
     * Get value of name
     */
    public String getName(){
        return this.name;
    }
    /**
     * Get value of element
     */
    public String getElement(){
        return this.element;
    }
    /**
     * Get value of description
     */
    public String getDesc(){
        return this.description;
    }
    /**
     * Get value of image path
     */
    public String getImgPath(){
        return this.imagePath;
    }
    /**
     * Get value of card type
     */
    public String getCardType(){
        return this.cardType;
    }
    /**
     * Get value of Imgee elemnt
     */
    public Image getImgElementPath(){
        if (this.getElement().equals("WATER")){
            return new Image(getClass().getResource("/com/avatarduel/card/image/symbol/water.png").toString());
        } else if (this.getElement().equals("AIR")){
            return new Image(getClass().getResource("/com/avatarduel/card/image/symbol/air.png").toString());
        } else if (this.getElement().equals("EARTH")){
            return new Image(getClass().getResource("/com/avatarduel/card/image/symbol/earth.png").toString());
        } else if (this.getElement().equals("FIRE")){
            return new Image(getClass().getResource("/com/avatarduel/card/image/symbol/fire.png").toString());
        } else if (this.getElement().equals("ENERGY")) {
            return new Image(getClass().getResource("/com/avatarduel/card/image/symbol/energy.png").toString());
        }
        return null;
    }

    /**
     * Set value of id
     * @param id id card
     */
    public void setID(String id){
        this.id = id;
    }
    /**
     * Set value of name
     * @param name name of the card
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Set value of element
     * @param element elemnent of the card
     */
    public void setElement(String element){
        this.element = element;
    }
    /**
     * Set value of description
     * @param description description of the card
     */
    public void setDesc(String description){
        this.description = description;
    }
    /**
     * Set value of image path card
     * @param imagePath image path of the card
     */
    public void setImgPath(String imagePath){
        this.imagePath = imagePath;
    }
    /**
     * Set value of cardType
     * @param cardType type of the card
     */
    public void setCardType(String cardType){
        this.cardType = cardType;
    }
}   
