/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author asier
 */
public class Weapon {
    private float power;
    private int uses;
    
    /**
     *
     * @param power
     * @param uses
     */
    public Weapon(float power, int uses){
        this.power = power;
        this.uses = uses;
        
    }
    
    /**
     * Utiliza el arma si y solo si tiene usos restantes, si no devuelve usos (0)
     * @return si usos > 0 devuelve @power, si no devuelve @uses (0) 
     */
    public float attack(){
        if (this.uses > 0){
            uses --;
            return (this.power);
        }
        else return this.uses;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return ("W[" + power + ", " + uses + "]");
    }
}
