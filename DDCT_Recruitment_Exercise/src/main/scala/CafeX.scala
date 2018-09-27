
/*
Class designed to create the menu items and instantiate the Cafe.
@Author - Ryan Corcoran
 */
class CafeX {

  //creating the menu items
  val cola: MenuItem = MenuItem("Cola", "Cold", "Drink", 0.50)
  val coffee: MenuItem = MenuItem("Coffee", "Hot", "Drink", 1.00)
  val cheeseSandwich: MenuItem = MenuItem("Cheese Sandwich", "Cold", "Food", 2.00)
  val steakSandwich: MenuItem = MenuItem("Steak Sandwich", "Hot", "Food", 4.50)

  def fullPurchase(productList: Array[String]): Double = {
    val productPrice = breakDownList(productList)
    val scModifier = checkServiceCharge(productList)
    productPrice + addServiceCharge(productPrice, scModifier)
  }

  /*
  takes in a product name and returns the price of the product
  @param string containing the product
  @return double of the price of the product
  @author Ryan Corcoran
   */
  def addItemPrice(product: String): Double = product match {
    case "Cola" => cola.price
    case "Coffee" => coffee.price
    case "Cheese Sandwich" => cheeseSandwich.price
    case "Steak Sandwich" => steakSandwich.price
  }

  /*
  takes in a list of products and adds the prices of each and returns the overall price
  @param an array of type string containing each of the products purchased
  @return a double of the price of all products in the list combined
  @author Ryan Corcoran
   */
  def breakDownList(products: Array[String]): Double = {
    var returnPrice = 0.0
    //for each product, add the price onto returnPrice
    for (p <- products) {
      returnPrice += addItemPrice(p)
    }
    //return the price
    returnPrice
  }

  def checkServiceCharge(products: Array[String]): Double = {
    var SCPercent = 1.00
    for (product <- products) {
      if (returnMenuItem(product).cat == "Food") {
        if (returnMenuItem(product).temp == "Hot") {
          SCPercent = 1.20
        }
        else {
          if (SCPercent == 1.00) {
            SCPercent = 1.10
          }
        }
      }
    }
    SCPercent
  }

  def returnMenuItem(product: String): MenuItem = product match {
    case "Cola" => cola
    case "Coffee" => coffee
    case "Cheese Sandwich" => cheeseSandwich
    case "Steak Sandwich" => steakSandwich
  }

  def addServiceCharge(totalPrice: Double, scModifier: Double): Double = {
    val serviceCharge = BigDecimal(totalPrice * (scModifier - 1.00)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    if (serviceCharge > 20.00) {
      20.00
    }
    else {
      serviceCharge
    }
  }
}
