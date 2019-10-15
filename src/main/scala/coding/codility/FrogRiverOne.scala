package coding.codility

object FrogRiverOne {
  def solution(x: Int, a: Array[Int]): Int =
    a.distinct match {
      case distinct if distinct.length != x =>
        -1

      case distinct =>
        a.indexOf(distinct.last)
    }
}
