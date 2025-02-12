package org.example

class Player (var name: String, val symbol: CellState, val board: Board) {

    override fun toString() = name


    fun makeMove(column: Int): Boolean {
        if (column < 1 || column > board.board[0].size){
            return false
        }

        if(board.getBoardState(column) < 0){
            return false
        }

        board.setPlayedCell(column, symbol)
        return true
    }

}