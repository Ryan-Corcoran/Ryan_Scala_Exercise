import org.scalatest.FunSuite

/*
ScalaTest class continuing unit tests for the CafeX product
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

  test ("No service charge added") {
    val productList: Array[String] = Array("Cola", "Coffee")
    val SVModifier = cafeX.checkServiceCharge(productList)
    assert(SVModifier == 1.0)
  }

  test ("Service charge of 10% added") {
    val productList: Array[String] = Array("Cola", "Coffee", "Cheese Sandwich")
    val SVModifier = cafeX.checkServiceCharge(productList)
    assert(SVModifier == 1.1)
  }

  test ("Service charge of 20% added") {
    val productList: Array[String] = Array("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich")
    val SVModifier = cafeX.checkServiceCharge(productList)
    assert(SVModifier == 1.20)
  }

  test ("Service charge less than £20") {
    val scValue = cafeX.addServiceCharge(100.00, 1.1)
    assert(scValue == 10.00)
  }

  test ("Service charge capped to £20") {
    val scValue = cafeX.addServiceCharge(250.00, 1.2)
    assert(scValue == 20.00)
  }

  test ("Overall e2e flow with 10% service charge") {
    val productList: Array[String] = Array("Cola", "Coffee", "Cheese Sandwich")
    val price = cafeX.fullPurchase(productList)
    assert(price == 3.85)
  }

  test ("Overall e2e with 20% service charge") {
    val productList: Array[String] = Array("Steak Sandwich", "Cola")
    val price = cafeX.fullPurchase(productList)
    assert(price == 6.00)
  }
}