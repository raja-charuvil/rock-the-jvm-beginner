package lectures.part3funProgram

object WhatsAFunction extends App {

  // Dream: Use functions as first class elements
  // Problem: OOP

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // Function Types = Function1[A, B]
  // Scala supports function types up to 22 parameters
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // Function type Function2[A, B, R] === (A, B) => R

  // ALL Scala functions are objects or instances of classes Function1, Function2...etc


  /*
    1. A Function which takes 2 strings and concat them
    2. Transform the MyPredicate and MyTransformer into function types
    3. Define a function which takes an Int, and returns a function which takes an Int and returns an Int
       - What's the type of the function
       - How to do it?
   */

  // 1. Solution
  val funConcat: ((String, String) => String) = new Function2 [String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(funConcat("Hello, ", "Scala"))

  // 3. Solution
  // Function1[(Int),  Funciton1[Int, Int]]
  val funFunction: ((Int) => Function1[Int, Int]) = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val adder3 = funFunction(3)
  println(adder3(4  ))
  println(funFunction(3)(4)) // curried function


}

// Function like class
trait MyFunction[A, B] {
  def apply(element: A): B
}