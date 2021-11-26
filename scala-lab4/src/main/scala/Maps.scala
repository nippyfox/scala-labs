/** Напишите вашу реализацию в тестовые функции.
  * 
  * https://docs.scala-lang.org/overviews/collections/maps.html
  */
object Maps extends App {
  case class User(name: String, age: Int)

  val usersList: Seq[User] = Seq(User("John", 40), User("Paul", 79), User("George", 58), User("Ringo", 81))

  /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`) и вычислите средний возраст: `name -> averageAge`
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testGroupUsers(user: Seq[User]): Map[String, Int] = user.groupBy(_.name).map(x => (x._1, user.map(_.age).sum / user.length))
  println(testGroupUsers(usersList))

  /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей, содержащихся в Map, содержат подстроку "Adam"?
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  val adamMap = Map("1" -> User("Adam", 25), "2" -> User("NotAdam", 30), "3" -> User("Adam", 35), "4" -> User("Noneadam", 40))
  def testNumberFrodos(map: Map[String, User]): Int = map.map(x => x._2.name).count(x => x.contains("Adam"))
  println(testNumberFrodos(adamMap))

  /* c) Удалите всех пользователей возраст которых менее 35 лет.
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testUnderaged(map: Map[String, User]): Map[String, User] = map.filter(x => x._2.age >= 35)
  println(testUnderaged(adamMap))
}
