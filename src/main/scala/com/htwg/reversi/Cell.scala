package com.htwg.reversi

class Cell(val position: Position, val value: Int) {
  def this(position: Position) = this(position, 0)
  def empty = value == 0
  
  override def toString = value.toString.replace('0', ' ')
}
