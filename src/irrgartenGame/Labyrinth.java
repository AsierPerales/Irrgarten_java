/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenGame;

import java.util.ArrayList;

/**
 * Representa el laberinto del juego, incluyendo jugadores, monstruos,
 * obstáculos, posiciones de combate y la salida.
 * 
 * Esta clase gestiona:
 * <ul>
 *   <li>El estado de cada celda (vacía, bloque, combate, monstruo, jugador, salida)</li>
 *   <li>Movimientos de {@link Player} y {@link FuzzyPlayer}</li>
 *   <li>Colocación de monstruos ({@link Monster}) y bloques ({@link Orientation})</li>
 *   <li>Generación de posiciones aleatorias mediante {@link Dice}</li>
 * </ul>
 * 
 * @author asier
 */
public class Labyrinth {

    private final char BLOCK_CHAR = 'X';
    private final char EMPTY_CHAR = '-';
    private final char MONSTER_CHAR = 'M';
    private final char COMBAT_CHAR = 'C';
    private final char EXIT_CHAR = 'E';
    
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
     * @param nRows número de filas del laberinto
     * @param nCols número de columnas del laberinto
     * @param exitRow fila de la salida
     * @param exitCol columna de la salida
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

    /** @return número de filas del laberinto */
    public int getnRows() {
        return nRows;
    }

    /** @return número de columnas del laberinto */
    public int getnCols() {
        return nCols;
    }
    
    /**
     * Comprueba si hay un jugador en la salida.
     * 
     * @return {@code true} si hay un ganador, {@code false} en caso contrario
     */
    boolean haveAWinner() {
        return players[exitRow][exitCol] != null;
    }

    /**
     * Devuelve una representación en texto del laberinto.
     *
     * @return estado del laberinto en forma de cadena
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
     * Añade un {@link Monster} en una posición específica.
     * 
     * Solo se añade si la celda está vacía y dentro de los límites.
     *
     * @param row fila
     * @param col columna
     * @param monster monstruo a colocar
     */
    public void addMonster(int row, int col, Monster monster) {
        if (posOK(row, col) && emptyPos(row, col)) {
            monsters[row][col] = monster;
            labyrinth[row][col] = MONSTER_CHAR;
        }
    }

    /**
     * @param row fila a comprobar
     * @param col columna a comprobar
     * @return {@code true} si la posición está dentro de los límites del laberinto  
     */
    public boolean posOK(int row, int col) {
        return (row >= 0 && row < nRows && col >= 0 && col < nCols);
    }

    /**
     * @param row fila a comprobar
     * @param col columna a comprobar
     * @return {@code true} si la celda está vacía  
     */
    public boolean emptyPos(int row, int col) {
        return (this.labyrinth[row][col] == EMPTY_CHAR);
    }

    /**
     * @param row fila a comprobar
     * @param col columna a comprobar
     * @return {@code true} si hay un monstruo en la celda  
     */
    public boolean monsterPos(int row, int col) {
        return (this.labyrinth[row][col] == MONSTER_CHAR);
    }

    /**
     * @param row fila a comprobar
     * @param col columna a comprobar
     * @return {@code true} si la celda es la salida  
     */
    public boolean exitPos(int row, int col) {
        return (this.labyrinth[row][col] == EXIT_CHAR);
    }

    /**
     * @param row fila a comprobar
     * @param col columna a comprobar
     * @return {@code true} si la celda representa un combate  
     */
    public boolean combatPos(int row, int col) {
        return (this.labyrinth[row][col] == COMBAT_CHAR);
    }

    /**
     * @param row fila a comprobar
     * @param col columna a comprobar
     * @return {@code true} si se puede pisar la celda 
     */
    public boolean canStepOn(int row, int col) {
        return (posOK(row, col) &&
                (emptyPos(row, col) || monsterPos(row, col) || exitPos(row, col)));
    }

