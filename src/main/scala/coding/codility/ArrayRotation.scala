package coding.codility

import coding.Helpers

object ArrayRotation extends Helpers {
  def solution(a: Array[Int], k: Int): Array[Int] =
    rotate2(a, k).toArray

  private def rotate1(seq: Seq[Int], rotate: Int)(currIdx: Int = 0, memo: Seq[Int] = Seq(seq.length)): Seq[Int] = {
    def rotateFormula(currIdx: Int, size: Int, rotate: Int): Int =
      Math.abs(currIdx + (size - rotate))

    if (currIdx <= seq.size)
      seq
    else if (memo.get(currIdx).isDefined)
      rotate1(seq, rotate)(currIdx + 1, memo)
    else {
      val from = currIdx
      val to = rotateFormula(currIdx, seq.size, rotate)
      val x1 = seq(from)
      val x2 = seq(to)

      seq.insert(from, x2).insert(to, x1)
    }
  }

  private def rotate2[T](array: Seq[T], move: Int): Seq[T] =
    if (move == array.length || array.isEmpty)
      array
    else if (move > array.length)
      array.takeRight(move % array.length) ++ array.dropRight(move % array.length)
    else
      array.takeRight(move) ++ array.dropRight(move)
}
