package hacker_rank.tests.first_gen.test_1

object Solution {

  def countSquares(a: Int, b: Int): Int = {
    val lower = math.ceil(math.sqrt(a)).toInt
    val upper = math.floor(math.sqrt(b)).toInt
    math.max(upper - lower + 1, 0)
  }

  def count_Squares(arr: Array[String]) = {
    for (line <- arr) {
      val Array(a, b) = line.split("\\s").map(_.toInt)
      println(countSquares(a, b))
    }
  }

  def main(args: Array[String]) {
    var _arr_size = 0
    _arr_size = Console.readInt
    val _arr = new Array[String](_arr_size)
    for (_arr_i <- 0 until _arr_size) {
      val _arr_item = readLine()


      _arr(_arr_i) = _arr_item
    }

    count_Squares(_arr)

  }
}
