package com.htwg.reversi

import com.htwg.reversi.Cell;
import com.htwg.reversi.Position;

class Board(size: Size) {
  private var _cells = Array.ofDim[Cell](size.x, size.y)

  reset

  def setCell(cell: Cell): Unit = setCellInternal(cell.position.column - 1, cell.position.row - 1, cell)
  private def setCellInternal(column: Integer, row:Integer, cell: Cell) = _cells(column)(row) = cell
  def getCell(position: Position) = _cells(position.column - 1)(position.row - 1)

  def findEmpty(col: Int): Integer = {
    if (col >= size.x) return -1

    for (index <- 0 until size.x) {
      if (_cells(col)(index) == null) return index
    }
    return -1
  }

  def reset() {
    for (column <- 0 until size.x; row <- 0 until size.y) {
      setCellInternal(column, row, new Cell(new Position(column, row)))
    }
  }

  override def toString(): String = {
    var ret = ""
    for (row <- 0 until size.y; column <- 0 until size.x) {

      if (row == 0 && column == 0) {
        ret += "-" * ((size.x * 2) + 1)
        ret += "\n";
      }
      if (column == 0) ret += "|"

      if (_cells(column)(row) != null && !_cells(column)(row).empty) {
        ret += _cells(column)(row).toString()
      } else {
        ret += " "
      }
      ret += "|"

      if (column == (size.x - 1)) ret += "\n";

      if (row == (size.y - 1) && column == (size.x - 1)) {
        ret += "-" * ((size.x * 2) + 1)
        ret += "\n";
      }
    }
    ret
  }

}