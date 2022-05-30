package com.nocountry.ecommerce.ports.input.rs.request;

import lombok.Data;

@Data
public class MarkUpdateRequest {

    private String name;

    private boolean isAvailable;
}
