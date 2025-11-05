/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 *
 * @author asier
 */
public class Shield extends CombatElement {
    
    
    /*
     * Delega en el constructor de CombatElement
     */
    public Shield(float protection, int uses) {
        super(protection, uses);        

    }

    /**
     *
     * @return Estadisticas de proteccion y usos restantes de una instancia de Shield
     */
    @Override
    public String toString() {
        return "S[" + this.geteffect() + ", " + this.getuses() + ']';
    }
    
    /**
     * Utiliza el escudo si y solo si tiene usos restantes, si no devuelve usos (0)
     * @return si usos > 0 devuelve @protection, si no devuelve @uses (0) 
     */
    public float protect(){
        return this.produceEffect();
    }
    
     /** YA IMPLEMENTADO EN COMBATELEMENT!! QUE GUAY !!!!!
     *
     * @return si el escudo de descarta o no segun usos. Delega esto en discardElement de Dice
     */
    
    /*
    public boolean discard(){
        return dado.discardElement(uses);
    }
    */
    
}
