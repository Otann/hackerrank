// package hacker_rank.tests.sample.first_generation.test_5

object Solution {

  val input = io.Source.stdin.getLines()
  def readInt: Int = input.next().toInt
  def readString: String = input.next()

  def symbolCount(s: String): Map[Char, Int] = {
    val m = collection.mutable.Map.empty[Char, Int]
    for(c <- s) m(c) = m.getOrElse(c, 0) + 1
    m.toMap
  }

  def diff(a: String, b: String): Int = {
    val a_symbols = symbolCount(a)
    val b_symbols = symbolCount(b)
    b_symbols
      .map{ case (b_symbol, b_count) =>
        val a_count = a_symbols.getOrElse(b_symbol, 0)
        math.max(b_count - a_count, 0)
      }
      .sum
  }

  def main(args: Array[String]) {
    val n = readInt
    for(_ <- 0 until n) {
      val input = readString
      if (input.length % 2 == 1) {
        println(-1)
      } else {
        val a = input.substring(0, input.length / 2)
        val b = input.substring(input.length / 2, input.length)
        println(diff(a, b))
      }
    }
  }

}
