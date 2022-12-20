package com.jardessouza.bookstoremanager.model.pusblisherentity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDTO {

    @NotNull
    private Long id;
    @NotBlank
    @Size(max = 205)
    private String name;
    @NotBlank
    @Size(max = 50)
    private String code;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate foundationDate;
}