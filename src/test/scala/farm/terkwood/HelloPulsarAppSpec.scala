package farm.terkwood

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HelloPulsarAppSpec extends AnyFlatSpec with Matchers {
  "The HelloPulsarApp object" should "say \uD83D\uDC1B  OK hello" in {
    HelloPulsarApp.greeting shouldEqual "\uD83D\uDC1B  OK hello"
  }
}
