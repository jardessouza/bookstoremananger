package com.jardessouza.bookstoremanager.user.controller;

import com.jardessouza.bookstoremanager.user.dto.JwtRequest;
import com.jardessouza.bookstoremanager.user.dto.JwtResponse;
import com.jardessouza.bookstoremanager.user.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface UserControllerDocs {

    @Operation(summary = "Operation to list all users")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Users Listed Successfully")
    })
    List<UserDTO> findAll();

    @Operation(summary = "Operation to save users")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User created successfull"),
            @ApiResponse(responseCode = "400", description = "Missing required fileds")
    })
    UserDTO create(UserDTO userDTO);

    @Operation(summary = "Operation to find User by Id")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User found successfully"),
            @ApiResponse(responseCode = "404", description = "User not found erro code")
    })
    public UserDTO findById(Long id);

    @Operation(summary = "Operation to find by name")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User found successfully")
    })
    List<UserDTO> findByName(String name);

    @Operation(summary = "Operation to update user")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "User update successfully"),
            @ApiResponse(responseCode = "404", description = "User not found erro code")
    })
    void replace(UserDTO userDTO);

    @Operation(summary = "Operation to deleted user")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found erro code")
    })
    public void delete(@PathVariable Long id);

    @Operation(summary = "User Authetication operation")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success user authemticated"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    JwtResponse createAuthenticationToken(JwtRequest jwtRequest);


}
