/** Напишите ваши решения в тестовых функциях.
  * 
  * https://www.scala-lang.org/api/2.12.3/scala/collection/immutable/StringOps.html
  */
object Strings extends App {
  // a) Преобразуйте все символы типа Char в верхний регистр (не используйте заглавные буквы).
  def testUppercase(str: String): String = str.toUpperCase
  println(testUppercase("не использую заглавные буквы"))

  // b) Вставьте следующие значения в строку:
  // Hi my name is <name> and I am <age> years old.
  def testInterpolations(name: String, age: Int): String = s"Hi! My name is $name and I am $age years old"
  println(testInterpolations("nippyfox", 21))

  /* c) Добавьте два числа в следующую строку:
   *       Hi,
   *       now follows a quite hard calculation. We try to add:
   *         a := <value of a>
   *         b := <value of b>
   * 
   *         result is <a + b>
   */
  def testComputation(a: Int, b: Int): String = s"Hi,\nnow follows a quite hard calculation. We try to add:" +
    s"\n  a := $a\n  b := $b\n\n  result is ${a+b}"
  println(testComputation(993, 7))

  // d) Если длина строки равна 2, верните всю строку, иначе верните первые два символа строки.
  def testTakeTwo(str: String): String = if (str.length == 2) str else str.take(2)
  println(testTakeTwo("nippyfox"))
}
