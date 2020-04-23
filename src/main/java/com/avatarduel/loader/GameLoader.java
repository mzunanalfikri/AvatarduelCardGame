package com.avatarduel.loader;

import java.io.*;
import java.util.*;

import com.avatarduel.model.Land;
import com.avatarduel.model.Character;
import com.avatarduel.model.Skill;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

/**
 * GameLoader adalah kelas pemroses file eksternal konfigurasi kartu dalam permainan.
 *
 * @author Kelompok 6 K1 IF2210
 */
public class GameLoader {
    private List<Character>  gameCharacter = new ArrayList<Character>(); //Fadhil
    private List<Land>  gameLand = new ArrayList<Land>();
    private List<Skill> gameSkill = new ArrayList<Skill>();

    /**
     * Memuat konfigurasi game dari file-file eksternal.
     * @param fileCharacter file csv berisi konfigurasi karakter
     * @param fileLand file csv berisi konfigurasi land
     * @param fileSkill file csv berisi konfigurasi skill
     */
    public GameLoader(File fileCharacter, File fileLand, File fileSkill) throws IOException {
        loadCharacter(fileCharacter);
        loadLand(fileLand);
        loadSkill(fileSkill);
    }

    /**
     * Melakukan loading file eksternal <filename>.csv yang berhubungan dengan karakter permainan.
     * @param fileName nama file konfigurasi karakter
     */
    public void loadCharacter(File filename) throws IOException {
        BufferedReader br = null;
        String line = "";
        String separatorString = "\t";
        br = new BufferedReader(new FileReader(filename));
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] charRead = line.split(separatorString);
            if (i!=0) {
                int att = Integer.parseInt(charRead[5]);
                int def = Integer.parseInt(charRead[6]);
                int pow = Integer.parseInt(charRead[7]);
                Character C = new Character(charRead[0], charRead[1], charRead[2], charRead[3], charRead[4], att, def, pow);
                gameCharacter.add(C);
            }
            i++;
        }
    }

    /**
     * Melakukan loading file eksternal <filename>.csv yang berhubungan dengan land permainan.
     * @param fileName nama file konfigurasi land
     */
    public void loadLand(File filename) throws IOException {
        BufferedReader br = null;
        String line = "";
        String separatorString = "\t";
        br = new BufferedReader(new FileReader(filename));
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] charRead = line.split(separatorString);
            System.out.print(charRead[3] + " | ");
            System.out.println(charRead[4]);
            if (i!=0){
                Land L = new Land(charRead[0],charRead[1],charRead[2],charRead[3],charRead[4]);
                gameLand.add(L);
            }
            i++;
        }
    }

    /**
     * Melakukan loading file eksternal <filename>.csv yang berhubungan dengan skill permainan.
     * @param fileName nama file konfigurasi skill
     */
    public void loadSkill(File filename) throws IOException {
        BufferedReader br = null;
        String line = "";
        String separatorString = "\t";
        br = new BufferedReader(new FileReader(filename));
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] charRead = line.split(separatorString);
            if (i!=0) System.out.println(charRead[4]);
            if (i!=0) {
                int att = Integer.parseInt(charRead[5]);
                int def = Integer.parseInt(charRead[6]);
                int pow = Integer.parseInt(charRead[7]);
                Skill S = new Skill(charRead[0], charRead[1], charRead[2], charRead[3], charRead[4], att, def, pow);
                if (S.getID()=="99"){
                    S.setIsSkillDestroy(true);
                }
                else if (S.getID()=="100"){
                    S.setSkillPowerUp(true);
                }
                gameSkill.add(S);
            }
            i++;
        }
    }

    /**
     * Mendapatkan list of list(s) yang berisi seluruh informasi mengenai karakter dalam game
     */
    public List<Character> getCharacterList(){
        return this.gameCharacter;
    }

    // mengembalikan list of list yang berisi seluruh informasi mengenai land dalam game
    /**
     * Mendapatkan list of list(s) yang berisi seluruh informasi mengenai land dalam game
     */
    public List<Land> getLandList(){
        return this.gameLand;
    }

    /**
     * Mendapatkan list of list(s) yang berisi seluruh informasi mengenai skill dalam game
     */
    public List<Skill> getSkillList(){
        return this.gameSkill;
    }

    /**
     * Mendapatkan hasil loading file eksternal mengenai karakter yang terletak pada indeks tertentu
     * @param idx indeks letak karakter dalam susunan baris
     */
    public Character getCharacterRow(int idx){
        return this.gameCharacter.get(idx);
    }

   /**
     * Mendapatkan hasil loading file eksternal mengenai land yang terletak pada indeks tertentu
     * @param idx indeks letak land dalam susunan baris
     */
    public Land getLandRow(int idx){
        return this.gameLand.get(idx);
    }

   /**
     * Mendapatkan hasil loading file eksternal mengenai skill yang terletak pada indeks tertentu
     * @param idx indeks letak skill dalam susunan baris
     */
    public Skill getSkillRow(int idx){
        return this.gameSkill.get(idx);
    }
}