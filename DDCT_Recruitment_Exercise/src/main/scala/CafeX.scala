class CafeX {

  //creating the menu items
  val cola: MenuItem = MenuItem("Cola", "Cold", "Drink", 0.50)
  val coffee: MenuItem = MenuItem("Coffee", "Hot", "Drink", 1.00)
  val cheeseSandwich: MenuItem = MenuItem("Cheese Sandwich", "Cold", "Food", 2.00)
  val steakSandwich: MenuItem = MenuItem("Steak Sandwich", "Hot", "Food", 4.50)

  //takes in a product name and returns the price of the product
  def addItemPrice(product: String): Double = product match {
    case "Cola" => cola.price
    case "Coffee" => coffee.price
    case "Cheese Sandwich" => cheeseSandwich.price
    case "Steak Sandwich" => steakSandwich.price
  }
}
