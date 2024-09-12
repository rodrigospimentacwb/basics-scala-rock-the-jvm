package com.rockthejvm

object ObjectOrientation extends App {

  // class and instance
  class Animal {
    //define fields
    val age: Int = 0
    // define methods
    def eat() = println("I'm eating")
  }
  val animal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal {
    //override def eat() = println("Override") --> Can be overrided
  } // constructor definition
  val aDog = new Dog("bacon")

  // constructor arguments are NOT fields: need put aval before the constructor argument
  aDog.name

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Spike")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime. Can use override

  //abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default public, can restrict by adding protected or private
    def walk(): Unit
  }

  //interface = ultimate abstract type Characteristics you can implement em concrete classes
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  // single-class inheritance, multi-trait "mixing" like with ... n
  class Crocodile extends Animal with Carnivore {
    override def eat(animal: Animal): Unit = print("Crocodile eat another animals")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only available for methods with ONE argument

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = print("I am adinosaur so I can eat pretty much anything")
  }

  // singleton object
  object MySingleton {
    val mySpecialValue = 12434
    def mySpecialMethod(): Int = 5678
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(5)
  MySingleton(65) // equivalent to MySingleton.apply(5)

  object Animal { // companions - companion object
    // companion can access each other's private fields/methods'
    // singleton Animal and instance of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  /*
    case class = lightweight data structure with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
    - pattern matching
    Summary: A case class in Scala is an immutable class with automatic equals, hashCode, toString, and pattern matching support.
   */
  case class Person(name: String, age:Int)
  // may be constructed widthout new
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "Some faulty error message"
  } finally {
    // execute some code no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head // int
  val rest = aList.tail
  val aStringList = List("Hello", "Scala")
  val firstString = aStringList.head // string

  // Point#1: in Scala we usually with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object
  /*
    benefits:
    1) works miracles in multithreaded/distribute env
    2) helps to make sense of the code ("reasoning about")
   */
  val reversedList = aList.reverse

  // Point #2: Scala is closest to the OO ideal
  
}
