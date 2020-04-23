package com.avatarduel.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void getID() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        assertEquals("1", test.getID());
    }

    @Test
    public void getName() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        assertEquals("Zuko", test.getName());
    }

    @Test
    public void getElement() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        assertEquals("AIR", test.getElement());
    }

    @Test
    public void getDesc() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        assertEquals("zuko adalah zuko", test.getDesc());
    }

    @Test
    public void getImgPath() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        assertEquals("/zuko.jpg", test.getImgPath());
    }

    @Test
    public void getCardType() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        assertEquals("Character", test.getCardType());
    }

    @Test
    public void setID() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        test.setID("FIRE");
        assertEquals("FIRE", test.getID());
    }

    @Test
    public void setName() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        test.setName("Katara");
        assertEquals("Katara", test.getName());
    }

    @Test
    public void setElement() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        test.setElement("FIRE");
        assertEquals("FIRE", test.getElement());
    }

    @Test
    public void setDesc() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        test.setDesc("Zuko kakaknya Azula");
        assertEquals("Zuko kakaknya Azula", test.getDesc());
    }

    @Test
    public void setImgPath() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        test.setImgPath("/folderDummy/zuko.jpg");
        assertEquals("/folderDummy/zuko.jpg", test.getImgPath());
    }

    @Test
    public void setCardType() {
        Card test = new Card("1", "Zuko", "AIR", "zuko adalah zuko", "/zuko.jpg", "Character");
        test.setCardType("Element");
        assertEquals("Element", test.getCardType());
    }
}