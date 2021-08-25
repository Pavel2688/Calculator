package com.company;

import com.company.Error.ValidationError;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Parsing {

    //метод принимает строку
    //проверяет ее на волидность
    // и возвращает в виде колекции List
    static List<String> parsingStr(String s) throws ValidationError {
        if (!Validation.validationStr(s))
        {
            throw new ValidationError("строка записана некорректно !");
        }
        return Arrays.asList(s.split(" "));
    }
}
