package com.jardessouza.bookstoremanager.model.userentity.enums;

import lombok.AllArgsConstructor;
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
