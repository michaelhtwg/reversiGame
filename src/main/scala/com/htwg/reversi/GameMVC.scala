package com.htwg.reversi

object GameMVC {
  
  var model = new GameEngine();
  var controller = new Controller(model)
  
  
  var view = new ReversiGui(controller)
  //var view = new ReversiTui(controller)
  
  def main(args: Array[String])
  {
    view.startup(args)
  }
}