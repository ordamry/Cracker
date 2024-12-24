package com.cracker.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class NtlmHashCalculatorTest {
    private static NtlmHashCalculator calculator;

    @BeforeAll
    static void setupClass() {
        calculator = new NtlmHashCalculator();
    }


    @Test
    void givenStringPassword_WhenTestingSimplePassword_ThenNeedToBeEqual() throws NoSuchAlgorithmException{
        String password = "password";
        String expectedHash = "8846F7EAEE8FB117AD06BDD830B7586C";
        String result = calculator.calculateHash(password);
        assertEquals(expectedHash, result);
    }

    @Test
    void givenEmptyStringPassword_WhenTestingEmptyPassword_ThenNeedToReturnCorrectHash() throws NoSuchAlgorithmException {
        String password = "";
        String expectedHash = "31D6CFE0D16AE931B73C8D4A6A4B2C72";
        String result = calculator.calculateHash(password);
        assertEquals(expectedHash, result);
    }

    @Test
    void givenLongStringPassword_WhenTestingLongPassword_ThenNeedToReturnCorrectHash() throws NoSuchAlgorithmException {
        String password = "thisisaverylongpasswordthatexceedstheordinary";
        String expectedHash = "2EC1F7B2F5BFD564547D0C80AA79E420";
        String result = calculator.calculateHash(password);
        assertEquals(expectedHash, result);
    }

    @Test
    void givenNullPassword_WhenTestingNullPassword_ThenNeedToBeEqual() throws NoSuchAlgorithmException {
        String password = "null";
        String expectedHash = "E8F3F7C5F16DB57D199FB3F85B1F7A7B";
        String result = calculator.calculateHash(password);
        assertEquals(expectedHash, result);
    }
}

