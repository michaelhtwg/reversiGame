package com.htwg.reversi

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameEngineTests {

  val noPlayer = 0
  var startPlayer = Player.Player1;

  @Before def initialize() {
    val model = new GameEngine()
    model.reset(startPlayer)
  }

  @Test def testDefaultValues = {
    val model = new GameEngine()
    Assert.assertSame(startPlayer, model.getPlayer)
  }

  @Test def testPlayer1Starter = {
    val model = new GameEngine()
    Assert.assertSame(Player.Player1, model.getPlayer)
  }

  @Test def testWhiteStarter = {
    val model = new GameEngine()
    model.reset(Player.Player2)
    Assert.assertSame(Player.Player2, model.getPlayer)
  }

  @Test def testFirstMove = {
    val model = new GameEngine()
    val player = model.getPlayer
    val nextPlayer = getNextPlayer(model.getPlayer)

    Assert.assertSame(nextPlayer, model.getCellValue(new Position(4, 5)))

    model.doMoveAt(new Position(3, 5))

    Assert.assertSame(player, model.getCellValue(new Position(3, 5)))

    Assert.assertSame(player, model.getCellValue(new Position(4, 5)))
  }

  @Test def testChangePlayer = {
    val model = new GameEngine()
    val player = model.getPlayer

    model.doMoveAt(new Position(3, 5))

    Assert.assertNotSame(player, model.getPlayer)
  }

  @Test def testAddScore = {
    val model = new GameEngine()
    val player = model.getPlayer
    val nextPlayer = getNextPlayer(model.getPlayer)
    var score = model.getPlayerScore(player)
    var nextScore = model.getPlayerScore(nextPlayer)

    model.doMoveAt(new Position(3, 5))

    Assert.assertSame(score + 2, model.getPlayerScore(player))

    Assert.assertSame(nextScore - 1, model.getPlayerScore(nextPlayer))
  }

  @Test def testRemoveScore = {
    val model = new GameEngine()
    val nextPlayer = getNextPlayer(model.getPlayer)
    var nextScore = model.getPlayerScore(nextPlayer)

    model.doMoveAt(new Position(3, 5))

    Assert.assertSame(nextScore - 1, model.getPlayerScore(nextPlayer))
  }

  @Test def testWrongMove = {
    val model = new GameEngine()
    model.doMoveAt(new Position(1, 1))

    Assert.assertSame(Player.Player1, Player.Player1)	
    Assert.assertNotSame(Player.Player1, model.getCellValue(new Position(1, 1)))
  }

  @Test def testWrongMoveNoChange = {
    val model = new GameEngine()
    val player = model.getPlayer
    val score = model.getPlayerScore(player)

    model.doMoveAt(new Position(1, 1))

    Assert.assertSame(player, model.getPlayer)
    Assert.assertSame(score, model.getPlayerScore(player))
  }
  
  private def getNextPlayer(current: Integer) = if (current == Player.Player1) Player.Player2 else Player.Player1
}