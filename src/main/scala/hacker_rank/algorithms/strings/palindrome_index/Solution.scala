package hacker_rank.algorithms.strings.palindrome_index

import scala.annotation.tailrec

/** https://www.hackerrank.com/challenges/palindrome-index */
//noinspection ScalaPackageName
object Solution {

  def log(s: Any) = Console.err.println(s)
  val input = io.Source.stdin.getLines()
  def readInt: Int = input.next().toInt
  def readString: String = input.next()


  @tailrec def substringPalindrome(s: String, left: Int, right: Int): Boolean = {
    if (left > right)
      true
    else if (s(left) != s(right))
      false
    else
      substringPalindrome(s, left + 1, right - 1)
  }

  @tailrec def almostPalindrome(s: String, left: Int, right: Int): Int = {
    if (left > right)
      -1
    else if (s(left) == s(right))
      almostPalindrome(s, left + 1, right - 1)
    else
      if (substringPalindrome(s, left + 1, right))
        left
      // supposedly each case IS palindrome without letter
      // we don;t have to check if right fits
      else
        right
  }

  def main(args: Array[String]) {
    val N = readInt
    for (_ <- 0 until N) {
      val s = readString
      if (substringPalindrome(s, 0, s.length - 1)) {
        println(-1)
      } else {
        println(almostPalindrome(s, 0, s.length - 1))
      }
    }
  }

}
