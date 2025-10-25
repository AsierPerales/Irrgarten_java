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

    // P3 :)
    //    private int  currentRound;
    //    private int nplayers;
    //    private static int ROWCOL = 10;
    //    private static int porcentaje=10;
    
    /**
     * Constructor de la clase Game. 
     * Inicializa el juego con el número de jugadores indicado, crea el laberinto 
     * y genera los jugadores con valores aleatorios de inteligencia y fuerza.
     *
     * @param nplayers número de jugadores que participarán en la partida.
     *                 Debe ser mayor que 0.
     */
    public Game(int nplayers) {
        // this.nplayers = nplayers;
        players = new ArrayList<>();
        monsters = new ArrayList<>();
        // currentRound = 0;
        log = "";
        labyrinth = new Labyrinth(6, 10, dado.randomPos(6), dado.randomPos(10));

        currentPlayerIndex = 0;
        for (int i = 0; i < nplayers; i++) {
            Player jugador = new Player(
                (char) ('0' + i + 1),
                dado.randomIntelligence(),
                dado.randomStrength()
            );
            players.add(jugador);
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
            players.toString(),
            monsters.toString(),
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
        
        int cont = 0;
        int porcentaje = 10;
        labyrinth.addBlock(Orientation.HORIZONTAL, 0, 0, 3);
                   
        for (int i = 0; i < labyrinth.getnRows(); i++) {
            for (int j = 0; j < labyrinth.getnCols(); j++) {
                if ((dado.randomPos(100) <= porcentaje) && labyrinth.emptyPos(i, j)) {
                    String nombre = "Monster" + (char) ('0' + i);
                    Monster m = new Monster(nombre, dado.randomIntelligence(), dado.randomStrength());
                    cont++;
                    m.setPos(i, j);
                    labyrinth.addMonster(i, j, m);
                    monsters.add(m);
                }
            }                        
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
    
    
    private Directions actualDirection(Directions preferredDirection) {
        Player currentPlayer = players.get(this.currentPlayerIndex);
        
        int currentRow = currentPlayer.getRow();
        int currentCol = currentPlayer.getCol();
        
        ArrayList<Directions> valid = labyrinth.validMoves(currentRow,currentCol);
        
        return currentPlayer.move(preferredDirection, valid);
    }
    
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
    
    private void manageResurrection() {
        if (dado.resurrectPlayer()){
            players.get(this.currentPlayerIndex).resurrect();
            this.logResurrected();
        }
        else{
            this.logPlayerSkipTurn();
        }
        
    }
    
    private void manageReward(GameCharacter winner) {
        if (winner == GameCharacter.PLAYER){
            players.get(this.currentPlayerIndex).receiveReward();
            this.logPlayerWon();
        }
        else{
            this.logMonsterWon();
        }
    }

    

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
