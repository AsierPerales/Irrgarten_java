/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;
import java.util.ArrayList;

/**
 * La clase {@code TestP4} se utiliza como clase de prueba para la Práctica 4.
 * <p>
 * Su objetivo es comprobar el correcto funcionamiento de las nuevas
 * funcionalidades introducidas en esta práctica, especialmente las relacionadas
 * con el manejo de mazos de cartas y el comportamiento del jugador difuso.
 *
 * En esta clase se realizan pruebas sobre:
 * <ul>
 *   <li>La clase {@link CardDeck} y sus especializaciones
 *       {@link WeaponCardDeck} y {@link ShieldCardDeck}, verificando la
 *       generación y extracción de cartas</li>
 *   <li>La clase {@link FuzzyPlayer}, comprobando su comportamiento en ataque,
 *       defensa y movimiento en base a decisiones no deterministas</li>
 * </ul>
 *
 * El método {@code main} (comentado en esta versión) ejecuta distintas pruebas
 * creando instancias de ejemplo y mostrando por consola los resultados obtenidos.
 *
 * Esta clase no forma parte de la lógica principal del juego, sino que actúa
 * como una herramienta de validación y comprobación del código desarrollado
 * en la práctica.
 *
 * @author asier
 */
public class TestP4 {
//        public static void main(String[] args){
//            
//            // Probando la clase CardDeck ...
//            
//            System.out.print("Probando CardDeck ...........\n");
//            
//            WeaponCardDeck cartasArmas = new WeaponCardDeck();
//            ShieldCardDeck cartasEscudos = new ShieldCardDeck();
//            
//            System.out.print(cartasArmas.nextCard().toString() + "\n");
//            System.out.print(cartasEscudos.nextCard().toString() + "\n");
//            
//            
//            System.out.print(cartasArmas.toString() + "\n");
//            System.out.print(cartasEscudos.toString() + "\n");
//            
//            
//            // Probando la clase FuzzyPlayer ....
//            System.out.print("\n\nProbando FuzzyPlayer ...........\n");
//            
//            Dice dado = new Dice();
//            Player base = new Player('a',dado.randomStrength() , dado.randomIntelligence());
//            FuzzyPlayer fuzzy = new FuzzyPlayer(base);
//            
//            System.out.println("\n"+fuzzy.toString()+"\n");
//
//            System.out.println("=== TEST ATTACK ===");
//            for(int i = 0; i < 10; i++) {
//                System.out.println(fuzzy.attack());
//            }
//
//            System.out.println("\n=== TEST DEFENSIVE ENERGY ===");
//            for(int i = 0; i < 10; i++) {
//                System.out.println(fuzzy.defensiveEnergy());
//            }
//
//            System.out.println("\n=== TEST MOVE ===");
//            ArrayList<Directions> validMoves = new ArrayList<>();
//            validMoves.add(Directions.UP);
//            validMoves.add(Directions.DOWN);
//            validMoves.add(Directions.LEFT);
//            validMoves.add(Directions.RIGHT);
//
//            for(int i = 0; i < 20; i++) {
//                System.out.println(fuzzy.move(Directions.UP, validMoves));
//            }
//        }
//            

}
