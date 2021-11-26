object Typeclasses extends App {

  // a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.

  trait Reversable[T] {
    def reversable(a: T): T
  }

  object Reversable {
    def reverse[T: Reversable](a: T): T = implicitly[Reversable[T]].reversable(a)

    // b) Реализуйте функцию Reverse для String.
    implicit object ReversableString extends Reversable[String] {
      override def reversable(a: String): String = a.reverse
    }
  }

  // примените тайп-класс-решение из пункта (a) здесь
  def testReversableString(str: String): String = Reversable.reverse(str)
  println(testReversableString("xof"))

  // c) Определите тайп-класс Smash таким образом чтобы в нем была функция smash, которая выполняет операцию со значениями одного типа.
  trait Smash[T] { def smash(a: T, b: T): T }

  object Smash {
    def smash[T: Smash](a: T, b: T): T = implicitly[Smash[T]].smash(a, b)
    // d) Реализуйте  функции Smash для типа Int и Double.
    //    Используйте сложение для типа Int у умножение для типа Double.
    implicit object SmashInt extends Smash[Int] {
      override def smash(a: Int, b: Int): Int = a + b
    }
    implicit object SmashDouble extends Smash[Double] {
      override def smash(a: Double, b: Double): Double = a * b
    }

    // e) Реализуйте функцию Smash для типа String. Необходимо выполнить конкатенацию строк, которые будут получены в качестве параметра.
    implicit object SmashStr extends Smash[String] {
      override def smash(a: String, b: String): String = a concat b
    }
  }

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashInt(a: Int, b: Int): Int = Smash.smash(a, b)
  println(testSmashInt(10, 4))

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashDouble(a: Double, b: Double): Double = Smash.smash(a, b)
  println(testSmashDouble(10.0, 5.0))

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashString(a: String, b: String): String = Smash.smash(a, b)
  println(testSmashString("made by ", "fox"))
}