/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 * La clase {@code ShieldCardDeck} representa un mazo de cartas de tipo {@link Shield}.
 * <p>
 * Es una especialización de {@link CardDeck} que define la forma concreta en la que
 * se generan y añaden las cartas de escudo al mazo.
 *
 * Cada vez que el mazo se reconstruye, se crean un número fijo de cartas {@code Shield}
 * cuyos atributos (potencia del escudo y usos restantes) se generan de forma aleatoria
 * mediante un dado, por lo que el contenido del mazo puede variar entre partidas.
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
