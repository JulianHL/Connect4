package org.example.validations

import org.example.Board
import org.example.CellState
import org.example.Iterator.CellsIterator

class LeftCellsValidation: WinningValidation {
    override fun isWinningMove(column: Int, board: Board, currentPlayerSymbol: CellState): Boolean {

        return CellsIterator().checkCells(column, column<4, board::getLeftCellState, currentPlayerSymbol)
    }
}