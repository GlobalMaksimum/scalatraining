package training

import scala.util.Random

object monads {
  // Option
  // List
  // Future monadic

  def customerVKN(cutomerId: Long): Option[Long] = Some(Random.between(1, 10))

  def customerTCKN(vkn: Long): Option[Long] = Some(Random.between(1, 10))

  def first(i:Int):Option[Int] = ???
  def second(i:Int):Option[Int] = ???
  def secondp(i:Int):Int = ???
  def third(x:Int,y:Int):Option[Int] = ???

  def firstN(i:Int):Int = ???
  def secondN(i:Int):Int = ???
  def thirdN(x:Int,y:Int):Int = ???  // null
  def forthN(x:Int,y:Int):Int = ???

  def calculateN(i:Int) = {
    val a = firstN(i)
    if(a!=null) {
      val b = secondN(a)
      if(a!=null && b!=null) {
        val t = thirdN(a,b)
        if(t!=null) {
          forthN(b,t)
        } else {
          null
        }
      } else {
        null
      }
    } else {
      null
    }
  }

  // higher kinded type
  trait Functor[T,F[_]] {
    def id(t:T):F[T]
    def map[X](f:T => X):F[X]
  }

  trait Monad[T,F[_]] extends Functor[T,F] {
    def flatMap[X](f:T => F[X]):F[X]
  }
  // cats, cats effect IO monad,monix Task,zio john de gaese ZIO => category theory
  // Some(1)
  Some(1).map(_.toString)
  // Option => Monad
  def calculate(i:Int) = for {
    a <- first(i)
    b <- second(a)
    c <- Option(secondp(b)).filter(_>0)
    d <- third(b,c)
  } yield d
//  def forth(x:Int,y:Int):Option[Int] = ???

  def main(args: Array[String]): Unit = {
    val l = List(1, 2, 3, 4, 5, 6)
    val l2 = List(1, 2, 3, 4)
    val l3 = List(1, 2, 3, 4)
    // for comprehension
    // flatMap map withFilter
    /*for {
      i <- l
      j <- l2
      x <- l3 if x % 2 == 0
    } yield i * j * x*/


  }
}
