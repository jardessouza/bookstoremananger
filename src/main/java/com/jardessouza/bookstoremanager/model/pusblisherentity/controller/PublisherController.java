package com.jardessouza.bookstoremanager.model.pusblisherentity.controller;

import com.jardessouza.bookstoremanager.model.pusblisherentity.dto.PublisherDTO;
import com.jardessouza.bookstoremanager.model.pusblisherentity.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/publishers")
@RequiredArgsConstructor
public class PublisherController implements PublishControllerDocs {
    private final PublisherService publisherService;

    @PostMapping
    public PublisherDTO create(@RequestBody @Valid PublisherDTO publisherDTO){
        return this.publisherService.create(publisherDTO);
    }

}
