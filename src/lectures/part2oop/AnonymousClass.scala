package lectures.part2oop

object AnonymousClass extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Anonymous class
  // Instantiating an abstract class, Which should be impossible!
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahahahahah")
  }
  // But, what really happened was =>
  /*
  class AnonymousClass$$anon$1 extends Animal {
    override def eat: Unit = println("hahahahahahahah")
  }
  val funnyAnimal: Animal = new AnonymousClass$$anon$1
   */
  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, My name is $name, who can I help?")
  }

  // Anonymous classes works for abstract as well as non abstract classes
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, My name is Jim, Who can I be of service")
  }
  /*
    1. Generic Trait MyPredicate[-T], with method test(T): Boolean
    2. Generic Trait MyTransformer[-A, B], with a method transform(A): B
    3. MyList:
       - map(transformer) => MyList
       - filter(predicate) => MyList
       - flatmap(transformer from A to MyList[B]) => MyList[B]

       class EvenPredicate extends MyPredicate[Int]
       class StringToIntTransformer extends MyTransformer[String, Int]

       (1,2,3).map(n*2) = (2,4,6)
       (1,2,3,4).filter(n % 2) = (2,4)
       (1,2,3).flatMap(n => [n, n+1]) = [1,2,2,3,3,4]
   */

}
