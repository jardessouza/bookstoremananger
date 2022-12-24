package com.jardessouza.bookstoremanager.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE("Male"),
    FEMALE("FEMALE");

    private final String description;

}
