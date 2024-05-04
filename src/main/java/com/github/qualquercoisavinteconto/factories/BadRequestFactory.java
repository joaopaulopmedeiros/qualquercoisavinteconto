package com.github.qualquercoisavinteconto.factories;

import java.util.List;

import com.github.qualquercoisavinteconto.responses.ApiError;
import com.github.qualquercoisavinteconto.responses.ValidationFailedResponse;

public class BadRequestFactory {
    public static ValidationFailedResponse createValidationFailedResponse(String code, String message) {
        var error = ApiError.builder()
                .code(code)
                .message(message)
                .build();

        return ValidationFailedResponse
                .builder()
                .errors(List.of(error))
                .build();
    }
}
