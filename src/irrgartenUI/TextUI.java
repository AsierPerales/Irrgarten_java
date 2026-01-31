
package irrgartenUI;

import irrgartenGame.Directions;
import irrgartenGame.GameState;
import java.util.Scanner;

/**
 * Implementación de {@link UI} que interactúa con el usuario mediante la consola de texto.
 * 
 * Esta clase permite:
 * <ul>
 *   <li>Solicitar al jugador la dirección en la que desea moverse ({@link #nextMove()})</li>
 *   <li>Mostrar el estado actual del juego en consola ({@link #showGame(GameState)})</li>
 * </ul>
 * 
 * Se utiliza principalmente para juegos en modo texto, siendo útil para depuración
 * o versiones simples del juego.
 * 
 * @author asier
 */
public class TextUI implements UI {
    
    /** Scanner para leer la entrada del usuario */
    private static Scanner in = new Scanner(System.in);
    
    /**
     * Lee un único carácter de la entrada estándar.
     * 
     * @return el primer carácter de la línea introducida por el usuario
     */
    private char readChar() {
        String s = in.nextLine();     
        return s.charAt(0);
    }
    
    /**
     * Solicita al usuario la dirección de movimiento.
     * 
     * La entrada esperada es:
     * <ul>
     *   <li>'w' para {@link Directions#UP}</li>
     *   <li>'s' para {@link Directions#DOWN}</li>
     *   <li>'a' para {@link Directions#LEFT}</li>
     *   <li>'d' para {@link Directions#RIGHT}</li>
     * </ul>
     * Si se introduce un carácter inválido, se vuelve a pedir hasta obtener uno correcto.
     * 
     * @return la {@link Directions} elegida por el usuario
     */
    @Override
    public Directions nextMove() {
        System.out.print("Where? ");
        
        Directions direction = Directions.DOWN;
        boolean gotInput = false;
        
        while (!gotInput) {
            char c = readChar();
            switch(c) {
                case 'w' -> {
                    System.out.print(" UP\n");
                    direction = Directions.UP;
                    gotInput = true;
                }
                case 's' -> {
                    System.out.print(" DOWN\n");
                    direction = Directions.DOWN;
                    gotInput = true;
                }
                case 'd' -> {
                    System.out.print("RIGHT\n");
                    direction = Directions.RIGHT;
                    gotInput = true;
                }
                case 'a' -> {
                    System.out.print(" LEFT\n");
                    direction = Directions.LEFT;
                    gotInput = true;
                }
            }
        }    
        return direction;
    }
    
    /**
     * Muestra en consola el estado actual del juego.
     * 
     * Se imprimen:
     * <ul>
     *   <li>Lista de monstruos ({@link GameState#getMonsters()})</li>
     *   <li>Lista de jugadores ({@link GameState#getPlayers()})</li>
     *   <li>Registro de eventos ({@link GameState#getLog()})</li>
     *   <li>Jugador actual ({@link GameState#getCurrentPlayer()})</li>
     *   <li>Representación textual del laberinto ({@link GameState#getLabyrinth()})</li>
     * </ul>
     * 
     * @param gameState el {@link GameState} que contiene toda la información actual del juego
     */
    @Override
    public void showGame(GameState gameState) {   
        System.out.println("Monstruos:\n");
        System.out.println(gameState.getMonsters());
         
        System.out.println("Jugadores:\n");
        System.out.println(gameState.getPlayers());
         
        System.out.println(gameState.getLog());
        System.out.println("Jugador actual: "+ gameState.getCurrentPlayer() + "\n");
        System.out.println(gameState.getLabyrinth());
    }
    
}
