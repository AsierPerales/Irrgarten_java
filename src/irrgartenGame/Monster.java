/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 *
 * @author asier
 */

/**
 * Representa a un monstruo dentro del juego, con atributos de combate como fuerza,
 * inteligencia y salud, además de su posición dentro del laberinto.
 * 
 * Los monstruos pueden atacar, defenderse, recibir daño y ser derrotados.
 */

public class Monster {
    
    /** Salud inicial de todos los monstruos. */
    private static final int INITIAL_HEALTH = 5;
    
    private String name;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    private Dice dado;

    /**
     * Crea un nuevo monstruo con los atributos especificados.
     *
     * @param name el nombre del monstruo
     * @param intelligence el nivel de inteligencia del monstruo, usado en defensa
     * @param strength la fuerza del monstruo, usada en ataques
     */
    public Monster(String name, float intelligence, float strength) {
        this.health = INITIAL_HEALTH;
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.dado = new Dice();
    }
    
    /**
     * Indica si el monstruo ha muerto.
     *
     * @return {true} si la salud del monstruo es menor o igual a cero, {false} en caso contrario
     */
    public boolean dead() {
        return (this.health <= 0);
    }
    
    /**
     * Realiza un ataque calculando su intensidad en función de la fuerza del monstruo.
     *
     * @return el valor del ataque generado
     */
    public float attack() {
        Dice dado = new Dice();
        return dado.intensity(this.strength); 
    }
    
    /**
     * Establece la posición del monstruo dentro del laberinto.
     *
     * @param row la fila donde se encuentra el monstruo
     * @param col la columna donde se encuentra el monstruo
     */
    public void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Devuelve una representación en texto del monstruo, mostrando sus atributos principales.
     *
     * @return una cadena con la información del monstruo
     */
    @Override
    public String toString() {
        return "M{" + "name=" + name + ", intelligence=" + intelligence + ", strength=" + strength +
               ", health=" + health + ", row=" + row + ", col=" + col + '}';
    }
    
    /**
     * Reduce la salud del monstruo en una unidad tras recibir daño.
     */
    public void gotWounded() {
        this.health--;
    }
    
    /**
     * Permite al monstruo defenderse de un ataque recibido.
     * 
     * Se calcula una energía defensiva en función de su inteligencia.
     * Si esta energía es menor que la intensidad del ataque recibido, el monstruo resulta herido.
     *
     * @param recievedAttack la intensidad del ataque recibido
     * @return {true} si el monstruo muere tras el ataque, {false} en caso contrario
     */
    public boolean defend(float recievedAttack) {
        
        if (!this.dead()) {
            float defensiveEnergy = dado.intensity(intelligence);
            
            if (defensiveEnergy < recievedAttack) {
                this.gotWounded();
            }       
        }
        return this.dead();
    }
}
