package org.example.validations

import org.example.Board
import org.example.CellState
import org.example.Player

interface WinningValidation {
    fun isWinningMove(column: Int, board: Board, currentPlayerSymbol: CellState): Boolean
}