package org.scalaeuler

object problem1 {

  def multipleOf(factors: List[Int]): Int => Boolean =
    x => factors exists (y => x % y == 0)         //> multipleOf: (factors: List[Int])Int => Boolean

  val factors = List(3, 5)                        //> factors  : List[Int] = List(3, 5)

  lazy val multiples = 0 to 999 filter multipleOf(factors)
                                                  //> multiples: => scala.collection.immutable.IndexedSeq[Int]
  val answer = multiples sum                      //> answer  : Int = 233168

}