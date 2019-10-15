package coding.codility

import coding.TestPrinterSupport

import org.scalatest.{FlatSpec, Matchers}

class ArrayRotationTest extends FlatSpec with Matchers with TestPrinterSupport {
  override val tracingEnabled: Boolean = true

  //Testing cases
  //a) k is smaller than array size
  //b) k is bigger than array size
  //c) k is exactly array size
  val evenSeed: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
  "ArrayRotation.solution (even)" should "work when k is smaller than array size" in {
    //k is smaller than array size
    val solution1 = Array(11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    ArrayRotation.solution(evenSeed, 2) shouldBe solution1
  }

  it should "work when k is bigger than array size" in {
    //k is bigger than array size
    val solution2 = Array(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
    ArrayRotation.solution(evenSeed, 13) shouldBe solution2
  }

  it should "work when k is exactly array size" in {
    //k is exactly array size
    val solution3 = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    ArrayRotation.solution(evenSeed, 12) shouldBe solution3
  }

  val unevenSeed: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
  "ArrayRotation.solution (uneven)" should "work when k is smaller than array size" in {
    //k is smaller than array size
    val solution1 = Array(8, 9, 1, 2, 3, 4, 5, 6, 7)
    ArrayRotation.solution(unevenSeed, 2) shouldBe solution1
  }

  it should "work when k is bigger than array size" in {
    //k is bigger than array size
    val solution2 = Array(8, 9, 1, 2, 3, 4, 5, 6, 7)
    ArrayRotation.solution(unevenSeed, 11) shouldBe solution2
  }

  it should "work when k is exactly array size" in {
    //k is exactly array size
    val solution3 = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    ArrayRotation.solution(unevenSeed, 9) shouldBe solution3
  }
}
