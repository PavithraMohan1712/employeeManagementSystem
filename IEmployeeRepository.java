package com.demo.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.entities.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer>,PagingAndSortingRepository<Employee,Integer> {
	Employee findById(int id);

	//Page<Employee> findAll(Pageable paging);
	

}
