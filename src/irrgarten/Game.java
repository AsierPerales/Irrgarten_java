/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;
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
    private int  currentRound;
    private int nplayers;
    private static int ROWCOL = 10;
    private static int porcentaje=10;
    Dice dado = new Dice();
    
    public Game(int nplayers){
        
        this.nplayers = nplayers;
        players = new ArrayList<>();
        monsters = new ArrayList<>();
        currentRound = 0;
        log="";
        labyrinth = new Labyrinth(6, 7, dado.randomPos(6), dado.randomPos(7));
        
        currentPlayerIndex = 0;
        for(int i =0; i<nplayers; i++){            
            Player jugador;
            jugador = new Player((char) ('0' + i+1),dado.randomIntelligence(),dado.randomStrength());
            players.add(jugador);                     
        }
    }
}
