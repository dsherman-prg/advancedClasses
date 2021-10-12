import java.text.DecimalFormat

// Create employee class
class Employee(
    private var name: String,
    private var position: PositionTitle,
    private var salary: Boolean,
    private var payRate: Double,
    private var shift: Int) {

    // Display all info about the employee
    fun display() {
        println(name + "\n" + PositionTitle.valueOf(position.toString()).properTitle + "; Is salary: " + salary + "; Shift: " + shift
        + "\nRate of pay is: $" + payRate + " per hour")
    }

    // Calculate the weekly pay and take into account over time and salary status
    fun calculate(hours: Int) {
        val roundTwoDigits = DecimalFormat ("###,###,###,###.00")
        var pay = "x"
        var rollingTotal: Double
        val overTime = hours - 40
        var hoursWorked = hours

        // If employee worked overtime separate base 40 hours from overtime
        if (hours > 40){
            hoursWorked = 40
        }



        // Calculate pay if salaried
        if (salary){

            when (shift) {
                1 -> pay = roundTwoDigits.format(40 * payRate)
                2 -> pay = roundTwoDigits.format(40 * payRate * 1.05)
                3 -> pay = roundTwoDigits.format(40 * payRate * 1.1)
            }
        }
        // Else calculate pay if not
        else{

            when (shift) {
                // 1st shift
                1 -> {
                    rollingTotal = hoursWorked * payRate
                    if (hours > 40) rollingTotal += overTime * payRate * 1.5
                    pay = roundTwoDigits.format(rollingTotal)

                }
                // 2nd shift
                2 -> {
                    rollingTotal = hoursWorked * payRate * 1.05
                    if (hours > 40) rollingTotal += (overTime * payRate * 1.05 * 1.5)
                    pay = roundTwoDigits.format(rollingTotal)

                }
                // 3rd shift
                else -> {
                    rollingTotal = hoursWorked * payRate * 1.1
                    if (hours > 40) rollingTotal += overTime * payRate * 1.1 * 1.5
                    pay = roundTwoDigits.format(rollingTotal)
                }
            }
        }
        // Print the weekly pay to the user
        println("$name earned $$pay this week.\n")
    }

    enum class PositionTitle(var properTitle: String) {
        ADMINISTRATION("Administration"),
        PRODUCTION("Production"),
        MAINTENANCE("Maintenance"),
        SALES("Sales"),
        TECHNICAL("Technical"),
        SECRETARIAL("Secretarial");
    }
}