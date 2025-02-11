package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCardTest {

    private TimeCard timeCard;

    @BeforeEach
    void setUp() {
        timeCard = new TimeCard("A001", 20);
    }

    @Test
    void getEmployeeID() {
        assertEquals("A001", timeCard.getEmployeeID());
    }

    @Test
    void getHoursWorked() {
        assertEquals(20, timeCard.getHoursWorked());
    }
}