package hacker_rank.tests.first_gen.test_3

object Solution {

  val input = io.Source.stdin.getLines()
  def readInt: Int = input.next().toInt
  def readIntSeq: Seq[Int] = input.next().split(' ').map(_.toInt)


  def find(a: Array[Int], x: Int, y: Int): Int = {
    if (x > y)
      1
    else
      math.pow(a(x - 1), find(a, x + 1, y)).toInt
  }

  def foo(a: Array[Int], x: Int, y: Int): String = {

    // pow(a(x-1), pow(0, Z)) % 2 == 1; for any Z
    if (x < a.length && y != x && a(x) == 0) return "Odd"

    // pow(a(x-1), Z) % 2 == a(x-1) % 2; Z > 0
    a(x - 1) % 2 match {
      case 0 => "Even"
      case _ => "Odd"
    }
  }

  def main(args: Array[String]) {
    val n = readInt
    val a = readIntSeq.toArray
    val q = readInt
    for(_ <- 0 until q) {
      val Seq(x, y) = readIntSeq
      println(foo(a, x, y))
    }
  }

}
