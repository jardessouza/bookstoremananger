package com.jardessouza.bookstoremanager.pusblisher.exception;

import javax.persistence.EntityNotFoundException;

public class PublishNotFoundException extends EntityNotFoundException {
    public PublishNotFoundException(Long id){
        super(String.format("Publish with id %s not exists", id ));
    }
}
