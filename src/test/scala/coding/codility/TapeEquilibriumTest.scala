package coding.codility

import org.scalatest.{FlatSpec, Matchers}

class TapeEquilibriumTest extends FlatSpec with Matchers {
  //Given array (1, 3, 8, 9, 2, 10, 30, 11)
  //Move to half
  //When P = 4, sum(0..P - 1) == 21, sum(P..N - 1) == 53
  //Difference is 21 - 53 == -32

  //Move to half of x2 == Math.ceil(4 - 1 / 2) + 4 == 6
  //When P = 6, sum(0..P - 1) == 33, sum(P..N - 1) == 41
  //Difference is 33 - 41 == -8

  //Move to half of x2 == Math.ceil(2 - 1 / 2) + 6 == 7
  //When P = 7, sum(0..P - 1) == 63, sum(P..N - 1) == 11
  //Difference is 63 - 11 == 52
  //
  //Winner is -8!
  "TapeEquilibrium.solution" should "work with basic example" in {
    TapeEquilibrium.solution(Array(1, 3, 8, 9, 2, 10, 30, 11)) shouldBe 8
  }

  it should "work with slightly more complex example" in {
    TapeEquilibrium.solution(Array(1, 2, 2, 7, 6)) shouldBe 8
  }

  it should "work with even complex example" in {
    TapeEquilibrium.solution(Array(1, 2, 3, 1, 5, 10, 1, 1)) shouldBe 0
  }

  it should "work with uneven complex example" in {
    TapeEquilibrium.solution(Array(1, 2, 3, 1, 5, 11, 1)) shouldBe 0
  }

  it should "work with bound at start" in {
    TapeEquilibrium.solution(Array(30, 2, 10, 10, 10)) shouldBe 2
  }

  it should "work with bound at end" in {
    TapeEquilibrium.solution(Array(10, 10, 10, 10, 10, 10, 2, 60)) shouldBe 2
  }

  it should "work with weird example (uneven)" in {
    TapeEquilibrium.solution(Array(10, 10, 10, 10, 10, 10, 10, 10, 10)) shouldBe 10
  }

  it should "work with weird example (even)" in {
    TapeEquilibrium.solution(Array(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)) shouldBe 0
  }
}
