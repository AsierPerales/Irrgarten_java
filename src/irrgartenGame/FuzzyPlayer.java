/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

import java.util.ArrayList;

/**
 * Representa una variante especial de {@link Player} con comportamiento
 * aleatorio influenciado por la inteligencia del jugador.
 * 
 * Un {@code FuzzyPlayer} puede considerarse una “resurrección peyorativa”
 * de un jugador existente, donde ataques, defensas y movimientos
 * no son deterministas, sino que dependen de tiradas de {@link Dice}.
 * 
 * @author asier
 */
public class FuzzyPlayer extends Player {

    /**
     * Crea un {@code FuzzyPlayer} a partir de otro {@link Player}.
     * 
     * Esta construcción se utiliza típicamente tras la resurrección
     * de un jugador.
     * 
     * @param other jugador original que sirve como base para la creación
     */
    public FuzzyPlayer(Player other) {
        super(other);        
    }
    
    /**
     * Devuelve una representación textual del {@code FuzzyPlayer}.
     * Se antepone la palabra "Fuzzy" al {@link Player#toString()} original.
     * 
     * @return cadena descriptiva del jugador fuzzy
     */
    @Override
    public String toString() {
        return "Fuzzy" + super.toString();
    }
    
    /**
     * Calcula el ataque total del {@code FuzzyPlayer}.
     * 
     * La fuerza base se combina con un valor aleatorio generado por
     * {@link Dice#intensity(float)}, que depende de la inteligencia
     * del jugador.
     * 
     * @return valor total de ataque aleatorio
     */
    @Override
    public float attack(){
        Dice dado = new Dice();
        return this.sumWeapons() + dado.intensity(this.getStrength());
    }
    
    /**
     * Calcula la energía defensiva total del {@code FuzzyPlayer}.
     * 
     * Se combina la suma de la defensa de los escudos con un valor
     * aleatorio generado por {@link Dice#intensity(float)}, según la
     * inteligencia del jugador.
     * 
     * @return valor total de energía defensiva aleatorio
     */
    @Override
    protected float defensiveEnergy(){
        Dice dado = new Dice();
        return this.sumShields() + dado.intensity(this.getIntelligence());
    }
    
    /**
     * Determina la dirección final del movimiento del {@code FuzzyPlayer}.
     * 
     * La dirección preferida se calcula primero con {@link Player#move(Directions, ArrayList)},
     * y luego se ajusta aleatoriamente mediante {@link Dice#nextStep(Directions, ArrayList, float)},
     * usando la inteligencia del jugador como factor de decisión.
     * 
     * @param direction dirección preferida
     * @param validMoves lista de movimientos válidos desde la posición actual
     * @return dirección final seleccionada
     * @see Directions
     */
    @Override
    public Directions move(Directions direction, ArrayList<Directions> validMoves){
        Dice dado = new Dice();
        
        Directions preferredDirection = super.move(direction, validMoves);
        
        return dado.nextStep(preferredDirection, validMoves, this.getIntelligence());
    }
}
