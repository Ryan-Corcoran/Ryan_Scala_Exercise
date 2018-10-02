case class Person(name: String, age:Int)
val xs = List(
  Person("mac", 41),
  Person("bob", 40)
)

val totalAge = xs.map(_.age)

totalAge.sum()
