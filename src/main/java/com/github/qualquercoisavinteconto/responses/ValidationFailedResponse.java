package com.github.qualquercoisavinteconto.responses;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ValidationFailedResponse {
    private List<ApiError> errors;
}
