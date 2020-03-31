package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Raja", 23)
  println(person.age)
  println(person.x)
  person.greet("Hari")
  person.greet()


  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great expectations", 1861, author)
  val impostor = new Writer("Charles", "Dickens", 1812)

  println(novel.authorAge())
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(impostor))

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.print
  counter.increment(5).print
}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2 // => These are fields
  println(1+3)

  def greet(name: String): Unit = {
    println(s"${this.name} says, Hi, $name")
  }

  // Overloading => Methods with same name, but different signatures
  // Different number of parameters, different types of params or coupled with different return types
  def greet(): Unit = println(s"Hi, I am $name") // => here $name is Person name (Raja)

  // multiple constructors => Overloading constructors
  def this(name: String) = this(name, 0) // => This constructor calls the primary constructor with diff parameter
  def this() = this("John Doe")
  // Implementation of auxiliary constructor has to be another constructor. Nothing else
  // This implementation can be easily achieved by supplying default values to the class parameters!
}

// Class parameters are not FIELDS

/*
  Novel and Writer Class
  Writer should have first name, surname and year of birth
  - method called fullName which returns first name + Surname

  Novel: name, year of release, author (Instance of type writer)
  methods
  - authorAge (age of author at age of release)
  - isWrittenBy(author)
  - copy(new year of release) => new Instance of Novel
 */

class Writer(firstName: String, surname: String, val yob: Int) {
  def fullName(): String = {
    s"$firstName $surname"
  }
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = {
    yearOfRelease - author.yob
  }

  def isWrittenBy(author: Writer): Boolean = {
    author == this.author
  }

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}

/*
  Counter Class
   - received Int
   - method current count
   - method to increment/ decrement => new counter
   - overload inc/dec to receive an amount
 */

class Counter(val count: Int = 0) {
  //def currentCount(): Int = count

  def increment(): Counter = {
    println("Incrementing...")
    new Counter(count+1)
  } // immutability

  def decrement(): Counter = {
    println("Decrementing...")
    new Counter(count-1)
  }

  def increment(amount: Int): Counter = {
    if (amount<=0) this
    else increment.increment(amount-1)
  }
  def decrement(amount: Int): Counter = {
    if (amount <= 0) this
    else decrement.decrement(amount-1)
  }
  def print =  println(count)
}