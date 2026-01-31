/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 * Representa a un monstruo dentro del juego, con atributos de combate como fuerza,
 * inteligencia y salud, además de su posición dentro del laberinto.
 * 
 * Las estadísticas del monstruo se inicializan delegando en la superclase
 * {@link LabyrinthCharacter}, de la que hereda atributos comunes
 * como la vida, la posición o las estadísticas básicas.
 * 
 * Los monstruos pueden atacar, defenderse, recibir daño y ser derrotados.
 * 
 * @author asier
 */

public class Monster extends LabyrinthCharacter{
    
    /** Salud inicial de todos los monstruos. */
    private static final int INITIAL_HEALTH = 5;
    

    /**
     * Crea un nuevo monstruo con los atributos especificados.
     *
     * @param name el nombre del monstruo
     * @param intelligence el nivel de inteligencia del monstruo, usado en defensa
     * @param strength la fuerza del monstruo, usada en ataques
     */
    public Monster(String name, float intelligence, float strength) {
        super(name, intelligence, strength, INITIAL_HEALTH);
    }
    
    
    /**
     * Realiza un ataque calculando su intensidad en función de la fuerza del monstruo
     * y la clase {@link Dice}.
     *
     * @return el valor del ataque generado
     */
    @Override
    public float attack() {
        Dice dado = new Dice();
        return dado.intensity(this.getStrength()); 
    }
    
    
    /**
     * Permite al monstruo defenderse de un ataque recibido.
     * 
     * Se calcula una energía defensiva en función de su inteligencia y el dado.
     * Si esta energía es menor que la intensidad del ataque recibido, el monstruo resulta herido.
     *
     * @param recievedAttack la intensidad del ataque recibido
     * @return {@code true} si el monstruo muere tras el ataque, {@code false} en caso contrario
     */
    @Override
    public boolean defend(float recievedAttack) {
        Dice dado = new Dice();
        
        if (!this.dead()) {
            float defensiveEnergy = dado.intensity(this.getIntelligence());
            
            if (defensiveEnergy < recievedAttack) {
                this.gotWounded();
            }       
        }
        return this.dead();
    }
    
    /**
     * Devuelve una representación en texto del monstruo, mostrando sus atributos principales.
     *
     * @return una cadena con la información del monstruo
     */
    @Override
    public String toString() {
        return "M{" + this.getName()+ ", I = " + this.getIntelligence() + ", S = " + this.getStrength() +
               ", HP = " + this.getHealth() + ", Row = " + this.getRow() + ", Col = " + this.getCol() + '}';
    }

    
}
