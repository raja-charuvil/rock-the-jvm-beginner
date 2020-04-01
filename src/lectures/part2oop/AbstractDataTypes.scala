package lectures.part2oop

object AbstractDataTypes extends App {

  // Abstract members
  // Unimplemented methods
  // Abstract classes can not be instantiated
  // These classes are supposed to be extended by sub classes
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
    // override is optional
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croc"
    def eat: Unit = println("nnumnunmnum")
    def eat(animal: Animal): Unit = println(s"I am a croc and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits VS abstract class
  // 1. Both of them can have non abstract (empty) members
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits are type of behavior, abstract class is a type of thing
}
