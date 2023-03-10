package com.jardessouza.bookstoremanager.books.controller;

import com.jardessouza.bookstoremanager.books.dto.BookRequestDTO;
import com.jardessouza.bookstoremanager.books.dto.BookResponseDTO;
import com.jardessouza.bookstoremanager.user.dto.AuthenticationUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;

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

    @Operation(summary = "Book delete operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Book by successfuly deleted"),
            @ApiResponse(responseCode = "404", description = "Book not found error")
    })
    public void deleteByIdAndUser(@AuthenticationPrincipal AuthenticationUser authenticationUser,
                                  @PathVariable Long bookId);
    @Operation(summary = "Book update operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book by successfuly deleted"),
            @ApiResponse(responseCode = "404", description = "Book not found error"),
            @ApiResponse(responseCode = "400", description = "Missing required fields")
    })
    public BookResponseDTO updateIdAndUser(AuthenticationUser authenticationUser, Long bookId,
                                           BookRequestDTO bookRequestDTO);
}
