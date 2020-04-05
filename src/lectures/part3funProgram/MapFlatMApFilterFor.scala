package lectures.part3funProgram

object MapFlatMApFilterFor extends App {
  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1)) // _ == x => x +....
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))
  println(list.flatMap(x => List(x, x+1)))

  // Exercise
  // print all combinations between 2 lists
  val numbers = List(1,2,3,4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("Black", "White")
  // List('a1', 'a2'....'d4')
  /* "Iterations" */
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)
  val colorCombinations = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + n + c + "-" + color)))
  print(colorCombinations)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield "" + n + c + "-" + color
  println(forCombinations)

  // for-with-filter
  val forCombinationsFilter = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + n + c + "-" + color
  println(forCombinationsFilter)

  // this is same as
  val eq = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + n + c + "-" + color)))
  println(eq)

  // foreach equivalent
  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x + 2
  }

  /*
    1. Does MyList supports for comprehension?
       map(f: A => B) => MyList[B]
       filter(f: A => Boolean) => MyList[A]
       flatMap(f: A => MyList[B]) => MyList[B]
    2. A small collection of at most ONE element - Maybe[+T]
       -  implement map, flatMap,, filter
   */
}
