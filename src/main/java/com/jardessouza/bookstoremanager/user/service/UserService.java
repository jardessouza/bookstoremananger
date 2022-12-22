package com.jardessouza.bookstoremanager.user.service;

import com.jardessouza.bookstoremanager.user.dto.UserDTO;
import com.jardessouza.bookstoremanager.user.entity.User;
import com.jardessouza.bookstoremanager.user.exception.UserNotFoundException;
import com.jardessouza.bookstoremanager.user.mapper.UserMapper;
import com.jardessouza.bookstoremanager.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO create(UserDTO userDTO){

        User userToBeCreated = UserMapper.INSTANCE.toModel(userDTO);
        User userCreate = this.userRepository.save(userToBeCreated);
        return UserMapper.INSTANCE.toDTO(userCreate);
    }

    public UserDTO findById(Long id){
        User userFound = this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.INSTANCE.toDTO(userFound);
    }

    public List<UserDTO> findByName(String name){
        return this.userRepository.findByName(name)
                .stream().map(UserMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());

    }

    public void update(UserDTO userDTO){
        User userFound = verifyAndGetIfExists(userDTO.getId());
        userDTO.setId(userFound.getId());
        User userToBeCreated = UserMapper.INSTANCE.toModel(userDTO);
        userToBeCreated.setCreatedDate(userFound.getCreatedDate());
        this.userRepository.save(userToBeCreated);

    }

    public void delete(Long id){
        UserDTO userFound = findById(id);
        User userToBeDeleted = UserMapper.INSTANCE.toModel(userFound);
        this.userRepository.delete(userToBeDeleted);
    }

    public List<UserDTO> findAll(){
        return this.userRepository.findAll()
                .stream().map(UserMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public User verifyAndGetIfExists(Long id){
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }



}
