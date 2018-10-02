
/*
Class designed to create the menu items and instantiate the Cafe.
@Author - Ryan Corcoran
 */
class CafeX {

  //creating the menu items
  val cola: MenuItem = MenuItem("Cola", "Cold", "Drink", 0.50, 1.00)
  val coffee: MenuItem = MenuItem("Coffee", "Hot", "Drink", 1.00, 1.00)
  val cheeseSandwich: MenuItem = MenuItem("Cheese Sandwich", "Cold", "Food", 2.00, 1.10)
  val steakSandwich: MenuItem = MenuItem("Steak Sandwich", "Hot", "Food", 4.50, 1.20)

  /*
  Full e2e purchasing method that calls other functions to return the total price
  @param list of products being purchased
  @return double value of price plus service charge if appropriate
  @Author Ryan Corcoran
   */
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
    val totalPrice = products.map(returnMenuItem(_).price).sum
    //return the price
    totalPrice
  }

  /*
  method that checks if a service charge needs adding and returns the service charge multiplier
  @param a list of products being purchased
  @return double of a service charge multiplier value
  @author Ryan Corcoran
   */
  def checkServiceCharge(products: Array[String]): Double = {
    val SCLists = products.map(returnMenuItem(_).SCPercent).sorted
    SCLists(SCLists.size - 1)
  }
  /*
  returns a type based on the string value given
  @param the string of the product purchased
  @return menu item corresponding to string value
  @author Ryan Corcoran
   */
  def returnMenuItem(product: String): MenuItem = product match {
    case "Cola" => cola
    case "Coffee" => coffee
    case "Cheese Sandwich" => cheeseSandwich
    case "Steak Sandwich" => steakSandwich
  }

  /*
  returns the service charge for the purchase to a max of £20
  @param total price of the order
  @param the service charge modifier
  @return double value of the service charge
   */
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
