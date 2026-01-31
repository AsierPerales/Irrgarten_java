
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package irrgarten;

import irrgartenGame.Game;

import irrgartenController.Controller;

//import irrgartenUI.GraphicalUI;

import irrgartenUI.TextUI;


/**
 * Clase principal que arranca el juego.
 * 
 * Crea la vista ({@link irrgartenUI.TextUI} ó {@link irrgartenUI.GraphicalUI} , el modelo y el controlador, y lanza el bucle de juego.
 * 
 * @author asier
 */
public class main {

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {

        // Inicializamos la vista (texto o gráfica)
        // GraphicalUI vista = new GraphicalUI();
        TextUI vista = new TextUI();

        // Inicializamos el modelo
        Game juego = new Game(1);

        // Inicializamos el controlador y lanzamos el juego
        Controller controlador = new Controller(juego, vista);
        controlador.play();    
    }
}

