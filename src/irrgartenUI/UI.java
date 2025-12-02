/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenUI;

import irrgartenGame.Directions;
import irrgartenGame.GameState;


/**
 *
 * @author asier
 */
public interface UI {
    
    public Directions nextMove();
    public void showGame(GameState gameState);
    
}
