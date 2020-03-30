package lectures.part1Basics

object Expressions extends App {

  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)
  // + - * $ | ^ << >> >>>

  println(1 == x)
  // == != > >= < <=

  println(!{1 == x})
  // ! && ||

  var aVariable = 2
  aVariable += 3 // -=, *=, /=  ... all are side effects
  println(aVariable)

  // Instructions (DO) VS Expressions (Something has a value or a type)

  // IF Expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)

  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }
  // Never use while loop like this !!

  // Everything in SCALA is an expression

  val aWieredValue = (aVariable = 3) // Unit == void
  println(aWieredValue)

  // Examples for side effects are => print, while, reassigning

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z>y) "hello" else "GoodBye"
  } // Value of code block is the value of it's last expression
  // Everything stays inside code block, not available outside
  println(aCodeBlock)

  // 1. Difference between "hello world" and println("hello world")
  // 2.

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 238 else 986
    42
  }
}
