package lectures.part1Basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumString = "45"
  val aNum = aNumString.toInt
  println('a' +: aNumString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // Scala specific interpolators.
  val name = "raja"
  val age = 23

  val greetings = s"Hello, name: $name, and age $age. I will be turning ${age+1} next year"
  println(greetings)

  // F-Interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per min "
  println(myth)

  // raw-Interpolator
  println(raw"This is a \n new line")

  val escaped = "This is a \n new line"
  println(raw"$escaped")


}
