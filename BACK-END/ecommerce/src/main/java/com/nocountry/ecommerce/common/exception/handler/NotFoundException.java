package com.nocountry.ecommerce.common.exception.handler;

@Getter
@AllArgsConstructor
public class NotFoundException extends RuntimeException {
    private final Object resourceId;

}
