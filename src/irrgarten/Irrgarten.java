/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package irrgarten;

/**
 *
 * @author asier
 */
public class Irrgarten {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Weapon arma = new Weapon(3,3);
        Shield escudin = new Shield(4,1);
        Dice dadin = new Dice();
        
        arma.attack();
        escudin.protect();
        
        System.out.println(arma.toString());
        System.out.println(escudin.toString());
        System.out.print(dadin.randomPos(5));
    }
    
}
