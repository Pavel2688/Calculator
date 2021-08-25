package com.company;


import com.company.Error.ValidationError;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;

public class ParsingTest {



    @Test(expected = ValidationError.class)
    public void parsingStrValidationErrorTest() throws ValidationError {
        Parsing.parsingStr("2_2");
    }
    @Test
    public void parsingStrTest() throws ValidationError {
        List<String> list= Parsing.parsingStr("2 + 2");
        String s1="2";
        String s2="+";
        String s3="2";
        List<String> rez =new ArrayList<>();
        rez.add(s1);
        rez.add(s2);
        rez.add(s3);
        //assertEquals(list, rez);
       // assertThat(rez, equalTo(list));

    }


}