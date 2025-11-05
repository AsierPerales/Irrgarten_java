/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 *
 * @author asier
 */
public class Weapon extends CombatElement {
   
        
    /*
    Delega en el constructor de CombatElement
    */
    public Weapon(float power, int uses){
        super(power,uses);        
    }
    
    /**
     * Utiliza el arma si y solo si tiene usos restantes, si no devuelve usos (0)
     * @return si usos > 0 devuelve @power, si no devuelve @uses (0) 
     */
    public float attack(){
        return this.produceEffect();
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return ("W[" + this.geteffect() + ", " + this.getuses() + "]");
    }
    
    /** ESTA IMPLEMENTADO EN COMBATELEMENT! QUE GUAY!
     *
     * @return si el arma de descarta o no segun usos. Delega esto en discardElement de Dice
     */
    /*
    public boolean discard(){
        Dice dado = new Dice();
        return dado.discardElement(uses);
    }
    */
}
