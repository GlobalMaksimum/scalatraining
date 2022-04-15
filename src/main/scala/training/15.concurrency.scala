package training
import scala.concurrent._
import ExecutionContext.Implicits.global // ForkJoinPool
import scala.util.{Failure, Random, Success,Try}
import scala.concurrent.duration._
// java.util.concurrent
object concurrency {
  // Future

  //  global executioncontext num of core
  // Option =< None Some
  // Try => Success Failure
  def customerVKN(cutomerId:Long):Future[Long] = Future {
    Thread.sleep(Random.between(800,900))
    Random.between(1,10)
  }

  def customerTCKN(vkn:Long):Future[Long] = Future {
    blocking {
      Thread.sleep(Random.between(800,900)) // db call file call netty jdbc
    }
    Random.between(1,10)
  }

  def main(args: Array[String]): Unit = {
    // 8 =9 10 11  512 kb stack   => 32767
    // context switch cost
    // context switch explicit management yok
    val tcknF = customerVKN(1).map(i => i*2).flatMap(vkn => customerTCKN(vkn))
    //tcknF.map

    println(Await.result(tcknF, 10.seconds))
    println(32767/2)
  }
}
