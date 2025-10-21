/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;
import java.util.ArrayList;

/**
 *
 * @author asier
 */
public class Player {
    private static final int MAX_WEAPONS = 2;
    private static final int MAX_SHIELDS = 2;
    private static final int INITIAL_HEALTH = 10;
    private static final int HITS2LOSE = 3;
    
    private String name;
    private char number;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    private int consecutiveHits = 0;
    
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;

    public Player(char number, float intelligence, float strength) {
        this.name = "Player#" + number;
        this.number = number;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = INITIAL_HEALTH;
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
    }
    
    /**
     *
     */
    public void resurrect(){
        this.weapons.clear();
        this.shields.clear();
        this.health = INITIAL_HEALTH;
        this.resetHits();
    }
    
    /**
     *
     * @return
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     *
     * @return
     */
    public int getCol(){
        return this.col;
    }
    
    /**
     *
     * @return
     */
    public char getNumber(){
        return this.number;
    }
    
    /**
     *
     * @param row
     * @param col
     */
    public void setPos(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    /**
     *
     * @return
     */
    public boolean dead(){
        return this.health <= 0;
    }
    
    // P3 :)

    /**
     *
     * @param direction
     * @param validMoves
     * @return
     */
    public Directions move(Directions direction, Directions[] validMoves){
        throw new UnsupportedOperationException();
    }
    
    /**
     *
     * @return
     */
    public Weapon newWeapon(){
        Dice dadoArma = new Dice();
        Weapon armaNueva = new Weapon(dadoArma.weaponPower(),dadoArma.usesLeft());
        weapons.add(armaNueva);
        return armaNueva;
    }
    
    /**
     *
     * @return
     */
    public Shield newShield(){
        Dice dadoEscudo = new Dice();
        Shield escudoNuevo = new Shield(dadoEscudo.shieldPower(),dadoEscudo.usesLeft());
        shields.add(escudoNuevo);
        return escudoNuevo;
    }
    
    /**
     *
     * @return
     */
    public float sumWeapons(){
        float suma = 0;
        
        for (Weapon w : weapons) {
            suma += w.attack();
        }
        
        return suma;
    }
    
    /**
     *
     * @return
     */
    public float attack(){
        return this.strength + this.sumWeapons();
    }
    
    //P3 :)

    /**
     *
     * @param receivedAttack
     * @return
     */
    public boolean defend(float receivedAttack){
        // manageHit() ???
        throw new UnsupportedOperationException();
    }
    
    /**
     *
     * @return
     */
    public float sumShields(){
        float suma = 0;
        
        for (Shield s : shields) {
            suma += s.protect();
        }
        
        return suma;
    }
    
    /**
     *
     * @return
     */
    public float defensiveEnergy(){
        return this.intelligence + this.sumShields();
    }
    
    /* P3 :)
    public boolean manageHit(float receivedAttack){
        
    }
    */

    /**
     *
     */

    
    public void incConsecutiveHits(){
        this.consecutiveHits++;
    }
    
    /**
     *
     */
    public void resetHits(){
        this.consecutiveHits = 0;
    }
    
    /**
     *
     */
    public void gotWounded(){
        this.health--;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", number=" + number + ", intelligence=" + intelligence + ", strength=" + strength + ", health=" + health + ", row=" + row + ", col=" + col + ", consecutiveHits=" + consecutiveHits + ", weapons=" + weapons + ", shields=" + shields + '}';
    }
    
    /*
    Para P3 :)
    public void receiveReward()
    @Override
    public void receiveWeapon(Weapon w)
    public void receiveShield(Shield s)
    */ 
    
}
