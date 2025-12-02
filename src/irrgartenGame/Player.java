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
public class Player extends LabyrinthCharacter{
    
    private static final int MAX_WEAPONS = 2;
    private static final int MAX_SHIELDS = 2;
    private static final int INITIAL_HEALTH = 10;
    private static final int HITS2LOSE = 3;
    
    private char number;
    private int consecutiveHits = 0;
    
    private WeaponCardDeck weaponCardDeck;
    private ShieldCardDeck shieldCardDeck;
    
    private ArrayList<Weapon> armas;
    private ArrayList<Shield> escudos;
    
    private Dice dado;

    /**
     * Crea un nuevo jugador con los atributos especificados.
     *
     * @param number identificador del jugador
     * @param intelligence nivel de inteligencia del jugador (afecta la defensa)
     * @param strength nivel de fuerza del jugador (afecta el ataque)
     */
    public Player(char number, float intelligence, float strength) {
                
        super("Player#"+number, intelligence, strength, INITIAL_HEALTH);
        
        this.number = number;
        
        this.weaponCardDeck = new WeaponCardDeck();
        this.shieldCardDeck = new ShieldCardDeck();
        
        this.armas = new ArrayList<>();
        this.escudos = new ArrayList<>();
        
        
    }
    
    public Player(Player other){
        
        super(other);
        
        this.number = other.number;
        this.consecutiveHits = other.consecutiveHits;
     
        this.armas = new ArrayList<>();
        for (Weapon weapon : other.armas) {
            Weapon copiedWeapon = new Weapon(weapon.geteffect(), weapon.getuses());
            this.armas.add(copiedWeapon);
        }

  
        this.escudos = new ArrayList<>();
        for (Shield shield : other.escudos) {
            Shield copiedShield = new Shield(shield.geteffect(), shield.getuses());
            this.escudos.add(copiedShield);
        }
        
        this.weaponCardDeck = new WeaponCardDeck();
        this.shieldCardDeck = new ShieldCardDeck();
    }
    
    /**
     * Restaura el estado del jugador tras resucitar.
     * 
     * El jugador recupera su salud inicial y pierde todas sus armas y escudos.
     */
    public void resurrect() {
        
        this.armas.clear();
        this.escudos.clear();
        this.setHealth(INITIAL_HEALTH);
        this.resetHits();
    }
    
    
    /** @return el identificador numérico del jugador */
    public char getNumber() {
        return this.number;
    }

    public int getConsecutiveHits() {
        return consecutiveHits;
    }

    public ArrayList<Shield> getShields() {
        return escudos;
    }

    public ArrayList<Weapon> getWeapons() {
        return armas;
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
     * Obsoleto gracias a WeaponCardDeck :)
     * @return un nuevo objeto {Weapon}
     */
    /*
    private Weapon newWeapon() {
        Dice dadoArma = new Dice();
        return new Weapon(dadoArma.weaponPower(), dadoArma.usesLeft());
    }
    */
    /**
     * Crea un nuevo escudo generado aleatoriamente con valores definidos por el dado.
     * Obsoleto gracias a ShieldCardDeck
     * @return un nuevo objeto {Shield}
     */
    /*
    private Shield newShield() {
        Dice dadoEscudo = new Dice();
        return new Shield(dadoEscudo.shieldPower(), dadoEscudo.usesLeft());
    }
    */
    
    /**
     * Calcula la suma del poder de ataque total de las armas equipadas.
     *
     * @return el valor total de ataque de las armas
     */
    protected float sumWeapons() {
        float suma = 0;
        for (Weapon w : armas) {
            suma += w.attack();
        }
        return suma;
    }
    
    /**
     * Calcula la suma del poder defensivo total de los escudos equipados.
     *
     * @return el valor total de defensa de los escudos
     */
    protected float sumShields() {
        float suma = 0;
        for (Shield s : escudos) {
            suma += s.protect();
        }
        return suma;
    }
    
    /**
     * Calcula el poder de ataque total del jugador (fuerza base + armas).
     *
     * @return el valor total de ataque
     */
    @Override
    public float attack() {
        return this.getStrength() + this.sumWeapons();
    }

    /**
     * Permite al jugador defenderse de un ataque recibido.
     *
     * @param receivedAttack intensidad del ataque recibido
     * @return {true} si el jugador pierde el enfrentamiento, {false} si sobrevive
     */
    @Override
    public boolean defend(float receivedAttack) {
        return this.manageHit(receivedAttack);
    }
    
    
    /**
     * Calcula la energía defensiva total del jugador (inteligencia + escudos).
     *
     * @return el valor total de energía defensiva
     */
    protected float defensiveEnergy() {
        return this.getIntelligence() + this.sumShields();
    }

    /** Incrementa el contador de golpes consecutivos recibidos. */
    private void incConsecutiveHits() {
        this.consecutiveHits++;
    }

    /** Reinicia el contador de golpes consecutivos. */
    private void resetHits() {
        this.consecutiveHits = 0;
    }


    /**
     * Devuelve una representación en texto del jugador y sus atributos.
     *
     * @return una cadena con la información completa del jugador
     */
    @Override
    public String toString() {
        return "Player{" + "name=Player#" + this.getNumber() + ", intelligence=" + this.getIntelligence() +
               ", strength=" + this.getStrength() + ", health=" + this.getHealth() + ", row=" + this.getRow() + ", col=" + this.getCol() +
               ", consecutiveHits=" + consecutiveHits + ", weapons=" + armas + ", shields=" + escudos + '}';
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
        
        dado = new Dice();
        
        for (int i = 0; i < dado.weaponsReward(); i++) {
            Weapon armaGanada = weaponCardDeck.nextCard();
            this.receiveWeapon(armaGanada);
        }
        
        for (int i = 0; i < dado.shieldsReward(); i++) {
            this.receiveShield(shieldCardDeck.nextCard());
        }
        
        int extraHealth = dado.healthReward();
        
        this.setHealth(this.getHealth()+extraHealth);
    }

    /**
     * Añade un arma al inventario del jugador si hay espacio disponible.
     * 
     * Las armas que deben ser descartadas se eliminan automáticamente.
     *
     * @param w el arma a añadir
     */
    private void receiveWeapon(Weapon w) {

        //Podria haber usado un iterador, pero encontre en StackOverflow
        //esto y me parecia mas elegante :)
        
        this.armas.removeIf(Weapon::discard);

        // Añade la nueva arma si hay espacio disponible
        if (this.armas.size() < MAX_WEAPONS) {
            this.armas.add(w);
        }
    }


    /**
     * Añade un escudo al inventario del jugador si hay espacio disponible.
     * 
     * Los escudos que deben ser descartados se eliminan automáticamente.
     *
     * @param s el escudo a añadir
     */
    private void receiveShield(Shield s) {
        
        this.escudos.removeIf(Shield::discard);

        if (this.escudos.size() < MAX_SHIELDS) {
            this.escudos.add(s);
        }
    }
    
    

}

    
    

