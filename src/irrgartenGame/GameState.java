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
public class GameState {

    // Atributos de instancia privados
    private String labyrinth;
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
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
     * @return instancia del laberinto (en forma de String) contenido en GameState
     */
    public String getLabyrinth() {
        return labyrinth;
    }

    /**
     *
     * Convierto el ArrayList de jugadores en String para que quede mas bonito :)
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
     * Convierto el ArrayList de monstruos en String para que quede mas bonito :)
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

