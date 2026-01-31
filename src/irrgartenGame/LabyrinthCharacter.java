/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 * Clase abstracta que representa un personaje dentro del laberinto.
 * Define los atributos comunes y el comportamiento básico de cualquier
 * entidad capaz de combatir y desplazarse por el escenario.
 *
 * Esta clase actúa como superclase de los distintos tipos de personajes
 * del juego, delegando en las subclases la implementación concreta
 * del combate.
 *
 * @author asier
 */
public abstract class LabyrinthCharacter {
    
    /** Nombre del personaje */
    private String name;

    /** Nivel de inteligencia  */
    private float intelligence;

    /** Nivel de fuerza  */
    private float strength;

    /** Puntos de vida actuales  */
    private int health;

    /** Fila actual en el laberinto */
    private int row;

    /** Columna actual en el laberinto */
    private int col;

    /**
     * Constructor principal del personaje.
     *
     * @param name Nombre del personaje
     * @param intelligence Nivel de inteligencia
     * @param strength Nivel de fuerza
     * @param health Puntos de vida iniciales
     */
    public LabyrinthCharacter(String name, float intelligence, float strength, int health) {
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = health;
    }

    /**
     * Constructor copia.
     * Crea un nuevo personaje duplicando el estado de otro existente.
     *
     * @param other Personaje a copiar
     */
    public LabyrinthCharacter(LabyrinthCharacter other) {
        this.name = other.name;
        this.intelligence = other.intelligence;
        this.strength = other.strength;
        this.health = other.health;
        this.row = other.row;
        this.col = other.col;
    }
    
    /**
     * Indica si el personaje ha muerto.
     *
     * @return true si los puntos de vida son menores o iguales a 0
     */
    public boolean dead(){
        return health <= 0;
    }

    /**
     * Devuelve la fila actual del personaje.
     *
     * @return Fila en el laberinto
     */
    public int getRow() {
        return row;
    }

    /**
     * Devuelve la columna actual del personaje.
     *
     * @return Columna en el laberinto
     */
    public int getCol() {
        return col;
    }

    /**
     * Actualiza la posición del personaje en el laberinto.
     *
     * @param row Nueva fila
     * @param col Nueva columna
     */
    public void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Realiza un ataque.
     * La lógica concreta del ataque se define en las subclases.
     *
     * @return Valor del ataque realizado
     */
    public abstract float attack();
    
    /**
     * Defiende al personaje frente a un ataque recibido.
     * La lógica concreta de la defensa se define en las subclases.
     *
     * @param attack Valor del ataque recibido
     * @return true si el ataque ha sido bloqueado o mitigado,
     *         false si el personaje recibe daño
     */
    public abstract boolean defend(float attack);
    
    /**
     * Representación textual del personaje.
     * Debe ser implementada por las subclases.
     *
     * @return Cadena descriptiva del personaje
     */
    @Override
    public abstract String toString();

    /**
     * Devuelve los puntos de vida actuales.
     * Método protegido para uso interno de las subclases.
     *
     * @return Puntos de vida
     */
    protected int getHealth() {
        return health;
    }

    /**
     * Devuelve el nivel de inteligencia del personaje.
     *
     * @return Inteligencia
     */
    protected float getIntelligence() {
        return intelligence;
    }

    /**
     * Devuelve el nivel de fuerza del personaje.
     *
     * @return Fuerza
     */
    protected float getStrength() {
        return strength;
    }

    /**
     * Establece los puntos de vida del personaje.
     *
     * @param health Nuevo valor de puntos de vida
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    /**
     * Reduce los puntos de vida del personaje en una unidad.
     */
    protected void gotWounded(){
        this.health--;
    }

    /**
     * Devuelve el nombre del personaje.
     *
     * @return Nombre del personaje
     */
    public String getName() {
        return name;
    }
}

