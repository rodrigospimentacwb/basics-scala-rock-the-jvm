package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

  // lazy evaluation
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy!")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1
  // useful in infinite collections. It can also be used to avoid loading data that is not needed at the start of the system or is heavy, loading it only when it is invoked.

  // "pseudo-collections": Option, Try
  def methodWhichCanReturnNull(): String = "Hello, Scala"

  val anOption = Option(methodWhichCanReturnNull()) // Some("Hello, Scala")
  // option = "collection" which contains at most one element: Some(Value) or None
  // Can use another methods in Option like Option(methodWitchCanReturnNull()).orNull

  var stringProcessing = anOption match {
    case Some(string) => s"I have obtained avalid string: $string"
    case None => "I obtained nothing"
  }
  // map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException

  val aTry = Try(methodWhichCanThrowException())

  /**
   * a try = "collection" with either a value if the code went well, or an exception if the code threw one
   *
   * Equivalent:
   *
   * try {
   * methodWhichCanThrowException()
   * } catch {
   * case e: Exception => "defend against this evil exception"
   * }
   *
   */

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(ex) => s"I have obtined an exception: $ex"
  }
  // map, flatMap, filter


  /**
   * Evaluate something on another thread
   * (asynchronus programing)
   */
  val aFuture = Future {
    println("Loading ...")
    Thread.sleep(1000)
    println("I have computed a value.")
    67
  }

  // future is a "collection" which contains a value when  it's evaluated
  // future is composable with map, flatMap and filter
  // monads

  /**
   * Implicits basics
   */
  // #1: implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1

  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  // #2: Implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEvent() = n % 2 == 0
  }

  println(23.isEvent()) // new MyRichInteger(23).isEven()
  // NOTE: use Implicit carefully, is very danger
}
