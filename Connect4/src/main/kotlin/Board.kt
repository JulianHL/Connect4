package org.example

class Board (var columns: Int, var rows: Int) {


    val board = Array(rows) { Array(columns) { CellState.EMPTY } }
    private val boardState = Array(columns) { rows-1 }

    fun displayBoardGrid(){
        print(" ")
        for(i in 1..columns){
            print(" $i ")
        }
        println()
        for(i in board.indices){
            print((65+i).toChar())
            for(j in board[i].indices){
                print("["+board[i][j]+"]")
            }
            println()
        }
    }

    fun isBoardFull(): Boolean {
        for (i in boardState) {
            if (i != 0) {
                return false
            }
        }
        return true
    }

    fun getRightCellState(column: Int, rightIndex: Int): CellState {
        return board[boardState[column-1]][column-1+rightIndex]
    }

    fun getLeftCellState(column: Int, leftIndex: Int): CellState {
        return board[boardState[column-1]][column-1-leftIndex]
    }

    fun getLowerCellState(column: Int, belowIndex: Int): CellState {
        return board[boardState[column-1]+belowIndex][column-1]
    }

    fun getUpperCellState(column: Int, upperIndex: Int): CellState{
        return board[boardState[column-1]-upperIndex][column-1]
    }

    fun getUpperRightCellState(column: Int, upperRightIndex: Int): CellState{
        return board[boardState[column-1]-upperRightIndex][column-1+upperRightIndex]
    }

    fun getUpperLeftCellState(column: Int, upperLeftIndex: Int): CellState{
        return board[boardState[column-1]-upperLeftIndex][column-1-upperLeftIndex]
    }

    fun getLowerRightCellState(column: Int, lowerRightIndex: Int): CellState{
        return board[boardState[column-1]+lowerRightIndex][column-1+lowerRightIndex]
    }

    fun getLowerLeftCellState(column: Int, lowerLeftIndex: Int): CellState{
        return board[boardState[column-1]+lowerLeftIndex][column-1-lowerLeftIndex]
    }

    fun getPlayedCellState(column: Int): CellState{
        return board[boardState[column-1]][column-1]
    }

    fun setPlayedCell(column: Int, symbol: CellState){
        board[boardState[column-1]][column-1] = symbol
    }

    fun getBoardState(column: Int): Int{
        return boardState[column-1]
    }
    fun updateBoardState(column: Int){
        boardState[column-1]--
    }


}