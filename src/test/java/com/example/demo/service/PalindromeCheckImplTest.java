package com.example.demo.service;

import com.example.demo.exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
class PalindromeCheckImplTest {

    private PalindromeCheck palindromeCheck;

    @BeforeEach
    void setup(){
         palindromeCheck = new PalindromeCheckImpl();
    }

    @Test
    @DisplayName("Test when input string is Palindrome")
    void testWhenPalindrome(){
            assertTrue(palindromeCheck.isPalindrome("abcba"));
    }
    @Test
    @DisplayName("Test when input string is NOT Palindrome")
    void testWhenNotPalindrome(){
        assertFalse(palindromeCheck.isPalindrome("abcppba"));
    }
    @Test
    @DisplayName("Test when input string is having mix of capital letters")
    void testWhenCapsPalindrome(){
        assertTrue(palindromeCheck.isPalindrome("abcbA"));
    }

    @Test
    @DisplayName("Test when input string is null")
    void testWhenNullPalindrome(){
        assertThrows(InvalidInputException.class,() ->palindromeCheck.isPalindrome(null));
    }

    @Test
    @DisplayName("Test when input string is empty")
    void testWhenEmptyPalindrome(){
        assertThrows(InvalidInputException.class,()->palindromeCheck.isPalindrome(""));
    }


}