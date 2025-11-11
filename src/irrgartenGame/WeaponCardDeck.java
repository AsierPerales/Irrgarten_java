/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 *
 * @author asier
 */
public class WeaponCardDeck extends CardDeck<Weapon> {
    
    /**
     *
     */
    
    @Override
    protected void addCards(){
        
       for(int i = 0; i<5; i++){
            
            Weapon arma = new Weapon(dado.weaponPower(), dado.usesLeft());
            addCard(arma);
        }
        
    }   
    
    
}
