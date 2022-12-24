package com.jardessouza.bookstoremanager.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jardessouza.bookstoremanager.user.enums.Gender;
import com.jardessouza.bookstoremanager.user.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank
    @Size(max = 255)

    private String name;
    @NotNull
    @Max(120)
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;
}
