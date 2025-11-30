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
public class Game {
    private static int MAX_ROUNDS = 10;
    private int currentPlayerIndex;
    private String log;
    
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    private Labyrinth labyrinth;

    Dice dado = new Dice();

    
    /**
     * Constructor de la clase Game. 
     * Inicializa el juego con el número de jugadores indicado, crea el laberinto 
     * y genera los jugadores con valores aleatorios de inteligencia y fuerza.
     *
     * @param nplayers número de jugadores que participarán en la partida.
     *                 Debe ser mayor que 0.
     */
    public Game(int nplayers) {
        players = new ArrayList<>();
        monsters = new ArrayList<>();
        log = "";
        labyrinth = new Labyrinth(6, 10, dado.randomPos(6), dado.randomPos(10));

        currentPlayerIndex = 0;
        for (int i = 0; i < nplayers; i++) {
            Player jugador = new Player(
                (char) ('0' + i),
                dado.randomIntelligence(),
                dado.randomStrength()
            );
            players.add(jugador);
            players.get(0).setHealth(0);
        }
        configureLabyrinth();
    }

    /**
     * Indica si la partida ha finalizado.
     * La partida termina cuando existe un jugador ganador dentro del laberinto.
     *
     * @return {@code true} si hay un ganador, {@code false} en caso contrario.
     */
    public boolean finished() {
        return labyrinth.haveAWinner();
    }

    /**
     * Obtiene el estado actual del juego, incluyendo la representación del laberinto,
     * los jugadores, los monstruos, el jugador actual, el estado de finalización
     * y el registro de eventos.
     *
     * @return un objeto {GameState} que contiene toda la información
     *         relevante sobre el estado del juego.
     */
    public GameState getGameState() {
        return new GameState(
            labyrinth.toString(),
            players,
            monsters,
            currentPlayerIndex,
            this.finished(),
            log
        );
    }

    /**
     * Configura el laberinto inicial del juego.
     * Añade bloques, genera monstruos en posiciones aleatorias y 
     * distribuye los jugadores dentro del laberinto.
     * 
     */
    private void configureLabyrinth() {
                
        // Añadir bloques ...
        labyrinth.addBlock(Orientation.HORIZONTAL, 0, 0, 3);
        labyrinth.addBlock(Orientation.VERTICAL, 0, 5, 4);
                   
        // Añadir monstruos ...
        int numMonstruos = 5;  

        for (int k = 0; k < numMonstruos; k++) {
            int[] pos = labyrinth.randomEmptyPos();  
            int i = pos[0];
            int j = pos[1];

            String nombre = "Monster" + k;
            Monster m = new Monster(nombre, dado.randomIntelligence(), dado.randomStrength());
            m.setPos(i, j);
            labyrinth.addMonster(i, j, m);
            monsters.add(m);
        }
        
        labyrinth.spreadPlayers(players);
        
    }

    /**
     * Cambia el turno al siguiente jugador.
     */
    private void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    /**
     * Registra en el log que el jugador actual ha ganado un combate.
     */
    public void logPlayerWon() {
        log += "El jugador " + (this.currentPlayerIndex) + " ha ganado el combate.\n";
    }

    /**
     * Registra en el log que un monstruo ha ganado un combate.
     */
    private void logMonsterWon() {
        log += "El monstruo ha ganado el combate.\n";
    }

    /**
     * Registra en el log que el jugador actual ha resucitado.
     */
    private void logResurrected() {
        log += "El jugador " + (this.currentPlayerIndex) + " ha resucitado.\n";
    }

    /**
     * Registra en el log que el jugador actual ha perdido su turno por estar muerto.
     */
    private void logPlayerSkipTurn() {
        log += "El jugador " + (this.currentPlayerIndex) + " ha perdido el turno por estar muerto.\n";
    }

    /**
     * Registra en el log que el jugador actual no ha seguido las instrucciones.
     */
    private void logPlayerNoOrders() {
        log += "El jugador " + (this.currentPlayerIndex) + " no ha seguido las instrucciones.\n";
    }

    /**
     * Registra en el log que el jugador se ha movido a una celda vacía 
     * o no ha podido moverse.
     */
    private void logNoMonster() {
        log += "El jugador se ha movido a una celda vacía o le ha sido imposible moverse.\n";
    }

    /**
     * Registra en el log la cantidad de rondas de combate que se han producido.
     *
     * @param rounds número de rondas efectivamente jugadas.
     * @param max número máximo de rondas permitidas.
     */
    private void logRounds(int rounds, int max) {
        log += "Se han producido " + rounds + " de " + max + " rondas de combate.\n";
    }
    
    /**
    * Determina la dirección real en la que se moverá el jugador actual.
    * 
    * A partir de una dirección preferida, se obtienen los movimientos válidos
    * desde la posición actual del jugador en el laberinto, y luego se decide
    * la dirección final basándose en esas opciones.
    *
    * @param preferredDirection la dirección que el jugador intenta tomar inicialmente
    * @return la dirección efectiva en la que el jugador se moverá
    */
    private Directions actualDirection(Directions preferredDirection) {
        Player currentPlayer = players.get(this.currentPlayerIndex);
        
        int currentRow = currentPlayer.getRow();
        int currentCol = currentPlayer.getCol();
        
        ArrayList<Directions> valid = labyrinth.validMoves(currentRow,currentCol);
        
        return currentPlayer.move(preferredDirection, valid);
    }
    
