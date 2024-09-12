package com.rockthejvm

object Basics extends App {

  val meaningOfLife = 42;

  val interpolatedString = s"The menaning of life $meaningOfLife"
  //println(interpolatedString)

  val listOfValues = Array("teste1", "teste2", "teste3", "teste4")
  // println(listOfValues.take(2).toList)
  // println(listOfValues(1))

  val resultOf = if (meaningOfLife > 43) 56 else 999

  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  val codeBlock = {
    var num = 4
    num + 1
  }
  //println(codeBlock)

  def myFunctio(x: Int, y:String): String = y + " " + x
  //println(myFunctio(1, "Test"))

  def factorial(n: Int): Int = {
    if (n<=1) 1
    else n * factorial(n - 1)
  }
  //println(factorial(5))

  //myUnitRetuningFunction()
  def myUnitRetuningFunction(): Unit = {
    println("Unit type is like Void function in Java")
  }

  val theUnit = ()


}
