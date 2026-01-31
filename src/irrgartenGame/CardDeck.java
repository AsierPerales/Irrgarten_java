/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase abstracta que representa un mazo genérico de cartas.
 * Proporciona la lógica común para gestionar un conjunto de cartas
 * y delega en las subclases la creación concreta del mazo.
 *
 * @author asier
 * @param <T> Tipo de carta que contendrá el mazo
 */
public abstract class CardDeck<T> {
    
    private ArrayList<T> cardDeck;

    /**
     *
     */
    protected Dice dado = new Dice();
   
    /**
     * Constructor del mazo.
     * Inicializa la estructura interna del mazo.
     */
    public CardDeck(){
        cardDeck = new ArrayList<>();
    }
    
    /**
     * Método abstracto que obliga a las subclases a definir
     * cómo se construye y rellena el mazo de cartas.
     */
    protected abstract void addCards();
    
    /**
     * Añade una carta al mazo.
     * Método protegido para ser utilizado por las subclases.
     *
     * @param card Carta a añadir
     */
    protected void addCard(T card){
        cardDeck.add(card);
    }
    
    /**
     * Obtiene la siguiente carta del mazo.
     * Si el mazo está vacío, se reconstruye automáticamente
     * y se baraja antes de devolver una nueva carta.
     *
     * @return La siguiente carta del mazo
     */
    public T nextCard(){
        
        if(cardDeck.isEmpty()){
            this.addCards();
            Collections.shuffle(this.cardDeck);
        }

        T card = this.cardDeck.get(0);
        this.cardDeck.remove(0);
        
        return card;
    }

    /**
     * Representación textual del mazo, útil para depuración.
     *
     * @return Estado actual del mazo en formato String
     */
    @Override
    public String toString() {
        return "CardDeck{" + "cardDeck=" + cardDeck + '}';
    }
}
