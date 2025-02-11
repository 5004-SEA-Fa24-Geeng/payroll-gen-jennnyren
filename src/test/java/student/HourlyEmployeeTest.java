package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {

    HourlyEmployee employee1;

    @BeforeEach
    void setUp() {
        employee1 = new HourlyEmployee("Ali", "A001", 50, 0, 0, 10);
    }

    @Test
    public void calculateGrossPayRegular() {
        double hoursWorked = 30.0;
        IPayStub stub = employee1.runPayroll(hoursWorked);
        assertNotNull(stub);
        double expectedNetPay = 1152.52;
        double expectedTaxes = 337.49;
        assertEquals(expectedNetPay, stub.getPay());
        assertEquals(expectedTaxes, stub.getTaxesPaid());
        assertEquals(expectedNetPay, employee1.getYTDEarnings());
        assertEquals(expectedTaxes, employee1.getYTDTaxesPaid());
    }
    @Test
    public void calculateGrossPayOvertime(){
        double hoursWorked = 50.0;
        IPayStub stub = employee1.runPayroll(hoursWorked);
        assertNotNull(stub);
        double expectedNetPay = 2119.39;
        double expectedTaxes = 620.61;
        assertEquals(expectedNetPay, stub.getPay());
        assertEquals(expectedTaxes, stub.getTaxesPaid());
        assertEquals(expectedNetPay, employee1.getYTDEarnings());
        assertEquals(expectedTaxes, employee1.getYTDTaxesPaid());
    }
}