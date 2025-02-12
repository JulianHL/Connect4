package org.example.validations

import org.example.Board
import org.example.CellState
import org.example.Iterator.CellsIterator

class UpperLeftCellsValidation: WinningValidation {
    override fun isWinningMove(column: Int, board: Board, currentPlayerSymbol: CellState): Boolean {
        return CellsIterator().checkCells(column, board.getBoardState(column) < 3 || column<4, board::getUpperLeftCellState, currentPlayerSymbol)
    }
}