package com.jardessouza.bookstoremanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @GetMapping
    @Operation(summary = "Return an example hello world")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucess method return" ),
            @ApiResponse(responseCode = "500", description = "Failed method return")
    })
    public String hello(){
        return "Hello Bookstore Manager";
    }
}
