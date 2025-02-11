package student;

import java.math.BigDecimal;

/**
 * The SalaryEmployee class
 */
public class SalaryEmployee extends Employee {
    /**
     * Construct a SalaryEmployee object
     * @param name the name of the employee
     * @param id the id of the employee
     * @param payRate the pay rate of the employee
     * @param ytdEarnings the year-to-date earnings of the employee
     * @param ytdTaxesPaid the year-to-date taxes paid of the employee
     * @param pretaxDeductions the pretax deductions of the employee
     */
    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
        setEmployeeType("SALARY");
    }

    @Override
    protected BigDecimal calculateGrossPay(double hoursWorked) {
        // Calculate daily pay by dividing by 30 (days of month)
        BigDecimal totalPay = BigDecimal.valueOf(getPayRate()).divide(BigDecimal.valueOf(30));
        return totalPay;
    }
}
