package lectures.part2oop

object Objects {
  // Scala does not have class level functionality ("static" in Java)
  // Achieved by Objects
  object Person { // type + it's only instance
    // Class level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory method
    def from(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // Instance level functionality
  }
  // COMPANIONS => Class and Object in the same file, like here

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = Singleton instance
    val person1 = Person
    val person2 = Person
    println(person1 == person2) // true

    val mary = new Person("Mary")
    val john = new Person("John")
    println(john == mary) // false
    val bobbie = Person.from(mary, john)
  }


  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
}
