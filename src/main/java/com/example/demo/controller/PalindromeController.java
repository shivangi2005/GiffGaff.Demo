package com.example.demo.controller;

import com.example.demo.model.dto.ResponseDTO;
import com.example.demo.model.dto.SuccessDTO;
import com.example.demo.service.PalindromeCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PalindromeController {
    private final PalindromeCheck palindromeCheck;

    @Autowired
    public PalindromeController(PalindromeCheck palindromeCheck) {
        this.palindromeCheck = palindromeCheck;
    }

    @GetMapping(value = "/v1/checkPalindrome/{text}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('palindrome')")
    public ResponseDTO<Boolean> checkPalindrome(@PathVariable String text){
        return new SuccessDTO<>(palindromeCheck.isPalindrome(text));
    }


}
