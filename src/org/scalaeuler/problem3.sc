package org.scalaeuler

object problem3 {

  def from(n: Int): Stream[Int] = n #:: from(n+1) //> from: (n: Int)Stream[Int]
	
	def sieveOfEratosthenes(s: Stream[Int]): Stream[Int] =
		s.head #:: sieveOfEratosthenes(s.tail filter (_ % s.head != 0) )
                                                  //> sieveOfEratosthenes: (s: Stream[Int])Stream[Int]

	val primes = sieveOfEratosthenes(from(2)) //> primes  : Stream[Int] = Stream(2, ?)

	def firstPrimeFactor(n: BigInt): Int =
		(primes filter (n % _ == 0)).head //> firstPrimeFactor: (n: BigInt)Int

	def primeFactors(n: BigInt): List[Int] = {
		def loop(rest: BigInt, factors: List[Int]): List[Int] = {
			val nextFactor = firstPrimeFactor(rest)
			if (rest == nextFactor) nextFactor :: factors
			else loop(rest / nextFactor, nextFactor :: factors)
		}
		loop(n, List())
	}                                         //> primeFactors: (n: BigInt)List[Int]
		
	primeFactors(600851475143L).head          //> res0: Int = 6857
	
}