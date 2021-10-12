fun main() {
    // Example employees
    val emp1 = Employee("Jane Doe", Employee.PositionTitle.ADMINISTRATION, true, 27.00, 1);
    val emp2 = Employee("Larry Jackson", Employee.PositionTitle.PRODUCTION, false, 22.00, 2);
    val emp3 = Employee("John Smith", Employee.PositionTitle.MAINTENANCE, false, 21.00, 3);


    //Call for the employee info to be displayed and calculate their weekly pay below each
    emp1.display();
    emp1.calculate(45);
    emp2.display();
    emp2.calculate(50);
    emp3.display();
    emp3.calculate(35);
}