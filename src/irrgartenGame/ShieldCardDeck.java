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
     *
     */
    
    @Override
    protected void addCards(){
        
       for(int i = 0; i<5; i++){
            
            Shield escudo = new Shield(dado.shieldPower(), dado.usesLeft());
            addCard(escudo);
        }
        
        
    }
    
    
    
    
}
