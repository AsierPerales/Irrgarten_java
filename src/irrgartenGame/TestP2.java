/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 * La clase {@code TestP2} se utiliza como clase de prueba para la Práctica 2.
 * <p>
 * Su finalidad es comprobar el correcto funcionamiento e interacción entre
 * las principales clases del juego, incluyendo jugadores, monstruos, el
 * laberinto y la lógica general de la partida.
 *
 * En esta clase se realizan pruebas sobre:
 * <ul>
 *   <li>La clase {@link Player}, verificando su estado, posicionamiento,
 *       equipamiento y comportamiento en combate</li>
 *   <li>La clase {@link Monster}, comprobando su creación, ataque y gestión
 *       de posición</li>
 *   <li>La clase {@link Labyrinth}, evaluando la colocación de entidades,
 *       el cálculo de posiciones y la detección de condiciones de victoria</li>
 *   <li>La clase {@link Game}, probando la gestión del estado del juego
 *       y el registro de eventos</li>
 * </ul>
 *
 * El método {@code main} (comentado en esta versión) ejecuta distintas pruebas
 * creando instancias de ejemplo y llamando a los métodos más relevantes de cada
 * clase, mostrando los resultados por consola cuando es necesario.
 *
 * Esta clase no forma parte de la lógica principal del juego, sino que sirve
 * como herramienta de validación y depuración del código desarrollado.
 *
 * @author asier
 */
public class TestP2 {
    /*
    public static void main(String[] args) {
        // Probando las clases Player, Monster, Labyrinth y Game
        
        /// Prueba de Monster y Player
        
        
        Player player1 = new Player('1', 3, 4);
        
        player1.gotWounded();
        player1.incConsecutiveHits();
        
        //System.out.println(player1.toString());

        player1.resurrect();
        player1.setPos(3, 4);
        
        //System.out.println(player1.toString());
        
        
        Monster monstruo1 = new Monster("1", 2, 3);
        monstruo1.setPos(4, 4);

        
        //System.out.println(monstruo1.toString());
        //System.out.println(monstruo1.attack());
        

        Weapon arma1 = player1.newWeapon();
                Weapon arma2 = player1.newWeapon();

        Shield escudo1 = player1.newShield();
        
        System.out.println(player1.toString());

        
        //System.out.println(player1.attack() + " ataca!");
        //System.out.println(player1.defensiveEnergy() + " defiende!");
        
        
        /// Prueba de Labyrinth y Game
        
        Labyrinth laberinto = new Labyrinth(6,10,3,3);
        laberinto.addMonster(1, 4, monstruo1);
        //System.out.println(laberinto.toString());
        //System.out.println(laberinto.haveAWinner());
        
        int[] pos = laberinto.dir2Pos(2, 3, Directions.UP);
        // System.out.println("Nueva posición: [" + pos[0] + ", " + pos[1] + "]");
        
        pos = laberinto.randomEmptyPos();
        // System.out.println("Posición aleatoria: [" + pos[0] + ", " + pos[1] + "]");
        
        Game juego = new Game(3);
        
        juego.logPlayerWon();
        
        GameState gamestate = juego.getGameState();
        //System.out.println(gamestate.getLog());
    }
*/
}
