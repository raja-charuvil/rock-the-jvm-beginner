package lectures.part3funProgram

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = (2, "Hello, Scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "Goodbye Java"))
  println(aTuple.swap) // ("Hello, Scala", 2)

  // Maps - Keys -> Values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  // a -> b is sugar for (a, b)
  println(phonebook)

  // Map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Mary"))

  // add a pairing
  val newPair = "Mary" -> 678
  val newPhonebook = phonebook + newPair
  println(newPhonebook)

  // Functions on maps
  // map, filter, flatMap
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  val x = phonebook.view.filterKeys(x => x.startsWith("J"))
  println(x)
  // mapValues
  println(phonebook.view.mapValues(number => number * 10))

  // conversion to other collections
  println(phonebook.toList)
  println(List(("Dainel", 555)).toMap)

  val names = List("Bob", "James", "Anjela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
}
