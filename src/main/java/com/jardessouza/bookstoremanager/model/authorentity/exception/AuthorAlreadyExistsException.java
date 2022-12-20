package com.jardessouza.bookstoremanager.model.authorentity.exception;

import javax.persistence.EntityExistsException;

public class AuthorAlreadyExistsException extends EntityExistsException {
    public AuthorAlreadyExistsException(String name) {
        super(String.format("User with name %s alredy exists!", name));
    }
}