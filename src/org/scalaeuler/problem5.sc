package org.scalaeuler

object problem5 {

  //Trivial, elegant solution, just finding the lcm from 2 to 20
  def gcd(a: Long, b: Long): Long = if (b == 0) a else gcd(b, a % b)
                                                  //> gcd: (a: Long, b: Long)Long
  def lcm(a: Long, b: Long) = (a * b) / gcd(a, b) //> lcm: (a: Long, b: Long)Long

  2L to 20L reduce lcm                            //> res0: Long = 232792560

  //optimized solution, decomposing on a product of prime powers
  //refer to package object for the auxiliary functions
  def multipliers(factors: List[Int], max: Int): List[Int] = {
    val limit = Math.sqrt(max)
    def loop(factors: List[Int]): List[Int] = {
      if (factors.head < limit)
        Math.floor(Math.log(max) / Math.log(factors.head)).toInt :: loop(factors.tail)
      else
        factors map { x => 1 }
    }
    loop(factors)
  }                                               //> multipliers: (factors: List[Int], max: Int)List[Int]

  lazy val primeFactors = (primes takeWhile { _ < 20 }).toList
                                                  //> primeFactors: => List[Int]
  lazy val powers = multipliers(primeFactors, 20) //> powers: => List[Int]

  def productOfPowers(tuples: List[(Int, Int)]): Long =
    tuples map { t => Math.pow(t._1, t._2) } reduce { _ * _ } toLong
                                                  //> productOfPowers: (tuples: List[(Int, Int)])Long

  productOfPowers(primeFactors zip powers)        //> res1: Long = 232792560
}