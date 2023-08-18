package com.bhanu.elasticsearch.repositories;

import com.bhanu.elasticsearch.document.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Employee Entity
 */
@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    List<Employee> findFirst10ByInterestsAndSalaryGreaterThanEqual(String interests, int salary);

    Long countByInterestsAndSalaryGreaterThanEqual(String interests, int salary);
}
