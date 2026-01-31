/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 * Representa los tipos de personajes que existen en el juego.
 *
 * Se utiliza para identificar si un personaje es {@link #PLAYER}
 * o {@link #MONSTER} en métodos como {@link Game#combat(Monster)}.
 *
 * @author asier
 */
public enum GameCharacter {

    /** Personaje controlado por el jugador */
    PLAYER,

    /** Personaje controlado por el sistema o IA */
    MONSTER
}
