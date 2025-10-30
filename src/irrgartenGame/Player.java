/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;
import java.util.ArrayList;

/**
 *
 * @author asier
 */


/**
 * Representa a un jugador dentro del juego.
 * 
 * Cada jugador tiene atributos de combate (fuerza, inteligencia, salud),
 * puede equiparse con armas y escudos, moverse por el laberinto, atacar,
 * defenderse, recibir recompensas y resucitar tras ser derrotado.
 * 
 * 
 * @author asier
 */
public class Player {
    private static final int MAX_WEAPONS = 2;
    private static final int MAX_SHIELDS = 2;
    private static final int INITIAL_HEALTH = 10;
    private static final int HITS2LOSE = 3;
    
    private String name;
    private char number;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    private int consecutiveHits = 0;
    
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;
    
    private Dice dado;

    /**
     * Crea un nuevo jugador con los atributos especificados.
     *
     * @param number identificador del jugador
     * @param intelligence nivel de inteligencia del jugador (afecta la defensa)
     * @param strength nivel de fuerza del jugador (afecta el ataque)
     */
    public Player(char number, float intelligence, float strength) {
        this.name = "Player#" + number;
        this.number = number;
        this.intelligence = intelligence;
        this.strength = strength;
        this.health = INITIAL_HEALTH;
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
        this.dado = new Dice();
    }
    
    /**
     * Restaura el estado del jugador tras resucitar.
     * 
     * El jugador recupera su salud inicial y pierde todas sus armas y escudos.
     */
    public void resurrect() {
        this.weapons.clear();
        this.shields.clear();
        this.health = INITIAL_HEALTH;
        this.resetHits();
    }
    
    /** @return la fila actual del jugador en el laberinto */
    public int getRow() {
        return this.row;
    }
    
    /** @return la columna actual del jugador en el laberinto */
    public int getCol() {
        return this.col;
    }
    
    /** @return el identificador numérico del jugador */
    public char getNumber() {
        return this.number;
    }
    
    /**
     * Establece la posición del jugador en el laberinto.
     *
     * @param row la fila donde se coloca el jugador
     * @param col la columna donde se coloca el jugador
     */
    public void setPos(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    /**
     * Indica si el jugador ha muerto.
     *
     * @return {true} si la salud del jugador es menor o igual a cero, {false} en caso contrario
     */
    public boolean dead() {
        return this.health <= 0;
    }

    /**
     * Determina la dirección final del movimiento del jugador según las opciones válidas.
     * 
     * Si la dirección preferida no es posible, el jugador se moverá en la primera dirección válida disponible.
     *
     * @param direction dirección preferida
     * @param validMoves lista de movimientos válidos desde la posición actual
     * @return la dirección efectiva en la que se moverá el jugador
     */
    public Directions move(Directions direction, ArrayList<Directions> validMoves) {   
        if (!validMoves.isEmpty() && !(validMoves.contains(direction))) {
            return validMoves.get(0);
        }
        return direction;
    }
    
    /**
     * Crea una nueva arma generada aleatoriamente con valores definidos por el dado.
     *
     * @return un nuevo objeto {Weapon}
     */
    public Weapon newWeapon() {
        Dice dadoArma = new Dice();
        return new Weapon(dadoArma.weaponPower(), dadoArma.usesLeft());
    }
    
    /**
     * Crea un nuevo escudo generado aleatoriamente con valores definidos por el dado.
     *
     * @return un nuevo objeto {Shield}
     */
    public Shield newShield() {
        Dice dadoEscudo = new Dice();
        return new Shield(dadoEscudo.shieldPower(), dadoEscudo.usesLeft());
    }
    
    /**
     * Calcula la suma del poder de ataque total de las armas equipadas.
     *
     * @return el valor total de ataque de las armas
     */
    public float sumWeapons() {
        float suma = 0;
        for (Weapon w : weapons) {
            suma += w.attack();
        }
        return suma;
    }
    
    /**
     * Calcula el poder de ataque total del jugador (fuerza base + armas).
     *
     * @return el valor total de ataque
     */
    public float attack() {
        return this.strength + this.sumWeapons();
    }

    /**
     * Permite al jugador defenderse de un ataque recibido.
     *
     * @param receivedAttack intensidad del ataque recibido
     * @return {true} si el jugador pierde el enfrentamiento, {false} si sobrevive
     */
    public boolean defend(float receivedAttack) {
        return this.manageHit(receivedAttack);
    }
    
    /**
     * Calcula la suma del poder defensivo total de los escudos equipados.
     *
     * @return el valor total de defensa de los escudos
     */
    public float sumShields() {
        float suma = 0;
        for (Shield s : shields) {
            suma += s.protect();
        }
        return suma;
    }
    
    /**
     * Calcula la energía defensiva total del jugador (inteligencia + escudos).
     *
     * @return el valor total de energía defensiva
     */
    public float defensiveEnergy() {
        return this.intelligence + this.sumShields();
    }

    /** Incrementa el contador de golpes consecutivos recibidos. */
    public void incConsecutiveHits() {
        this.consecutiveHits++;
    }

    /** Reinicia el contador de golpes consecutivos. */
    public void resetHits() {
        this.consecutiveHits = 0;
    }

    /** Reduce la salud del jugador en una unidad. */
    public void gotWounded() {
        this.health--;
    }

    /**
     * Devuelve una representación en texto del jugador y sus atributos.
     *
     * @return una cadena con la información completa del jugador
     */
    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", number=" + number + ", intelligence=" + intelligence +
               ", strength=" + strength + ", health=" + health + ", row=" + row + ", col=" + col +
               ", consecutiveHits=" + consecutiveHits + ", weapons=" + weapons + ", shields=" + shields + '}';
    }

