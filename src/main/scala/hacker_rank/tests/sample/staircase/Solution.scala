package hacker_rank.tests.sample.staircase

object Solution {

  val input = io.Source.stdin.getLines()
  def readInt: Int = input.next().toInt

  def StairCase(n: Int) = {
    for(i <- 1 to n) {
      print(" " * (n - i))
      println("#" * i)
    }
  }

  def main(args: Array[String]) {
    val N = Console.readInt()
    scala.io.StdIn.readInt()
  }
}
