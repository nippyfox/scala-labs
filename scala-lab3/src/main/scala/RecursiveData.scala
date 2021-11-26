sealed trait List[A]
case class Cons[A](head: A, tail: List[A]) extends List[A]
case class Nil[A]() extends List[A]
/** Напишите свои решения в виде функций. */
object RecursiveData extends App {
  /** a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.
  */
  def testListIntEmpty(list: List[Int]): Boolean = list match {
    case _: Nil[Int] => true
    case _ => false
  }
  println(testListIntEmpty(Nil()))
  println(testListIntEmpty(Cons(14, Cons(7, Cons(9, Nil())))))

  /** b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.
  * используйте функцию из пункта (b) здесь, не изменяйте сигнатуру
  */
  def testListIntHead(list: List[Int]): Int = list match {
    case list: Cons[Int] => list.head
    case _ => -1
  }
  println(testListIntHead(Nil()))
  println(testListIntHead(Cons(14, Cons(7, Cons(9, Nil())))))

  /** c) Можно ли изменить `List[A]` так чтобы гарантировать что он не является пустым?
   */
  sealed trait ChangedList[A]
  case class ChangedCons[A](head: A, tail: ChangedList[A]) extends ChangedList[A]
  case class ChangedNil[A](head: A) extends ChangedList[A]

  /** d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
   *      node - левое и правое дерево (Tree)
   *      leaf - переменная типа A
   */
  sealed trait Tree[A]
  case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
  case class leaf[A](leaf: A) extends Tree[A]
}
