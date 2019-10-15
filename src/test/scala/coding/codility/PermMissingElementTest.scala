package coding.codility

import org.scalatest.{FlatSpec, Matchers}

class PermMissingElementTest extends FlatSpec with Matchers {
  "PermMissingElements" should "work when starting from 1" in {
    PermMissingElement.solution(Array(2, 3, 1, 5)) shouldBe 4
  }

  it should "work when starting from n" in {
    PermMissingElement.solution(Array(6, 2, 3, 4)) shouldBe 5
  }
}
