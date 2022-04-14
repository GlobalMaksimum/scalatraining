package training

import scala.util.Random

object hof {

  def outer(): String = {
    def inner(): String = ""
    inner()
  }

  val x = 1
  val myfunc: Int => Int = a => a * a
  val myfunc1: Function1[Int, Int] = a => a * a

  def myfunc2(i: Int) = i * i
  // eta expansition
  val myfuncEExpansion: Int => Int = i => hof.myfunc2(i)

  def sum(l: Int, r: Int): Int = l + r
  val sumF: (Int, Int) => Int = (l, r) => l + r

  def logFunctionCall(l: Int,r:Double, f: (Int,Double) => String): Unit = {
    println("start to call function")
    val v = f(l,r)
    println(s"function finished value $v")
    //v
  }

  val s:String = "" + 12

  val i:Object = "hello world"

  val castedValue = i.asInstanceOf[String] //
  // if(i.isInstanceOf[String]) i.asInstanceOf[String] else

  // Haskell Curry
  // 2  Int => Int => Int

  val sumCurry: Int => Int => Int = (l) => (r) => sum(l, r)

  def inverseCurrySum(l: Int, r: Int) = sumCurry(l)(r)

  def example(l:Int,r:Double):String = s""

  def scalaCurriedFunction(l: Int)(r: Int) = l + r

  def noFormat(l: String) = l
  def shortFormatter(l:String) = if(l.length>10) s"${l.substring(0,12)} ..." else l
  def log(line: String, format: String => String = noFormat) = {
    println(format(line))
  }
  val colors = Array(
    Console.RED,
    Console.WHITE,
    Console.BLUE,
    Console.MAGENTA,
    Console.YELLOW,
    Console.GREEN,
    Console.CYAN
  )

  def colored(line: String):String = {
    val splitted = line.split("(?<=[\\s,]+)(?![\\s,])|(?<![\\s,])(?=[\\s,]+)")
    val coloredSplit =
      for (e <- splitted)
        yield
          if (e.trim.isEmpty) Console.RESET + e
          else colors(Math.abs(Random.nextInt()) % colors.length) + e
    coloredSplit.mkString + Console.RESET
  }

  def main(args: Array[String]): Unit = {
    println(logFunctionCall(2,1.5d, (l,r) => s"l:$l r:$r"))
    val oneAdder = sumCurry(1)
    val oneAdder2 = scalaCurriedFunction(1) _
    println(oneAdder(2))
    println(oneAdder(5))
    println(oneAdder(6))
    println(oneAdder2(2))
    log("hello fdskfjsdhkfjdshfkjsdh",shortFormatter)
    log("hello trendyol how it is going", colored)
  }
}
