package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testBuildEmployeeFromCSVHourly() {
        String csvFile = "HOURLY,Eren Yeager,a105,35.00,0,6000,1359";
        IEmployee employee = Builder.buildEmployeeFromCSV(csvFile);
        assertNotNull(employee);
        assertEquals("HOURLY", employee.getEmployeeType());
        assertEquals("Eren Yeager", employee.getName());
        assertEquals("a105", employee.getID());
        assertEquals("35.00", employee.getPayRate());
        assertEquals("0", employee.getPretaxDeductions());
        assertEquals("6000", employee.getYTDEarnings());
        assertEquals("1359", employee.getYTDTaxesPaid());
    }
    @Test
    public void testBuildEmployeeFromCSVSalary() {
        String csvFile = "SALARY,Nami,s193,200000,1000,17017,4983";
        IEmployee employee = Builder.buildEmployeeFromCSV(csvFile);
        assertNotNull(employee);
        assertEquals("SALARY", employee.getEmployeeType());
        assertEquals("Nami", employee.getName());
        assertEquals("s193", employee.getID());
        assertEquals("200000", employee.getPayRate());
        assertEquals("1000", employee.getPretaxDeductions());
        assertEquals("17017", employee.getYTDEarnings());
        assertEquals("4983", employee.getYTDTaxesPaid());
    }

    @Test
    void testBuildTimeCardFromCSV() {
        String csvFile = "A001, 1.0";
        ITimeCard timeCard = Builder.buildTimeCardFromCSV(csvFile);
        assertNotNull(timeCard);
        assertEquals("A001", timeCard.getEmployeeID());
        assertEquals("1.0", timeCard.getHoursWorked());
    }
}