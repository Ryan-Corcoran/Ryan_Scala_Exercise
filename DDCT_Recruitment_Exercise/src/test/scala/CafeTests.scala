import org.scalatest.FunSuite

class CafeTests extends FunSuite {

  val cafeX = new CafeX

  test("Cola returns price") {
    val colaPrice = cafeX.addItemPrice("Cola")
    assert(colaPrice === 0.50)
  }

  test("Coffee returns a price") {
    val coffeePrice = cafeX.addItemPrice("Coffee")
    assert(coffeePrice === 1.00)
  }

  test("Cheese Sandwich returns price") {
    val cheeseSWPrice = cafeX.addItemPrice("Cheese Sandwich")
    assert(cheeseSWPrice === 2.00)
  }

  test("Steak Sandwich returns a price") {
    val steakSWPrice = cafeX.addItemPrice("Steak Sandwich")
    assert(steakSWPrice === 4.50)
  }
}