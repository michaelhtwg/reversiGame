package com.htwg.reversi

class Size(val x: Integer, val y: Integer) {
  def center: Position = new Position((x / 2).toInt, (y / 2).toInt)
}