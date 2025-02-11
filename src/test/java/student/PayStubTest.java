package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayStubTest {

    private PayStub payStub;

    @BeforeEach
    void setUp() {
        payStub  = new PayStub("Ali", 10, 20, 300, 400);
    }

    @Test
    void getName() {
        assertEquals("Ali", payStub.getName());
    }

    @Test
    void getPay() {
        assertEquals(10, payStub.getPay());
    }

    @Test
    void getTaxesPaid() {
        assertEquals(20, payStub.getTaxesPaid());
    }

    @Test
    void getYtdEarnings() {
        assertEquals(300, payStub.getYtdEarnings());
    }

    @Test
    void getYtdTaxesPaid() {
        assertEquals(400, payStub.getYtdTaxesPaid());
    }

    @Test
    void toCSV() {
        assertEquals("Ali,10,20,300,400", payStub.toCSV());
    }
}