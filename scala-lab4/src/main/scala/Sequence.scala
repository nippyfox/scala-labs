/** Напишите свои решения в тестовых функциях.
  * 
  * Seq(1, 2) match {
  *   case head +: tail => ???
  *   case Nil          => ???
  *   case s            => ???
  * }
  * 
  * https://www.scala-lang.org/api/2.12.0/scala/collection/Seq.html
  */

object Sequence extends App {
  val seq1 = Seq(1, 2, 3, 4, 5, 6, 7)
  val seq2 = Seq(1, 2, 3, 4, 3, 2, 1)

  // a) Найдите последний элемент Seq.
  def testLastElement[A](seq: Seq[A]): Option[A] = seq.lastOption
  println(testLastElement(seq1))

  // b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))) - если Seq длиннее игнорируйте оставшиеся элементы.
  def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = a.zip(b)
  println(testZip(seq1, seq2))

  // c) Проверьте, выполняется ли условие для всех элементов в Seq.
  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = seq.forall(cond)
  println(testForAll(seq1)(x => x < 5))

  // d) Проверьте, является ли Seq палиндромом
  def testPalindrom[A](seq: Seq[A]): Boolean = seq == seq.reverse
  println(testPalindrom(seq1))

  // e) Реализуйте flatMap используя foldLeft.
  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = seq.foldLeft(Seq[B]())((x, y) => x++:f(y))
  println(testFlatMap(seq1)(x => Seq(x * 3)))
}
