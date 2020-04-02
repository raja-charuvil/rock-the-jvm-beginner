package lectures.part2oop

object CaseClass extends App {
  /*
  equals, hashCode, toString..etc
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are promoted to fields
  val jim =  new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim.toString)
  println(jim)
  // println(instance) = println(instance.toString) => Syntactic sugar

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Case classed have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. Case classes have companion objects
  val thePerson = Person
  val mary = Person.apply("Mary", 23)
  println(mary)

  // 6. Case classes are serializable
  // Akka

  // 7. Case classes have extractor patterns // pattern matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  Exercise
  Expand MyList
  Use case classes and case objects
   */

}
