package com.jardessouza.bookstoremanager.books.controller;

import com.jardessouza.bookstoremanager.books.dto.BookRequestDTO;
import com.jardessouza.bookstoremanager.books.dto.BookResponseDTO;
import com.jardessouza.bookstoremanager.books.service.BookService;
import com.jardessouza.bookstoremanager.user.dto.AuthenticationUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController implements BookControllerDocs {

   private final BookService bookService;
   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public BookResponseDTO create(
           @AuthenticationPrincipal AuthenticationUser authenticationUser,
           @RequestBody @Valid BookRequestDTO bookRequestDTO) {
      return bookService.create(authenticationUser, bookRequestDTO);
   }
}
