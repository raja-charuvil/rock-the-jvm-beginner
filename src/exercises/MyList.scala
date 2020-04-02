package exercises

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
  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  // Concatenation for flatMap
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = ""

  // map, filter, flatMap
  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
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
  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }
}

trait MyPredicate[-T]{
  def test(elem: T): Boolean
}
trait MyTransformer[-A, B] {
  def transform(elem: A): B
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
  val listOfStrings = new Cons("A", new Cons("B", new Cons("C", Empty)))
  println(listOfIntegers.toString())
  println(listOfStrings.toString())

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem+1, Empty))
  }).toString)

  // Case class
  println(listOfIntegers == cloneListOfIntegers)
}
