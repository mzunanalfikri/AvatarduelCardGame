package com.avatarduel.model;

public class Character extends Card {
    private int attack;
    private int defense;
    private int power;
    private boolean isAttacking;
    private boolean isValidToAttack;
    public Character(String id, String name, String element, String description, String imagePath, int attack, int defense, int power){
        super(id,name,element,description,imagePath,"Character");
        this.attack = attack;
        this.defense = defense;
        this.power = power;
        this.isAttacking = true;
        isValidToAttack = false;
    }

    // copy constructor
    public Character(Character character){
        super(character.id,character.name,character.element,character.description,character.imagePath,"Character");
        this.attack = character.attack;
        this.defense = character.defense;
        this.power = character.power;
        this.isAttacking = true;
    }

    //GETTER
    public int getAttack(){
        return this.attack;
    }
    public int getDefense(){
        return this.defense;
    }
    public int getPower(){
        return this.power;
    }
    public boolean getIsAttacking(){
        return this.isAttacking;
    }
    public boolean getIsValidToAttack(){
        return isValidToAttack;
    }
    
    //SETTER
    public void setAttack(int attack){
        this.attack = attack;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
    public void setPower(int power){
        this.power = power;
    }
    public void setIsAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }
    public void setIsValidToAttack(boolean isValidToAttack){
        this.isValidToAttack = isValidToAttack;
    }

    public void applySkillAura(Skill skill){
        attack += skill.getAttack();
        defense += skill.getDefense();
    }


}
