package com.company;

import com.company.Error.DivisionZeroError;
import com.company.Error.ValidationError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        List<String> list ;
        System.out.println("ПРОГРАММА КАЛЬКУЛЯТОР");
        int end = 1;
        while (end != 0) {
            System.out.println("Вветите пример в виде строки. \nЧисла и операции разделяйте пробелами");
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();

            try {
                list = Parsing.parsingStr(s);
                Calculator c = new Calculator();
                System.out.println(c.computing(list));
            } catch (DivisionZeroError | ValidationError divisionZeroError) {
                divisionZeroError.printStackTrace();
            }
            System.out.println("1: повторить");
            System.out.println("0: выйти из программы");
            end = scan.nextInt();
        }

    }
}
