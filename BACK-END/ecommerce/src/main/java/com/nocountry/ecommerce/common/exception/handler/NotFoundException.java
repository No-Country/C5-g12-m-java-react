package com.nocountry.ecommerce.common.exception.handler;

<<<<<<< .merge_file_a04392
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


=======
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundException extends RuntimeException {
    private final Object resourceId;
>>>>>>> .merge_file_a11436
}
