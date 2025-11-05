/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 *
 * @author asier
 */
public abstract class CombatElement {
    private float effect;
    private int uses;

    public CombatElement(float effect, int uses) {
        this.effect = effect;
        this.uses = uses;
    }
    
    public float  geteffect(){
        
        return this.effect;
    }
    
    public int getuses(){
        
        return this.uses;
    }
    
    protected  float produceEffect(){
        
        float ataque = 0;

        if (uses > 0) {
            ataque = effect;
            uses--;
        }
        return ataque;
    }
        
        
    public boolean discard(){
        
        Dice dado = new Dice();
        return dado.discardElement(this.uses);
    } 
    
    @Override
    public abstract String toString();
}
