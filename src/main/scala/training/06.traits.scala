package training
//package com.trendyol.dao

object traitstraining {

  trait Walk {
    def walk: Int = 10
  }
  trait Fly {
    def fly: Int
  }

  abstract class BaseObject {
    def walk: Int
  }

  abstract class BaseObject2 {
    def walk: Int
  }

  class MyPersonSuper extends BaseObject {
    def walk: Int = 20
  }

  class MyPerson(val name: String, val surname: String) extends Walk with Fly {

    override def walk: Int = name.length + surname.length

    override def fly: Int = 40
  }

  // dont use
  object Colors extends Enumeration {
    type Colors = Value
    val Red, Green, Blue = Value
  }
  object Colors2 extends Enumeration {
    type Colors = Value
    val Red, Green, Blue = Value
  }

  def test(v: Colors.Colors) = println(v)
  //def test(v:Colors2.Colors) = println(v) error

  object MyColor {
    sealed trait MyColor

    object Red extends MyColor

    object Green extends MyColor

    object Blue extends MyColor

    val values = Array(Red, Green, Blue)
  }

}
