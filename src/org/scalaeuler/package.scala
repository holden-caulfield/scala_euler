package org

package object scalaeuler {
  def from(n: Int): Stream[Int] = n #:: from(n + 1)
  
  val naturals = from(1)
  
  def sieveOfEratosthenes(s: Stream[Int]): Stream[Int] =
    s.head #:: sieveOfEratosthenes(s.tail filter (_ % s.head != 0))
  
  val primes = sieveOfEratosthenes(from(2)) 
}