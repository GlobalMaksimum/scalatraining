package training

object UniqueNumbers{
//class UniqueNumbers
//class UniqueNumbers$
  private var counter = 0

  def getUnique:Int = {
    counter+=1
    counter
  }
}
/*

class App {
public static void main(String[] args) {
}
}
 */
object AppObjects {
  def main(args: Array[String]): Unit = {
    println(UniqueNumbers.getUnique)
  }
}


