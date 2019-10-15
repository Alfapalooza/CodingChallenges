package coding.codility

import coding.{DataGenSupport, TestPrinterSupport}

import org.scalatest.{FlatSpec, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class OddOccurencesInArrayTest extends FlatSpec with Matchers with ScalaCheckDrivenPropertyChecks with DataGenSupport with TestPrinterSupport {
  override val tracingEnabled: Boolean = false

  "OddOccurencesInArray.solution" should "work for all" in {
    forAll(genPosNumGreaterThanZero, genOddOccurrences) {
      case (unmatchedInteger, oddOccurrencesFn)=>
        val oddOccurrences =
          oddOccurrencesFn.apply(unmatchedInteger).toArray

        val oddOccurrence =
          OddOccurrencesInArray.solution(oddOccurrences)

        trace("Unmatched Integer:")
        trace(unmatchedInteger)

        trace("Odd Occurrences:")
        trace(oddOccurrences.sorted.mkString("[", ", ", "]"))

        unmatchedInteger shouldBe oddOccurrence
    }
  }
}