    /**
     * Actualiza la celda que ha sido abandonada por un jugador o monstruo.
     * Si había un combate, vuelve a mostrar el monstruo; si no, queda vacía.
     *
     * @param row fila anterior
     * @param col columna anterior
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
     * Calcula la nueva posición según la dirección.
     *
     * @param row fila actual
     * @param col columna actual
     * @param direction dirección a moverse
     * @return array [fila, columna] de la nueva posición
     * @see Directions
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
     * Devuelve una posición vacía aleatoria dentro del laberinto.
     *
     * @return array [fila, columna] de la posición vacía
     * @see Dice
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

    /**
     * Calcula las direcciones válidas de movimiento desde una posición.
     *
     * @param row fila actual
     * @param col columna actual
     * @return lista de {@link Directions} válidas
     */
    public ArrayList<Directions> validMoves(int row, int col){
        ArrayList<Directions> validMoves = new ArrayList<>();
        if (canStepOn(row+1,col)) validMoves.add(Directions.DOWN);
        if (canStepOn(row-1,col)) validMoves.add(Directions.UP);
        if (canStepOn(row,col+1)) validMoves.add(Directions.RIGHT);
        if (canStepOn(row,col-1)) validMoves.add(Directions.LEFT);
        return validMoves;
    }

    /**
     * Mueve un {@link Player} en una dirección.
     *
     * @param direction dirección a moverse
     * @param player jugador a mover
     * @return {@link Monster} si se encuentra uno en la nueva posición, {@code null} si no
     */
    public Monster putPlayer(Directions direction, Player player){
        int oldRow = player.getRow();
        int oldCol = player.getCol();
        
        int[] newPos = this.dir2Pos(oldRow, oldCol, direction);
        return this.putPlayer2D(oldRow, oldCol, newPos[0], newPos[1], player);
    }

    /**
     * Coloca un jugador en la matriz 2D y devuelve un monstruo si hay combate.
     *
     * @param oldRow fila anterior
     * @param oldCol columna anterior
     * @param row nueva fila
     * @param col nueva columna
     * @param player jugador a colocar
     * @return {@link Monster} si hay combate, {@code null} si no
     */
    public Monster putPlayer2D(int oldRow, int oldCol, int row, int col, Player player){
        Monster monster = null;
        if(this.canStepOn(row,col)){
           if(this.posOK(oldRow, oldCol)){
               Player p = this.players[oldRow][oldCol];
               if(p.equals(player)){
                   this.updateOldPos(oldRow, oldCol);
                   players[oldRow][oldCol] = null;              
               }
           }
           
           if(this.monsterPos(row, col)){
               labyrinth[row][col] = COMBAT_CHAR;
               monster = this.monsters[row][col];          
           } else {
               labyrinth[row][col] = player.getNumber();
           }
           players[row][col] = player;
           player.setPos(row, col);
        }
        return monster;
    }

    /**
     * Añade un bloque ({@link Orientation}) en el laberinto.
     *
     * @param orientation orientación del bloque
     * @param startRow fila inicial
     * @param startCol columna inicial
     * @param length longitud del bloque
     */
    void addBlock(Orientation orientation, int startRow, int startCol, int length){
        int incRow = (orientation == Orientation.VERTICAL) ? 1 : 0;
        int incCol = (orientation == Orientation.HORIZONTAL) ? 1 : 0;
        
        int row = startRow;
        int col = startCol;
        while(posOK(row,col) && emptyPos(row,col) && length > 0 ){
            labyrinth[row][col] = BLOCK_CHAR;
            length--;
            row+=incRow;
            col+=incCol;
        }
    }

    /**
     * Coloca a todos los jugadores en posiciones vacías aleatorias.
     *
     * @param players lista de jugadores
     * @see Player
     */
    void spreadPlayers(ArrayList<Player> players){
        for(Player p : players){
            int[] pos = this.randomEmptyPos();
            this.putPlayer2D(-1, -1, pos[0], pos[1], p);
        }
    }

    /**
     * Sustituye a un jugador muerto por un {@link FuzzyPlayer}.
     *
     * @param actual jugador original
     * @param otro {@link FuzzyPlayer} a colocar
     */
    public void limpiaCadaverFuzzy(Player actual, Player otro){
        players[actual.getRow()][actual.getCol()]=otro;
    }
}

