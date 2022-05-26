package com.nocountry.ecommerce.common.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExistingNameException extends RuntimeException {
    private final Object resourceId;
}