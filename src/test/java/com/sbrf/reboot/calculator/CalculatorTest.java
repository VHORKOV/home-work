package com.sbrf.reboot.calculator;
import com.sbrf.reboot.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getAddition() {
        assertEquals(9, Calculator.getAddition(4, 5));
    }

    @Test
    void getSubtraction() {
        assertEquals(-1, Calculator.getSubtraction(4, 5));
    }

    @Test
    void getMultiplication() {
        assertEquals(20, Calculator.getMultiplication(4, 5));
    }

    @Test
    void getDivision() {
        assertEquals(1.5, Calculator.getDivision(3, 2));
    }

    @Test
    void getSin() {
        assertEquals(0,0.2588, Calculator.getSin(15));
    }

    @Test
    void getCos() {
        assertEquals(0.5, Calculator.getCos(60));
    }

    @Test
    void getTan() {
        assertEquals(1d, Calculator.getTan(45));
    }

    @Test
    void classHasSevenMethods(){
        assertEquals(7,Calculator.class.getMethods().length-Object.class.getMethods().length);
    }
}