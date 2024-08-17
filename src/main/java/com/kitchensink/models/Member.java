package com.kitchensink.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@Document(collection = "users")
public class Member {

    @Id
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 25, message = "Name must be between 1 and 25 characters")
    @Pattern(regexp = "[^0-9]*", message = "Name must not contain numbers")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 10, max = 12, message = "Phone number must be between 10 and 12 digits")
    @Pattern(regexp = "\\d+", message = "Phone number must be numeric")
    private String phoneNumber;
}


