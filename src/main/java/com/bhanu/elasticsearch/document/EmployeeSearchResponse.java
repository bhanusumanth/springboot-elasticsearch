package com.bhanu.elasticsearch.document;

import lombok.Data;

import java.util.List;

/**
 * Response model for employee search.
 */
@Data
public class EmployeeSearchResponse {

    private Long count;
    private List<Employee> results;
}

