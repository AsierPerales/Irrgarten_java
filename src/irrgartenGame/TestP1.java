/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

/**
 * La clase {@code TestP1} se utiliza como clase de prueba para la Práctica 1.
 * <p>
 * Su objetivo es verificar el correcto funcionamiento de las clases implementadas
 * en la práctica mediante la creación de instancias y la llamada a todos sus métodos.
 *
 * En esta clase se prueban, entre otros:
 * <ul>
 *   <li>Las clases {@link Weapon} y {@link Shield}, comprobando su comportamiento
 *       y representación en texto</li>
 *   <li>Los tipos enumerados {@link Directions}, {@link Orientation} y
 *       {@link GameCharacter}</li>
 *   <li>La clase {@link Dice}, llamando repetidamente a sus métodos para observar
 *       la distribución de los valores aleatorios generados</li>
 * </ul>
 *
 * El método {@code main} (comentado en esta versión) ejecuta una batería de pruebas
 * creando objetos de ejemplo y mostrando los resultados por consola.
 *
 * Esta clase no forma parte de la lógica del juego, sino que sirve exclusivamente
 * como apoyo para pruebas y validación del código desarrollado.
 *
 * @author asier
 */
public class TestP1 {
    /*
    public static void main(String[] args) {
        
        // Crea varias instancias de cada clase creada en esta práctica y utiliza todos sus métodos.
        
        
        Weapon arma1 = new Weapon(1,6);
        Weapon arma2 = new Weapon(2,3);
        Weapon arma3 = new Weapon(4,0);
        
        Shield escudo1 = new Shield(1,6);
        Shield escudo2 = new Shield(2,3);
        Shield escudo3 = new Shield(4,0);
        
        arma1.attack(); System.out.println(arma1.toString());
        arma2.attack(); System.out.println(arma2.toString());
        arma3.attack(); System.out.println(arma3.toString());
        
        System.out.println("-");

        escudo1.protect(); System.out.println(escudo1.toString());
        escudo2.protect(); System.out.println(escudo2.toString());
        escudo3.protect(); System.out.println(escudo3.toString());
        
        
        // Utilizar los valores de los tipos enumerados creados.
        
        for (Directions direcciones : Directions.values()) {
            System.out.println(direcciones);
        }
        System.out.println("-");
        
        for (Orientation orientacion : Orientation.values()) {
            System.out.println(orientacion);
        }
        System.out.println("-");

        for (GameCharacter personaje : GameCharacter.values()) {
            System.out.println(personaje);
        }
        System.out.println("-");

        // Prueba de la clase Dice: llama a cada método 100 veces
        
        Dice dado = new Dice();
        int max = 10;        // valor ejemplo para randomPos
        int nplayers = 4;    // número de jugadores de ejemplo
        float competence = 5.0f; // valor ejemplo para intensidad

        for (int i = 0; i < 100; i++) {
            System.out.println("Iteración " + (i+1));

            System.out.println("randomPos: " + dado.randomPos(max));
            System.out.println("whoStarts: " + dado.whoStarts(nplayers));

            System.out.println("randomIntelligence: " + dado.randomIntelligence());
            System.out.println("randomStrength: " + dado.randomStrength());

            System.out.println("resurrectPlayer: " + dado.resurrectPlayer());

            System.out.println("weaponsReward: " + dado.weaponsReward());
            System.out.println("shieldsReward: " + dado.shieldsReward());
            System.out.println("healthReward: " + dado.healthReward());

            System.out.println("weaponPower: " + dado.weaponPower());
            System.out.println("shieldPower: " + dado.shieldPower());

            int usos = dado.usesLeft();
            System.out.println("usesLeft: " + usos);

            System.out.println("intensity: " + dado.intensity(competence));

            System.out.println("discardElement: " + dado.discardElement(usos));

            System.out.println("----------------------");
        }
       
    }
*/
}
