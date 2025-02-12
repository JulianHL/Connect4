package org.example.validations

import org.example.Board
import org.example.CellState
import org.example.Iterator.CellsIterator

class RightCellsValidation: WinningValidation {
    override fun isWinningMove(column: Int, board: Board, currentPlayerSymbol: CellState): Boolean {

        return CellsIterator().checkCells(column, board.board[0].size-column<3, board::getRightCellState, currentPlayerSymbol,)
    }
}