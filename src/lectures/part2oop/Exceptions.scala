package lectures.part2oop

object Exceptions extends App {
  val x: String = null
  // This will crash with NullPointerException
  // println(x.length)

  // 1. Trowing and catching exceptions
  // val aWeiredValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exceptions and Error are major Throwable subtypes

  // 2. How to catch Exceptions
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No Int for you")
    else 42
  }

  val potentialFail: Int = try {
    // code that might fail
    getInt(false)
  } catch {
    // Expected exceptions to throw
    case e: RuntimeException => 43
  } finally {
    // Code that will executed, no matter what!
    // optional
    // does not influence the return type
    // Use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  class MyException extends Exception

  val exception = new MyException
  // throw exception

  /*
    1. Crash your program with OutOfMemoryError
    2. Crash with SOError
    3. Pocket Calculator
       - add(x,y)
       - subtract(x,y)
       - multiply(x,y)
       - divide(x,y)
       Throw
         - OverflowException if add(x,y) exceeds Int.MAX_VALUE
         - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
         - MathCalculationException for division by zero
   */

  // 1. OOM Error
  // val array = Array.ofDim(Int.MaxValue)

  // 2. SO Error
  def infinite: Int = 1 + infinite
  // val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {

    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && x < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y >  0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x : Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }

  }

  // println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(4, 0))

}
