package com.htwg.reversi

import scala.swing.Reactor

class ReversiTui(controller: Controller) extends Reactor {
  listenTo(controller)

  reactions += {
    case e: GameStateChanged => println("Changed")
    case e: BoardChanged => reDraw
  }
  
  def reDraw(){
    print(controller.toString())
  }

  def startup(args: Array[String]): Unit =
    {
      var input = ""
      var startWithPlayer = controller.getCurrentPlayer
      var size = 8;

      controller.reset(size, size, startWithPlayer);

      println("Current player is: Player " + controller.getCurrentPlayer)
      println(controller.toString)

      while (true) {
        input = readLine

        input match {
          case "q" => {
            println("Game stoped!")
            return
          }
          case "r" => {
            println("Game reset!")
            controller.reset(size,size,startWithPlayer)
          }
          case "black" => {
            println("black starts")
            startWithPlayer = Player.Player1
          }
          case "white" => {
            println("white starts")
            startWithPlayer = Player.Player2
          }
          case "size1" => {
            size=4
            println("change size "+size+"x"+size)
             controller.reset(size,size,startWithPlayer)
          }
          case "size2" => {
            size=6
            println("change size "+size+"x"+size)
             controller.reset(size,size,startWithPlayer)
          }
          case "size3" => {
            size=8
            println("change size "+size+"x"+size)
            controller.reset(size,size,startWithPlayer)
          }
          case _ => {
            println("input!")
            input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
              case column :: row :: Nil => {
                println("column/row: " + column + "/" + row)
                controller.setCell(column, row)
                println("Current player is: Player " + controller.getCurrentPlayer)
                print(controller.toString)
              }
              case _ => println("False Input!!!")

            }
          }
        }
      }
    }
}