package com.nocountry.ecommerce.ports.input.rs.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @NotEmpty
    @NotBlank
    @JsonProperty("first_name")
    private String firstName;

    @NotEmpty
    @NotBlank
    @JsonProperty("last_name")
    private String lastName;

    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @NotEmpty
    @NotBlank
    private String phone;
}