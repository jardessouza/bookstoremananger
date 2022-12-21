package com.jardessouza.bookstoremanager.model.pusblisherentity.controller;

import com.jardessouza.bookstoremanager.model.pusblisherentity.dto.PublisherDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface PublishControllerDocs {
    @Operation(summary = "Create Publisher operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create publisher sucessfull"),
            @ApiResponse(responseCode = "400", description = "Missing required fileds")
    })
    PublisherDTO create(PublisherDTO publisherDTO);

}
