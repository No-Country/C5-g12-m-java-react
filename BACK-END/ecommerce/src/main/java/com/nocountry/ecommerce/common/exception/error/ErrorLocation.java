package com.nocountry.ecommerce.common.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorLocation {
    BODY, PATH, QUERY, HEADER
}
