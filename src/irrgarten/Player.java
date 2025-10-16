/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;
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
        return armaNueva;
    }
    
    /**
     *
     * @return
     */
    public Shield newShield(){
        Dice dadoEscudo = new Dice();
        Shield escudoNuevo = new Shield(dadoEscudo.shieldPower(),dadoEscudo.usesLeft());
        return escudoNuevo;
    }
    
    /**
     *
     * @return
     */
    public float sumWeapons(){
        return weapons.get(0).attack() + weapons.get(0).attack();
    }
    
    /**
     *
     * @return
     */
    public float attack(){
        float ataque = this.strength + this.sumWeapons();
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
        return this.shields.get(0).protect() + this.shields.get(1).protect();
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
        return "Player{" + "name=" + name + ", number=" + number + ", intelligence=" + intelligence + ", strength=" + strength + ", health=" + health + ", row=" + row + ", col=" + col + ", consecutiveHits=" + consecutiveHits + ", weapons=" + weapons + ", shiels=" + shiels + '}';
    }
    
    /*
    Para P3 :)
    public void receiveReward()
    @Override
    public void receiveWeapon(Weapon w)
    public void receiveShield(Shield s)
    */ 
    
}
