package hacker_rank.solve_me_first

object Solution {

  def log(s: Any) = Console.err.println(s)
  val input = io.Source.stdin.getLines()
  def readInt: Int = input.next().toInt
  def readIntSeq: Seq[Int] = input.next().split(' ').map(_.toInt)
  def readString: String = input.next()

  def main(args: Array[String]) {
    val a = readInt
    val b = readInt

    println(a + b)
  }
}
