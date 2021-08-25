package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    //проверка корректности строки
    //строка должна содержать только цифры знаки операций и пробелы
    static boolean validationStr(String s){
        Pattern pattern = Pattern.compile("[^\\d .*/+-]");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            return false;
        }
         pattern = Pattern.compile("\\d$");
         matcher = pattern.matcher(s);
        if(!matcher.find()){
            return false;
        }
        return true;
    }

    //проверка корректности колекции
    //колекция должна содержать числа и знаки
    //не допускается два подряд числа или знака
    //колекция должна начинатся с числа
    static boolean validationList(List<String> list){
       for(int i=0; i<list.size(); i++){
           if(i%2==0){
               if( ! list.get(i).matches("[\\d.]+"))
                   return false;
               if ( ! list.get(i).matches("\\d+.?\\d*"))
                  return false;
           }
           if(i%2==1 ) {
               if (list.get(i).length() != 1 || list.get(i).matches("[^+-/*]")) {
                   return false;
               }
           }
       }

        return true;
    }

}
