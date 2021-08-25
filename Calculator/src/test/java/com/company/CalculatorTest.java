package com.company;

import com.company.Error.DivisionZeroError;
import com.company.Error.ValidationError;

import org.junit.Before;
import org.junit.Test;
//import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator c;
    private List<String> list;
    @Before
    public void setUp() throws Exception {
        c= new Calculator();
        list = new ArrayList<>();
        list.add("8");
        list.add("/");
    }

    @Test(expected = ValidationError.class)
    public void computingValidationErrorTest() throws ValidationError, DivisionZeroError {
        list.add("+");
        c.computing(list);
    }

    @Test(expected = DivisionZeroError.class)
    public void computingDivisionZeroErrorTest() throws ValidationError, DivisionZeroError {
        list.add("0");
        c.computing(list);
    }

    @Test
    public void computingTest() throws ValidationError, DivisionZeroError {
        list.add("4");
        assertEquals(c.computing(list),2.0, 0.01);
        list.add("+");
        list.add("1.999");
        assertEquals(c.computing(list), 3.99, 0.01);
        list.add("-");
        list.add("0.999");
        assertEquals(c.computing(list), 3.0, 0.01);
        list.add("+");
        list.add("2");
        list.add("*");
        list.add("3");
        assertEquals(c.computing(list), 9, 0.01);
    }
    //4 / 2 + 1.999 - 0.999 + 2 * 3
}