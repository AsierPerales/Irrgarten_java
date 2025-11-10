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
public class FuzzyPlayer extends Player {

    /**
     * Un FuzzyPlayer solo puede crearse a partir de otro jugador como 
     * producto de la resurreccion del mismo
     * 
     * @param other
     */
    public FuzzyPlayer(Player other) {
        super(other);        
    }
    
    
    @Override
    public String toString() {
        return "FuzzyPlayer{" + "name=Player#" + this.getNumber() + 
                ", intelligence=" + this.getIntelligence() +
               ", strength=" + this.getStrength() + 
                ", health=" + this.getHealth() + 
                ", row=" + this.getRow() + ", col=" + this.getCol() +
               ", consecutiveHits=" + this.getConsecutiveHits() + 
                ", weapons=" + this.getWeapons().toString() + ", shields=" + this.getShields().toString() + '}';
    }
    
    /**
     *
     * @return
     */
    @Override
    public float attack(){
        Dice dado = new Dice();
        return this.sumWeapons() + dado.intensity(this.getStrength());
    }
    
    @Override
    protected float defensiveEnergy(){
        Dice dado = new Dice();
        return this.sumShields() + dado.intensity(this.getIntelligence());
    }
    
    @Override
    public Directions move(Directions direction, ArrayList<Directions> validMoves){
        Dice dado = new Dice();
        
        Directions preferredDirection = super.move(direction, validMoves);
        
        return dado.nextStep(preferredDirection, validMoves, this.getIntelligence());
    }
    
    
}
