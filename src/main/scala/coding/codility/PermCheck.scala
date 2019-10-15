package coding.codility

object PermCheck {
  def solution(a: Array[Int]): Int =
    permCheck(a.toList)

  def permCheck(list: List[Int]): Int = {
    def innerPermCheck(prev: Option[Int] = Option.empty): Iterable[Int] => Int = {
      case next :: Nil if prev.fold(false)(next == _ + 1) =>
        1

      case next :: tail if prev.fold(true)(next == _ + 1) =>
        innerPermCheck(Some(next))(tail)

      case _ =>
        0
    }

    innerPermCheck()(list.sorted)
  }
}
