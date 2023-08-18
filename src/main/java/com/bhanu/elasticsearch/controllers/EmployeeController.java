package com.bhanu.elasticsearch.controllers;

import com.bhanu.elasticsearch.document.Employee;
import com.bhanu.elasticsearch.document.EmployeeSearchRequest;
import com.bhanu.elasticsearch.document.EmployeeSearchResponse;
import com.bhanu.elasticsearch.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for handling employee search requests
 */
@RestController
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Endpoint for searching employees based on the given criteria
     * @param request EmployeeSearchRequest - Request contain mandatory params interests, minSalary
     * @return EmployeeSearchResponse
     */
    @PostMapping(value = "/searchEmployees")
    public EmployeeSearchResponse searchEmployees(@Valid @RequestBody EmployeeSearchRequest request) {
        log.info("Got input: " + request.getInterest() + " : " + request.getMinSalary());
        EmployeeSearchResponse response = null;
        try {
            Long count = employeeService.countEmployeesByInterestsAndMinSalary(request.getInterest(), request.getMinSalary());
            List<Employee> results = employeeService.searchEmployeesByInterestsAndMinSalary(request.getInterest(), request.getMinSalary());

            response = new EmployeeSearchResponse();
            response.setCount(count);
            response.setResults(results);
        } catch (Exception e) {
            log.error("Error while searching employees: Elasticsearch Connection Error", e);
        }
        return response;
    }


}
