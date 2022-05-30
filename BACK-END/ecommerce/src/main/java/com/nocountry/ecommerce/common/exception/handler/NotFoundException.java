package com.nocountry.ecommerce.common.exception.handler;

import com.nocountry.ecommerce.common.exception.error.ApplicationErrorCode;
import com.nocountry.ecommerce.common.exception.error.ErrorDetails;
import com.nocountry.ecommerce.common.exception.error.ErrorLocation;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private Object resourceId;

    private ErrorDetails errorDetails;

    public NotFoundException(Object resourceId) {

        this.errorDetails = new ErrorDetails
                (ApplicationErrorCode.RESOURCE_NOT_FOUND,
                        "resource not found",
                        "ID",
                        resourceId,
                        ErrorLocation.PATH);

    }


}
