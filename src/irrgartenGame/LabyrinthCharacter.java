/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 *
 * @author asier
 */
public abstract class LabyrinthCharacter {
    
    
    private String name;
    private float intelligence;
    private float strength;
    private int health;
    private int row;
    private int col;

    public LabyrinthCharacter(String name, float intelligence, float strength, int health) {
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = health;
    }

    public LabyrinthCharacter(LabyrinthCharacter other) {
        this.name = other.name;
        this.intelligence = other.intelligence;
        this.strength = other.strength;
        this.health = other.health;
        this.row = other.row;
        this.col = other.col;
    }
    
    public boolean dead(){
        return health <= 0;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public abstract float attack();
    
    public abstract boolean defend(float attack);
    
    @Override
    public abstract String toString();

    protected int getHealth() {
        return health;
    }

    protected float getIntelligence() {
        return intelligence;
    }

    protected float getStrength() {
        return strength;
    }

    protected void setHealth(int health) {
        this.health = health;
    }
    
    protected void gotWounded(){
        this.health--;
    }

    public String getName() {
        return name;
    }
    
    
}
