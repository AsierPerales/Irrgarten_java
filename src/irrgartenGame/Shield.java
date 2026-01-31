/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 * Representa un escudo utilizado como elemento defensivo en combate.
 * Extiende la funcionalidad común definida en {@link CombatElement}.
 *
 * @author asier
 */
public class Shield extends CombatElement {

    /**
     * Constructor del escudo.
     * Delega la inicialización en el constructor de {@link CombatElement}.
     *
     * @param protection Valor de protección del escudo
     * @param uses Número de usos disponibles
     */
    public Shield(float protection, int uses) {
        super(protection, uses);
    }

    /**
     * Utiliza el escudo para proteger.
     * Si el escudo dispone de usos restantes, devuelve su valor de protección
     * y consume un uso; en caso contrario, devuelve 0.
     *
     * @return Valor de protección aplicado, o 0 si no quedan usos
     */
    public float protect(){
        return this.produceEffect();
    }

    /**
     * Representación textual del escudo, mostrando su protección
     * y el número de usos restantes.
     *
     * @return Cadena descriptiva del escudo
     */
    @Override
    public String toString() {
        return "S[" + this.geteffect() + ", " + this.getuses() + ']';
    }
}
