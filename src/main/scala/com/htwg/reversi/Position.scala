package com.htwg.reversi

class Position(val column: Integer, val row: Integer) {
  
  def add(offset: Position): Position = new Position(column + offset.column, row + offset.row)
  def isOutOfBounce(size: Size): Boolean = column < 1 || column > size.x || row < 1 || row > size.y
}