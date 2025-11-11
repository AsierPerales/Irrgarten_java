/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author asier
 * @param <T>
 */
public abstract class CardDeck<T> {
    
    private ArrayList<T> cardDeck;
    protected Dice dado;
   
    /**
     *
     */
    public CardDeck(){
        
        cardDeck = new ArrayList<>();
        dado = new Dice();
        
    }
    
    /**
     *
     */
    protected abstract void addCards();
    
    protected void addCard(T card){
        
        cardDeck.add(card);
        
    }
    
    /**
     *
     * @return
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
}
