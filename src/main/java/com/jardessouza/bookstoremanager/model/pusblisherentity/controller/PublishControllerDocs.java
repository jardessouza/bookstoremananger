package com.jardessouza.bookstoremanager.model.pusblisherentity.controller;

import com.jardessouza.bookstoremanager.model.pusblisherentity.dto.PublisherDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PublishControllerDocs {
    @Operation(summary = "Create Publisher operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create publisher sucessfull"),
            @ApiResponse(responseCode = "400", description = "Missing required fileds")
    })
    PublisherDTO create(PublisherDTO publisherDTO);

    @Operation(summary = "Search operation by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucess publisher found"),
            @ApiResponse(responseCode = "403", description = "Publish not found erro code")
    })
    public PublisherDTO findById(Long id);
    @Operation(summary = "Publishers list operation")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Publishers listed succesfull"),
    })
    public List<PublisherDTO> findAll();

    @Operation(summary = "Publisher delete operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Publisher deleted succesfull"),
            @ApiResponse(responseCode = "404", description = "Publisher not found")
    })
    public void delete(Long id);



}
