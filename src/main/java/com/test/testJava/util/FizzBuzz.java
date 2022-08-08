package com.test.testJava.util;

public class FizzBuzz {
    public String divisible(int number) {

        if(number % 3 == 0 && number % 5 == 0){
            return "FizzBuzz";
        }
        if ( number % 3 == 0 ){
           return "Fizz";
        }
        if (number % 5 == 0){
           return "Buzz";
       }else{
           return "" + number;
       }
    }
}
