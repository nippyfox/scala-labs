package exercise1

/* This task has no tests. It is an exercise for you to write different class structures.
 * 
 a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String
 * 
 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }
 * c) Добавьте следующие метод в Animals:
 *      def eats(food: String): Boolean
 *
 *     который проверяет ест ли животное определенную пищу
 */

class AnimalC(val name: String, val species: String, food: String) {
  def eats(food: String): Boolean = this.food == food
}

 /* b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *      - cat, mammal, meat
 *      - parrot, bird, vegetables
 *      - goldfish, fish, plants
 * 
 *    Синтаксис: object MyClass {
 *              // статические поля и методы
 *            }
 */

object AnimalsC {
  val cat = new AnimalC("cat", "mammal", "meat")
  val parrot = new AnimalC("parrot", "bird", "vegetables")
  val goldfish = new AnimalC("goldfish", "fish", "plants")
}

 /*
 * d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishes.
 *    Вам все еще нужно поле `species`?
 */

trait Animal {
  val name: String
  val food: Food

  def eats(food: Food): Boolean = this.food == food
}

case class Mammals(name: String, food: Food) extends Animal
case class Birds(name: String, food: Food) extends Animal
case class Fishes(name: String, food: Food) extends Animal


 /* e) Добавьте следующие функции в объект-компаньон Animal:
 *      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
 *      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
 */

object Animal {
  def knownAnimal(name: String): Boolean = name == "cat" | name == "parrot" | name == "goldfish"

  def apply(name: String): Option[Animal] = name match {
    case "cat" => Some(Mammals("cat", Meat))
    case "parrot" => Some(Birds("parrot", Vegetables))
    case "goldfish" => Some(Fishes("goldfish", Plants))
    case _ => None
  }
}

 /* f) Создайте трейт Food со следующими классами-образцами:
 *      - Meat
 *      - Vegetables
 *      - Plants
 *   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
 *      def apply(food: String): Option[Food]
 */

trait Food

case object Meat extends Food
case object Vegetables extends Food
case object Plants extends Food

object Food {
  def apply(food: String): Option[Food] = {
    food match {
      case "meat" => Some(Meat)
      case "vegetables" => Some(Vegetables)
      case "plants" => Some(Plants)
      case _ => None
    }
  }
}

object main extends App {
  println("Cat eats meat: ", AnimalsC.cat.eats("meat"))
  println("Parrot eats meat: ", AnimalsC.parrot.eats("meat"))
  println("Cat is known animal: ", Animal.knownAnimal("cat"))
  println("Unicorn is known animal: ", Animal.knownAnimal("unicorn"))
  println(Animal.apply("cat"))
  println(Food.apply("vegetables"))
}