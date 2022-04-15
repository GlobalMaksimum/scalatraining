package training

import training.implicitdefinitions.LogFormatter


object formatters {
  implicit val noFormat: LogFormatter = (l: String) => l
  implicit val trimFormat: LogFormatter = l =>
    if (l.length > 10) s"${l.substring(0, 12)} ..." else l
  implicit def intT2String[T](i:T):String = i.toString

}
object implicitdefinitions {
  trait LogFormatter {
    def format(l: String): String
  }
  import formatters.noFormat

  case class Person(name:String,surname:String,age:Int)

  case class BasicPerson(name:String,surname:String)

  //implicit def person2BasicPerson(p:Person):BasicPerson = BasicPerson(p.name,p.surname)

  def log(line: String)(implicit format: LogFormatter): Unit = println(
    format.format(line)
  )



  implicit class RichPerson(val p:Person) {
    def asBasicPerson:BasicPerson = BasicPerson(p.name,p.surname)
  }

  /*
  pimp my library
   */

  import formatters.intT2String
  def main(args: Array[String]): Unit = {

    import scala.jdk.CollectionConverters._

    val jList = java.util.List.of(1,2,3,4,5)
    val scalaList = jList.asScala.toList

    "dasdsadsa".toInt

    val person = Person("name","dasdsa",22)
    person.asBasicPerson
    log(1)
    log(1l)
  }
}
