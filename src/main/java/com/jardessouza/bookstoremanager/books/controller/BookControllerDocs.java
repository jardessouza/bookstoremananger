package com.jardessouza.bookstoremanager.books.controller;

import com.jardessouza.bookstoremanager.books.dto.BookRequestDTO;
import com.jardessouza.bookstoremanager.books.dto.BookResponseDTO;
import com.jardessouza.bookstoremanager.user.dto.AuthenticationUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface BookControllerDocs {
    @Operation(summary = "Book creation Operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucess book creation"),
            @ApiResponse(responseCode = "400", description = "Missing required fields")
    })
    BookResponseDTO create(AuthenticationUser authenticationUser, BookRequestDTO bookRequestDTO);

}
