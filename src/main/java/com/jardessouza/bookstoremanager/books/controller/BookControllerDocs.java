package com.jardessouza.bookstoremanager.books.controller;

import com.jardessouza.bookstoremanager.books.dto.BookRequestDTO;
import com.jardessouza.bookstoremanager.books.dto.BookResponseDTO;
import com.jardessouza.bookstoremanager.user.dto.AuthenticationUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

public interface BookControllerDocs {
    @Operation(summary = "Book creation Operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucess book creation"),
            @ApiResponse(responseCode = "400", description = "Missing required fields")
    })
    BookResponseDTO create(AuthenticationUser authenticationUser, BookRequestDTO bookRequestDTO);

    @Operation(summary = "Book find by id and user operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucess book found"),
            @ApiResponse(responseCode = "400", description = "Book not found error")
    })
    BookResponseDTO findByIdAndUser(AuthenticationUser authenticationUser, Long bookId);

    @Operation(summary = "List all books by a specific authenticated user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book list found by authenticated user informed"),
    })
    public List<BookResponseDTO> findAllByUser(AuthenticationUser authenticationUser);
}
