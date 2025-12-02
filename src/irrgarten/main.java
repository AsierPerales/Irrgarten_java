
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package irrgarten;

import irrgartenGame.Game;

import irrgartenController.Controller;

import irrgartenUI.GraphicalUI;

/**
 *
 * @author asier
 */
public class main {
    
    public static void main(String[] args){
       
      // Inicializamos vista  y controlador
      //TextUI vista  = new TextUI();    
      GraphicalUI vista = new GraphicalUI();
      Controller controlador;
      
      // Inicializamos modelo
      Game juego;
      juego = new Game(3);
      
      // Llamamos a play
      controlador = new Controller(juego,vista);
      controlador.play();    
        
    }

}
