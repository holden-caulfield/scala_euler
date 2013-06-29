package org.scalaeuler

object problem4 {

  def isPalindrome(n: Int) = n == (n toString).reverse.toInt
                                                  //> isPalindrome: (n: Int)Boolean

  lazy val palindromes = for {
    n <- Range(999, 100, -1)
    m <- Range(n, 100, -1)
    if isPalindrome(n * m)
  } yield n * m                                   //> palindromes: => scala.collection.immutable.IndexedSeq[Int]

  palindromes.sorted.reverse.head                 //> res0: Int = 906609
}