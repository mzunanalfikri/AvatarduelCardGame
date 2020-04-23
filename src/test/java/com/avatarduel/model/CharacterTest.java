package com.avatarduel.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest extends CardTest {

    @Test
    public void getAttack() {
        Character test = new Character("p1", "Zuko", "FIRE", "desc", "/dor.jpg", 5, 6, 7);
        assertEquals(5, test.getAttack());
    }

    @Test
    public void getDefense() {
        Character test = new Character("p1", "Zuko", "FIRE", "desc", "/dor.jpg", 5, 6, 7);
        assertEquals(6, test.getDefense());
    }

    @Test
    public void getPower() {
        Character test = new Character("p1", "Zuko", "FIRE", "desc", "/dor.jpg", 5, 6, 7);
        assertEquals(7, test.getPower());
    }

    @Test
    public void getIsAttacking() {
        Character test = new Character("p1", "Zuko", "FIRE", "desc", "/dor.jpg", 5, 6, 7);
        assertEquals(true, test.getIsAttacking());
    }

    @Test
    public void getIsValidToAttack() {
        Character test = new Character("p1", "Zuko", "FIRE", "desc", "/dor.jpg", 5, 6, 7);
        assertEquals(false, test.getIsValidToAttack());
    }

    @Test
    public void setAttack() {
        Character test = new Character("p1", "Zuko", "FIRE", "desc", "/dor.jpg", 5, 6, 7);
        test.setAttack(1);
        assertEquals(1, test.getAttack());
    }

    @Test
    public void setDefense() {
        Character test = new Character("p1", "Zuko", "FIRE", "desc", "/dor.jpg", 5, 6, 7);
        test.setDefense(1);
        assertEquals(1, test.getDefense());
    }

    @Test
    public void setPower() {
        Character test = new Character("p1", "Zuko", "FIRE", "desc", "/dor.jpg", 5, 6, 7);
        test.setPower(1);
        assertEquals(1, test.getPower());
    }

    @Test
    public void setIsAttacking() {
        Character test = new Character("p1", "Zuko", "FIRE", "desc", "/dor.jpg", 5, 6, 7);
        test.setIsAttacking(false);
        assertEquals(false, test.getIsAttacking());
    }

    @Test
    public void setIsValidToAttack() {
        Character test = new Character("p1", "Zuko", "FIRE", "desc", "/dor.jpg", 5, 6, 7);
        test.setIsValidToAttack(true);
        assertEquals(true, test.getIsValidToAttack());

    }

    @Test
    public void applySkillAura() {
        Character test = new Character("p1", "Zuko", "FIRE", "desc", "/dor.jpg", 5, 6, 7);
        Skill testSkill = new Skill("id", "name", "element", "description", "imagePath", 2, 2, 2);
        test.applySkillAura(testSkill);
        assertEquals(7, test.getAttack());
        assertEquals(8, test.getDefense());
    }
}