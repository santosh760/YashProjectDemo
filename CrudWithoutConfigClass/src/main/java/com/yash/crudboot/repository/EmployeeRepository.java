package com.yash.crudboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.crudboot.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>, JpaRepository<Employee, Integer> {

}
