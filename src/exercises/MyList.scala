package exercises

import javafx.collections.transformation.SortedList
import lectures.part2oop.Generics.MyList

abstract class MyList[+A]
{
  /*
  List of integers
    method head => first element of the list
    tail => reminder of the list
    isEmpty = > Is this list empty
    add[Int] => New list with this element added
    toString => s string representation of the List
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]

  def printElements: String
  // Polymorphic call
  override def toString(): String = "[" + printElements + "]"

  // map, filter, flatMap
  // Higher order functions
  def map[B](transformer: A => B): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  // Concatenation for flatMap
  def ++[B >: A](list: MyList[B]): MyList[B]

  // HOFs
  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = ""

  // map, filter, flatMap
  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  // HOFs
  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("Lists do not have same length")
    else Empty
  }
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  // map, filter, flatMap
  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  // HOFs
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }
  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] ={
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists do not have same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }

  /*
    [1,2,3].fold(0)(+) =
    = [2,3].fold(1)(+) =
    = [3].fold(3)(+)
      .
      .
      6

   */
  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)

  println(list.toString())

  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers = new Cons(4, new Cons(5, Empty))
  val listOfStrings = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfIntegers.toString())
  println(listOfStrings.toString())

  println(listOfIntegers.map(elem => elem * 2).toString)

  println(listOfIntegers.filter(elem => elem % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem+1, Empty))).toString)

  // Case class
  println(listOfIntegers == cloneListOfIntegers)

  // HOFs
  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x, y) => y - x))
  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _ ))
  println(listOfIntegers.fold(0)(_ + _))

  // for comprehension
  val combinations = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + "-" + string
  println(combinations)
}
