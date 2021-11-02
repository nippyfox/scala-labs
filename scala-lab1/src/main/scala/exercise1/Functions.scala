package exercise1

import scala.math.pow
import scala.math.Pi

/** Напишите отдельные функции, решающие поставленную задачу. 
  * 
  * Синтаксис:
  *   // метод
  *   def myFunction(param0: Int, param1: String): Double = // тело
  * 
  *   // значение
  *   val myFunction: (Int, String) => Double (param0, param1) => // тело
  */
object Functions extends App {

  def acreage(r: Double): Double = pow(r, 2) * Pi
  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = acreage(r)
  println(testCircle(4))

  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def rectangle(a: Double)(b: Double): Double = a * b

  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = rectangle(a)(b)
  val carrFun = testRectangleCurried(4, _)
  println(carrFun(5))

  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def rectangleUc(a: Double, b: Double): Double = a * b

  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = rectangleUc(a, b)
  println(testRectangleUc(4, 5))
}
