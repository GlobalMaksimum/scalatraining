package training

object patternmatching {

  def matchInt(i:Int) = i match {
    case 1 => "bir"
    case 0 => "sifir"
    case x if x>=2 => "buyuktur iki"
    case _ => s"negatif"
  }

  case class Person(name:String,surname:String,age:Int)

  def matchPerson(p:Person):Int = p match {
    case Person("Anil",s,_) => s.length
    case Person("anil",s,a) if a>20 => s.length
    case Person("Anil","Halil",39) => 0
    case Person(_,"",0) => 1
  }
  def matchList(l:List[Int]) :Int = l match {
    case _ :: 2 :: Nil => 0
    case 1 :: 2 :: Nil => 0
    case 1 :: 2 :: _ => 0
    case 1 :: _ :: 3 :: _ :: 5 ::Nil => 10
  }

  def matchList2(l:List[Person]) :Int = l match {
    case Person("Anil",_,_) :: _ :: Nil => 0
    case Person("anil",_,_) :: _ :: Nil => 0
    //case 1 :: 2 :: _ => 0
    //case 1 :: _ :: 3 :: _ :: 5 ::Nil => 10
  }

  def matchList3(t:(List[Person],Int)) :Int = t match {
    case (Person("Anil",_,_) :: _ :: Nil,0) => 0
    //case Person("anil",_,_) :: _ :: Nil => 0
    //case 1 :: 2 :: _ => 0
    //case 1 :: _ :: 3 :: _ :: 5 ::Nil => 10
  }

  def useExtractor(l:String): Int = l match {
    case PersonExtractor("Anil",surname) =>  surname.length
  }
  object PersonExtractor {
    def unapply(s:String):Option[(String,String)] = {
      val splitted = s.split(' ')
      if(splitted.length==2) Some((splitted(0),splitted(1))) else None
    }
  }


  def main(args: Array[String]): Unit = {
    println(matchInt(9))
  }
}
