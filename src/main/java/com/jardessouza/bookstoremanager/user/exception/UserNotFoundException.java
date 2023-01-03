package com.jardessouza.bookstoremanager.user.exception;

import javax.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(Long id){
        super(String.format("User with id %d, not exists!", id));
    }

    public UserNotFoundException(String username){
        super(String.format("User with username %s, not exists!", username));
    }
}
