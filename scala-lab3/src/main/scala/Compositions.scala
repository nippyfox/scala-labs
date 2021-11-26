/** Option представляет собой контейнер, который хранит какое-то значение
  * или не хранит ничего совсем, указывает, вернула ли операция результат или нет. 
  * Это часто используется при поиске значений или когда операции могут потерпеть неудачу, 
  * и вам не важна причина.
 
  * Комбинаторы называются так потому, что они созданы, чтобы объединять результаты. 
  * Результат одной функции часто используется в качестве входных данных для другой.

  * Наиболее распространенным способом, является использование их со стандартными структурами данных.
  * Функциональные комбинаторы `map` и` flatMap` являются контекстно-зависимыми. 
  * map - применяет функцию к каждому элементу из списка, возвращается список с тем же числом элементов.
  * flatMap берет функцию, которая работает с вложенными списками и объединяет результаты.
*/
sealed trait Option[A] {
  def map[B](f: A => B): Option[B]
  def flatMap[B](f: A => Option[B]): Option[B]
}

case class Some[A](a: A) extends Option[A] {
  def map[B](f: A => B): Option[B] = Some(f(a))
  def flatMap[B](f: A => Option[B]): Option[B] = f(a)
}

case class None[A]()     extends Option[A] {
  def map[B](f: A => B): Option[B] = None()
  def flatMap[B](f: A => Option[B]): Option[B] = None()
}

/** Напишите ваши решения в тестовых функциях.  */
object Compositions extends App {
  val num = 110

  // a) Используйте данные функции. Вы можете реализовать свое решение прямо в тестовой функции.
  def testCompose[A, B, C, D](f: A => B)
                             (g: B => C)
                             (h: C => D): A => D = f andThen g andThen h
  println(testCompose((num: Int) => num.toLong)((num: Long) => num.toChar)((sym: Char) => sym.toString)(num))

  // b) Напишите функции с использованием `map` и `flatMap`. Вы можете реализовать свое решение прямо в тестовой функции.
  def testMapFlatMap[A, B, C, D](f: A => Option[B])
                                (g: B => Option[C])
                                (h: C => D): Option[A] => Option[D] = _.flatMap(f).flatMap(g).map(h)
  println(testMapFlatMap((num: Int) => Some(num))((num: Int) => Some(num + num))((num: Int) => num * num)(Some(2)))

  // c) Напишите функцию используя for. Вы можете реализовать свое решение прямо в тестовой функции.
  def testForComprehension[A, B, C, D](f: A => Option[B])
                                      (g: B => Option[C])
                                      (h: C => D): Option[A] => Option[D] = {
    for {
      a <- _
      b <- f(a)
      c <- g(b)
    }
      yield h(c)
  }
  println(testForComprehension((num: Int) => Some(num / num))((num: Int) => Some(num + num))((num: Int) => Some(num + num))(Some(14)))
}
