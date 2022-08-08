package com.test.testJava.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DateUtilLeapYearTestShould {

    @Test
    public void return_true_when_year_is_divisible_by_400(){
        assertThat( DateUtilLeapYear.isLeapYear(1600), is(true));
        assertThat( DateUtilLeapYear.isLeapYear(2000), is(true));
        assertThat( DateUtilLeapYear.isLeapYear(2400), is(true));
    }

    @Test
    public void return_false_when_year_is_divisible_by_100_but_not_400(){
        assertThat( DateUtilLeapYear.isLeapYear(1700), is(false));
        assertThat( DateUtilLeapYear.isLeapYear(1800), is(false));
        assertThat( DateUtilLeapYear.isLeapYear(1900), is(false));
    }

    @Test
    public void return_true_when_year_is_divisible_by_4_but_not_100(){
        assertThat( DateUtilLeapYear.isLeapYear(1996), is(true));
        assertThat( DateUtilLeapYear.isLeapYear(2004), is(true));
        assertThat( DateUtilLeapYear.isLeapYear(2008), is(true));

    }

    @Test
    public void return_false_when_year_is_not_divisible_by_4(){
        assertThat( DateUtilLeapYear.isLeapYear(2017), is(false));
        assertThat( DateUtilLeapYear.isLeapYear(2018), is(false));
        assertThat( DateUtilLeapYear.isLeapYear(2019), is(false));

    }

}