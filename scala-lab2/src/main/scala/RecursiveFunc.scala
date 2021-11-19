import scala.annotation.tailrec
/** Реализуйте функции для решения следующих задач.
  * Примечание: Попытайтесь сделать все функции с хвостовой рекурсией, используйте аннотацию для подстверждения.
  * рекурсия будет хвостовой если:
  *   1. рекурсия реализуется в одном направлении
  *   2. вызов рекурсивной функции будет последней операцией перед возвратом
  */
object RecursiveFunctions extends App {
  val cons = Cons(14, Cons(7, Cons(9, Nil())))
  val consToAdd = Cons(1, Cons(2, Cons(3, Nil())))

  def length[A](as: List[A]): Int = {
    @tailrec
    def loop(rem: List[A], agg: Int): Int = rem match {
      case Cons(_, tail) => loop(tail, agg + 1)
      case Nil()         => agg
    }

    loop(as, 0)
  }

  /** a) Напишите функцию которая записывает в обратном порядке список:
   *        def reverse[A](list: List[A]): List[A]
   */
  def testReverse[A](list: List[A]): List[A] = {
    @tailrec
    def loop(list: List[A], num: List[A]): List[A] = list match {
      case Cons(x, y) => loop(y, Cons(x, num))
      case Nil() => num
    }
    loop(list, Nil())
  }
  println(testReverse(cons))

  /** b) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def map[A, B](list: List[A])(f: A => B): List[B]
   */
  def testMap[A, B](list: List[A], f: A => B): List[B] = {
    @tailrec
    def mapLoop(l: List[A], num: List[B]): List[B] = l match {
      case Cons(x, y) => mapLoop(y, Cons(f(x), num))
      case Nil() => testReverse(num)
    }
    mapLoop(list,Nil())
  }
  println(testMap(cons, (num: Int) => num * 2))
  
  /** c) Напишите функцию, которая присоединяет один список к другому:
   *        def append[A](l: List[A], r: List[A]): List[A]
   */
  def testAppend[A](l: List[A], r: List[A]): List[A] = l match {
    case Cons(x, y) => Cons(x, testAppend(y, r))
    case Nil() => r
  }
  println(testAppend(cons, consToAdd))

  /** d) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def flatMap[A, B](list: List[A])(f: A => List[B]): List[B]
   * 
   *    она получает функцию, которая создает новый List[B] для каждого элемента типа A в 
   *    списке. Поэтому вы создаете List[List[B]]. 
   */
  def testFlatMap[A, B](list: List[A], f: A => List[B]): List[B] = {
    @tailrec
    def flatMapLoop(l: List[A],num: List[B]): List[B] = l match {
      case Cons(x, y) => flatMapLoop(y, testAppend(f(x), num))
      case Nil() => testReverse(num)
    }
    flatMapLoop(list, Nil())
  }
  println(testFlatMap(cons, (x: Int) => Cons(x * 2, Nil())))
}
