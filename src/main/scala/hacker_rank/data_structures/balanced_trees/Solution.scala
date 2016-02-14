//package hacker_rank.data_structures.balanced_trees

import scala.annotation.tailrec

/** https://www.hackerrank.com/challenges/array-and-simple-queries */
// Got only 14/27 tests
object Solution {

  val input = io.Source.stdin.getLines()
  def readInt: Int = input.next().toInt
  def readIntSeq: Seq[Int] = input.next().split(' ').map(_.toInt)

  class Node(val data: Int, var next: Node = null) {

    @tailrec final def nodeAt(i: Int): Node = i match {
      case 0 => null
      case 1 => this
      case _ => next.nodeAt(i-1)
    }

    @tailrec final def last: Node = next match {
      case null => this
      case node => node.last

    }

    def length: Int = {
      var result = 1
      var node = this
      while (node.next != null) {
        result += 1
        node = node.next
      }
      result
    }

    def append(node: Node): Node = {
      this.last.next = node
      this
    }

    @tailrec
    final def printAll(): Unit = {
      print(this.data)
      next match {
        case null => println
        case node => print(" "); node.printAll()
      }
    }
  }

  object Node {
    def fromSeq(s: Seq[Int]) = {
      val reversed = s.reverse
      var head = reversed.head
      var tail = reversed.tail
      var node = new Node(head)
      while (tail.nonEmpty) {
        head = tail.head
        tail = tail.tail
        node = new Node(head, node)
      }
      node
    }
  }

  def rotate1(head: Node, beginIndex: Int, endIndex: Int): Node = {
    if (beginIndex == 1) return head

    val begin = head.nodeAt(beginIndex)
    val end = begin.nodeAt(endIndex - beginIndex + 1)
    head.nodeAt(beginIndex-1).next = end.next
    end.next = head
    begin
  }

  def rotate2(head: Node, beginIndex: Int, endIndex: Int, length: Int): Node = {
    if (endIndex == length) return head

    val begin = head.nodeAt(beginIndex)
    val end = begin.nodeAt(endIndex - beginIndex + 1)
    val end_next = end.next
    val last = head.last

    end.next = null
    last.next = begin

    if (beginIndex != 1) {
      head.nodeAt(beginIndex-1).next = end_next
      head
    } else {
      end_next
    }
  }

  def main(args: Array[String]) {
    val Seq(n, m) = readIntSeq
    var head: Node = Node.fromSeq(readIntSeq)
    val length = head.length

    //    head.printAll()
    //    log(s"M: $m, N: $n")

    for (i <- 0 until m) {
      val Seq(qtype, begin, end) = readIntSeq

      //      print(s"Iterating query ${i + 1}")
      //      print(s"Applying type $qtype: from $begin to $end")
      //      print(s"Seq: "); head.printAll()

      head = qtype match {
        case 1 => rotate1(head, begin, end)
        case 2 => rotate2(head, begin, end, length)
      }
    }

    println(Math.abs(head.data - head.last.data))
    head.printAll()
  }
}