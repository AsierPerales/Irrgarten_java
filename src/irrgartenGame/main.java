/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

import irrgartenController.Controller;

import irrgartenTextUI.TextUI;

/**
 *
 * @author asier
 */
public class main {
    public static void main(String[] args){
      TextUI vista  = new TextUI();                        
      Controller controlador;
      Game juego;
      juego = new Game(2);
      controlador = new Controller(juego,vista);
      controlador.play();    
        
    }
}
