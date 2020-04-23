package com.avatarduel.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SkillTest extends CardTest {

    @Test
    public void getAttack() {
        Skill testSkill = new Skill("id", "name", "element", "description", "imagePath", 2, 3, 4);
        assertEquals(2, testSkill.getAttack());
    }

    @Test
    public void getDefense() {
        Skill testSkill = new Skill("id", "name", "element", "description", "imagePath", 2, 3, 4);
        assertEquals(3, testSkill.getDefense());
    }

    @Test
    public void getPower() {
        Skill testSkill = new Skill("id", "name", "element", "description", "imagePath", 2, 3, 4);
        assertEquals(4, testSkill.getPower());
    }

    @Test
    public void setDefense() {
        Skill testSkill = new Skill("id", "name", "element", "description", "imagePath", 2, 3, 4);
        testSkill.setDefense(6);
        assertEquals(6, testSkill.getDefense());
    }

    @Test
    public void setPower() {
        Skill testSkill = new Skill("id", "name", "element", "description", "imagePath", 2, 3, 4);
        testSkill.setPower(7);
        assertEquals(7, testSkill.getPower());
    }
}