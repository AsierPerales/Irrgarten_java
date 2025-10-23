/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

import java.util.Random;

/**
 *
 * @author asier
 */
public class Dice {
    private static final int MAX_USES = 5; //(número máximo de usos de armas y escudos)
    private static final float MAX_INTELLIGENCE = 10.0f; //(valor máximo para la inteligencia de jugadores y monstruos)
    private static final float MAX_STRENGTH = 10.0f; //(valor máximo para la fuerza de jugadores y monstruos)
    private static final double RESURRECT_PROB = 0.3f; //(probabilidad de que un jugador sea resucitado en cada turno)
    private static final int WEAPONS_REWARD = 2; //(numero máximo de armas recibidas al ganar un combate)
    private static final int SHIELDS_REWARD = 3; //(numero máximo de escudos recibidos al ganar un combate)
    private static final int HEALTH_REWARD = 5; //(numero máximo de unidades de salud recibidas al ganar un combate)
    private static final int MAX_ATTACK = 3; //(máxima potencia de las armas)
    private static final int MAX_SHIELD = 2; //(máxima potencia de los escudos)
    
    private java.util.Random generator;

    public Dice() {
        Random generador;
        generador = new Random();
        this.generator = generador;
    }
    
    
    
    /**
    * Devuelve una posición aleatoria dentro del rango [0, max).
    * La posición puede representar fila o columna del tablero,
    * siendo el índice mínimo 0.
    *
    * @param max número total de filas o columnas
    * @return posición aleatoria válida
    */
   public int randomPos(int max) {
       return generator.nextInt(max);
   }

   /**
    * Devuelve el índice del jugador que comenzará la partida.
    * El valor está en el rango [0, nplayers).
    *
    * @param nplayers número total de jugadores
    * @return índice del jugador inicial
    */
   public int whoStarts(int nplayers) {
       return generator.nextInt(nplayers);
   }

   /**
    * Genera un valor aleatorio de inteligencia en el intervalo [0, MAX_INTELLIGENCE).
    *
    * @return inteligencia aleatoria
    */
   public float randomIntelligence() {
       return generator.nextFloat(MAX_INTELLIGENCE);
   }
// TEMA REDONDEO Y ESO ???
//    float value = generator.nextFloat(MAX_INTELLIGENCE);
//    return Math.round(value * 10.0f) / 10.0f;   // redondea a 1 decimal
//    return Math.round(value * 100.0f) / 100.0f; // redondea a 2 decimales
   
   /**
    * Genera un valor aleatorio de fuerza en el intervalo [0, MAX_STRENGTH).
    *
    * @return fuerza aleatoria
    */
   public float randomStrength() {
       return generator.nextFloat(MAX_STRENGTH);
   }

   /**
    * Determina si un jugador muerto debe resucitar en base a la
    * probabilidad RESURRECT_PROB.
    *
    * @return true si el jugador resucita, false en caso contrario
    */
   public boolean resurrectPlayer() {
       return generator.nextFloat(0, 1) < RESURRECT_PROB;
   }

   /**
    * Devuelve la cantidad de armas obtenidas como recompensa al ganar
    * un combate. El valor está en el intervalo [0, WEAPONS_REWARD].
    *
    * @return número de armas de recompensa
    */
   public int weaponsReward() {
       return generator.nextInt(WEAPONS_REWARD+1);
   }

   /**
    * Devuelve la cantidad de escudos obtenidos como recompensa al ganar
    * un combate. El valor está en el intervalo [0, SHIELDS_REWARD].
    *
    * @return número de escudos de recompensa
    */
   public int shieldsReward() {
       return generator.nextInt(SHIELDS_REWARD+1);
   }

   /**
    * Devuelve la cantidad de unidades de salud obtenidas como recompensa
    * al ganar un combate. El valor está en el intervalo [0, HEALTH_REWARD].
    *
    * @return unidades de salud de recompensa
    */
   public int healthReward() {
       return generator.nextInt(HEALTH_REWARD+1);
   }

   /**
    * Genera un valor de poder de arma en el intervalo [0, MAX_ATTACK).
    *
    * @return poder del arma
    */
   public float weaponPower() {
       float wPower = generator.nextFloat(MAX_ATTACK);
       return Math.round(wPower * 100) / 100f;
   }

   /**
    * Genera un valor de poder de escudo en el intervalo [0, MAX_SHIELD).
    *
    * @return poder del escudo
    */
   public float shieldPower() {
        float sPower = generator.nextFloat(MAX_SHIELD);
       return Math.round(sPower * 100) / 100f;   }

   /**
    * devuelve el número de usos que se asignará a un arma o escudo
    * en el intervalo [0,MAX_USES)
    * 
    * @return numero de usos restantes
    */
   public int usesLeft(){
       return generator.nextInt(MAX_USES+1);
   }
   
   /**
    * devuelve la cantidad de competencia aplicada en el intervalo [0, competence)
    * 
    * @param  competence : inteligencia, fuerza, ...
    * @return competencia aplicada
    */
   public float intensity(float competence){
       return generator.nextFloat(competence);
   }
   
   /**
    * Decide si un elemento será descartado en base a sus usos restantes
    * A mas usos restantes, menos probabilidad de descartarse
    * 
    * @param  usesLeft usos restantes
    * @return booleano que decide si se descarta o no
    */
   public boolean discardElement(int usesLeft){
    float probabilidad_Discard = (float) usesLeft / MAX_USES;
    return generator.nextFloat(0, 1) > probabilidad_Discard;
   }
}
