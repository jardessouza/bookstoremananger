package com.jardessouza.bookstoremanager.pusblisher.controller;

import com.jardessouza.bookstoremanager.pusblisher.dto.PublisherDTO;
import com.jardessouza.bookstoremanager.pusblisher.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/publishers")
@RequiredArgsConstructor
public class PublisherController implements PublishControllerDocs {
    private final PublisherService publisherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublisherDTO create(@RequestBody @Valid PublisherDTO publisherDTO){
        return this.publisherService.create(publisherDTO);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublisherDTO findById(@PathVariable Long id){
        return this.publisherService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PublisherDTO> findAll(){
        return this.publisherService.findAll();
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        this.publisherService.delete(id);
    }



}
