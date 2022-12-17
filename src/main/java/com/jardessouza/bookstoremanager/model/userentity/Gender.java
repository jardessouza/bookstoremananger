package com.jardessouza.bookstoremanager.model.userentity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("Male"),
    FEMALE("FEMALE");

    private String description;

}
