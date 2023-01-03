package com.jardessouza.bookstoremanager.pusblisher.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublisherDTO {


    private Long id;
    @NotNull
    @NotEmpty
    @Size(max = 205)
    private String name;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String code;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate foundationDate;
}
