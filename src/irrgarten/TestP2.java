/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author asier
 */
public class TestP2 {
    public static void main(String[] args) {
        // Probando las clases Player, Monster, Labyrinth y Game
        
        /// Prueba de Monster y Player
        
        Player player1 = new Player('1', 3, 4);
        
        player1.gotWounded();
        player1.incConsecutiveHits();
        
        System.out.println(player1.toString());

        player1.resurrect();
        player1.setPos(3, 4);
        
        System.out.println(player1.toString());
        
        
        Monster monstruo1 = new Monster("1", 2, 3);
        monstruo1.setPos(4, 4);

        
        System.out.println(monstruo1.toString());
        System.out.println(monstruo1.attack());
        

        Weapon arma1 = player1.newWeapon();
        Shield escudo1 = player1.newShield();
        
        System.out.println(player1.attack() + " ataca!");
        System.out.println(player1.defensiveEnergy() + " defiende!");
        
        
    }
}
