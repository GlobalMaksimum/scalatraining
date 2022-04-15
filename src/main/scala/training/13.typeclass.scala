package training
object typeclasses {
  trait Animal {
    def walk: Int
  }

  class Cheetah extends Animal {
    def walk: Int = 10
  }
  class Turtle extends Animal {
    def walk: Int = 2
  }

  // subtype polymorphism
  trait Show {
    def show: String
  }
  // adhoc polymorphism
  trait ShowTC[T] {
    def show(t: T): String
  }

  case class Json(t: String)
  class Person(val name: String, val surname: String)

  implicit val intShow = new ShowTC[Int] {
    override def show(t: Int): String = t.toString
  }
  implicit val longShow = new ShowTC[Long] {
    override def show(t: Long): String = t.toString
  }

  implicit val personShow = new ShowTC[Person] {
    override def show(t: Person): String = s"Person(${t.name},${t.surname})"
  }

  def showImp[T](t: T)(implicit imp: ShowTC[T]): String = imp.show(t)
  // context bound
  def show2[T: ShowTC](t: T): String = {
    val impValue: ShowTC[T] = implicitly[ShowTC[T]]
    impValue.show(t)
  }

  implicit class ShowOps[T: ShowTC](t: T) {
    def show: String = showImp(t)
  }

  //implicit def t2showOps[T: ShowTC](t: T): ShowOps[T] = new ShowOps(t)
  /*
  Rust explicit typeclass
   */

  def log[T](t: T)(implicit imp: ShowTC[T]): Unit = println(showImp(t))

  def main(args: Array[String]): Unit = {
    1.show
    1l.show
    val p = new Person("a","b")
    p.show
  }

}
