package com.bhanu.elasticsearch.service;

import com.bhanu.elasticsearch.document.Employee;
import com.bhanu.elasticsearch.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling employee-related operations.
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    /**
     * Search for employees based on interests and minimum salary. Results Limited to 10.
     * @param interests The interest keyword to search for.
     * @param minSalary The minimum salary threshold.
     * @return A list of employees matching the search criteria.
     */
    public List<Employee> searchEmployeesByInterestsAndMinSalary(String interests, int minSalary) {
        return employeeRepository.findFirst10ByInterestsAndSalaryGreaterThanEqual(interests, minSalary);
    }

    /**
     * Count the number of employees matching interests and minimum salary.
     * @param interests The interest keyword to search for.
     * @param minSalary The minimum salary threshold.
     * @return The count of employees matching the search criteria.
     */
    public Long countEmployeesByInterestsAndMinSalary(String interests, int minSalary) {
        return employeeRepository.countByInterestsAndSalaryGreaterThanEqual(interests, minSalary);
    }

}
