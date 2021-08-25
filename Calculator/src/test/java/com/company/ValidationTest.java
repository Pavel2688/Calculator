package com.company;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ValidationTest {
 //   public List<String> list;
    private final String s;
    private final boolean actual;

    public ValidationTest(String s, boolean actual) {
        this.s = s;
        this.actual = actual;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"5-4/12+o", false},
                {"5-4/12", true},
                {"5.999-4", true}
        });
    }


    @Test
    public void validationStrTest() {
        assertEquals(Validation.validationStr(s), actual);
    }


    @Test
    public void validationListTest() {
        assertTrue(Validation.validationList(new ArrayList<>()));
        List<String> list = new ArrayList<>();
        list.add("5");
        assertTrue(Validation.validationList(list));
        list.add("+");
        list.add("2.333333333");
        assertTrue(Validation.validationList(list));
        list.add("/");
        list.add("3.3.3");
        assertFalse(Validation.validationList(list));
        list.set(4, "3.3");
        assertTrue(Validation.validationList(list));
        list.set(0, "-");
        assertFalse(Validation.validationList(list));
    }


}