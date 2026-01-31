package irrgartenController;

import irrgartenGame.Directions;
import irrgartenGame.*;
import irrgartenUI.UI;

/**
 * Controlador principal del juego.
 *
 * <p>
 * Esta clase implementa el patrón MVC (Modelo-Vista-Controlador) de forma básica:
 *  <ul>
 *      <li>Modelo: {@link Game} — contiene la lógica y estado del juego.</li>
 *      <li>Vista: {@link UI} — representa la interfaz gráfica o de texto.</li>
 *      <li>Controlador: esta clase — gestiona la interacción entre el jugador y el juego.</li>
 *  </ul>
 * 
 *
 * <p>
 * El método {@link #play()} inicia el bucle principal del juego:
 * <ol>
 *   <li>Muestra el estado actual mediante {@link UI#showGame(GameState)}.</li>
 *   <li>Recoge la dirección elegida por el usuario mediante {@link UI#nextMove()}.</li>
 *   <li>Ejecuta un paso del juego con {@link Game#nextStep(Directions)}.</li>
 *   <li>Repite hasta que exista un ganador.</li>
 * </ol>
 * 
 */

public class Controller {
    
    /**
    * Referencia al modelo del juego.
    */
   private Game game;

   /**
    * Referencia a la vista que se usará (texto o gráfica).
    */
   private UI view;

   /**
    * Crea un controlador con un juego y una vista asociados.
    *
    * @param game el modelo del juego
    * @param view la vista asociada al juego
    */
   public Controller(Game game, UI view) {
       this.game = game;
       this.view = view;
   }

   /**
    * Inicia el bucle principal del juego.
    * <p>
    * Muestra el estado actual, recoge la dirección del jugador y actualiza el juego
    * hasta que haya un ganador.
    * </p>
    */
   public void play() {
       boolean endOfGame = false;
       while (!endOfGame) {
           view.showGame(game.getGameState()); 
           Directions direction = view.nextMove(); 
           endOfGame = game.nextStep(direction);
       }
       game.logHaveAWinner();
       view.showGame(game.getGameState());   
   }

   
}
