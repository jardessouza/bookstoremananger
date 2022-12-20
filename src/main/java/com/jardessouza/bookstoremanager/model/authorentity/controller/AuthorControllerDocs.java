package com.jardessouza.bookstoremanager.model.authorentity.controller;

import com.jardessouza.bookstoremanager.model.authorentity.dto.AuthorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

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

    @Operation(summary = "Authors list operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authors listed sucessful"),
    })
    List<AuthorDTO> listAll();
    @Operation(summary = "Delete author operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Author deleted sucessful"),
            @ApiResponse(responseCode = "404", description = "Author not found error code")
    })
    public void delete(Long id);
}
