package com.jardessouza.bookstoremanager.user.service;

import com.jardessouza.bookstoremanager.user.dto.UserDTO;
import com.jardessouza.bookstoremanager.user.entity.User;
import com.jardessouza.bookstoremanager.user.mapper.UserMapper;
import com.jardessouza.bookstoremanager.user.repository.UserRepository;
import com.jardessouza.bookstoremanager.user.builder.UserDTOBuilder;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@RequiredArgsConstructor
public class UserServiceTest {

    private UserDTOBuilder userDTOBuilder;

    @InjectMocks
    private UserService userService;

    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserRepository userRepositoryMock;

    @BeforeEach
    void setUp(){
        userDTOBuilder = UserDTOBuilder.builder().build();

        BDDMockito.when(this.userRepositoryMock.save(ArgumentMatchers.any(User.class)))
                .thenReturn(UserMapper.INSTANCE.toModel(userDTOBuilder.builderUserDTO()));

        BDDMockito.when(this.userRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(userDTOBuilder.createUser()));

        BDDMockito.when(this.userRepositoryMock.findAll())
                .thenReturn(List.of(userDTOBuilder.createUser()));

        BDDMockito.doNothing().when(this.userRepositoryMock).delete(ArgumentMatchers.any(User.class));

        BDDMockito.when(this.userRepositoryMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(userDTOBuilder.createUser()));



    }

    @Test
    void WhenSaveSuccessfulReturnsUser(){
        UserDTO ExpectedUser = userDTOBuilder.builderUserDTO();


        UserDTO userCreated = this.userService.create(ExpectedUser);

        Assertions.assertThat(userCreated.getId()).isNotNull();
        Assertions.assertThat(userCreated.getName()).isEqualTo(ExpectedUser.getName());
    }

    @Test
    void WhenFindingIdSuccessfullyReturnsUser(){
        UserDTO user = this.userService.findById(1L);

        Assertions.assertThat(user.getId()).isNotNull();
        Assertions.assertThat(user.getId()).isEqualTo(1L);
    }

    @Test
    void ReturnUserListWhenSucceeded(){
        String ExpectedName = userDTOBuilder.builderUserDTO().getName();
        List<UserDTO> usersList = this.userService.findAll();

        Assertions.assertThat(usersList)
                .isNotEmpty()
                .isNotNull()
                .hasSize(1);
        Assertions.assertThat(usersList.get(0).getName()).isEqualTo(ExpectedName);
    }

    @Test
    void WhenSucceededDeleteUser(){
        Assertions.assertThatCode(() -> this.userService.delete(1L))
                .doesNotThrowAnyException();
    }

    @Test
    void WhenSucceededUpdateUser(){


        Assertions.assertThatCode(() -> this.userService.update(userDTOBuilder.builderUserDTO()))
                .doesNotThrowAnyException();
    }

    @Test
    void WhenFindingNameReturnUserSuccessfully(){
        List<UserDTO> userList = this.userService.findByName("Jardes Souza");

        Assertions.assertThat(userList)
                .isNotEmpty()
                .isNotNull()
                .hasSize(1);

        Assertions.assertThat(userList.get(0).getName()).isEqualTo("Jardes Souza");

    }
}
