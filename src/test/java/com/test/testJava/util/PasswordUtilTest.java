package com.test.testJava.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters(){
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("123aa!"));
    }
    @Test
    public void weak_when_only_letters(){
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("abcdef"));
    }
    @Test
    public void medium_when_has_letters_and_numbers(){
        assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }
    @Test
    public void strong_when_has_letters_and_symbols(){
        assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assessPassword("abcd1234!"));
    }

}