    /**
    * Ejecuta un combate entre el jugador actual y un monstruo.
    * <p>
    * El combate se desarrolla por rondas alternadas de ataque y defensa entre el jugador
    * y el monstruo, hasta que uno de los dos es derrotado o se alcanza el número máximo
    * de rondas permitidas. El método determina y devuelve el ganador del enfrentamiento.
    *
    * @param monster el monstruo con el que combate el jugador actual
    * @return el personaje que gana el combate ( {GameCharacter.PLAYER} o {GameCharacter.MONSTER})
    */
    private GameCharacter combat(Monster monster) {
        Player jugador = players.get(this.currentPlayerIndex);
        GameCharacter ganador = GameCharacter.PLAYER;
        int rounds = 0;
        
        boolean pierdeIntercambioDeGolpesEpico = monster.defend(jugador.attack());
        
        while(!pierdeIntercambioDeGolpesEpico && rounds < MAX_ROUNDS){
            ganador = GameCharacter.MONSTER;           
            rounds++;
            
            pierdeIntercambioDeGolpesEpico = jugador.defend(monster.attack());
            
            if(!pierdeIntercambioDeGolpesEpico){
                ganador = GameCharacter.PLAYER;
                pierdeIntercambioDeGolpesEpico = monster.defend(jugador.attack());
            }          
        }
        this.logRounds(rounds, MAX_ROUNDS);
        
        return ganador;
        /* PORPUESTA DECENTE :)
        private GameCharacter combat(Monster monster) {
        Player player = players.get(this.currentPlayerIndex);
        int rounds = 0;
        while (rounds < MAX_ROUNDS) {
            rounds++;
            // Turno del jugador
            boolean monsterDefeated = monster.defend(player.attack());
            if (monsterDefeated) {
                return GameCharacter.PLAYER;
            }
            // Turno del monstruo
            boolean playerDefeated = player.defend(monster.attack());
            if (playerDefeated) {
                return GameCharacter.MONSTER;
            }
        }
        // Si se llega aquí, se acabaron los turnos
        this.logRounds(rounds, MAX_ROUNDS);

        return GameCharacter.PLAYER; 
        }

        */
    }
    
    /**
    * Gestiona la posible resurrección del jugador actual tras haber sido derrotado.
    * 
    * Si el dado determina que el jugador puede resucitar, este es revivido, convertido en FuzzyPlayer 
    * y se registra en log.
    * En caso contrario, el jugador pierde su turno y también se deja constancia en el log.
    */
    private void manageResurrection() {
        if (dado.resurrectPlayer()){
            Player jugadorAfortunado = players.get(this.currentPlayerIndex);
            jugadorAfortunado.resurrect();
            FuzzyPlayer nuevoFuzzy = new FuzzyPlayer(jugadorAfortunado);
            players.set(this.currentPlayerIndex, nuevoFuzzy );
            
            // Muy importante actualizar en el laberinto, ya que sino saldria dos veces el jugador afortunado
            labyrinth.limpiaCadaverFuzzy(jugadorAfortunado, nuevoFuzzy);
            this.logResurrected();
        }
        else{
            this.logPlayerSkipTurn();
        }
        
    }
    
    /**
    * Gestiona la recompensa tras un combate en función del ganador.
    * 
    * Si el jugador resulta vencedor, recibe su recompensa y se registra en log.
    * En caso contrario, se registra la victoria del monstruo.
    *
    * @param winner el personaje que ganó el combate ({GameCharacter.PLAYER} o {GameCharacter.MONSTER})
    */
    private void manageReward(GameCharacter winner) {
        if (winner == GameCharacter.PLAYER){
            players.get(this.currentPlayerIndex).receiveReward();
            this.logPlayerWon();
        }
        else{
            this.logMonsterWon();
        }
    }

    

    /**
    * Ejecuta el siguiente paso del turno del jugador actual en el juego.
    * 
    * Si el jugador está muerto, se gestiona su posible resurrección.  
    * 
    * En caso contrario, intenta moverse en la dirección preferida y se determina
    * la dirección real posible según las reglas del laberinto.  
    * 
    * Si hay un monstruo en la nueva posición, se inicia un combate y se gestionan
    * las recompensas según el ganador.  
    * 
    * Finalmente, se verifica si la partida ha finalizado; de lo contrario, se pasa
    * el turno al siguiente jugador.
    *
    * @param preferredDirection la dirección en la que el jugador desea moverse
    * @return {true} si el juego ha finalizado, {false} en caso contrario
    */
    public boolean nextStep(Directions preferredDirection) {
        this.log = "";
        Player jugador = this.players.get(this.currentPlayerIndex);
        
        if(jugador.dead()){
            this.manageResurrection();
        }
        else{
            Directions direction = this.actualDirection(preferredDirection);
            if(direction != preferredDirection){
               this.logPlayerNoOrders();
            }
            Monster monstruo = this.labyrinth.putPlayer(direction, jugador);
            
            if (monstruo == null){
                this.logNoMonster();
            }
            else{
                GameCharacter winner = this.combat(monstruo);
                this.manageReward(winner);
            }
        }
        if(this.finished()){
            return true;
        }
        this.nextPlayer();
        return false;
    }
    
    
    
}
