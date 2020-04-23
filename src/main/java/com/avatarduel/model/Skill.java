package com.avatarduel.model;

public class Skill extends Card {
    private int attack;
    private int defense;
    private int power;
    private boolean isSkillDestroy;
    private boolean isSkillPowerUp;

    public Skill(String id, String name, String element, String description, String imagePath, int attack, int defense, int power){
        super(id,name,element,description,imagePath,"Skill");
        this.attack = attack;
        this.defense = defense;
        this.power = power;
        isSkillDestroy = false;
        isSkillPowerUp = false;
    }

    // copy constructor
    public Skill(Skill skill){
        super(skill.id,skill.name,skill.element,skill.description,skill.imagePath,"Skill");
        this.attack = skill.attack;
        this.defense = skill.defense;
        this.power = skill.power;
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
    public boolean getIsSkillDestroy(){
        return isSkillDestroy;
    }
    public boolean getIsSkillPowerUp(){
        return isSkillPowerUp;
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
    public void setIsSkillDestroy(boolean isSkillDestroy){
        this.isSkillDestroy = isSkillDestroy;
    }
    public void setSkillPowerUp(boolean isSkillPowerUp){
        this.isSkillPowerUp = isSkillPowerUp;
    }

}

