package com.example.demo.controller;

import com.example.demo.model.dto.ResponseDTO;
import com.example.demo.service.PalindromeCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PalindromeControllerTest {

    @InjectMocks
    private PalindromeController palindromeController;

    @Mock
    PalindromeCheck palindromeCheck;


    @Test
    @DisplayName("Input is palnidrom")
    void testCheckPalindrome(){
        ResponseDTO<Boolean> responseDTO = palindromeController.checkPalindrome("1234321");
        assertNotNull(responseDTO);
        assertTrue(responseDTO.isSuccess());
        assertNull(responseDTO.getError());
        assertTrue(responseDTO.getResponse());
    }

    @Test
    @DisplayName("Input is not palnidrom")
    void testCheckPalindromeFalse(){
        ResponseDTO<Boolean> responseDTO = palindromeController.checkPalindrome("123431");
        assertNotNull(responseDTO);
        assertTrue(responseDTO.isSuccess());
        assertNull(responseDTO.getError());
        assertFalse(responseDTO.getResponse());
    }



}