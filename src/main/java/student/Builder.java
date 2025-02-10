package student;

/** 
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {
    
    private Builder() {
    }


     /**
     * Builds an employee object from a CSV string.
     * 
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     * 
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        // Split the string into parts with '.'
        String[] parts = csv.split(",");
        // Assign the col num to 7 to avoid magic numbers
        int colNum = 7;

        // Ensure the CSV has exactly 7 columns
        if (parts.length != colNum) {
            throw new IllegalArgumentException("CSV contains invalid number of columns");
        }
        try{
            // Extract each field from CSV
            String employeeType = parts[0];  // Employee type
            String name = parts[1];  // Employee name
            String id = parts[2];  // Employee ID
            double payRate = Double.parseDouble(parts[3]);  // Pay rate
            double pretaxDeductions = Double.parseDouble(parts[4]);  // Pre-tax deductions
            double ytdEarnings = Double.parseDouble(parts[5]);  // year-to-date earnings
            double ytdTaxesPaid = Double.parseDouble(parts[6]);  // year-to-date taxes paid

            // Determine and generate the correct employee type
            switch (employeeType) {
                case "HOURLY" -> {
                    return new HourlyEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
                }
                case "SALARY" -> {
                    return new SalaryEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
                }
                default -> throw new IllegalArgumentException("Employee type not recognized");
            }
        }catch(NumberFormatException e){
            // Handle invalid number format in employees CSV
            throw new IllegalArgumentException("Invalid number format in employee CSV", e);
        }
    }

   /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        // Split the string into parts with ','
        String[] parts = csv.split(",");
        // Assign 2 to col to avoid magic numbers
        int colNum = 2;

        // Ensure the CSV has exactly 2 columns
        if (parts.length != colNum) {
            throw new IllegalArgumentException("CSV contains invalid number of columns");
        }
        // Extract each field from CSV
        try{
            String employeeID = parts[0];
            double hoursWorked = Double.parseDouble(parts[1]);
            // Return a new TimeCard object
            return new TimeCard(employeeID, hoursWorked);
        } catch (NumberFormatException e){
            // Handle invalid number format in hours worked
            throw new IllegalArgumentException("Invalid number format in timeCard CSV", e);
        }
    }
}
