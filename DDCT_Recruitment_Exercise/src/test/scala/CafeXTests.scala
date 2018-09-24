import org.scalatest.FunSuite
import main.scala.*

class CafeXTests extends FunSuite {

    //Testing A equals 3.5
    test(A) {
      Assert(A == 3.5)
    }

    test(B) {
      Assert(B == 1.00)
    }

    test(C) {
      Assert(C == 0.5)
    }
}
