package coding.codility

object TapeEquilibrium {
  type Idx = Int
  type Diff = Int

  def solution(a: Array[Int]): Int =
    tapeEquilibrium(a)

  // - Valid ranges (1, n - 1)
  // Approach:
  // - Split in the middle, Math.ceil((n - 1) / 2)
  // - Num elements on the left = x1, Num elements on the right = x2
  // - If distance is less than 0, then we have disequilibrium on the right side... move to half of x2
  // - If distance is greater than 0, the we have disequilibrium on the left side... move to half of x1
  private def tapeEquilibrium(a: Array[Int]): Int = {
    def innerTapeEquilibrium(currIdx: Idx, best: Option[(Idx, Diff)] = Option.empty): Int = {
      if (currIdx == 1 || currIdx == a.length - 1 || best.map(_._1).fold(false)(_ == currIdx))
        best.map(_._2).getOrElse(-1)
      else {
        val (left, right) =
          a.splitAt(currIdx)

        val diff =
          left.sum - right.sum

        val absDiff =
          Math.abs(diff)

        val newBest =
          best
            .filter(_._2 < absDiff)
            .getOrElse(currIdx -> absDiff)

        if (a(currIdx) == absDiff)
          absDiff
        else if (diff == 0)
          diff
        else if (diff < 0)
          innerTapeEquilibrium(findMiddle(right.length) + currIdx, Some(newBest))
        else
          innerTapeEquilibrium(currIdx - findMiddle(left.length), Some(newBest))
      }
    }

    innerTapeEquilibrium(findMiddle(a.length))
  }

  private def findMiddle(size: Int): Int =
    Math.ceil((size.toDouble - 1) / 2).toInt
}
