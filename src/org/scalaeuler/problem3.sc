package org.scalaeuler

object problem3 {
  //refer to package object for auxiliary functions

  def firstPrimeFactor(n: BigInt): Int =
    (primes filter (n % _ == 0)).head             //> firstPrimeFactor: (n: BigInt)Int

  def primeFactors(n: BigInt): List[Int] = {
    def loop(rest: BigInt, factors: List[Int]): List[Int] = {
      val nextFactor = firstPrimeFactor(rest)
      if (rest == nextFactor) nextFactor :: factors
      else loop(rest / nextFactor, nextFactor :: factors)
    }
    loop(n, List())
  }                                               //> primeFactors: (n: BigInt)List[Int]

  primeFactors(600851475143L).head                //> res0: Int = 6857

}