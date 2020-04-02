package lectures.part2oop

import playground.{Cinderalla => Princess, PrinceCharming}
// import playground._ If you want to import everything

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  // Package members are accessible by their simple name
  val writer = new Writer("Raja", "My Life", 30)

  // Can import the packages
  val princess = new Princess
  // If you don't want to import, then give fully qualified name of the member and package
  // val princess = new playground.Cinderalla

  // packages are in hierarchy
  // matching their folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  //
  val prince = new PrinceCharming

  //
  val d = new SqlDate(2009, 1, 1)
  println(d)

  // Default imports
  // java.lang = String, Object, Exception
  // scala = Int, Nothing, Function
  // scala.Predef = println, ???
}
