package org.example.validations

import org.example.Board
import org.example.CellState
import org.example.Iterator.CellsIterator

class AboveCellsValidation : WinningValidation {
    override fun isWinningMove(column: Int, board: Board, currentPlayerSymbol: CellState): Boolean {

        return CellsIterator().checkCells(column, board.getBoardState(column) < 3, board::getUpperCellState, currentPlayerSymbol)
    }
}