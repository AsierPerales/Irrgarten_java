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
    
    Dice dado;

    public Player(char number, float intelligence, float strength) {
        this.name = "Player#" + number;
        this.number = number;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = INITIAL_HEALTH;
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
        
        this.dado = new Dice();
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
    public Directions move(Directions direction, ArrayList<Directions> validMoves){   
        if (!validMoves.isEmpty() && !(validMoves.contains(direction))){
            return validMoves.get(0);
        }
        return direction;
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
        return this.manageHit(receivedAttack);
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
    
    private boolean manageHit(float recievedAttack){
        float defensa = this.defensiveEnergy();
        boolean pierde;
        
        if (defensa < recievedAttack){
            this.gotWounded();
            this.incConsecutiveHits();
        }
        else {
            this.resetHits();
        }
        
        if (this.consecutiveHits == HITS2LOSE || this.dead()){
            this.resetHits();
            pierde = true;
        }
        else{
            pierde = false;
        }
        return pierde;
    }
    
    public void receiveReward(){
        int wReward = dado.weaponsReward();
        int sReward = dado.shieldsReward();
        
        for (int i = 1 ; i<=wReward ; i++){
            Weapon wnew = this.newWeapon();
            this.receiveWeapon(wnew);
        }
        
        for (int i = 1 ; i<=sReward ; i++){
            Shield snew = this.newShield();
            this.receiveShield(snew);
        }
        
        this.health += dado.healthReward();
    }
    
    public void receiveWeapon(Weapon w){
        for (Weapon weapon : this.weapons) {
            if (weapon.discard()){
                this.weapons.remove(weapon);
            }
        }
        
        if(this.weapons.size() < MAX_WEAPONS){
            this.weapons.add(w);
        }
    }

    public void receiveShield(Shield s){
        for (Shield shield : this.shields) {
            if (shield.discard()){
                this.shields.remove(shield);
            }
        }
        
        if(this.shields.size() < MAX_SHIELDS){
            this.shields.add(s);
        }
    }

    
    
    
}
