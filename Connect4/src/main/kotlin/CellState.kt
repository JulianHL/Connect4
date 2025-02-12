package org.example

enum class CellState (private val symbol : Char){
    EMPTY(' '),
    X('X'),
    O('O');
    override fun toString() = symbol.toString()
}