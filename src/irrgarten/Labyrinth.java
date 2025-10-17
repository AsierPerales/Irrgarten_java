/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import java.util.Arrays;

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
    
    private Dice dado;
    
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
        
        this.dado = new Dice();
        
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
    
    boolean haveAWinner(){
        return players[exitRow][exitCol] != null ;
    }

    /**
     *
     * @return 
     */
    @Override
    public String toString() {
        return "Labyrinth{" + "labyrinth=" + Arrays.toString(labyrinth) + '}';
    }

    /**
     *
     * @param row
     * @param col
     * @param monster
     */
    public void addMonster(int row, int col, Monster monster){
        if (posOK(row,col) && emptyPos(row,col)){
            monsters[row][col] = monster;
        }
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public boolean posOK(int row, int col){
        return (row <= this.nRows && col <= this.nCols);
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public boolean emptyPos(int row, int col){
        return (this.labyrinth[row][col] == EMPTY_CHAR);
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public boolean monsterPos(int row, int col){
        return (this.labyrinth[row][col] == MONSTER_CHAR);
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public boolean exitPos(int row, int col){
        return (this.labyrinth[row][col] == EXIT_CHAR);
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public boolean combatPos(int row, int col){
        return (this.labyrinth[row][col] == COMBAT_CHAR);
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public boolean canStepOn(int row, int col){
        return ( posOK(row,col) 
                && 
                (emptyPos(row,col)||monsterPos(row,col)||exitPos(row,col)) );
    }

    /**
     *
     * @param row
     * @param col
     */
    public void updateOldPos(int row, int col){
        if(posOK(row,col)){
            if(combatPos(row,col)){
                labyrinth[row][col] = MONSTER_CHAR;
            }
            else{
                labyrinth[row][col]=EMPTY_CHAR;
            }
        }
    }

    /**
     *
     * @param row
     * @param col
     * @param direction
     * @return
     */
    public int[] dir2Pos(int row, int col, Directions direction) {
        return switch (direction) {
            case UP -> new int[]{row - 1, col};
            case DOWN -> new int[]{row + 1, col};
            case LEFT -> new int[]{row, col - 1};
            case RIGHT -> new int[]{row, col + 1};
            default -> new int[]{row, col};
        }; // Si la dirección no es válida, devolvemos la misma posición
}

    /**
     *
     * @return
     */
    public int[] randomEmptyPos(){
        int randomRow = dado.randomPos(nRows);
        int randomCol = dado.randomPos(nCols);
        while (!emptyPos(randomRow,randomCol)){
            randomRow = dado.randomPos(nRows);
            randomCol = dado.randomPos(nCols);
        }
        return new int[]{randomRow,randomCol};   
    }
    
    /*
    spreadPlayers(ArrayList<Player> players){}
    Monster putPlayer(Directions direction, Player player){}
    void addBlock(Orientation orientation, int startRow, int startCol, int length){}
    ArrayList<Directions> validMoves(int row, int col){}
    Monster putPlayer2D{}
    */
    
    
}
