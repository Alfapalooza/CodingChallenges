package coding

import org.scalacheck.Gen

import scala.util.Random

trait DataGenSupport {
  val genPosNumGreaterThanZero: Gen[Int] =
    Gen.posNum[Int].suchThat(_ > 0)

  val genMatchingPair: Gen[(Int, Int)] =
    Gen
      .posNum[Int]
      .map { integer =>
        integer -> integer
      }

  val genNonEmptySeqOfMatchingPairs: Gen[Seq[Int]] =
    for {
      atLeastOne <- genPosNumGreaterThanZero
      pairs <- Gen.nonEmptyContainerOf[Seq, Seq[(Int, Int)]](Gen.containerOfN[Seq, (Int, Int)](atLeastOne, genMatchingPair))
    } yield
      pairs
        .flatten
        .flatMap {
          case (x1, x2) =>
            Seq(x1, x2)
        }

  val genOddOccurrences: Gen[Function[Int, Seq[Int]]] =
    genNonEmptySeqOfMatchingPairs.map { pairs =>
      (unpairedInteger: Int) =>
        Random.shuffle(pairs :+ unpairedInteger)
    }
}
