package com.bhanu.elasticsearch.service;

import com.bhanu.elasticsearch.document.Employee;
import com.bhanu.elasticsearch.repositories.EmployeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSearchEmployeesByInterestsAndMinSalary() throws IOException {
        String interests = "Aircraft Spotting";
        int minSalary = 70000;

        List<Employee> mockEmployees = new ArrayList<>();
        // Create mock employee objects and add to mockEmployees list
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee1 = new Employee();
        employee1.setFirstName("LIA");
        employee1.setLastName("BELICH");
        employee1.setDesignation("Manager");
        employee1.setSalary(84000);
        employee1.setDateOfJoining("1997-02-13");
        employee1.setAddress("43 Broad St. Grand Blanc, MI 48439");
        employee1.setGender("Female");
        employee1.setAge(40);
        employee1.setMaritalStatus("Unmarried");
        employee1.setInterests(Collections.singletonList("Aircraft Spotting"));
        mockEmployees.add(employee1);

        when(employeeRepository.findFirst10ByInterestsAndSalaryGreaterThanEqual(interests, minSalary))
                .thenReturn(mockEmployees);

        List<Employee> result = employeeService.searchEmployeesByInterestsAndMinSalary(interests, minSalary);


        assertEquals(mockEmployees.get(0), result.get(0));
    }

    @Test
    void testCountEmployeesByInterestsAndMinSalary() {
        String interests = "Aircraft Spotting";
        int minSalary = 70000;
        long expectedCount = 93; // Adjust according to the sample output provided

        when(employeeRepository.countByInterestsAndSalaryGreaterThanEqual(interests, minSalary))
                .thenReturn(expectedCount);

        long result = employeeService.countEmployeesByInterestsAndMinSalary(interests, minSalary);

        assertEquals(expectedCount, result);
    }
}

