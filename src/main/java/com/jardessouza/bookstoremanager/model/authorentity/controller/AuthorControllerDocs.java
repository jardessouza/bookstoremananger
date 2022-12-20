package com.jardessouza.bookstoremanager.model.authorentity.controller;

import com.jardessouza.bookstoremanager.model.authorentity.dto.AuthorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface AuthorControllerDocs {

    @Operation(summary = "Author creation operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success author creation"),
            @ApiResponse(responseCode = "400", description = "Missing required fileds")
    })
    AuthorDTO create(AuthorDTO authorDTO);
}
