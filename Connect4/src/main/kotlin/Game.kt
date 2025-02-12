package org.example

import org.example.validations.*

class Game (val board: Board, private val player1: Player, private val player2: Player) {

    private var currentPlayer = player1
    private val winningValidation: List<WinningValidation> = listOf(
        RightCellsValidation(),
        LeftCellsValidation(),
        AboveCellsValidation(),
        BelowCellsValidation(),
        UpperRightCellsValidation(),
        UpperLeftCellsValidation(),
        LowerRightCellsValidation(),
        LowerLeftCellsValidation()
    )
    private var alert = ""
    private var matches = 1

    fun play(){

        setGame()
        currentPlayer = player1
        while(true){
            printBoard()

            if(displayDrawMessage()){
                break
            }

            val column = try {
                getPlayerColumn()
            } catch (e: NumberFormatException){
                displayInvalidInputMessage()
                continue
            }

            if(!isCurrentMoveValid(column)){
                continue
            }

            if(checkWin(column)){
                break
            }

        }
        askToPlayAgain()
    }

    private fun switchPlayer() {
        currentPlayer = if (currentPlayer == player1) {
            player2
        } else {
            player1
        }
    }

    private fun getCurrentPlayer(): Player {
        return currentPlayer
    }

    fun checkWin(column: Int): Boolean {

        if(matches >= 7) {
            for (validation in winningValidation) {
                if (validation.isWinningMove(column, board, getCurrentPlayer().symbol)) {
                    matches = 1
                    displayWinningMessage()
                    return true
                }
            }
        }

        board.updateBoardState(column)
        matches++
        switchPlayer()
        clearConsole()

        return false
    }

    fun isCurrentMoveValid(column: Int): Boolean{
        if(!currentPlayer.makeMove(column)) {
            displayInvalidMoveMessage()
            return false
        }

        return true
    }

    private fun setGame(){
        println("Welcome to Connect Four!")
        println("Do you want to keep the default settings? (y/n)")
        if(readln() != "y"){
            askBoardSize()
            askPlayersName()
        }
    }

    private fun askBoardSize(){
        println("Enter the size of the board:")
        println("Enter the number of columns:")
        val columns = readln().toInt()
        println("Enter the number of rows:")
        val rows = readln().toInt()
        board.columns = columns
        board.rows = rows
    }

    private fun askPlayersName(){
        println("Enter the name of player 1:")
        player1.name = readln()
        println("Enter the name of player 2:")
        player2.name = readln()
    }

    private fun printBoard() {
        println("Match: $matches")
        println(alert)
        alert = ""
        board.displayBoardGrid()
        println()
    }

    private fun displayDrawMessage(): Boolean {
        if(board.isBoardFull()){
            alert = "It's a draw!"
            return true
        }
        return false
    }

    private fun getPlayerColumn(): Int {
        println("${currentPlayer}'s turn")
        println("Enter column number (1 - ${board.board[0].size}):")
        return readln().toInt()
    }

    private fun displayInvalidInputMessage() {
        alert = "Invalid input, please enter a number"
        clearConsole()
    }

    private fun displayInvalidMoveMessage() {
        alert = "Invalid move, please try again"
        clearConsole()
    }

    private fun displayWinningMessage() {
        clearConsole()
        board.displayBoardGrid()
        println("$currentPlayer wins!")
    }

    private fun askToPlayAgain() {
        println("\nDo you want to play again? (y/n)")
        val response = readln()
        if(response == "y"){
            clearConsole()
            play()
        }
    }

    private fun clearConsole() {
        repeat(50) { println() }
    }
}