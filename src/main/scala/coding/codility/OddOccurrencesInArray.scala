package coding.codility

import coding.Helpers

import scala.annotation.tailrec

object OddOccurrencesInArray extends Helpers {
  def solution(a: Array[Int]): Int =
    findUmatched1(a.toList)

  @tailrec
  private def findUmatched1(list: List[Int], matched: Map[Int, Boolean] = Map.empty): Int =
    list match {
      case Nil =>
        findUnmatched(matched)

      case next :: Nil if matched.get(next).fold(false)(!_) =>
        findUnmatched(matched + (next -> true))

      case next :: Nil =>
        next

      case next :: tail if matched.get(next).fold(false)(!_) =>
        findUmatched1(tail, matched + (next -> true))

      case next :: tail =>
        findUmatched1(tail, matched + (next -> false))
    }

  private def findUmatched2(list: List[Int]): Int = {
    val sortedList =
      list.view.sorted.zipWithIndex

    sortedList
      .find {
        case (pair, idx) =>
          idx + 1 == list.size || (idx % 2 == 0 && !sortedList.get(idx + 1).map(_._1).contains(pair))
      }
      .map(_._1)
      .getOrElse(-1)
  }

  private def findUnmatched(matched: Map[Int, Boolean]): Int =
    matched
      .find {
        case (_, innerMatched) =>
          !innerMatched
      }
      .map(_._1)
      .getOrElse(-1)
}