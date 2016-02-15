package hacker_rank.tests.first_gen.test_2

object Solution {

  def cutSticks(lengths: Array[Int]) = {
    var sticksLeft = lengths.length
    var totalCut = 0

    for(stickLength <- lengths.sorted) {
      if (stickLength > totalCut) {
        println(sticksLeft)
        totalCut = stickLength
      }
      sticksLeft -= 1
    }
  }

  def main(args: Array[String]) {
    val _lengths_size = Console.readInt
    val _lengths = new Array[Int](_lengths_size)
    for (_lengths_i <- 0 until _lengths_size) {
      var _lengths_item:Int = Console.readInt


      _lengths(_lengths_i) = _lengths_item
    }

    cutSticks(_lengths)

  }

}
