package com.jardessouza.bookstoremanager.model.authorentity.controller;

import com.jardessouza.bookstoremanager.model.authorentity.dto.AuthorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

public interface AuthorControllerDocs {

    @Operation(summary = "Author creation operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success author creation"),
            @ApiResponse(responseCode = "400", description = "Missing required fileds")
    })
    AuthorDTO create(AuthorDTO authorDTO);

    @Operation(summary = "Find author by id operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success author found"),
            @ApiResponse(responseCode = "404", description = "Author not found error code")
    })
    AuthorDTO findById(Long id);
}
