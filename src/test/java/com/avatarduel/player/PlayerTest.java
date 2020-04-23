package com.avatarduel.player;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void isPlayerDead() {
        Player p = new Player();
        Player q = new Player();
        assertEquals(p.isPlayerDead(), q.isPlayerDead());
    }

    @Test
    public void getHealth() {
        Player a = new Player();
        assertEquals(80, a.getHealth());
    }

    @Test
    public void getCntCardInDeck() {
        Player a = new Player();
        assertEquals(60, a.getCntCardInDeck());
    }

    @Test
    public void setHealth() {
        Player a = new Player();
        a.setHealth(7);
        assertEquals(7, a.getHealth());
    }
}