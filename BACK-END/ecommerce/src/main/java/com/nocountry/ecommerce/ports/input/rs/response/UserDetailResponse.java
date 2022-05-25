package com.nocountry.ecommerce.ports.input.rs.response;

import com.nocountry.ecommerce.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailResponse {

    private String firstName;

    private String lastName;

    private String email;

    private Role role;
}