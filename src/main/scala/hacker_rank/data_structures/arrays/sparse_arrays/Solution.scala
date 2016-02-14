package hacker_rank.data_structures.arrays.sparse_arrays

object Solution {

  val input = io.Source.stdin.getLines()
  def readString: String = input.next()
  def readInt: Int = input.next().toInt

  def main(args: Array[String]) {
    val N = readInt
    val stringsCount = collection.mutable.Map.empty[String, Int]
    for (_ <- 0 until N) yield {
      val s = readString
      stringsCount(s) = stringsCount.getOrElse(s, 0) + 1
    }

    val Q = readInt
    for (_ <- 0 until Q) yield {
      val query = readString
      println(stringsCount.getOrElse(query, 0))
    }

  }
}
