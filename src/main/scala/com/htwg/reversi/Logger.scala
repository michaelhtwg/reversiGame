package com.htwg.reversi

object Logger {
  val infoHeader = "Info	-	"
  val warningHeader = "Warning	-	"
  val errorHeader = "Error	-	"

  def info(message: String) = write(infoHeader + message)
  def warning(message: String) = write(warningHeader + message)
  def error(message: String) = write(errorHeader + message)

  private def write(message: String) = println(message)
}