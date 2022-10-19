package com.example.demo.controller;

import com.example.demo.model.dto.APIError;
import com.example.demo.model.dto.ErrorDTO;
import com.example.demo.model.dto.ResponseDTO;
import com.example.demo.model.dto.SuccessDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(authorities = "palindrome")
class PalindromeControllerTestT {

    private static final String ENDPOINT = "/api/v1/checkPalindrome/";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("verify Palindrome Endpoint")
    void testEndpoint() throws Exception {
        ResponseDTO<Boolean> expectedDTO = new SuccessDTO<>(true);
        mockMvc.perform(get(ENDPOINT + "1234321"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedDTO)));
    }

    @Test
    @DisplayName("verify endpoint returning error")
    void  testEndpoingError() throws Exception {
        ResponseDTO<Boolean> expectedDTO = new ErrorDTO<>(new APIError(HttpStatus.BAD_REQUEST.getReasonPhrase(),"Input can not be blank"));
        mockMvc.perform(get(ENDPOINT + " "))
                .andExpect(status().isBadRequest());
                //.andExpect(content().json(mapper.writeValueAsString(expectedDTO)));

    }

}