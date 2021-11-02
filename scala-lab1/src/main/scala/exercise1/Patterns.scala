package exercise1

/** Напишите решение в виде функции. 
  * 
  * Синтаксис:
  *   val a: Int = ???
  * 
  *   a match {
  *     case 0 => true
  *     case _ => false
  *   }
  */
object Patterns extends App {

  sealed trait Hand
  case object Rock    extends Hand
  case object Paper   extends Hand
  case object Scissor extends Hand

  sealed trait Result
  case object Win  extends Result
  case object Lose extends Result
  case object Draw extends Result

  sealed trait Food
  case object Meat       extends Food
  case object Vegetables extends Food
  case object Plants     extends Food

  sealed trait Animal {

    val name: String
    val food: Food
  }
  case class Mammal(name: String, food: Food, weight: Int) extends Animal
  case class Fish(name: String, food: Food)                extends Animal
  case class Bird(name: String, food: Food)                extends Animal

  /* a) Напишите функцию, которая ставит в соответствие числу строку следующим образом:
   * Если:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     иначе => "what's that"
   */

  def intToString(x: Int): String = x match {
    case 1 => "It is one"
    case 2 => "It is two"
    case 3 => "It is three"
    case _ => "What's that?"
  }

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testIntToString(value: Int): String = intToString(value)
  println(testIntToString(1))

  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
   *     "max" или "Max"
   *     "moritz" или "Moritz"
   */
  def isMaxAndMoritz(value: String): Boolean = value == "max" || value == "Max" || value == "moritz" || value == "Moritz"

  // примените функции из пункта (b) здесь, не изменяя сигнатуру
  def testIsMaxAndMoritz(value: String): Boolean = isMaxAndMoritz(value)
  println(testIsMaxAndMoritz("maxi"))

  // c) Напишите функцию проверки является ли `value` четным
  def isEven(value: Int): Boolean = value % 2 == 0

  // примените функции из пункта (c) здесь, не изменяя сигнатуру
  def testIsEven(value: Int): Boolean = isEven(value)
  println(testIsEven(1414))
  
  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага 
   *     1. камень побеждает ножницы
   *     2. ножницы побеждают бумагу
   *     3. бумага побеждает камень
   *    Выиграет ли игрок `a`?
   */
  def winsA(a: Hand, b: Hand): Result = a match {
    case Rock => b match {
      case Rock => Draw
      case Scissor => Win
      case Paper => Lose
    }
    case Scissor => b match {
      case Scissor => Draw
      case Paper => Win
      case Rock => Lose
    }
    case Paper => b match {
      case Paper => Draw
      case Rock => Win
      case Scissor => Lose
    }
  }

  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
  def testWinsA(a: Hand, b: Hand): Result = winsA(a, b)
  println(testWinsA(Scissor, Scissor))

  // Примечание: используйте определение Animals

  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
  def extractMammalWeight(animal: Animal): Int = animal match {
    case mammal: Mammal => mammal.weight
    case _ => -1
  }

  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testExtractMammalWeight(animal: Animal): Int = extractMammalWeight(animal)
  println(testExtractMammalWeight(Mammal("Fox", Meat, 1414)))

  // f) Измените поле еда, объектов классов Fishes и Birds на Plants, класс Mammals оставьте неизмененным.
  def updateFood(animal: Animal): Animal = animal match {
    case fish: Fish => Fish(fish.name, Plants)
    case bird: Bird => Bird(bird.name, Plants)
    case mammal: Mammal => Mammal(mammal.name, mammal.food, mammal.weight)
  }

  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
  def testUpdateFood(animal: Animal): Animal = updateFood(animal)
  println(testUpdateFood(Bird("Raven", Meat)))
}
