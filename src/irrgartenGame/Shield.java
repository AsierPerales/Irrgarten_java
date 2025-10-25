/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 *
 * @author asier
 */
public class Shield {
    private float protection;
    private int uses;
    
    private Dice dado;

    public Shield(float protection, int uses) {
        this.protection = protection;
        this.uses = uses;
        this.dado = new Dice();
    }

    /**
     *
     * @return Estadisticas de proteccion y usos restantes de una instancia de Shield
     */
    @Override
    public String toString() {
        return "S[" + protection + ", " + uses + ']';
    }
    
    /**
     * Utiliza el escudo si y solo si tiene usos restantes, si no devuelve usos (0)
     * @return si usos > 0 devuelve @protection, si no devuelve @uses (0) 
     */
    public float protect(){
        if (this.uses > 0){
            uses --;
            return (this.protection);
        }
        else return (this.uses);
    }
    
     /**
     *
     * @return si el escudo de descarta o no segun usos. Delega esto en discardElement de Dice
     */
    public boolean discard(){
        return dado.discardElement(uses);
    }
    
}
