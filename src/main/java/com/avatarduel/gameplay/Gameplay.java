package com.avatarduel.gameplay;

import com.avatarduel.loader.GameLoader;
import com.avatarduel.model.Card;
import com.avatarduel.model.Land;
import com.avatarduel.model.Skill;
import com.avatarduel.player.Player;
import com.avatarduel.model.Character;

import com.avatarduel.util.CSVReader;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class Gameplay {
    private Player player1;
    private Player player2;
    private int idxPhaseGame;
    private int turn;

    private static String phaseGame[] ={"Draw Phase","Main Phase", "Battle Phase"};

    private static List<Card> pickAwal(int size, List<Land> ll, List<Character> lc, List<Skill> ls ){// proporsi 2:2:1
        List<Card> l = new ArrayList<Card>();
        int cnt = 0;
        int turn = 0;
        for (int i = 0; i<size; ++i){
            if (turn==0){
                int idx = (int) (Math.random() * ((ll.size() - 1 - 0) + 1)); //(Math.random() * ((max - min) + 1)) + min
                l.add(new Land(ll.get(idx)));
                cnt++;
                if (cnt==2){
                    cnt = 0;
                    turn = 1;
                }
            }
            else if (turn==1){
                int idx = (int) (Math.random() * ((lc.size() - 1 - 0) + 1)); //(Math.random() * ((max - min) + 1)) + min
                l.add(new Character(lc.get(idx)));
                cnt++;
                if (cnt==2){
                    cnt = 0;
                    turn = 2;
                }
            }
            else{
                int idx = (int) (Math.random() * ((ls.size() - 1 - 0) + 1)); //(Math.random() * ((max - min) + 1)) + min
                l.add(new Skill(ls.get(idx)));
                cnt = 0;
                turn = 0;
            }
        }
        return l;
    }




    public Gameplay(GameLoader loader) throws IOException, URISyntaxException {
        System.out.println("Game play constructed");

        idxPhaseGame = 0;
        turn = 1;

        List<Land> ll = loader.getLandList();
        List<Character> lc = loader.getCharacterList();
        List<Skill> ls = loader.getSkillList();

        System.out.println(ll.size());
        System.out.println(lc.size());
        System.out.println(ls.size());

        int sizeDeck = 60;
        int sizeHand = 7;
        List<Card> deck1 = pickAwal(sizeDeck,ll,lc,ls);
        List<Card> deck2 = pickAwal(sizeDeck,ll,lc,ls);
        List<Card> hand1 = pickAwal(sizeHand,ll,lc,ls);
        List<Card> hand2 = pickAwal(sizeHand,ll,lc,ls);


        // cek isi
//        for (int i = 0; i<sizeDeck; ++i){
//            if (deck1.get(i) instanceof Character){
//                System.out.println("Character");
//            }
//            else if (deck1.get(i) instanceof Land){
//                System.out.println("land");
//            }
//            else{
//                System.out.println("Skill");
//            }
//        }

        // setelah ini construct player
        // List<Card> _onDeck, List<Card> _onHand, List<Card> _onBoard, int _playerBerapa, String _charState
        player1 = new Player(deck1,hand1,1);         // belum fix
        player2 = new Player(deck2,hand2,2);         // belum fix
    }

    public Player getPlayer(int player){
        if (player==1){
            return player1;
        }
        else return player2;
    }

    public void nextPhase(){    // ganti ke game state selanjutnya
        idxPhaseGame++;
        idxPhaseGame%=3;
        if (idxPhaseGame==0){
            turn%=2;
            turn++;
        }
    }

    public String getPhaseNow(){           // phase sekarang
        return phaseGame[idxPhaseGame];
    }

    public int getTurnNow(){        // turn sekarang
        return turn;
    }

    public int attackCardToCard(Character card1, Character card2, Player playerTarget){       // attack dari kartu ke kartu
        // cek posisi card2 (menyerang/bertahan)
        if (card2.getIsAttacking()){ // menyerang
            if (card1.getAttack() > card2.getAttack()){
                int diff =  card1.getAttack() - card2.getAttack();
                attackCardToPlayer(diff,playerTarget);
                return diff; // berhasil nyerang
            }
        }
        else{
            if (card1.getAttack() > card2.getDefense()){
                int diff =  card1.getAttack() - card2.getDefense();
                attackCardToPlayer(diff,playerTarget);
                return diff; // berhasil nyerang
            }
        }
        return 0; // fail to attack
    }


    public void attackCardToPlayer(int attack, Player playerTarget){
        // minus HP player
        playerTarget.setHealth(playerTarget.getHealth()-attack);
    }


    public boolean isCardDeckKosong(Player player){       // ngecek jika deck kosong
        return  (player.getCntCardInDeck()==0);
    }


    public int getKondisiGame(){
        // jika 1 player 1 menang, jika 2 player 2 menang, jika 0 belum ada yg menang
        // if health player 1 = 0  atau deck player 1 habis -> player 2 menang
        if (player1.getHealth()<=0 || isCardDeckKosong(player1)) return 2;
        else if (player2.getHealth()<=0 || isCardDeckKosong(player2)) return 1; // else if health player 2 = 0 -> player 1 menang
        return 0;
    }
}
