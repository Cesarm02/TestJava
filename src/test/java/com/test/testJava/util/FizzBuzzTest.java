package com.test.testJava.util;

import org.junit.Test;

import static org.junit.Assert.*;
public class FizzBuzzTest {

    @Test
    public void return_when_divisible_by_3(){
        FizzBuzz fizz = new FizzBuzz();
        assertEquals(fizz.divisible(9), "Fizz");
    }

    @Test
    public void return_when_divisible_by_5(){
        FizzBuzz fizz = new FizzBuzz();
        assertEquals(fizz.divisible(25), "Buzz");
    }

    @Test
    public void return_when_divisible_by_3_and_5(){
        FizzBuzz fizz = new FizzBuzz();
        assertEquals(fizz.divisible(15), "FizzBuzz");
    }

    @Test
    public void return_when_is_not_divisible_by_3_and_5(){
        FizzBuzz fizz = new FizzBuzz();
        assertEquals(fizz.divisible(8), "" + 8);
    }

}