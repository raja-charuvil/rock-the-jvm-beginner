package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use type A inside class definition
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Dog => B turns Animal
     */
  }

  // Multiple parameter also possible
  // Traits can also be type parametrised
  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // Variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  // ? If Cat extends Animal, Does List[Cat] extends List[Animal]?

  // 1. Yes List[Cat] extends List[Animal] => Covariance
  class CovariantList[+A]
  val animal: Animal = new Animal
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog), Is that possible? Hard question!!
  // We return a List of Animals

  // 2. No => Invariance
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, No => Contravariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  // It makes sense, when
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded types
  class Cage[A <: Animal] (animal: A)
  val cage = new Cage(new Dog)

  class Car
  // val newCage = new Cage(new Car) => not possible

  // Exercise:
  // Expand MyList to be Generic



}
