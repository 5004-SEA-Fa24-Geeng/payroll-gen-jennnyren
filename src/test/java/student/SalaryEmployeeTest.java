package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {

    SalaryEmployee employee1;

    @BeforeEach
    void setUp() {
        employee1 = new SalaryEmployee("Ali", "A001", 30000, 0, 0, 500);
    }

    @Test
    void calculateGrossPay() {
        double hoursWorked = 30.0;
        IPayStub stub = employee1.runPayroll(hoursWorked);
        assertNotNull(stub);

        double expectedNetPay = 886.75;
        double expectedTaxes = 113.25;
        assertEquals(expectedNetPay, stub.getPay());
        assertEquals(expectedTaxes, stub.getTaxesPaid());

        assertEquals(expectedNetPay, employee1.getYTDEarnings());
        assertEquals(expectedTaxes, employee1.getYTDTaxesPaid());
    }
}