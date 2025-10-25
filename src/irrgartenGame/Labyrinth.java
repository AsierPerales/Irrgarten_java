/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

import java.util.ArrayList;

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

    /**
     * Crea un nuevo laberinto con las dimensiones y posición de salida indicadas.
     * Inicializa las matrices de jugadores, monstruos y celdas vacías.
     *
     * @param nRows número de filas del laberinto.
     * @param nCols número de columnas del laberinto.
     * @param exitRow fila en la que se encuentra la salida.
     * @param exitCol columna en la que se encuentra la salida.
     */
    public Labyrinth(int nRows, int nCols, int exitRow, int exitCol) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.exitRow = exitRow;
        this.exitCol = exitCol;
        
        this.dado = new Dice();
        
        monsters = new Monster[nRows][nCols];
        players = new Player[nRows][nCols];
        labyrinth = new char[nRows][nCols];
        
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                monsters[i][j] = null;
                players[i][j] = null;
                labyrinth[i][j] = EMPTY_CHAR;                                               
            }                        
        }                
        labyrinth[exitRow][exitCol] = EXIT_CHAR;  
    }

    /**
     * Comprueba si hay un jugador en la posición de salida, 
     * lo que significa que existe un ganador.
     *
     * @return {@code true} si un jugador ha alcanzado la salida, 
     *         {@code false} en caso contrario.
     */
    boolean haveAWinner() {
        return players[exitRow][exitCol] != null;
    }

    /**
     * Devuelve una representación en texto del laberinto.
     * Cada celda se separa con un espacio y las filas se muestran en líneas distintas.
     *
     * @return una cadena con el estado actual del laberinto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                sb.append(labyrinth[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Añade un monstruo en una posición específica del laberinto.
     * Solo se añade si la posición está dentro de los límites y vacía.
     *
     * @param row fila donde se colocará el monstruo.
     * @param col columna donde se colocará el monstruo.
     * @param monster objeto {@link Monster} que se añadirá.
     */
    public void addMonster(int row, int col, Monster monster) {
        if (posOK(row, col) && emptyPos(row, col)) {
            monsters[row][col] = monster;
            labyrinth[row][col] = MONSTER_CHAR;
        }
    }

    /**
     * Comprueba si una posición está dentro de los límites del laberinto.
     *
     * @param row fila a comprobar.
     * @param col columna a comprobar.
     * @return {@code true} si la posición es válida, {@code false} si está fuera de los límites.
     */
    public boolean posOK(int row, int col) {
        return (row >= 0 && row < nRows && col >= 0 && col < nCols);
    }

    /**
     * Comprueba si una posición está vacía.
     *
     * @param row fila a comprobar.
     * @param col columna a comprobar.
     * @return {@code true} si la celda está vacía, {@code false} en caso contrario.
     */
    public boolean emptyPos(int row, int col) {
        return (this.labyrinth[row][col] == EMPTY_CHAR);
    }

    /**
     * Comprueba si en una posición determinada hay un monstruo.
     *
     * @param row fila a comprobar.
     * @param col columna a comprobar.
     * @return {@code true} si hay un monstruo, {@code false} en caso contrario.
     */
    public boolean monsterPos(int row, int col) {
        return (this.labyrinth[row][col] == MONSTER_CHAR);
    }

    /**
     * Comprueba si una posición corresponde a la salida del laberinto.
     *
     * @param row fila a comprobar.
     * @param col columna a comprobar.
     * @return {@code true} si la celda es la salida, {@code false} en caso contrario.
     */
    public boolean exitPos(int row, int col) {
        return (this.labyrinth[row][col] == EXIT_CHAR);
    }

    /**
     * Comprueba si una celda representa una posición de combate.
     *
     * @param row fila a comprobar.
     * @param col columna a comprobar.
     * @return {@code true} si hay un combate en esa posición, {@code false} en caso contrario.
     */
    public boolean combatPos(int row, int col) {
        return (this.labyrinth[row][col] == COMBAT_CHAR);
    }

    /**
     * Determina si una posición es transitable.
     * Se puede pisar una celda si está dentro de los límites y es vacía, contiene un monstruo o es la salida.
     *
     * @param row fila a comprobar.
     * @param col columna a comprobar.
     * @return {@code true} si se puede pisar la celda, {@code false} en caso contrario.
     */
    public boolean canStepOn(int row, int col) {
        return (posOK(row, col) &&
                (emptyPos(row, col) || monsterPos(row, col) || exitPos(row, col)));
    }

    /**
     * Actualiza el contenido de una celda después de que un jugador o monstruo la haya abandonado.
     * Si la celda representaba un combate, vuelve a mostrar un monstruo; en caso contrario, queda vacía.
     *
     * @param row fila de la posición anterior.
     * @param col columna de la posición anterior.
     */
    public void updateOldPos(int row, int col) {
        if (posOK(row, col)) {
            if (combatPos(row, col)) {
                labyrinth[row][col] = MONSTER_CHAR;
            } else {
                labyrinth[row][col] = EMPTY_CHAR;
            }
        }
    }

    /**
     * Calcula una nueva posición a partir de una posición inicial y una dirección dada.
     *
     * @param row fila actual.
     * @param col columna actual.
     * @param direction dirección en la que se quiere mover.
     * @return un array de dos enteros con la nueva posición [fila, columna].
     */
    public int[] dir2Pos(int row, int col, Directions direction) {
        return switch (direction) {
            case UP -> new int[]{row - 1, col};
            case DOWN -> new int[]{row + 1, col};
            case LEFT -> new int[]{row, col - 1};
            case RIGHT -> new int[]{row, col + 1};
            default -> new int[]{row, col};
        };
    }

    /**
     * Devuelve una posición aleatoria dentro del laberinto que esté vacía.
     *
     * @return un array de dos enteros [fila, columna] correspondientes a una posición vacía.
     */
    public int[] randomEmptyPos() {
        int randomRow = dado.randomPos(nRows);
        int randomCol = dado.randomPos(nCols);

        while (!emptyPos(randomRow, randomCol)) {
            randomRow = dado.randomPos(nRows);
            randomCol = dado.randomPos(nCols);
        }

        return new int[]{randomRow, randomCol};
    }
    
    /*
    spreadPlayers(ArrayList<Player> players){}
    Monster putPlayer(Directions direction, Player player){}
    void addBlock(Orientation orientation, int startRow, int startCol, int length){}
    Monster putPlayer2D{}
    */
    
    ArrayList<Directions> validMoves(int row, int col){
        ArrayList<Directions> validMoves = new ArrayList<>();
        
        if (canStepOn(row+1,col)){
            validMoves.add(Directions.DOWN);
        }
        if (canStepOn(row-1,col)){
            validMoves.add(Directions.UP);
        }
        if (canStepOn(row,col+1)){
            validMoves.add(Directions.RIGHT);
        }
        if (canStepOn(row,col-1)){
            validMoves.add(Directions.LEFT);
        }
        
        return validMoves;
    }

    
}
