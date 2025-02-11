package student;

import java.math.BigDecimal;

/**
 * The HourlyEmployee class
 */
public class HourlyEmployee extends Employee {
    /**
     * Construct an HourlyEmployee object
     * @param name the name of the employee
     * @param id the id of the employee
     * @param payRate the hourly pay rate of the employee
     * @param ytdEarnings the year-to-date earnings of the employee
     * @param ytdTaxesPaid the year-to-date taxes paid of the employee
     * @param pretaxDeductions the pretax deductions of the employee
     */
    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    protected BigDecimal calculateGrossPay(double hoursWorked) {
        BigDecimal regularHours = BigDecimal.valueOf(Math.min(40, hoursWorked));
        BigDecimal overtimeHours = BigDecimal.valueOf(Math.max(hoursWorked - 40, 0));
        BigDecimal regularPay = regularHours.multiply(BigDecimal.valueOf(getPayRate()));
        BigDecimal overtimePay = overtimeHours.multiply(BigDecimal.valueOf(getPayRate()*1.5));
        BigDecimal totalPay = regularPay.add(overtimePay);
        return totalPay;
    }
}
