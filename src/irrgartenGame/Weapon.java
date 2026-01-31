/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 * Representa un arma utilizada como elemento ofensivo en combate.
 * Extiende la funcionalidad común definida en {@link CombatElement}.
 *
 * @author asier
 */
public class Weapon extends CombatElement {

    /**
     * Constructor del arma.
     * Delega la inicialización en el constructor de {@link CombatElement}.
     *
     * @param power Valor de ataque del arma
     * @param uses Número de usos disponibles
     */
    public Weapon(float power, int uses){
        super(power, uses);
    }

    /**
     * Utiliza el arma para atacar.
     * Si el arma dispone de usos restantes, devuelve su poder de ataque
     * y consume un uso; en caso contrario, devuelve 0.
     *
     * @return Valor de ataque aplicado, o 0 si no quedan usos
     */
    public float attack(){
        return this.produceEffect();
    }

    /**
     * Representación textual del arma, mostrando su poder
     * y el número de usos restantes.
     *
     * @return Cadena descriptiva del arma
     */
    @Override
    public String toString(){
        return "W[" + this.geteffect() + ", " + this.getuses() + "]";
    }
}
