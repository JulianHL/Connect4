package org.example

fun main() {

    val board = Board(7,6)
    val player1 = Player("Player1", CellState.X, board)
    val player2 = Player("Player2", CellState.O, board)
    Game(board, player1, player2).play()
}