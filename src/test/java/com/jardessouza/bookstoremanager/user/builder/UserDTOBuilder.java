package com.jardessouza.bookstoremanager.user.builder;

import com.jardessouza.bookstoremanager.user.dto.UserDTO;
import com.jardessouza.bookstoremanager.user.entity.User;
import com.jardessouza.bookstoremanager.user.enums.Gender;
import com.jardessouza.bookstoremanager.user.enums.Role;
import lombok.Builder;

import java.time.LocalDate;
@Builder
public class UserDTOBuilder {
    @Builder.Default
    private Long id = 1L;
    @Builder.Default
    private String name = "Jardes Souza";
    @Builder.Default
    private int age = 34;
    @Builder.Default
    private Gender gender = Gender.MALE;
    @Builder.Default
    private String email = "jardessouza@gmail.com";
    @Builder.Default
    private String username = "jardessouza";
    @Builder.Default
    private String password = "dijer433";
    @Builder.Default
    private LocalDate birthDate = LocalDate.of(1988, 12,12);

    @Builder.Default
    private Role role = Role.USER;

    public UserDTO builderUserDTO(){
        return new UserDTO(
                id,
                name,
                age,
                gender,
                email,
                username,
                password,
                birthDate,
                role
        );
    }

    public User createUser(){
        return User.builder()
                .id(id)
                .name(name)
                .age(age)
                .email(email)
                .username(username)
                .password(password)
                .birthDate(birthDate)
                .role(role)
                .build();
    }
}
