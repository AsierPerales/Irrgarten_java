/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 * Clase abstracta que representa un elemento de combate genérico.
 * Sirve como superclase para elementos ofensivos y defensivos,
 * encapsulando atributos y comportamientos comunes.
 *
 * @author asier
 */
public abstract class CombatElement {

    /**
     * Intensidad del efecto producido por el elemento
     * (daño, defensa, etc.).
     */
    private float effect;

    /**
     * Número de usos restantes del elemento.
     */
    private int uses;

    /**
     * Constructor del elemento de combate.
     *
     * @param effect Intensidad del efecto
     * @param uses Número de usos iniciales
     */
    public CombatElement(float effect, int uses) {
        this.effect = effect;
        this.uses = uses;
    }
    
    /**
     * Devuelve el valor del efecto del elemento.
     *
     * @return Intensidad del efecto
     */
    public float geteffect(){
        return this.effect;
    }
    
    /**
     * Devuelve el número de usos restantes.
     *
     * @return Usos disponibles
     */
    public int getuses(){
        return this.uses;
    }
    
    /**
     * Produce el efecto del elemento si aún dispone de usos.
     * Cada invocación consume una unidad de uso.
     *
     * @return Valor del efecto producido, o 0 si no quedan usos
     */
    protected float produceEffect(){
        
        float ataque = 0;

        if (uses > 0) {
            ataque = effect;
            uses--;
        }
        return ataque;
    }
        
    /**
    * Determina si el elemento debe ser descartado en función
    * de los usos restantes y un criterio aleatorio delegado
    * al método {@link Dice#discardElement(int)}.
    *
    * @return true si el elemento se descarta, false en caso contrario
    */
    public boolean discard(){

        Dice dado = new Dice();
        return dado.discardElement(this.uses);
    }

    
    /**
     * Representación textual del elemento de combate.
     * Debe ser implementada por las subclases.
     *
     * @return Descripción del elemento
     */
    @Override
    public abstract String toString();
}
