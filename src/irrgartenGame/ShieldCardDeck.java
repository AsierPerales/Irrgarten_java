/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 *
 * @author asier
 */
public class ShieldCardDeck extends CardDeck<Shield> {
    
     /**
        * Implementación concreta del método addCards().
        * Reconstruye el mazo añadiendo un conjunto fijo de cartas Shield.
        * Cada escudo se crea con valores generados aleatoriamente mediante el dado,
        * por lo que el contenido del mazo varía en cada reconstrucción.
    */
    @Override
    protected void addCards(){
        
        // Se generan cinco cartas de tipo Shield
        for(int i = 0; i < 5; i++){
            
            // Cada escudo recibe valores aleatorios de potencia y usos restantes
            Shield escudo = new Shield(dado.shieldPower(), dado.usesLeft());
            
            // Se añade la carta al mazo utilizando el método de la superclase
            addCard(escudo);
        }
    }

}
