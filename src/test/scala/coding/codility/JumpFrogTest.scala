package coding.codility

import org.scalatest.{FlatSpec, Matchers}

class JumpFrogTest extends FlatSpec with Matchers {
  //Everything fits, x = 10, y = 70, d = 30, expected 2
  //Slight overflow, x = 20, y = 70, d = 30, expected 2
  //Big overflow, x = 20, y = 70, d = 60, expected 1
  //D is bigger than y, x = 20, y = 70, d = 80, expected 1
  "JumpFrog.solution" should "work when everything fits" in {
    JumpFrog.solution(10, 70, 30) shouldBe 2
  }

  it should "work when slight overflow" in {
    JumpFrog.solution(20, 70, 30) shouldBe 2
  }

  it should "work when big overflow" in {
    JumpFrog.solution(20, 70, 60) shouldBe 1
  }

  it should "work when d is bigger than y" in {
    JumpFrog.solution(20, 70, 80) shouldBe 1
  }
}
