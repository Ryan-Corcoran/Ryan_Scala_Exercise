import org.scalatest.FunSuite

/*
ScalaTest class containung unit tests for the CafeX product
@Author Ryan Corcoran
 */
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

  test("Steak Sandwich and Cola return a price") {
    val productList: Array[String] = Array("Cola", "Steak Sandwich")
    val steakColaPrice = cafeX.breakDownList(productList)
    assert(steakColaPrice === 5.00)
  }

    test("Cheese Sandwich and Cola return a price") {
      val productList: Array[String] = Array("Cola", "Cheese Sandwich")
      val steakColaPrice = cafeX.breakDownList(productList)
      assert(steakColaPrice === 2.50)
  }

  test ("Cola, Coffee and Cheese Sandwich return 3.5") {
    val productList: Array[String] = Array("Cola", "Coffee", "Cheese Sandwich")
    val listPrice = cafeX.breakDownList(productList)
    assert(listPrice === 3.5)
  }
}