/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author asier
 */
public class Labyrinth {
    private final char BLOCK_CHAR = 'X';
    private final char EMPTY_CHAR = '-';
    private final char MONSTER_CHAR = 'M';
    private final char COMBAT_CHAR = 'C';
    private final char EXIT_CHAR = 'E';
    private final int ROW = 0;
    private final int COL = 1;
    
    private int nRows;
    private int nCols;
    private int exitRow;
    private int exitCol;
    
    private Monster[][] monsters;
    private Player[][] players;
    private char[][] labyrinth;

    public Labyrinth(int nRows, int nCols, int exitRow, int exitCol) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.exitRow = exitRow;
        this.exitCol = exitCol;
        
        monsters=new Monster[nRows][nCols];
        players=new Player[nRows][nCols];
        labyrinth=new char[nRows][nCols];
        for(int i = 0; i<nRows;i++){
            
            for(int j = 0; j<nCols; j++){          
                monsters[i][j]=null;
                players[i][j]=null;
                labyrinth[i][j]=EMPTY_CHAR;                                               
            }                        
        }                
       labyrinth[exitRow][exitCol]=EXIT_CHAR;  
    }
    
    
}
