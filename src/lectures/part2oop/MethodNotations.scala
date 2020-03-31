package lectures.part2oop

import java.io.PrintStream

import com.sun.deploy.perf.{PerfLabel, PerfRollup}
import scala.language.postfixOps

object MethodNotations  extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name What the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name favorite movie is $favoriteMovie"

    // Exercise Answers
    def +(nickName: String): Person = new Person(s"$name {$nickName}", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age+1)
    def learns(language: String): String = s"$name learns $language"
    def learnsScala: String = this learns "Scala"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation. => Only for methods with single parameter
  // Example of syntactic sugars

  // "Operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1+2)
  println(1.+(2))
  // ALL Operators are METHODS!
  // AKKA actors have ! and ?

  // Prefix notations
  val x = -1 // - => unary operator == 1.unary_-
  val y = 1.unary_-
  // Unary operator only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // Postfix notation
  // Only available for methods without parameters
  println(mary.isAlive)
 //  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  // Exercises
  /*
    1. Overload the + operator
       mary + "the rockstar" => new person "Mary {the rockstar}"
    2. Add an age to the person class with default 0
       Add a unary + operator => new person with age + 1
       +mary => mary with age incrementer
    3. Add a "learns" method in the person class => Mary learns Scala
       Add a learnsScala method (without parameters), calls the leans method with "scala" as a parameter
       Use it as a postfix notation
    4. Overload the apply method
       mary.apply(2) = "Mary watched the Inception 2 times"
   */
  println((mary + "the rockstar")())
  println((+mary).age)
  println(mary learnsScala)
  println(mary(2))
}
