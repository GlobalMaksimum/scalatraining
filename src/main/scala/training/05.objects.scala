package training
import java.util.Date

object UniqueNumbers{
//class UniqueNumbers
//class UniqueNumbers$
  private var counter = 0

  def getUnique:Int = {
    counter+=1
    counter
  }
}

class MyPerson(val name:String,val surname:String) {
  private val fullname = s"$name $surname"
}



object MyPerson {

  def compare(lp:MyPerson,rp:MyPerson):Boolean = lp.fullname == rp.fullname

  def apply(n:String,s:String) = new MyPerson(n,s)
}
/*

class App {
public static void main(String[] args) {
}
}
 */
object AppObjects {

  //object Magenta extends traitstraining.MyColor.MyColor
  def main(args: Array[String]): Unit = {
    val date = new Date()
    val b = date.after(new Date())

    val arr = Array(1,2,3)
    println(MyPerson("anil","surname"))
  }
}


