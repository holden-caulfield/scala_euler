package org.scalaeuler

object problem6 {

  //the "elegant" way, using monads and expressing the problem itself
  lazy val nums = 1 to 100                        //> nums: => scala.collection.immutable.Range.Inclusive

  def square(n:Int) = n * n                       //> square: (n: Int)Int

  val sumOfSquares = nums map square sum          //> sumOfSquares  : Int = 338350
  val squareOfSums = square(nums sum)             //> squareOfSums  : Int = 25502500
  val diff = squareOfSums - sumOfSquares          //> diff  : Int = 25164150

  //the optimized way, using the properties of the sucessions
  def sumSquares(n: Int) = (n * (n + 1) * (2 * n + 1)) / 6
                                                  //> sumSquares: (n: Int)Int
  def squaresSum(n: Int) = square((n * (n + 1)) / 2)
                                                  //> squaresSum: (n: Int)Int
  def optDiff(n: Int) = squaresSum(n) - sumSquares(n)
                                                  //> optDiff: (n: Int)Int
	
	optDiff(100)                              //> res0: Int = 25164150
}