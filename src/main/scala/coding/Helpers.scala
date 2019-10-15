package coding

trait Helpers {
  implicit class AugmentedSeq[T](val seq: Seq[T]) {
    def get(i: Int): Option[T] =
      scala.util.Try(seq(i)).toOption

    def insert(i: Int, values: T*): Seq[T] = {
      val (front, back) = seq.splitAt(i)
      front ++ values ++ back
    }
  }
}
