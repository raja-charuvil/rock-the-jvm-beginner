package lectures.part3funProgram

object AnonymousFunction extends App {

  // Anonymous function LAMBDA
  val doubler: Int => Int = x => x * 2
  // OR val doubler = (x: Int) => x * 2

  // Multiple params in Lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // function itself
  println(justDoSomething()) // call
  // Lambdas must be called with ()

  // Curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // More syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to a => a + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  /*
    1. MyList: Replace all FunctionX calls with Lambdas
    2. Rewrite the "special" adder as an anonymous function
   */

  // Solution to 2
  val funFunction: ((Int) => Function1[Int, Int]) = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(4)(9))
}
