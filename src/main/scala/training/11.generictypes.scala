package training

object generictypes {
  val listInt: List[Int] = List(1, 2, 3)
  val listString: List[String] = List("a", "b", "c")
  class MyContainer[+T](value: T) {
    //private var va:T = value
    def setValue[B >: T](v:B):MyContainer[B] = new MyContainer[B](value)
  }


  case class FruitContainer[B <: Fruit](v:B)

  // T invariant
  // +T covariant
  // lower type bounds

  /*
  lower type bound
        B
      /
     T
   */
  /*
  upper type bound
        Fruit
        /
        B
   */

  val mContainer = new MyContainer("dasdsa")
  val mContainerI = new MyContainer(3)

  def lengthOfList[T](l: List[T]) = l.length

  trait Fruit
  trait Apple extends Fruit
  trait Orange extends Fruit

  /*
          Fruit
          /   \
      Orange  Apple  // Liskov Substitution principle
   */

  def getOrange:Orange = new Object with Orange
  def getApple:Apple = new Object with Apple

  val fruit:Fruit = getOrange
  val fruit2:Fruit = getApple

  def doWithFruit(fruit:Fruit):Int = ???
  //doWithFruit(getApple)
  def doWithFruitContainer(c:MyContainer[Fruit]):Int = 1

  def orangeInContainer :MyContainer[Orange] = ???
  def fruitInContainer :MyContainer[Fruit] = ???
  def orangeContainer: MyContainer[Orange] = new MyContainer(getOrange)

  doWithFruitContainer(new MyContainer[Orange](getOrange))

  // Orange <: Fruit   MyContainer[Orange] <: MyContainer[Fruit]
  // Orange <: Fruit   MyContainer[Fruit] <: MyContainer[Orange]

  //  Fruit supertype of Apple | Orange

  def main(args: Array[String]): Unit = {

  }




}
