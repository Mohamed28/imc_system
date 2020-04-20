package com.example.imc_system;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MainActivityUnitTest {
    @Test
    public void imc_calculation_isCorrect() {
        double height = 1.76, weight = 65;
        assertEquals(20.98, weight/Math.pow(height, 2), 0.2);
    }
}