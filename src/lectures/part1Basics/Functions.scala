package lectures.part1Basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 4))

  def aParameterlessFun() = 42
  println(aParameterlessFun())
  println(aParameterlessFun)

  def aRepeatedFun(aString: String, n: Int): String = {
    if (n==1) aString
    else aString + aRepeatedFun(aString, n-1)
  }

  val res = aRepeatedFun("Hello", 3)
  println(res)
  // Use recursion instead of Loops

  def aFunWithSideEffects(aString: String): Unit = {
    println("Raja")
  }

  def aBigFun(n: Int): Int = {
    def aSmallFun(a: Int, b: Int):Int = a+b
    aSmallFun(n, n-1)
  }

  /*
    1. A Greeting fun.
       name, age
       "Hi my name is $name, and I am $age years old"
    2. Factorial fun. Product of all numbers up to n.
    3. A Fibonacci fun.
       f(1) = 1
       f(2) = 1
       f(n) = f(n-1) + f(n-2)
    4. Tests if a number is prime
   */

  def aGreet(name: String, age: Int): String = {
    s"Hi, my name is $name, I am $age years old"
  }

  def aFactorial(n: Int): Int = {
    if (n <= 1) 1
    else n * aFactorial(n-1)
  }

  // 1,1,2,3,5,8,13.....
  def aFibonacci(n: Int): Int = {
    if (n <= 2) 1
    else aFibonacci(n-2) + aFibonacci(n-1)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }

  println(aGreet("raja", 25))
  println(aFactorial(5))
  println(aFibonacci(8))
  println(isPrime(7))

}
