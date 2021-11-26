import scala.util.{Try, Failure, Success}

/** Реализуйте следующие функции.
  * 
  * List(1, 2) match {
  *   case head :: tail => ???
  *   case Nil          => ???
  *   case l            => ???
  * }
  * 
  * Option(1) match {
  *   case Some(a) => ???
  *   case None    => ???
  * }
  * 
  * Either.cond(true, 1, "right") match {
  *   case Left(i)  => ???
  *   case Right(s) => ???
  * }
  * 
  * Try(impureExpression()) match {
  *   case Success(a)     => ???
  *   case Failure(error) => ???
  * }
  * 
  * Try(impureExpression()).toEither
  * 
  */
object Adts extends App {

  // a) Дан List[Int], верните элемент с индексом n
  def testGetNth(list: List[Int], n: Int): Option[Int] = Some(list(n))
  println(testGetNth(List(0, 1, 2, 3, 4, 5, 6, 7), 4))

  // b) Напишите функцию, увеличивающую число в два раза.
  def testDouble(n: Option[Int]): Option[Int] = Some(n.get * 2)
  println(testDouble(Some(7)))

  // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right. В противном случае, верните Left("Нечетное число.").
  def testIsEven(n: Int): Either[String, Int] = n match {
    case value: Int if value % 2 == 0 => Right(n)
    case _ => Left("Нечётное число.")
  }
  println(testIsEven(13))

  // d) Напишите функцию, реализующую безопасное деление целых чисел. Верните Right с результатом или Left("Вы не можете делить на ноль.").
  def testSafeDivide(a: Int, b: Int): Either[String, Int] = (a, b) match {
    case (a, b) if b != 0 => Right(a / b)
    case _ => Left("Вы не можете делить на ноль.")
  }
  println(testSafeDivide(28, 0))

  // e) Обработайте исключения функции с побочным эффектом вернув 0.
  def testGoodOldJava(impure: String => Int, str: String): Try[Int] = Try(impure(str)).recover{case _ => 0}
  println(testGoodOldJava(x => x.toInt, "fox"))
}
