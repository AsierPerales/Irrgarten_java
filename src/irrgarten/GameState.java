/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author asier
 */
public class GameState {

    // Atributos de instancia privados
    private String labyrinth;
    private String players;
    private String monsters;
    private int currentPlayer;
    private boolean winner;
    private String log;

    /**
     * Constructor de GameState.
     * Inicializa todos los atributos del estado del juego.
     *
     * @param labyrinth     representación del laberinto
     * @param players       representación de los jugadores
     * @param monsters      representación de los monstruos
     * @param currentPlayer índice del jugador actual
     * @param winner        indica si ya existe un ganador
     * @param log           registro de eventos recientes
     */
    public GameState(String labyrinth, String players, String monsters,
                     int currentPlayer, boolean winner, String log) {
        this.labyrinth = labyrinth;
        this.players = players;
        this.monsters = monsters;
        this.currentPlayer = currentPlayer;
        this.winner = winner;
        this.log = log;
    }

    /**
     *
     * @return 
     */
    public String getLabyrinth() {
        return labyrinth;
    }

    /**
     *
     * @return
     */
    public String getPlayers() {
        return players;
    }

    /**
     *
     * @return
     */
    public String getMonsters() {
        return monsters;
    }

    /**
     *
     * @return
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     *
     * @return
     */
    public boolean isWinner() {
        return winner;
    }

    /**
     *
     * @return
     */
    public String getLog() {
        return log;
    }
    
    
}