    /**
     * Gestiona el resultado de un ataque recibido y determina si el jugador pierde.
     *
     * @param recievedAttack intensidad del ataque recibido
     * @return {true} si el jugador muere o alcanza el límite de golpes consecutivos, {false} en caso contrario
     */
    private boolean manageHit(float recievedAttack) {
        float defensa = this.defensiveEnergy();
        boolean pierde;
        
        if (defensa < recievedAttack) {
            this.gotWounded();
            this.incConsecutiveHits();
        } else {
            this.resetHits();
        }
        
        if (this.consecutiveHits == HITS2LOSE || this.dead()) {
            this.resetHits();
            pierde = true;
        } else {
            pierde = false;
        }
        return pierde;
    }

    /**
     * Asigna recompensas al jugador tras ganar un combate.
     * 
     * Puede recibir nuevas armas, escudos y una mejora de salud.
     */
    public void receiveReward() {
        int wReward = dado.weaponsReward();
        int sReward = dado.shieldsReward();
        
        //System.out.println("Recibiste "+ wReward + " y " + sReward);
        
        for (int i = 0; i < wReward; i++) {
            Weapon wnew = this.newWeapon();
            this.receiveWeapon(wnew);
        }
        
        for (int i = 0; i < sReward; i++) {
            Shield snew = this.newShield();
            this.receiveShield(snew);
        }
        
        this.health += dado.healthReward();
    }

    /**
     * Añade un arma al inventario del jugador si hay espacio disponible.
     * 
     * Las armas que deben ser descartadas se eliminan automáticamente.
     *
     * @param w el arma a añadir
     */
    public void receiveWeapon(Weapon w) {

        //Podria haber usado un iterador, pero encontre en StackOverflow
        //esto y me parecia mas elegante :)
        
        this.weapons.removeIf(Weapon::discard);

        // Añade la nueva arma si hay espacio disponible
        if (this.weapons.size() < MAX_WEAPONS) {
            this.weapons.add(w);
        }
    }


    /**
     * Añade un escudo al inventario del jugador si hay espacio disponible.
     * 
     * Los escudos que deben ser descartados se eliminan automáticamente.
     *
     * @param s el escudo a añadir
     */
    public void receiveShield(Shield s) {
        
        this.shields.removeIf(Shield::discard);

        if (this.shields.size() < MAX_SHIELDS) {
            this.shields.add(s);
        }
    }

}

    
    

