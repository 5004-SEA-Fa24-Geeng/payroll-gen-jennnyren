package student;

/**
 * A pay stub class
 */
public class PayStub implements IPayStub {
    /**
     * The employee's name.
     */
    private String name;  // The employee's name

    /**
     * The net pay amount.
     */
    private double netPay;  // The net pay amount

    /**
     * The amount of taxes paid.
     */
    private double taxes;  // The amount of taxes paid

    /**
     * The year-to-date earnings.
     */
    private double ytdEarnings;  // The year-to-date earnings

    /**
     * The year-to-date taxes paid.
     */
    private double ytdTaxesPaid;  // The year-to-date taxes paid

    /**
     * Constructs a new PayStub object.
     *
     * @param name the employee's name
     * @param netPay the net pay amount
     * @param taxes the amount of taxes paid
     * @param ytdEarnings the year-to-date earnings
     * @param ytdTaxesPaid the year-to-date taxes paid
     */
    public PayStub(String name, double netPay, double taxes, double ytdEarnings, double ytdTaxesPaid) {
        this.name = name;
        this.netPay = netPay;
        this.taxes = taxes;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    /**
     * Return the employee's name.
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Return the net pay amount.
     * @return the net pay amount
     */
    @Override
    public double getPay() {
        return this.netPay;
    }

    /**
     * Return the amount of taxes paid.
     * @return the taxes paid
     */
    @Override
    public double getTaxesPaid() {
        return this.taxes;
    }

    /**
     * Return the year-to-date earnings.
     * @return the YTD earnings
     */
    public double getYtdEarnings() {
        return ytdEarnings;
    }

    /**
     * Return the year-to-date taxes paid.
     * @return the YTD taxes paid
     */
    public double getYtdTaxesPaid() {
        return ytdTaxesPaid;
    }

    /**
     * Return a CSV representation of the pay stub.
     * @return a CSV representation the pay stub
     */
    @Override
    public String toCSV() {
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                name, netPay, taxes, ytdEarnings, ytdTaxesPaid);
    }
}