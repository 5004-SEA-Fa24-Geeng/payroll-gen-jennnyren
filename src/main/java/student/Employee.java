package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
* A generic Employee class
 */
public abstract class Employee implements IEmployee {
    /**
     * The employee's name
     */
    private String name;  // The employee's name
    /**
     * The employee's ID
     */
    private String id;  // The employee's id
    /**
     * The type of the employee
     */
    private String employeeType;  // The type of the employee
    /**
     * The pay rate of the employee
     */
    private double payRate;  // The pay rate of the employee
    /**
     * The year-to-date earnings of the employee
     */
    private double ytdEarnings;  // The year-to-date earnings of the employee
    /**
     * The year-to-date taxes paid by the employee
     */
    private double ytdTaxesPaid;  // The year-to-date taxes paid of the employee
    /**
     * The pre-tax deductions of the employee
     */
    private double pretaxDeductions;  // The pre-tax deductions of the employee

    /**
     * Fixed tax rate used in payroll calculations
     */
    private static final BigDecimal TAX_RATE = new BigDecimal("0.2265");

    /**
     * Constructs a new employee with details
     *
     * @param name the name of the employee
     * @param id the id of the employee
     * @param payRate the pay rate of the employee
     * @param ytdEarnings the year-to-date earnings of the employee
     * @param ytdTaxesPaid the year-to-date taxes paid of the employee
     * @param pretaxDeductions the pre-tax deductions of the employee
     * @throws IllegalArgumentException if numeric parameters negative
     */
    public Employee(String name, String id, double payRate, double ytdEarnings,
                    double ytdTaxesPaid, double pretaxDeductions) {
        if (payRate < 0 || ytdEarnings < 0 || ytdTaxesPaid < 0 || pretaxDeductions < 0) {
            throw new IllegalArgumentException("Negative values not allowed");
        }
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }
    /**
     * Return the employee's name
     * @return the employee's name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Return the employee's id
     * @return the employee's id
     */
    @Override
    public String getID(){
        return this.id;
    }

    /**
     * Return the employee's pay rate
     * @return the employee's pay rate
     */
    @Override
    public double getPayRate() {
        return this.payRate;
    }

    /**
     * Return the employee's type
     * @return the employee's type
     */
    @Override
    public String getEmployeeType() {
        return this.employeeType;
    }

    /**
     * Return the employee's year-to-date earnings
     * @return the employee's year-to-date earnings
     */
    @Override
    public double getYTDEarnings(){
        return this.ytdEarnings;
    }

    /**
     * Return the employee's year-to-date taxes paid
     * @return the year-to-date taxes paid
     */
    @Override
    public double getYTDTaxesPaid(){
        return this.ytdTaxesPaid;
    }

    /**
     * Return the employee's pre-tax deductions
     * @return the employee's pre-tax deductions
     */
    @Override
    public double getPretaxDeductions(){
        return this.pretaxDeductions;
    }

    /**
     * Create payrolls based on hours worked
     * @param hoursWorked the number of hours worked by the employee
     * @return IPayStub with payroll details
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0.0) {
            return null;
        }
        BigDecimal grossPay = calculateGrossPay(hoursWorked);
        BigDecimal pretax = BigDecimal.valueOf(pretaxDeductions);
        BigDecimal netBeforeTax = grossPay.subtract(pretax);
        BigDecimal taxes = netBeforeTax.multiply(TAX_RATE);
        BigDecimal netPay = netBeforeTax.subtract(taxes);

        this.ytdEarnings = BigDecimal.valueOf(this.ytdEarnings).add(netPay).doubleValue();
        this.ytdTaxesPaid = BigDecimal.valueOf(this.ytdTaxesPaid).add(taxes).doubleValue();

        return new PayStub(name, netPay.doubleValue(), taxes.doubleValue(), this.ytdEarnings, this.ytdTaxesPaid);
    }
    /**
     * Calculate the gross pay for employees
     * @param hoursWorked the number of hours worked by the employee
     * @return the gross pay as a BigDecimal
     */
    protected abstract BigDecimal calculateGrossPay(double hoursWorked);
    /**
     * Return a CSV of employees' details
     * @return a CSV of employees' details
     */
    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f", employeeType, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
    }

}
