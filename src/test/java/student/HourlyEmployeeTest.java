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
        double expectedNetPay = 1152.515;
        double expectedTaxes = 337.485;
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
        double expectedNetPay = 696.15;
        double expectedTaxes = 2119.39;
        assertEquals(expectedNetPay, stub.getPay());
        assertEquals(expectedTaxes, stub.getTaxesPaid());
        assertEquals(expectedNetPay, employee1.getYTDEarnings());
        assertEquals(expectedTaxes, employee1.getYTDTaxesPaid());
    }
}