/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenUI;

import irrgartenGame.Directions;
import irrgartenGame.GameState;


import irrgartenGame.Directions;
import irrgartenGame.GameState;

/**
 * Interfaz que define la interacción entre el juego y el usuario.
 * 
 * Las implementaciones de esta interfaz son responsables de:
 * <ul>
 *   <li>Solicitar al usuario la siguiente acción a realizar</li>
 *   <li>Mostrar el estado actual del juego</li>
 * </ul>
 * 
 * Permite desacoplar la lógica del juego de la representación de la interfaz.
 * Puede implementarse con distintos tipos de UI, como consola, GUI o web.
 * 
 * @author asier
 */
public interface UI {
    
    /**
     * Solicita al usuario la siguiente dirección en la que desea moverse.
     *
     * @return una {@link Directions} que representa la elección del jugador
     */
    Directions nextMove();

    /**
     * Muestra el estado actual del juego al usuario.
     *
     * @param gameState el {@link GameState} que contiene toda la información
     *                  sobre el laberinto, los jugadores, los monstruos y el registro de eventos
     */
    void showGame(GameState gameState);
    
}

