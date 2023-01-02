package com.jardessouza.bookstoremanager.user.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Builder
public class JwtResponse {
    @NotNull
    @NotEmpty
    private final String jwtToken;

}
