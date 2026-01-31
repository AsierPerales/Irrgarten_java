/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

import java.util.ArrayList;

/**
 * Representa el estado completo del juego en un momento dado.
 * 
 * Contiene la información sobre:
 * <ul>
 *   <li>El laberinto como cadena</li>
 *   <li>Los jugadores activos ({@link Player})</li>
 *   <li>Los monstruos activos ({@link Monster})</li>
 *   <li>El índice del jugador actual</li>
 *   <li>Si hay un ganador</li>
 *   <li>El registro de eventos recientes</li>
 * </ul>
 * 
 * Esta clase es útil para almacenar snapshots del juego, serializar el estado
 * o actualizar interfaces gráficas.
 * 
 * @author asier
 */
public class GameState {

    /** Representación textual del {@link Labyrinth} */
    private String labyrinth;

    /** Lista de {@link Player} que participan en el juego */
    private ArrayList<Player> players;

    /** Lista de {@link Monster} que participan en el juego */
    private ArrayList<Monster> monsters;

    /** Índice del {@link Player} que tiene el turno actual */
    private int currentPlayer;

    /** Indica si ya existe un ganador en la partida */
    private boolean winner;

    /** Registro de eventos recientes en el juego */
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
    public GameState(String labyrinth, ArrayList<Player> players, ArrayList<Monster> monsters,
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
     * @return instancia de {@link Labyrinth} (en forma de {@code String}) contenido en {@link GameState}
     */
    public String getLabyrinth() {
        return labyrinth;
    }

    /**
     *
     * Convierte el ArrayList de jugadores en String.
     * 
     * @return String que representa los jugadores en la partida
     */
    public String getPlayers() {
        StringBuilder sb = new StringBuilder();
        for (Player p : players) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     *
     * Convierte el ArrayList de monstruos en String.
     * 
     * @return String que representa los monstruos en la partida
     */
    public String getMonsters() {
        StringBuilder sb = new StringBuilder();
        for (Monster m : monsters) {
            sb.append(m.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     *
     * @return Numero del jugador actual 
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }
    

    /**
     *
     * @return Variable booleana que dice si hay un ganador o no
     */
    public boolean isWinner() {
        return winner;
    }

    /**
     *
     * @return Registro de los eventos del juego en formato String
     */
    public String getLog() {
        return log;
    }
    
    
}

