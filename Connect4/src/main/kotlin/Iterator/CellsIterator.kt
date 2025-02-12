package org.example.Iterator

import org.example.CellState


class CellsIterator {
    fun checkCells(column: Int, limiter: Boolean, checkDirection: (Int, Int) -> CellState, currentPlayerSymbol: CellState ): Boolean {
        if(limiter){
            return false
        }

        var symbolCount = 1

        for(i in 1..3){
            if(checkDirection(column, i) != currentPlayerSymbol){
                break
            }

            symbolCount++
        }

        return symbolCount == 4
    }
}