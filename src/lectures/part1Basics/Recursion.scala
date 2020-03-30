package lectures.part1Basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n<=1) 1
    else {
      println("Computing the factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1) // This is not tail recursion
      // Recursion should be last one in the code block
      println("Computed factorial of " + n)

      result
    }
  }

  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x-1, x * accumulator) // Last expression of code block
      // Scala doesn't need to store intermediate results
      // This is called TAIL RECURSION
    }

    factHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10, 1)
  - factHelper(9, 10*1)
  - factHelper(8, 9*10*1)
  - ...
  - factHelper(1, 2*3*......*10*1)
  - 1*2*3*.......*10
   */
  // println(anotherFactorial(5000))

  // When you need loops -> Use tail recursion

  /*
    1. Concatenate a string n times, using tailrec
    2. IsPrime using tailrec
    3. Fibonacci fun using tailrec
   */

  @tailrec
  def strConcatTailrec(str: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else strConcatTailrec(str, n-1, str + accumulator)
  }

  println(strConcatTailrec("Hello", 3, ""))

  def isPrimeTailrec(n: Int): Boolean = {
    @tailrec
    def innerIsPrime(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else innerIsPrime(t-1, n % t != 0 && isStillPrime )
    }

    innerIsPrime(n/2, true)
  }

  println(isPrimeTailrec(2003))
  println(isPrimeTailrec(629))

  def fibonacci(n: Int): Int = {
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)
    }
    if (n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
  }

  println(fibonacci(8))
}
