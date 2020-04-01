package lectures.part3funProgram

object WhatsAFunction extends App {

  /*
    1. A Function which takes 2 strings and concat them
    2. Transform the MyPredicate and MyTransformer into function types
    3. Define a function which takes an Int, and returns a function which takes an Int and returns an Int
       - What's the type of the function
       - How to do it?
   */

  val funConcat: ((String, String) => String) = new Function2 [String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(funConcat("Hello, ", "Scala"))

}
