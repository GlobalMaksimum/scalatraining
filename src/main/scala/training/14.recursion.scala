package training

import scala.annotation.tailrec

object recursion {
  //n! n*n-1*n-2....1
  // 0 => 1
  // 1 => 1
  // BigInt
  def fac(i: BigInt): BigInt = if (i <= 1) 1 else i * fac(i - 1)

  def facTailR(i: BigInt): BigInt = {
    @tailrec
    def loop(a: BigInt, acc: BigInt): BigInt =
      if (a <= 1) acc else loop(a - 1, a * acc)
    loop(i, 1)
  }
  // 0 1 2 3 4 5 6 7  n = fib(n-1) +fib(n-2)
  // 0 1 1 2 3 5 8 13
  // 13 8 5 3 2 1 1 0
  def fib(n: Long): Long = if (n <= 1) n else fib(n - 1) + fib(n - 2)

  def fibTR(n: Long): Long = {
    def loop(a: Long, prev: Long, pprev: Long): Long =
      if (a <= 2) prev + pprev else loop(a - 1, prev + pprev, prev)
    if (n < 2) n else loop(n, 1, 0)
  }

  def length[T](l: List[T]): Int = l match {
    case Nil    => 0
    case _ :: t => 1 + length(t)
  }
  def lengthR[T](l: List[T]): Int = {
    def loop(list: List[T], acc: Int): Int = list match {
      case Nil    => acc
      case h :: t => loop(t, 1 + acc)
    }
    loop(l, 0)
  }

  def drop[T](l: List[T], n: Int): List[T] =
    if (l == Nil || n <= 0) l else drop(l.tail, n - 1)

  def dropWhile[T](l: List[T])(predicate: T => Boolean): List[T] = l match {
    case Nil => Nil
    case h::t if(predicate(h)) => dropWhile(t)(predicate)
    case _ => l
  }

  def main(args: Array[String]): Unit = {
    val l = (0 to 20).toList
    println(l.dropWhile(_<9))
    println(dropWhile(l)(i => i<9))

    val list = List(1,2,3,4,5)
    println(list.foldLeft(1)((z,i) => z*i))
  }
}
