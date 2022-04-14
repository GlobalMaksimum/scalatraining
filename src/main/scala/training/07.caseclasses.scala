package training

object caseclasses {

  class NormalPerson(val name:String,val surname:String){
    //def fullname
  }

  case class CasePerson(name:String,surname:String)

  sealed trait Color
  case object Red extends Color


  /*
  Option
  None
  Some
  */

  def findPerson(id:String):Option[CasePerson] = Some(CasePerson("anil","halil"))

  /*
  Either[L,R]
  Left
  Right
   */

  def findPersonE(id:String):Either[Exception,CasePerson] = if(id.length==13) {
    Left(new Exception("not found"))
  } else {
    Right(CasePerson("anil","halil"))
  }

  def main(args: Array[String]): Unit = {

    //new NormalPerson("name","surname") ==new NormalPerson("name","surname")
    println(new NormalPerson("name","surname") ==new NormalPerson("name","surname"))
    println(CasePerson("anil","halil") == CasePerson("anil","halil"))
    val p = CasePerson("anil","halil")
    println(Red)

  }
}
