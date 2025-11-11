/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;
import java.util.ArrayList;

/**
 *
 * @author asier
 */
public class TestP4 {
        public static void main(String[] args){
            
            // Probando la clase CardDeck ...
            
            System.out.print("Probando CardDeck ...........\n");
            
            WeaponCardDeck cartasArmas = new WeaponCardDeck();
            ShieldCardDeck cartasEscudos = new ShieldCardDeck();
            
            System.out.print(cartasArmas.nextCard().toString() + "\n");
            System.out.print(cartasEscudos.nextCard().toString() + "\n");
            
            
            System.out.print(cartasArmas.toString() + "\n");
            System.out.print(cartasEscudos.toString() + "\n");
            
            
            // Probando la clase FuzzyPlayer ....
            System.out.print("\n\nProbando FuzzyPlayer ...........\n");
            
            Dice dado = new Dice();
            Player base = new Player('a',dado.randomStrength() , dado.randomIntelligence());
            FuzzyPlayer fuzzy = new FuzzyPlayer(base);
            
            System.out.println("\n"+fuzzy.toString()+"\n");

            System.out.println("=== TEST ATTACK ===");
            for(int i = 0; i < 10; i++) {
                System.out.println(fuzzy.attack());
            }

            System.out.println("\n=== TEST DEFENSIVE ENERGY ===");
            for(int i = 0; i < 10; i++) {
                System.out.println(fuzzy.defensiveEnergy());
            }

            System.out.println("\n=== TEST MOVE ===");
            ArrayList<Directions> validMoves = new ArrayList<>();
            validMoves.add(Directions.UP);
            validMoves.add(Directions.DOWN);
            validMoves.add(Directions.LEFT);
            validMoves.add(Directions.RIGHT);

            for(int i = 0; i < 20; i++) {
                System.out.println(fuzzy.move(Directions.UP, validMoves));
            }
        }
            

}
