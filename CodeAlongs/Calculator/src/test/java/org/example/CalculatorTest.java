package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    //mandatory annotation. code will not run without the annotation.
    @Test
    //test methods are always void, they don't return anything
    public void addOneAndTwo_ReturnsThree(){
        //Act
        var result = calculator.add(1,2);

        //Assert
        //expected, what you actually got
        assertEquals(3, result);
    }

    @Test
    public void subtractOneFromTwo_ReturnOne(){
        //Act
        var result = calculator.subtract(2,1);

        //Assert
        assertEquals(1, result);
    }

    @Test
    public void divideByZero_ThrowsException(){
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> { calculator.divide(10, 0); });
    }


    //multiple test cases that you don't want to write tons of tests
    //parameterize your test
    @ParameterizedTest
    @CsvSource({"1, 2, 3", "10, 5, 15", "100, 3, 103"})
    public void testAdd(double a, double b, double expected){
        assertEquals(expected, calculator.add(a,b), () -> a + "+" + b + "should equal" + expected);
    }
}