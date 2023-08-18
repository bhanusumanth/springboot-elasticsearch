package com.bhanu.elasticsearch.document;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
/**
 * Request model for employee search.
 */
@Data
public class EmployeeSearchRequest {

    @Valid
    @NotBlank(message = "interest is mandatory")
    private String interest;

    @Valid
    @NotBlank(message = "minSalary is mandatory")
    @Positive
    private int minSalary;
}

