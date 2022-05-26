package com.nocountry.ecommerce.common.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundException extends RuntimeException {
    private final Object resourceId;
}
