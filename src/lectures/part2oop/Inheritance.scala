package lectures.part2oop

object Inheritance extends App {

  // Single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("num num num")
  }

  class Cat extends Animal {
    def cruch = {
      eat
      println("crunch crunch crunch")
    }
  }

  val cat = new Cat
  cat.cruch

  // Constructors
  // Extending class with parameters
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  //class Adult(name: String, age: Int, idCard: String) extends Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name: String)

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType: String = "domestic"
    override def eat: Unit = {
      super.eat
      println("crunch crunch crunch")
    }
  }
  val dog =  new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // Type substitution (Also called polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // Overriding (supplying different implementation on derived classes) VS
  // Overloading (Supplying multiple methods with different signatures on same class with same name)

  // Super

  // Preventing override
  // 1. using final on the member
  // 2. Use final on the entire class
  // 3. Seal the class => can extend the class in this file but not on any other file

}
