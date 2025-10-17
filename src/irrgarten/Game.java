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

    Dice dado = new Dice();

    // P3 :)
    //    private int  currentRound;
    //    private int nplayers;
    //    private static int ROWCOL = 10;
    //    private static int porcentaje=10;
    
    /**
     *
     * @param nplayers
     */
    public Game(int nplayers){
        
        // this.nplayers = nplayers;
        players = new ArrayList<>();
        monsters = new ArrayList<>();
        // currentRound = 0;
        log="";
        labyrinth = new Labyrinth(6, 10, dado.randomPos(6), dado.randomPos(10));
        
        currentPlayerIndex = 0;
        for(int i =0; i<nplayers; i++){            
            Player jugador;
            jugador = new Player((char) ('0' + i+1),dado.randomIntelligence(),dado.randomStrength());
            players.add(jugador);                     
        }
        //configureLabyrinth()
    }
    
    /**
     *
     * @return
     */
    public boolean finished() {
        return labyrinth.haveAWinner();
    }
    
    /**
     *
     * @return
     */
    public GameState getGameState() {
        return new GameState(labyrinth.toString(), 
                players.toString(),
                monsters.toString(), 
                currentPlayerIndex,
                this.finished(), 
                log);
    }
    
    public void configureLabyrinth() {
        /*
        int cont=0;

        labyrinth.addBlock(Orientation.HORIZONTAL, 0, 0, 3);
                   
        for(int i=0; i < labyrinth.getnRows();i++){
            
            for(int j = 0; j< labyrinth.getnCols(); j++){
                
                if((dado.randomPos(100)<=this.porcentaje)&&labyrinth.emptyPos(i, j)){
                    
                    String nombre = "Monster"+(char) ('0'+i);
                    
                    Monster m = new Monster(nombre,dado.randomIntelligence(),dado.randomStrength());
                    cont++;
                    m.setPos(i, j);
                    labyrinth.addMonster(i, j, m);
                    
                    monsters.add(m);
                    
                }                                
            }                        
        }              
       labyrinth.spreadPlayers(players);
        */
    }
    
    private void nextPlayer(){}
    
    private void logPlayerWon() {
        log += "El jugador " +(this.currentPlayerIndex)+ "ha ganado el combate.\n";
    }

    private void logMonsterWon() {
        log += "El monstruo ha ganado el combate.\n";
    }
    
    private void logResurrected() {
        log += "El jugador " +(this.currentPlayerIndex)+ " ha resucitado.\n";
    }

    private void logPlayerSkipTurn() {
        log += "El jugador " +(this.currentPlayerIndex)+ " ha perdido el turno por estar muerto.\n";
    }
    
    private void logPlayerNoOrders() {
        log += "El jugador " +(this.currentPlayerIndex)+ " no ha seguido las instrucciones.\n";
    }
    
    private void logNoMonster() {
        log += "El jugador se ha movido a una celda vacía o le ha sido imposible moverse.\n";
    }
    
    private void logRounds(int rounds, int max) {
        log += "Se han producido " + rounds + " de " + max + " rondas de combate.\n";
    }
    
    /*
    private Directions actualDirection(Directions preferredDirection) {
        // TODO: Determinar dirección real basada en obstáculos o reglas del laberinto
        return preferredDirection;
    }

    private GameCharacter combat(Monster monster) {
        // TODO: Simular combate entre jugador actual y monstruo
        return null;
    }

    private void manageReward(GameCharacter winner) {
        // TODO: Aplicar recompensa al ganador del combate
    }

    private void manageResurrection() {
        // TODO: Comprobar si el jugador debe resucitar
    }

    public boolean nextStep(Directions preferredDirection) {
        // TODO: Implementar lógica principal de movimiento y combate del jugador
        return false;
    }
    */
    
}
