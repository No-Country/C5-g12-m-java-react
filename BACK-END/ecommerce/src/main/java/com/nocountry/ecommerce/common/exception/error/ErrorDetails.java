package com.nocountry.ecommerce.common.exception.error;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
<<<<<<< .merge_file_a14760
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
=======
import lombok.Builder;
>>>>>>> .merge_file_a16276
import lombok.Value;

import javax.validation.constraints.NotNull;

<<<<<<< .merge_file_a14760
@AllArgsConstructor
@Setter
=======
@Value
>>>>>>> .merge_file_a16276
@Builder
@JsonPropertyOrder({"code", "detail", "field", "value", "location"})
public class ErrorDetails {

    /**
     * The unique and fine-grained application-level error code.
     */
    @NotNull com.nocountry.ecommerce.common.exception.error.ApplicationErrorCode code;

    /**
     * The human-readable description for an issue. Provide non-standard more granular error message.
     */
    @NotNull String detail;

    /**
     * The field that caused the error. If the field is in the body, set this value to the JSON pointer to that field.
     * Example: "field": {"$ref": "#/body-field"}
     */
    String field;

    /**
     * The value of the field that caused the error.
     */
    Object value;
    /**
     * The location of the field that caused the error. Value is `BODY`, `PATH`, `QUERY` or `HEADER`.
     */
    com.nocountry.ecommerce.common.exception.error.ErrorLocation location;
}
