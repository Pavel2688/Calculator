package com.company;

import com.company.Error.DivisionZeroError;
import com.company.Error.ValidationError;

import java.util.*;

public class Calculator {

    //колекция для определения приоритетов операций
    private Map<String, Integer> priority = new HashMap<>(Map.of("+", 1, "-", 1, "*", 2, "/", 2));


    //метод принимает пример в виде ArrayList
    //и методом "обратной польской записи" решает поставленый пример
    // возращает ответ
    public double computing(List<String> list) throws DivisionZeroError, ValidationError {
        if (!Validation.validationList(list)) {
            throw new ValidationError("Недопустимая последовательность символов !");
        }
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        double rez = Double.parseDouble(list.get(0));
        for (String s : list) {
            if (s.matches("[.\\d]+")) {    //если число помещаем его в стек
                stack1.push(s);
            } else {                          //
                if (stack2.empty()) {         //если стек 2 пуст то добавляем туда новый знак
                    stack2.push(s);
                } else {                      //если стек 2 не пуст то проверяем приоритеты
                    if (priority.get(s) > priority.get(stack2.peek())) {
                        stack2.push(s);
                    } else {
                        rez = operation(stack1.pop(), stack1.pop(), stack2.pop());
                        stack1.push(String.valueOf(rez));
                        stack2.push(s);
                    }
                }
            }
        }
        while (!stack2.empty()) {
            rez = operation(stack1.pop(), stack1.pop(), stack2.pop());
            stack1.push(String.valueOf(rez));
        }
        return rez;
    }

    //метод принимает два числа и операцию z
    //и возращает результат соответствующей операции
    private double operation(String a, String b, String z) throws DivisionZeroError {
        double rez = 0;
        switch (z) {
            case "+":
                rez = Double.parseDouble(b) + Double.parseDouble(a);
                break;

            case "-":
                rez = Double.parseDouble(b) - Double.parseDouble(a);
                break;

            case "*":
                rez = Double.parseDouble(b) * Double.parseDouble(a);
                break;

            case "/":
                if (Double.parseDouble(a) == 0) {
                    throw new DivisionZeroError("Ошибка при делении на 0");
                }
                rez = Double.parseDouble(b) / Double.parseDouble(a);
                break;
            default:
                System.out.print("Операция не определена");
                break;
        }
        return rez;
    }


}
