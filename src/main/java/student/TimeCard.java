package student;

/**
 * The TimeCard class
 */

public class TimeCard implements ITimeCard {
    /**
     * The ID of the employee
     */
    private String employeeID;
    /**
     * The number of hours worked of the employee
     */
    private double hoursWorked;

    /**
     * Construct a new TimeCard object
     * @param employeeID the ID of the employee
     * @param hoursWorked the number of hours worked of the employee
     */
    public TimeCard(String employeeID, double hoursWorked) {
        if (hoursWorked < 0) {
            return;
        }
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
    }

    /**
     * Return the ID of the employee
     * @return the ID of the employee
     */
    @Override
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * Return the number of hours worked of the employee
     * @return the number of hours worked of the employee
     */
    @Override
    public double getHoursWorked() {
        return hoursWorked;
    }
}
