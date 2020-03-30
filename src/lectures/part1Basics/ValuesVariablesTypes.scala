package lectures.part1Basics

object ValuesVariablesTypes extends App {
  val x: Int = 10
  println(x)

  // VALS are immutable
  // Compiler can infer types

  val aString: String = "raja"
  val aBoolean: Boolean = true
  val aChar: Char = 'c'

  // Variables
  var aVariable: Int = 4
  aVariable = 5
  // Variables cause side effects

}
