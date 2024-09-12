package com.rockthejvm

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function === bob.apply(43)

  /*
    Scala runs on the JVM
    Functional programing:
    - compose functions
    - pass functions as args
    - return functions as results

    Conclusion: FunctionX = Function1, Function2, ... Function22 - max args is 22
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23)
  simpleIncrementer(23) // equal simpleIncrementer.apply(23)
  // defined a function!

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTIONS_X TYPES

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  // val stringConcatenatorSugar: (String, String) => String = (v1, v2) => v1 + v2

  stringConcatenator("I love", " Scala") // "I love Scala"

  // syntax sugars
  val doubler: Int => Int = (x: Int) => 2 * x
  doubler(2)

  /*
  equivalent to the much longer:
    val doubler: Function[Int, Int] = new Function1[Int, Int] {
      override def apply(x: Int) = 2 * x

    Can use to:
      val doubler = (x: Int) => 2 * x
      doubler(2)
   */

  // high-order functions:ons as args/return functions as results
  val aMappedList: List[Int] = List(1,2,3).map(x => x + 1) // HOF
  println(aMappedList)

  val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2 * x))
  println(aFlatMappedList)

//  val aFlatMappedList = List(1,2,3).flatMap { x =>
//    List(x, 2 * x)
//  } // Alternative syntax, same as .map(x => List(x, 2 * x))
  println(aFlatMappedList)

  val aFilteredList = List(1,2,3,4,5,6).filter(x => x <= 3)
  // val aFilteredList = List(1,2,3,4,5,6).filter(_ <= 3) // sugar syntax with underscore, avoid repeat x
  println(aFilteredList)

  // all pairs between the numbers 1, 2, 3 and the letters 'a', 'b', 'c'
  val allPairs = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  println(allPairs)

  // for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"  // equivalent to the map/flatmap chain above
  println(alternativePairs)

  /**
   * Colections
   */

  // lists
  var aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List(0,1,2,3,4,5) add zero in head of list
  val anExtentedList = 0 +: aList :+ 6 // List(0, 1, 2, 3, 4, 5, 6) with 0 added to the head and 6 added to the tail.

  // sequences
  val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  val acessedElemnent = aSequence(1) // the element at index 1 is 2

  // vectors: fast Seq implementation
  val vector = Vector(1,2,3,4,5)

  // sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val aAddedSet = aSet + 5 // Set(1,2,3,4,5) *Note order is not important in Set
  val aRemovedSet = aSet - 3 // Set(1,2,4)

  // range
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList // (2,4,6,8....,2000)

  // tuples =  A structure that allows grouping multiple values into a single entity, even if those values are of different types.
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 2908289),
    "Jane" -> 126373 // equivalent ("Jane", 126373)
  )

}