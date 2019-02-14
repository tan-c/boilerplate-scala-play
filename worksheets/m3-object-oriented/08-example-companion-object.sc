/**
  * m3-object-oriented -> 08-example-companion-object.sc
  */
object Employee {
  private val departmentCodeByName: Map[String, String] = Map(
    "HR" -> "Human Resources",
    "ACT" -> "Accounts",
    "R&D" -> "Research and Development",
    "MKT" -> "Marketing",
    "SLS" -> "Sales",
    "OPS" -> "Operations"
  )

  def apply(first: String, last: String, stocks: Int): Employee = new Employee(first, last, stocks)

  def getDepartmentName(code: String): String =
    departmentCodeByName.getOrElse(code, "The department with such code does not exist")
}

class Employee(f: String, l: String, s: Int) {
  private val first: String = f
  private val last: String = l
  private var stocks: Int = s

  def getFirst = first
  def getLast = last
  def getStocks = stocks

  // Immutable way of writing
  def awardMoreStocks(numberOfStocks: Int): Employee = Employee(first, last, stocks + numberOfStocks)
  //  def awardMoreStocks(numberOfStocks: Int): Unit = stocks += numberOfStocks

  override def toString: String = first + " " + last + " " + stocks
}

val bobMartin = Employee("Bob", "Martin", 10)
bobMartin.getLast
Employee.getDepartmentName("R&D")
bobMartin.awardMoreStocks(25)
