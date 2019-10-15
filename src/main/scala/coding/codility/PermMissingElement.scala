package coding.codility

import coding.Helpers

object PermMissingElement extends Helpers {
  def solution(a: Array[Int]): Int =
    permMissingElement(a)

  //TODO: If only 2 elements, need to add some missing integer (test unclear)
  private def permMissingElement(list: Array[Int]): Int =
    if (list.isEmpty)
      1
    else if (list.length == 1 && list.head == 1)
      2
    else if (list.length == 1 && list.head != 1)
      list.head - 1
    else
      (list.min to list.max).sum - list.sum
}
