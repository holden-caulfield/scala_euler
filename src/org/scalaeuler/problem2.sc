package org.scalaeuler

object problem2 {
  
 	//Literal definition: on scala with Streams performs well enough
  lazy val fib: Stream[BigInt] = {
    def loop(h: BigInt, n: BigInt): Stream[BigInt] = h #:: loop(n, h + n)
    loop(1, 1)
  }                                               //> fib: => Stream[BigInt]
  
  def isEven(n: BigInt): Boolean = n % 2 == 0     //> isEven: (n: BigInt)Boolean
  
  fib filter isEven takeWhile {_ < 4000000} sum   //> res0: BigInt = 4613732

	//Optimized version: avoids checking for every fibonacci number
	//to see if it is even. We can use the fact that every third fibonacci
	//number is even, which deviates on this formula for the fibonacci
	//sequence: F(n) = 4*F(n-1) + F(n-2)
	lazy val optFib: Stream[BigInt] = {
		def loop(h: BigInt, n: BigInt): Stream[BigInt] =
			n #:: loop(n, 4*n + h)
		2 #:: loop(2, 8)
	}                                         //> optFib: => Stream[BigInt]

	optFib takeWhile {_ < 4000000} sum        //> res1: BigInt = 4613732
}