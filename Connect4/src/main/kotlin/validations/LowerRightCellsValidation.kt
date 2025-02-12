package org.example.validations

import org.example.Board
import org.example.CellState
import org.example.Iterator.CellsIterator

class LowerRightCellsValidation: WinningValidation {
    override fun isWinningMove(column: Int, board: Board, currentPlayerSymbol: CellState): Boolean {
        return CellsIterator().checkCells(column, board.board.size - board.getBoardState(column) < 4 || board.board[0].size-column<3, board::getLowerRightCellState, currentPlayerSymbol)
    }
}