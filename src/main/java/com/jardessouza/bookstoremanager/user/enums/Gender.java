package com.jardessouza.bookstoremanager.user.enums;

import lombok.Getter;


@Getter
public enum Gender {
    MALE("Male"),
    FEMALE("FEMALE");

    private String description;
    Gender(String description) {
        this.description = description;
    }

}
